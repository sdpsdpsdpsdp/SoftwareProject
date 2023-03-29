package com.laison.softwareproject.service.sys.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.laison.softwareproject.common.constants.CommonConstant;
import com.laison.softwareproject.common.exception.CustomException;
import com.laison.softwareproject.common.utils.*;
import com.laison.softwareproject.model.common.LoginAppUser;
import com.laison.softwareproject.model.common.Result;
import com.laison.softwareproject.model.sys.body.SysLoginModel;
import com.laison.softwareproject.service.sys.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.laison.softwareproject.common.constants.ConfigConstant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.cache.Cache;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
import com.laison.softwareproject.model.sys.SysUser;
import com.laison.softwareproject.dao.sys.SysUserDao;
import com.laison.softwareproject.service.sys.SysUserService;


/**
 * @author lihua 496583747@qq.com
 * @date 2023-03-27 16:43:20
 */
@Slf4j
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private SysLogService sysLogService;

    @Override
    public int countByCondition(HashMap<String, Object> condition) throws Exception {
        Example example = createExample(condition);
        return sysUserDao.selectCountByExample(example);
    }

    @Override
    @CacheEvict(value = CACHE_NAME, allEntries = true)// 清空  缓存
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteByCondition(HashMap<String, Object> condition) throws Exception {
        Example example = createExample(condition);
        return sysUserDao.deleteByExample(example);
    }

    @Override
    @CacheEvict(value = CACHE_NAME, key = "#id") // 清空 缓存
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteByPrimaryKey(String id) throws Exception {

        return sysUserDao.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int save(SysUser record) throws Exception {

        return sysUserDao.insertSelective(record);
    }

    @Override
    public List<SysUser> selectAllByCondition(HashMap<String, Object> condition) throws Exception {
        Example example = createExample(condition);
        if (ConfigConstant.ISOLATE_ENABLE) {
            LoginUserUtil.addIsolate(example);
        }
        String orderByClause = (String) condition.get("orderByClause");
        if (orderByClause != null) {
            example.setOrderByClause(orderByClause);
        }
        return sysUserDao.selectByExample(example);
    }

    @Override
    public PageInfo<SysUser> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
            throws Exception {
        Example example = createExample(condition);
        if (ConfigConstant.ISOLATE_ENABLE) {
            LoginUserUtil.addIsolate(example);
        }
        PageHelper.startPage(pageNum, pageSize, true);
        String orderByClause = (String) condition.get("orderByClause");
        if (orderByClause != null) {
            example.setOrderByClause(orderByClause);
        }
        List<SysUser> list = sysUserDao.selectByExample(example);
        PageInfo<SysUser> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public SysUser selectFirstByCondition(HashMap<String, Object> condition) throws Exception {
        Example example = createExample(condition);
        String orderByClause = (String) condition.get("orderByClause");
        if (orderByClause != null) {
            example.setOrderByClause(orderByClause);
        }
        PageHelper.startPage(1, 1, true);
        List<SysUser> list = sysUserDao.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        } else {
            return list.get(0);
        }

    }

    @Override
    @Cacheable(value = CACHE_NAME, key = "#id", sync = true)
    public SysUser selectByPrimaryKey(String id) throws Exception {
        return sysUserDao.selectByPrimaryKey(id);
    }

    @Override
    @CacheEvict(value = CACHE_NAME, allEntries = true)// 清空  缓存
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateByCondition(SysUser record, HashMap<String, Object> condition) throws Exception {
        Example example = createExample(condition);
        return sysUserDao.updateByExample(record, example);
    }

    @Override
    @CacheEvict(value = CACHE_NAME, key = "#record.id") // 清除 缓存
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateByPrimaryKey(SysUser record) throws Exception {
        return sysUserDao.updateByPrimaryKeySelective(record);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteByPrimaryKeys(List<String> ids) throws Exception {
        Example example = new Example(SysUser.class);
        Criteria criteria = example.createCriteria();
        criteria.andIn("id", ids);
        Cache cache = SpringContextUtils.getCache(CACHE_NAME);
        ((List<String>) ids).forEach((id) -> cache.evict(id));
        return sysUserDao.deleteByExample(example);
    }

    /**
     * 登录
     */
    @Override
    public Result login(SysLoginModel sysLoginModel) throws Exception {
        String username = sysLoginModel.getUsername();
        if (isLoginFailOvertimes(username)) {
            return Result.error("用户登录失败次数过多，请10分钟后再次重试！");
        }
        //验证码
        String captcha = sysLoginModel.getCaptcha();
        if (StringUtils.isBlank(captcha)) {
            return Result.error("验证码无效");
        }
        // 加入密钥作为混淆，避免简单的拼接，被外部利用，用户自定义该密钥即可
        //captcha: "65es"
        //checkKey: 1679909537411
        //password: "123456"
        //remember_me: true
        //username: "jeecg"
        String lowerCaseCaptcha = captcha.toLowerCase();
//        String origin = lowerCaseCaptcha + sysLoginModel.getCheckKey() + projectConfig.getSignatureSecret();
        String origin ="";
        String realKey = Md5Util.md5Encode(origin, "utf-8");
        Object checkCode = redisUtil.get(realKey);
        //当进入登录页时，有一定几率出现验证码错误 #1714
        if (checkCode == null || !checkCode.toString().equals(lowerCaseCaptcha)) {
            log.warn("验证码错误，key= {} , Ui checkCode= {}, Redis checkCode = {}", sysLoginModel.getCheckKey(), lowerCaseCaptcha, checkCode);
            return Result.error(HttpStatus.PRECONDITION_FAILED.value(), "验证码错误");
        }
        //查询用户是否存在
        SysUser sysUser = sysUserDao.selectOneByUsername(username);
        //判断用户是否正常
        checkUserIsEffective(sysUser);
        //验证用户或者密码是否正确、
        String password = sysLoginModel.getPassword();
        String userpassword = PasswordUtil.encrypt(username, password, sysUser.getSalt());
        String syspassword = sysUser.getPassword();
        if (!syspassword.equals(userpassword)) {
            addLoginFailOvertimes(username);
            return Result.error("用户名或密码错误");
        }
        //设置用户信息
        //生成token
        String token = JwtUtil.sign(username, syspassword);
        // 设置token缓存有效时间
        redisUtil.set(CommonConstant.PREFIX_USER_TOKEN + token, token);
        redisUtil.expire(CommonConstant.PREFIX_USER_TOKEN + token, JwtUtil.EXPIRE_TIME * 2 / 1000);
        //update-begin--Author:liusq  Date:20210126  for：登录成功，删除redis中的验证码
        redisUtil.del(realKey);
        redisUtil.del(CommonConstant.LOGIN_FAIL + username);
        //设置超时时间
        sysLogService.addLog("用户名: " + username + ",登录成功！", CommonConstant.LOG_TYPE_1, null, sysUser);
        //update-end--Author:wangshuai  Date:20200714  for：登录日志没有记录人员
        Map data = new HashMap();
        data.put("token", token);
        data.put("user", sysUser);
        return Result.okData(data);
    }


    /**
     * 判断用户是否有效
     */
    private void checkUserIsEffective(SysUser sysUser) throws Exception {
        if (sysUser == null) {
            sysLogService.addLog("用户登录失败，用户不存在！", CommonConstant.LOG_TYPE_1, null);
            throw CustomException.create("用户不存在，请注册");
        }
        if (sysUser.getDelFlag()) {
            String msg = "用户登录失败，用户名:" + sysUser.getUsername() + "已注销！";
            sysLogService.addLog(msg, CommonConstant.DEL_FLAG_1, null);
            throw CustomException.create(msg);
        }
        //情况3：根据用户信息查询，该用户已冻结
        if (CommonConstant.USER_FREEZE.equals(sysUser.getStatus())) {
            sysLogService.addLog("用户登录失败，用户名:" + sysUser.getUsername() + "已冻结！", CommonConstant.LOG_TYPE_1, null);
            throw CustomException.create("该用户已冻结");
        }
    }

    /**
     * 记录登录失败次数
     *
     * @param username
     */
    private void addLoginFailOvertimes(String username) {
        String key = CommonConstant.LOGIN_FAIL + username;
        Object failTime = redisUtil.get(key);
        Integer val = 0;
        if (failTime != null) {
            val = Integer.parseInt(failTime.toString());
        }
        // 1小时
        redisUtil.set(key, ++val, 3600);
    }

    @Override
    public LoginAppUser findByUsername(String username) throws UsernameNotFoundException {

        SysUser user = sysUserDao.selectOneByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        LoginAppUser loginAppUser = new LoginAppUser();
        BeanUtils.copyProperties(user, loginAppUser);
//        List<SysRole> sysRoles = sysRoleService.findRolesByUserId(user.getId());
//        HashSet<SysRole> setRoles = new HashSet<>();
//        setRoles.addAll(sysRoles);
//        Set<String> permissions = new HashSet<String>();
//        List<String> authoritys = null;
//        if (loginAppUser.getId().equals("1") || loginAppUser.getId().equals("2")) {
//            SysMenuService sysMenuService = SpringContextUtils.getBean(SysMenuService.class);
//            authoritys = sysMenuService.findAllAuthoritys();
//        } else {
//            authoritys = sysUserDao.findUserAuthoritys(loginAppUser.getId());
//
//        }
//        for (String authority : authoritys) {
//            String[] split = authority.split(",");
//            for (String auth : split) {
//                if (!org.apache.commons.lang3.StringUtils.isBlank(auth)) {
//                    permissions.add(auth);
//                }
//            }
//        }
//
//        loginAppUser.setPermissions(permissions);// 设置权限集合
        return loginAppUser;
    }


    /**
     * 判断是否登录失败次数过多
     */
    private boolean isLoginFailOvertimes(String username) {
        String key = CommonConstant.LOGIN_FAIL + username;
        Object failTimes = redisUtil.get(key);
        if (failTimes != null) {
            int times = Integer.parseInt(failTimes.toString());
            return times > CommonConstant.LOGIN_FAIL_TIMES;
        }
        return false;
    }

    private Example createExample(HashMap<String, Object> condition) {
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        if (condition != null) {
            if (condition.get("id") != null && !"".equals(condition.get("id"))) {
                criteria.andEqualTo("id", condition.get("id"));
            }
            if (condition.get("delFlag") != null && !"".equals(condition.get("delFlag"))) {
                criteria.andEqualTo("delFlag", condition.get("delFlag"));
            }
            if (condition.get("startTime") != null) {
                criteria.andGreaterThanOrEqualTo("createTime", DateUtils.parse(condition.get("startTime") + ""));

            }
            if (condition.get("endTime") != null) {
                criteria.andLessThanOrEqualTo("createTime", DateUtils.parse(condition.get("endTime") + ""));
            }
        }
        return example;
    }


}
