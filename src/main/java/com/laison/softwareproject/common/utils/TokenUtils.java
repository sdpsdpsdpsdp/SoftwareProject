package com.laison.softwareproject.common.utils;

import com.laison.softwareproject.common.api.CommonAPI;
import com.laison.softwareproject.common.constants.CacheConstant;
import com.laison.softwareproject.common.constants.CommonConstant;
import com.laison.softwareproject.common.constants.TenantConstant;
import com.laison.softwareproject.common.exception.CustomException;
import com.laison.softwareproject.model.sys.SysUser;
import com.laison.softwareproject.service.sys.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author scott
 * @Date 2019/9/23 14:12
 * @Description: 编程校验token有效性
 */
@Slf4j
public class TokenUtils {

    /**
     * 获取 request 里传递的 token
     *
     * @param request
     * @return
     */
    public static String getTokenByRequest(HttpServletRequest request) {
        String token = request.getParameter("token");
        if (token == null) {
            token = request.getHeader("X-Access-Token");
        }
        return token;
    }

    /**
     * 获取 request 里传递的 tenantId (租户ID)
     *
     * @param request
     * @return
     */
    public static String getTenantIdByRequest(HttpServletRequest request) {
        String tenantId = request.getParameter(TenantConstant.TENANT_ID);
        if (tenantId == null) {
            tenantId = oConvertUtils.getString(request.getHeader(CommonConstant.TENANT_ID));
        }
        return tenantId;
    }

    /**
     * 获取 request 里传递的 lowAppId (低代码应用ID)
     *
     * @param request
     * @return
     */
    public static String getLowAppIdByRequest(HttpServletRequest request) {
        String lowAppId = request.getParameter(TenantConstant.FIELD_LOW_APP_ID);
        if (lowAppId == null) {
            lowAppId = oConvertUtils.getString(request.getHeader(TenantConstant.X_LOW_APP_ID));
        }
        return lowAppId;
    }

    /**
     * 验证Token
     */
    public static boolean verifyToken(HttpServletRequest request, CommonAPI commonApi, RedisUtil redisUtil) {
        log.debug(" -- url --" + request.getRequestURL());
        String token = getTokenByRequest(request);
        return TokenUtils.verifyToken(token, commonApi, redisUtil);
    }

    /**
     * 验证Token
     */
    public static boolean verifyToken(String token, CommonAPI commonApi, RedisUtil redisUtil) {
        if (StringUtils.isBlank(token)) {
            throw CustomException.create("token不能为空!");
        }

        // 解密获得username，用于和数据库进行对比
        String username = JwtUtil.getUsername(token);
        if (username == null) {
            throw CustomException.create("token非法无效!");
        }

        // 查询用户信息
        SysUser user = TokenUtils.getSysUser(username, commonApi, redisUtil);
        //SysUser user = commonApi.getUserByName(username);
        if (user == null) {
            throw CustomException.create("用户不存在!");
        }
        // 判断用户状态
        if (user.getStatus() != 1) {
            throw CustomException.create("账号已被锁定,请联系管理员!");
        }
        // 校验token是否超时失效 & 或者账号密码是否错误
        if (!jwtTokenRefresh(token, username, user.getPassword(), redisUtil)) {
            throw CustomException.create(CommonConstant.TOKEN_IS_INVALID_MSG);
        }
        return true;
    }

    /**
     * 刷新token（保证用户在线操作不掉线）
     *
     * @param token
     * @param userName
     * @param passWord
     * @param redisUtil
     * @return
     */
    private static boolean jwtTokenRefresh(String token, String userName, String passWord, RedisUtil redisUtil) {
        String cacheToken = oConvertUtils.getString(redisUtil.get(CommonConstant.PREFIX_USER_TOKEN + token));
        if (oConvertUtils.isNotEmpty(cacheToken)) {
            // 校验token有效性
            if (!JwtUtil.verify(cacheToken, userName, passWord)) {
                String newAuthorization = JwtUtil.sign(userName, passWord);
                // 设置Toekn缓存有效时间
                redisUtil.set(CommonConstant.PREFIX_USER_TOKEN + token, newAuthorization);
                redisUtil.expire(CommonConstant.PREFIX_USER_TOKEN + token, JwtUtil.EXPIRE_TIME * 2 / 1000);
            }
            return true;
        }
        return false;
    }

    /**
     * 获取登录用户
     *
     * @param commonApi
     * @param username
     * @return
     */
    public static SysUser getSysUser(String username, CommonAPI commonApi, RedisUtil redisUtil) {
        SysUser SysUser = null;
        String SysUserKey = CacheConstant.SYS_USERS_CACHE + "::" + username;
        //【重要】此处通过redis原生获取缓存用户，是为了解决微服务下system服务挂了，其他服务互调不通问题---
        if (redisUtil.hasKey(SysUserKey)) {
            try {
                SysUser = (SysUser) redisUtil.get(SysUserKey);
                //解密用户
                SensitiveInfoUtil.handlerObject(SysUser, false);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            // 查询用户信息
            SysUser = commonApi.findByUsername(username);
        }
        return SysUser;
    }
}
