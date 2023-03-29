package com.laison.softwareproject.common.utils;

import cn.hutool.core.convert.Convert;
import org.apache.commons.collections4.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 字符串工具类, 继承org.apache.commons.lang3.StringUtils类
 *
 * @author lihua
 * @version 2019-05-22
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    private static final char SEPARATOR = '_';
    private static final String CHARSET_NAME = "UTF-8";

    /**
     * 转换为字节数组
     *
     * @param str
     * @return
     */
    public static byte[] getBytes(String str) {
        if (str != null) {
            try {
                return str.getBytes(CHARSET_NAME);
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 转换为字节数组
     * @return
     */
    public static String toString(byte[] bytes) {
        try {
            return new String(bytes, CHARSET_NAME);
        } catch (UnsupportedEncodingException e) {
            return EMPTY;
        }
    }

    /**
     * 是否包含字符串
     *
     * @param str  验证字符串
     * @param strs 字符串组
     * @return 包含返回true
     */
    public static boolean inString(String str, String... strs) {
        if (str != null) {
            for (String s : strs) {
                if (str.equals(trim(s))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 替换掉HTML标签方法
     */
    public static String replaceHtml(String html) {
        if (isBlank(html)) {
            return "";
        }
        String regEx = "<.+?>";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(html);
        String s = m.replaceAll("");
        return s;
    }

    /**
     * 替换为手机识别的HTML，去掉样式及属性，保留回车。
     *
     * @param html
     * @return
     */
    public static String replaceMobileHtml(String html) {
        if (html == null) {
            return "";
        }
        return html.replaceAll("<([a-z]+?)\\s+?.*?>", "<$1>");
    }


    /**
     * 数据库字段类型与JAVA类型转换
     */
    public static String typeTrans(String type) {
        if (type.contains("tinyint(1)")) {
            return "Boolean";
        } else if (type.contains("int") && !type.contains("bigint")) {
            return "Integer";
        } else if (type.contains("datetime")) {
            return "Date";
        } else if (type.contains("BIGINT") || type.contains("bigint")) {
            return "Long";
        } else if (type.contains("decimal")) {
            return "BigDecimal";
        } else if (type.contains("varchar") || type.contains("date")
                || type.contains("time") || type.contains("timestamp")
                || type.contains("text") || type.contains("enum")
                || type.contains("set")) {
            return "String";
        } else if (type.contains("binary") || type.contains("blob")) {
            return "byte[]";
        } else {
            return "String";
        }
    }


    /**
     * 获得用户远程地址
     */
    public static String getRemoteAddr(HttpServletRequest request) {
        String remoteAddr = request.getHeader("X-Real-IP");
        if (isNotBlank(remoteAddr)) {
            remoteAddr = request.getHeader("X-Forwarded-For");
        } else if (isNotBlank(remoteAddr)) {
            remoteAddr = request.getHeader("Proxy-Client-IP");
        } else if (isNotBlank(remoteAddr)) {
            remoteAddr = request.getHeader("WL-Proxy-Client-IP");
        }
        return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
    }

    /**
     * 驼峰命名法工具
     *
     * @return toCamelCase(" hello_world ") == "helloWorld"
     * toCapitalizeCamelCase("hello_world") == "HelloWorld"
     * toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }

        s = s.toLowerCase();

        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == SEPARATOR) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    /**
     * 驼峰命名法工具
     *
     * @return toCamelCase(" hello_world ") == "helloWorld"
     * toCapitalizeCamelCase("hello_world") == "HelloWorld"
     * toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toCapitalizeCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = toCamelCase(s);
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    /**
     * 驼峰命名法工具
     *
     * @return toCamelCase(" hello_world ") == "helloWorld" <br>
     * toCapitalizeCamelCase("hello_world") == "HelloWorld"  <br>
     * toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toUnderScoreCase(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            boolean nextUpperCase = true;

            if (i < (s.length() - 1)) {
                nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
            }

            if ((i > 0) && Character.isUpperCase(c)) {
                if (!upperCase || !nextUpperCase) {
                    sb.append(SEPARATOR);
                }
                upperCase = true;
            } else {
                upperCase = false;
            }

            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    public static String toMidScoreCase(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            boolean nextUpperCase = true;

            if (i < (s.length() - 1)) {
                nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
            }

            if ((i > 0) && Character.isUpperCase(c)) {
                if (!upperCase || !nextUpperCase) {
                    sb.append("-");
                }
                upperCase = true;
            } else {
                upperCase = false;
            }

            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    /**
     * 转换为JS获取对象值，生成三目运算返回结果
     *
     * @param objectString 对象串
     *                     例如：row.user.id
     *                     返回：!row?'':!row.user?'':!row.user.id?'':row.user.id
     */
    public static String jsGetVal(String objectString) {
        StringBuilder result = new StringBuilder();
        StringBuilder val = new StringBuilder();
        String[] vals = split(objectString, ".");
        for (int i = 0; i < vals.length; i++) {
            val.append("." + vals[i]);
            result.append("!" + (val.substring(1)) + "?'':");
        }
        result.append(val.substring(1));
        return result.toString();
    }

    /**
     * @param s
     * @return : String
     * @Description:首字母转小写
     */
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    /**
     * @param s
     * @return : String
     * @Description:首字母转大写
     */
    public static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }


    public static Long[] stringToLongArray(String s) {
        return null;

    }

    public static List<String> strConvertList(String paths) {
        if (isBlank(paths)) return null;
        String[] ps = Convert.toStrArray(paths);
        if (ps == null || ps.length < 1) return null;
        return new ArrayList<>(Arrays.asList(ps));
    }

    public static String listToStr(Collection<String> list, String region) {
        StringBuilder sb = new StringBuilder();
        int index = -1;
        for (String val : list) {
            index++;
            sb.append(val);
            if (index < list.size() - 1) {
                sb.append(region);
            }
        }
        return sb.toString();
    }

    public static String listToStr(Collection<String> list) {
        return listToStr(list, ",");
    }

    public static List<String> splite(String origin, String regex) {
        if (isBlank(origin)) return null;
        if (origin.endsWith(regex)) {
            origin = origin.substring(0, origin.length() - regex.length());
        }
        if (isBlank(origin)) return null;
        List<String> res = new ArrayList<>();
        if (!origin.contains(regex)) {
            res.add(origin);
            return res;
        }
        Collections.addAll(res, origin.split(regex));
        return res;
    }

    public static Set<String> splite2(String origin, String regex) {
        List<String> splite = splite(origin, regex);
        if (CollectionUtils.isEmpty(splite)) return null;
        return new LinkedHashSet<>(splite);
    }

    public static String collection2Str(List<String> list, String regex) {
        if (CollectionUtils.isEmpty(list)) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(regex);
            }
        }
        return sb.toString();
    }

    public static String queryByEnd(String end, String vals) {
        List<String> values = splite(vals, ",");
        if (CollectionUtils.isEmpty(values)) return "";
        for (String value : values) {
            if (value.endsWith(end)) return value;
        }
        return "";
    }

    public static String buildLength(String content, int maxSize) {
        if (StringUtils.isBlank(content)) return content;
        int conLength = content.length();
        if (conLength <= maxSize) return content;
        return content.substring(0, maxSize);
    }

    public static String buildPhone(String phone) {
        if (StringUtils.isBlank(phone)) return phone;
        String newPhone = phone.replaceAll(" ", "");
        if (StringUtils.isBlank(newPhone)) return phone;
        int index = newPhone.indexOf("-");
        if (index == -1) return newPhone;
        return newPhone.substring(index + 1);
    }

    public static String buildAndAddNew(String oldStr, String newStr) {
        if (StringUtils.isBlank(newStr)) return oldStr;
        if (StringUtils.isBlank(oldStr)) return newStr;
        List<String> oldList = splite(oldStr, ",");
        List<String> newList = splite(newStr, ",");
        Set<String> res = new LinkedHashSet<>();
        if (oldList != null) {
            res.addAll(oldList);
        }
        if (newList != null) {
            res.addAll(newList);
        }
        return listToStr(res, ",");
    }
}