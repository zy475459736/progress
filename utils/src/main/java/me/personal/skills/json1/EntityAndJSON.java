package me.personal.skills.json1;

import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by zhongyi on 2017/12/11.
 */
public class EntityAndJSON {
    /**
     * ��ʵ��ת��Ϊjson�ַ���
     *
     * @param t
     * @return
     * @throws Exception
     */
    public static <T> String toJSON(T t) throws Exception {
        JSONObject jsonObject = new JSONObject();
        Field[] fieldArr = t.getClass().getDeclaredFields();
        for (Field field : fieldArr) {
            JSON json = field.getAnnotation(JSON.class);
            if (json != null) {
                Object value = getValue(t, field);
                jsonObject.put(json.name(), value);
            }
            System.err.println(field.getName());

        }
        return jsonObject.toString();
    }

    /**
     * ��JSONת��ΪObject
     *
     * @param jsonObject
     * @param clazT
     * @return
     * @throws Exception
     */
    public static <T> T json2Object(String jsonStr, Class<T> clazT)
            throws Exception {
        JSONObject jsonObject = new JSONObject(jsonStr);
        Field[] fieldArr = clazT.getDeclaredFields();
        T t = clazT.newInstance();
        for (Field field : fieldArr) {
            JSON json = field.getAnnotation(JSON.class);
            if (json == null) {
                continue;
            }
            if (!jsonObject.has(json.name())) {
                continue;
            }
            Object value = jsonObject.get(json.name());

            setValue(t, field, toObject(field, value.toString()));

        }
        return t;
    }

    /**
     * ��ȡSet����
     *
     * @param filedName
     * @param claz
     * @return
     * @throws Exception
     */
    private static Method getSetMethod(Field field, Class claz)
            throws Exception {
        return claz.getMethod(createMethodName("set", field.getName()),
                field.getType());
    }

    /**
     * ��ȡget����
     *
     * @param fileName
     * @param claz
     * @return
     * @throws Exception
     */
    private static Method getGetMethod(String filedName, Class claz)
            throws Exception {

        return claz.getMethod(createMethodName("get", filedName));
    }

    /**
     * ���ɷ�������
     *
     * @param startWith
     * @param fieldName
     * @return
     */
    private static String createMethodName(String startWith, String fieldName) {
        String methodName = startWith + fieldName.substring(0, 1).toUpperCase()
                + fieldName.substring(1, fieldName.length());
        return methodName;
    }

    /**
     * ��ȡ��Field��ֵ
     *
     * @param t
     * @param field
     * @return
     * @throws Exception
     */
    private static <T> Object getValue(T t, Field field) throws Exception {
        Method method = getGetMethod(field.getName(), t.getClass());
        if (method == null) {
            throw new Exception("û��field.getName()��get����");
        }
        return method.invoke(t);
    }

    /**
     * ����Set������ֵset��T��
     *
     * @param t
     * @param field
     * @param value
     * @throws Exception
     */
    private static <T> void setValue(T t, Field field, Object value)
            throws Exception {
        Method method = getSetMethod(field, t.getClass());
        if (method == null) {
            throw new Exception("û��field.getName()��set����");
        }
        method.invoke(t, value);
    }

    /**
     * ת����������
     *
     * @param field
     * @param value
     * @return
     */
    private static Object toObject(Field field, String value) {
        if (value == null) {
            return null;
        }
        String typeName = field.getType().getSimpleName();
        if (typeName.equals("int") || typeName.equals("Integer")) {
            return Integer.valueOf(value);
        }
        if (typeName.equals("double") || typeName.equals("Double")) {
            return Double.valueOf(value);
        }
        if (typeName.equals("float") || typeName.equals("Float")) {
            return Float.valueOf(value);
        }

        if (typeName.equals("long") || typeName.equals("Long")) {
            return Long.valueOf(value);
        }

        return value;
    }

}
