package com.laison.softwareproject;

import com.laison.softwareproject.common.utils.Md5Util;

public class Test1 {
    public static void main(String[] args) {

        String captcha = "65es";
        long checkKey = 1679909537411L;
        //password: "123456"
        //remember_me: true
        //username: "jeecg"
        String lowerCaseCaptcha = captcha.toLowerCase();
        String origin = lowerCaseCaptcha + checkKey + "dd05f1c54d63749eda95f9fa6d49v442a";
        String realKey = Md5Util.md5Encode(origin, "utf-8");
        System.out.println(realKey);
    }
    }
