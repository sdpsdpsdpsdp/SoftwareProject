package com.laison.softwareproject.controller.sys;

import cn.hutool.core.util.RandomUtil;
import com.laison.softwareproject.common.utils.Md5Util;
import com.laison.softwareproject.common.utils.RandImageUtil;
import com.laison.softwareproject.common.utils.RedisUtil;
import com.laison.softwareproject.model.common.Result;
import com.laison.softwareproject.model.sys.body.SysLoginModel;
import com.laison.softwareproject.service.sys.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * 登录接口
 */
@RestController
@RequestMapping("/sys")
@Api(tags = "用户登录")
@Slf4j
public class LoginController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private SysPermissionService sysPermissionService;
    @Autowired
    private SysDepartService sysDepartService;
    @Autowired
    private SysTenantService sysTenantService;
    @Autowired
    private SysDictService sysDictService;
    private final String BASE_CHECK_CODES = "qwertyuiplkjhgfdsazxcvbnmQWERTYUPLKJHGFDSAZXCVBNM1234567890";

    @ApiOperation("登录接口")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody SysLoginModel sysLoginModel) throws Exception {
        return sysUserService.login(sysLoginModel);
    }

    /**
     * 后台生成图形验证码 ：有效,key是前端传过来的，需要记录
     */
    @ApiOperation("获取验证码")
    @GetMapping(value = "/randomImage/{key}")
    public Result randomImage(@PathVariable("key") String key) {
        try {
            //生成验证码
            String code = RandomUtil.randomString(BASE_CHECK_CODES, 4);
            //存到redis中
            String lowerCaseCode = code.toLowerCase();

            //update-begin-author:taoyan date:2022-9-13 for: VUEN-2245 【漏洞】发现新漏洞待处理20220906
            // 加入密钥作为混淆，避免简单的拼接，被外部利用，用户自定义该密钥即可
//            String origin = lowerCaseCode + key + projectConfig.getSignatureSecret();
            String origin = "";
            String realKey = Md5Util.md5Encode(origin, "utf-8");
            //update-end-author:taoyan date:2022-9-13 for: VUEN-2245 【漏洞】发现新漏洞待处理20220906
//            redisUtil.set(realKey, lowerCaseCode, 60);
            //todo 需要查询为什么设置超时时间会失效
            redisUtil.set(realKey, lowerCaseCode);
            log.info("获取验证码，Redis key = {}，checkCode = {}", realKey, code);
            //返回前端
            String base64 = RandImageUtil.generate(code);
            return Result.okData(base64);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.error("获取验证码失败,请检查redis配置!");
        }
    }
}
