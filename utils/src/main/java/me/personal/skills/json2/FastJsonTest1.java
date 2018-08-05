package me.personal.skills.json2;

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
     * ����תjson��ʽ�ַ���
     */
    public void array2Json(){
        String[] arr = {"bill","green","maks","jim"};
        String jsonText = JSON.toJSONString(arr, true);
        System.out.println("array2Json()������jsonText=="+jsonText);
        // ��������jsonText==["bill","green","maks","jim"]
    }

    /**
     * json��ʽ�ַ���ת����
     */
    public void json2Array(){
        String jsonText = "[\"bill\",\"green\",\"maks\",\"jim\"]";
        JSONArray jsonArr = JSON.parseArray(jsonText);
        System.out.println("json2Array()������jsonArr=="+jsonArr);
        // ��������jsonArr==["bill","green","maks","jim"]
    }

    /**
     * ����תjson��ʽ�ַ���
     */
    public void array2Json2(){
        User user1 = new User("P001","TOM",16);
        User user2 = new User("P002","JACKSON",21);
        User user3 = new User("P003","MARTIN",20);
        User[] userArr = {user1,user2,user3};
        String jsonText = JSON.toJSONString(userArr, true);
        System.out.println("array2Json2()������jsonText=="+jsonText);
        //��������jsonText==[{"age":16,"id":"P001","name":"TOM"},{"age":21,"id":"P002","name":"JACKSON"},{"age":20,"id":"P003","name":"MARTIN"}]
    }

    /**
     * json��ʽ�ַ���ת����
     */
    public void json2Array2(){
        String jsonText = "[{\"age\":16,\"id\":\"P001\",\"name\":\"TOM\"},{\"age\":21,\"id\":\"P002\",\"name\":\"JACKSON\"},{\"age\":20,\"id\":\"P003\",\"name\":\"MARTIN\"}]";
        JSONArray jsonArr = JSON.parseArray(jsonText);
        System.out.println("json2Array2()������jsonArr=="+jsonArr);
        // ��������jsonArr==[{"age":16,"id":"P001","name":"TOM"},{"age":21,"id":"P002","name":"JACKSON"},{"age":20,"id":"P003","name":"MARTIN"}]
    }

    /**
     * list����תjson��ʽ�ַ���
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
        System.out.println("list2Json()������jsonText=="+jsonText);
        //��������jsonText==[{"age":16,"id":"L001","name":"TOM"},{"age":21,"id":"L002","name":"JACKSON"},{"age":20,"id":"L003","name":"MARTIN"}]
    }

    /**
     * list����תjson��ʽ�ַ���
     */
    public void list2Json2(){
        List list = new ArrayList();
        Address address1 = new Address("�㶫ʡ","������","��Է��·","580053");
        User user1 = new User("L001","TOM",16,address1);
        list.add(user1);
        Address address2 = new Address("����ʡ","�ϲ���","����·","330004");
        User user2 = new User("L002","JACKSON",21,address2);
        list.add(user2);
        Address address3 = new Address("����ʡ","������","������·","710114");
        User user3 = new User("L003","MARTIN",20,address3);
        list.add(user3);
        String jsonText = JSON.toJSONString(list, true);
        System.out.println("list2Json2()������jsonText=="+jsonText);
        //��������jsonText==[{"address":{"city":"������","post":"580053","province":"�㶫ʡ","street":"��Է��·"},"age":16,"id":"L001","name":"TOM"},{"address":{"city":"�ϲ���","post":"330004","province":"����ʡ","street":"����·"},"age":21,"id":"L002","name":"JACKSON"},{"address":{"city":"������","post":"710114","province":"����ʡ","street":"������·"},"age":20,"id":"L003","name":"MARTIN"}]
    }

    /**
     * mapתjson��ʽ�ַ���
     */
    public void map2Json(){
        Map map = new HashMap();
        Address address1 = new Address("�㶫ʡ","������","��Է��·","580053");
        map.put("address1", address1);
        Address address2 = new Address("����ʡ","�ϲ���","����·","330004");
        map.put("address2", address2);
        Address address3 = new Address("����ʡ","������","������·","710114");
        map.put("address3", address3);
        String jsonText = JSON.toJSONString(map, true);
        System.out.println("map2Json()������jsonText=="+jsonText);
        //��������jsonText=={"address1":{"city":"������","post":"580053","province":"�㶫ʡ","street":"��Է��·"},"address2":{"city":"�ϲ���","post":"330004","province":"����ʡ","street":"����·"},"address3":{"city":"������","post":"710114","province":"����ʡ","street":"������·"}}
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