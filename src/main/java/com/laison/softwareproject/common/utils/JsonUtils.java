package com.laison.softwareproject.common.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import cn.hutool.json.JSON;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

import lombok.extern.log4j.Log4j2;
import springfox.documentation.spring.web.json.Json;

/**
 * JsonUtils
 */
@Log4j2
public class JsonUtils {


    //private static final ObjectMapper MAPPER = new I18NObjectMapper();
    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.setSerializationInclusion(Include.NON_NULL);
        TimeZone timeZone = TimeZone.getTimeZone(YmlUtils.getvalue("spring.jackson.time-zone"));
        MAPPER.setTimeZone(timeZone);
        MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * 将对象转换成json字符串。
     * <p>Title: pojoToJson</p>
     * <p>Description: </p>
     *
     * @param data
     * @return
     */
    public static String objectToJsonWhitI18N(Object data) {
        try {
            if (data == null) return null;
            return MAPPER.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            log.info(e);
            e.printStackTrace();
        }
        return null;
    }

    public static String objectToJson(Object data) {
        try {
            if (data == null) return null;
            if (data instanceof String) {
                return (String) data;
            }
            return MAPPER.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            log.info(e);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json结果集转化为对象
     *
     * @param jsonData json数据
     * @return
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        if (StringUtils.isBlank(jsonData)) return null;
        try {
            return MAPPER.readValue(jsonData, beanType);
        } catch (Exception e) {
            log.info(e);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json结果集转化为对象
     *
     * @param jsonData json数据
     * @param beanType 对象中的object类型
     * @return
     */
    public static <T> T jsonToPojo(Object jsonData, Class<T> beanType) {
        if (jsonData == null) return null;
        String json = objectToJson(jsonData);
        if (StringUtils.isBlank(json)) return null;
        try {
            return MAPPER.readValue(json, beanType);
        } catch (Exception e) {
            log.info(e);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json数据转换成pojo对象list
     * <p>Title: jsonToList</p>
     * <p>Description: </p>
     *
     * @param jsonData
     * @param beanType
     * @return
     */
    public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
        if (StringUtils.isBlank(jsonData)) return null;
        try {
            JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
            List<T> list = MAPPER.readValue(jsonData, javaType);
            return list;
        } catch (Exception e) {
//            log.info(e);
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> jsonToList2(String jsonData, Class<T> beanType) {
        if (StringUtils.isBlank(jsonData)) return null;
        try {
            JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
            List<T> list = MAPPER.readValue(jsonData, javaType);
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> List<T> jsonToList(Object jsonData, Class<T> beanType) {
        if (jsonData == null) return null;
        String json = objectToJson(jsonData);
        if (StringUtils.isBlank(json)) return null;
        try {
            JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
            List<T> list = MAPPER.readValue(json, javaType);
            return list;
        } catch (Exception e) {
            log.info(e);
            // e.printStackTrace();
        }

        return null;
    }

    public static boolean isJson(String str) {
        boolean result = false;
        if (StringUtils.isNotBlank(str)) {
            str = str.trim();
            if (str.startsWith("{") && str.endsWith("}")) {
                result = true;
            } else if (str.startsWith("[") && str.endsWith("]")) {
                result = true;
            }
        }
        return result;
    }

    public static class I18NObjectMapper extends ObjectMapper {

        private static final long serialVersionUID = 1L;

        public I18NObjectMapper() {
            super();
            this.setSerializationInclusion(Include.NON_NULL);
            SimpleModule module = new SimpleModule();
            module.addSerializer(String.class, new I18NStringSerializer());//翻译字符串
            //module.addSerializer(Long.class, ToStringSerializer.instance);
            //module.addSerializer(Long.TYPE, ToStringSerializer.instance);//解决long精度丢失问题
            this.registerModule(module);
        }
    }

    public static class I18NStringSerializer extends JsonSerializer<String> {

        @Override
        public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(I18NResourceBundleUtils.getLocalizedText(value));
        }

    }
}
