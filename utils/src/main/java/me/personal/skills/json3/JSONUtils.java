package me.personal.skills.json3;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.*;

/**
 * Created by zhongyi on 2017/12/11.
 */
@SuppressWarnings("unchecked")
public class JSONUtils {

    /**1��
     * ת�� ServiceDataObject���ɵ�json�ַ���ΪJSONArray����
     * @param datasJSON
     * @return
     */
    public static JSONArray createJSONArray(String datasJSON){
        String datas = JSONUtils.json2String(datasJSON, "datas");
        JSONArray results = new JSONArray();;
        JSONArray datasJSONArray = JSONArray.fromObject(datas);
        Iterator<JSONObject> iterator = datasJSONArray.iterator();
        while(iterator.hasNext()){
            JSONObject data = (JSONObject) iterator.next();
            JSONObject eachDataObject = data.getJSONObject("data");
            results.element(eachDataObject);
        }
        return results;
    }

    /**
     * ת�� ServiceDataObject���ɵ�json�ַ���ΪList<JSONObject>����
     * @param datasJSON
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static List<JSONObject> createJSONObjects(String datasJSON){
        List<JSONObject> results = new ArrayList<JSONObject>();
        String datas = JSONUtils.json2String(datasJSON, "datas");
        JSONArray jsonArray = JSONArray.fromObject(datas);
        Iterator iterator = jsonArray.iterator();
        while(iterator.hasNext()){
            JSONObject data = (JSONObject) iterator.next();
            JSONObject eachDataObject = data.getJSONObject("data");
            results.add(eachDataObject);
        }
        return results;
    }

    /**
     * ת�� ServiceDataObject���ɵ�json�ַ���ΪJSONObject����
     * @param datasJSON
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static JSONObject createJSONObject(String datasJSON){
        JSONObject result = new JSONObject();
        String datas = JSONUtils.json2String(datasJSON, "datas");
        JSONArray jsonArray = JSONArray.fromObject(datas);
        Iterator iterator = jsonArray.iterator();
        while(iterator.hasNext()){
            JSONObject data = (JSONObject) iterator.next();
            JSONObject eachDataObject = data.getJSONObject("data");
            result = eachDataObject;
        }
        return result;
    }


    /**
     * ��json�ַ���ת����List<Map>(List����Map����).
     *
     * @param json the json
     * @return List<Map>
     *
     */

    public static  List<Map<String,Object>> jsonToList(String json) {
        List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
        String JSON = json.substring(1, json.length() - 1);
        JSON = JSON.replaceAll("},", "}^");
        StringTokenizer strTokenizer = new StringTokenizer(JSON, "^");
        while (strTokenizer.hasMoreTokens()) {
            String token = strTokenizer.nextToken();
            Map<String,Object> paraMap =getMap4Json(token);
            listMap.add(paraMap);
        }

        return listMap;
    }

    /**
     * ������json����ת��ΪMap����.
     *
     * @param jsonString the json string
     * @return the 4Json
     *
     */
    public static Map<String,Object> getMap4Json(String jsonString) {
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        String key;
        Object value;
        Map<String,Object> valueMap = new HashMap<String,Object>();
        Iterator<String> keyIter = jsonObject.keys();
        while (keyIter.hasNext()) {
            key =keyIter.next();
            value = String.valueOf(jsonObject.get(key));
            valueMap.put(key, value);
        }
        return valueMap;
    }

    /**
     * ���õ����Ե�JSON����.
     *
     * @param key the key
     * @param value the value
     * @return {a:1,b:8}
     *
     */
    public static String string2json(String key, String value) {
        JSONObject object = new JSONObject();
        object.put(key, value);
        return object.toString();
    }

    /**
     * ��jsonתΪ����.
     *
     * @param json the json
     * @param valueClz the value clz
     * @return ��Ӧ������
     *
     */
    public static Object json2Array(String json, Class<?> valueClz) {
        JSONArray jsonArray = JSONArray.fromObject(json);
        return JSONArray.toArray(jsonArray, valueClz);
    }

    /**
     * ��Collectionת����JSON.
     *
     * @param object the object
     * @return the string
     * @param:objectΪ����
     */
    public static String collection2json(Object object) {
        JSONArray jsonArray = JSONArray.fromObject(object);
        return jsonArray.toString();
    }

    /**
     * ������ת��ΪJSON.
     *
     * @param object the object
     * @return the string
     *
     */
    public static String array2json(Object object) {
        JSONArray jsonArray = JSONArray.fromObject(object);
        return jsonArray.toString();
    }

    /**
     * ��MapתΪJSON.
     *
     * @param object the object
     * @return the string
     *
     */
    public static String map2json(Map<String,Object> object) {
        JSONObject jsonObject = JSONObject.fromObject(object);
        return jsonObject.toString();
    }

    /**
     * ��JSONת����Map.
     *
     * @param keyArray the key array
     * @param json the json
     * @param valueClz the value clz
     * @return the map
     * @param:valueClzΪMap��value��Class,
     * @param:keyArrayΪMap��key
     */
    @SuppressWarnings("rawtypes")
    public static Map json2Map(Object[] keyArray, String json, Class<?> valueClz) {
        JSONObject jsonObject = JSONObject.fromObject(json);
        Map classMap = new HashMap();
        for (int i = 0; i < keyArray.length; i++) {
            classMap.put(keyArray[i], valueClz);
        }
        return (Map) JSONObject.toBean(jsonObject, Map.class, classMap);
    }

    /**
     * ��POJOת����JSON.
     *
     * @param object the object
     * @return the string
     *
     */
    public static String bean2json(Object object) {
        JSONObject jsonObject = JSONObject.fromObject(object);
        return jsonObject.toString();
    }

    /**
     * ��JSONת����POJO.
     *
     * @param json the json
     * @param beanClz the bean clz
     * @return the object
     *
     */
    @SuppressWarnings("rawtypes")
    public static Object json2Object(String json, Class beanClz) {
        return JSONObject.toBean(JSONObject.fromObject(json), beanClz);
    }

    /**
     * ��JSONת����String.
     *
     * @param json the json
     * @param key the key
     * @return the string
     */
    public static String json2String(String json, String key) {
        JSONObject jsonObject = JSONObject.fromObject(json);
        return jsonObject.get(key).toString();
    }

    /**
     * ��List ת����JSON.
     *
     * @param list the list
     * @return the string
     *
     */
    @SuppressWarnings("rawtypes")
    public static String list2json(List list){
        JSONArray jsonArray2 = JSONArray.fromObject(list);
        return jsonArray2.toString();
    }
}
