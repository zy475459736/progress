package utils.json2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhongyi on 2017/12/11.
 */
public class FastJsonTest1
{

    /**
     * 数组转json格式字符串
     */
    public void array2Json(){
        String[] arr = {"bill","green","maks","jim"};
        String jsonText = JSON.toJSONString(arr, true);
        System.out.println("array2Json()方法：jsonText=="+jsonText);
        // 输出结果：jsonText==["bill","green","maks","jim"]
    }

    /**
     * json格式字符串转数组
     */
    public void json2Array(){
        String jsonText = "[\"bill\",\"green\",\"maks\",\"jim\"]";
        JSONArray jsonArr = JSON.parseArray(jsonText);
        System.out.println("json2Array()方法：jsonArr=="+jsonArr);
        // 输出结果：jsonArr==["bill","green","maks","jim"]
    }

    /**
     * 数组转json格式字符串
     */
    public void array2Json2(){
        User user1 = new User("P001","TOM",16);
        User user2 = new User("P002","JACKSON",21);
        User user3 = new User("P003","MARTIN",20);
        User[] userArr = {user1,user2,user3};
        String jsonText = JSON.toJSONString(userArr, true);
        System.out.println("array2Json2()方法：jsonText=="+jsonText);
        //输出结果：jsonText==[{"age":16,"id":"P001","name":"TOM"},{"age":21,"id":"P002","name":"JACKSON"},{"age":20,"id":"P003","name":"MARTIN"}]
    }

    /**
     * json格式字符串转数组
     */
    public void json2Array2(){
        String jsonText = "[{\"age\":16,\"id\":\"P001\",\"name\":\"TOM\"},{\"age\":21,\"id\":\"P002\",\"name\":\"JACKSON\"},{\"age\":20,\"id\":\"P003\",\"name\":\"MARTIN\"}]";
        JSONArray jsonArr = JSON.parseArray(jsonText);
        System.out.println("json2Array2()方法：jsonArr=="+jsonArr);
        // 输出结果：jsonArr==[{"age":16,"id":"P001","name":"TOM"},{"age":21,"id":"P002","name":"JACKSON"},{"age":20,"id":"P003","name":"MARTIN"}]
    }

    /**
     * list集合转json格式字符串
     */
    public void list2Json(){
        List list = new ArrayList();
        User user1 = new User("L001","TOM",16);
        list.add(user1);
        User user2 = new User("L002","JACKSON",21);
        list.add(user2);
        User user3 = new User("L003","MARTIN",20);
        list.add(user3);
        String jsonText = JSON.toJSONString(list, true);
        System.out.println("list2Json()方法：jsonText=="+jsonText);
        //输出结果：jsonText==[{"age":16,"id":"L001","name":"TOM"},{"age":21,"id":"L002","name":"JACKSON"},{"age":20,"id":"L003","name":"MARTIN"}]
    }

    /**
     * list集合转json格式字符串
     */
    public void list2Json2(){
        List list = new ArrayList();
        Address address1 = new Address("广东省","深圳市","科苑南路","580053");
        User user1 = new User("L001","TOM",16,address1);
        list.add(user1);
        Address address2 = new Address("江西省","南昌市","阳明路","330004");
        User user2 = new User("L002","JACKSON",21,address2);
        list.add(user2);
        Address address3 = new Address("陕西省","西安市","长安南路","710114");
        User user3 = new User("L003","MARTIN",20,address3);
        list.add(user3);
        String jsonText = JSON.toJSONString(list, true);
        System.out.println("list2Json2()方法：jsonText=="+jsonText);
        //输出结果：jsonText==[{"address":{"city":"深圳市","post":"580053","province":"广东省","street":"科苑南路"},"age":16,"id":"L001","name":"TOM"},{"address":{"city":"南昌市","post":"330004","province":"江西省","street":"阳明路"},"age":21,"id":"L002","name":"JACKSON"},{"address":{"city":"西安市","post":"710114","province":"陕西省","street":"长安南路"},"age":20,"id":"L003","name":"MARTIN"}]
    }

    /**
     * map转json格式字符串
     */
    public void map2Json(){
        Map map = new HashMap();
        Address address1 = new Address("广东省","深圳市","科苑南路","580053");
        map.put("address1", address1);
        Address address2 = new Address("江西省","南昌市","阳明路","330004");
        map.put("address2", address2);
        Address address3 = new Address("陕西省","西安市","长安南路","710114");
        map.put("address3", address3);
        String jsonText = JSON.toJSONString(map, true);
        System.out.println("map2Json()方法：jsonText=="+jsonText);
        //输出结果：jsonText=={"address1":{"city":"深圳市","post":"580053","province":"广东省","street":"科苑南路"},"address2":{"city":"南昌市","post":"330004","province":"江西省","street":"阳明路"},"address3":{"city":"西安市","post":"710114","province":"陕西省","street":"长安南路"}}
    }

}

class Address{
    String province;
    String country;
    String road;
    String postnumber;
    public Address(String province,String country,String road,String postnumber){
        this.province = province;
        this.country= country;
        this.road = road;
        this.postnumber = postnumber;
    }
}

class User{
    String id;
    String name;
    int age;
    Address address;
    public User(String id,String name , int age , Address address){
        this.id = id;
        this.name = name;
        this.age =age;
        this.address = address;
    }
    public User(String id,String name , int age){
        this(id,name,age,null);
    }
}