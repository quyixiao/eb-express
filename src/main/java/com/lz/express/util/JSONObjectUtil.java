package com.lz.express.util;

import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;

public class JSONObjectUtil {
    public static <T> T getValue(String str, String path, Class<T> clazz) {
        String as[] = path.split("\\.");
        for (int i = 0; i < as.length; i++) {
            String b = as[i];
            JSONObject jsonObject = JSONObject.parseObject(str);
            if (jsonObject != null) {
                Object temp = jsonObject.get(b);
                if (temp != null) {
                    str = temp.toString();
                }
            }
        }
        return (T) parseBasicTypeWrapper(clazz, str);
    }

    public static Object parseBasicTypeWrapper(Class<?> parameterType, Object value) {
        if (Number.class.isAssignableFrom(parameterType)) {
            if (parameterType == Integer.class) {
                return NumberUtil.objToIntDefault(value, null);
            } else if (parameterType == Short.class) {
                return NumberUtil.objToShortDefault(value, null);
            } else if (parameterType == Long.class) {
                return NumberUtil.objToLongDefault(value, null);
            } else if (parameterType == Float.class) {
                return NumberUtil.objToFloatDefault(value, null);
            } else if (parameterType == Double.class) {
                return NumberUtil.objToDoubleDefault(value, null);
            } else if (parameterType == Byte.class) {
                return NumberUtil.objToByteDefault(value, null);
            }
        } else if (parameterType == Boolean.class) {
            return NumberUtil.objToBooleanDefault(value, null);
        } else if (parameterType == Character.class) {
            return NumberUtil.objToCharacterDefault(value, null);
        } else if (parameterType == String.class) {
            return value.toString();
        } else if (parameterType == BigDecimal.class) {
            return NumberUtil.objToBigDecimalDefault(value, null);
        }
        return null;
    }

    public static void main(String[] args) {
        String a = "{\"result\":{\"position\":{\"x1\":59,\"x2\":775,\"x3\":789,\"x4\":47,\"y1\":95,\"y2\":95,\"y3\":1251,\"y4\":1250},\"type\":{\"id_card\":0.958},\"front_back\":0.05,\"style\":{\"ori_shooting\":0.992,\"screen_remark\":0.008,\"photocopy\":0.001,\"color_scan\":0.0,\"scan\":0.0},\"integrity\":0.739,\"light_spot\":0.081,\"blurry\":0.022},\"code\":200,\"message\":\"OK\"}";
        double b = getValue(a, "result.front_back", Double.class);
        System.out.println(b);
    }

}
