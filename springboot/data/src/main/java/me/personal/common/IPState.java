package me.personal.common;

/**
 * Created by zhongyi on 2018/7/23.
 */
public enum IPState {

    FREE(0,"free"),
    USED(1,"using"),
    DISUSE(2,"disuse");

    private int code;
    private String text;

    IPState(int code,String text){
        this.code = code;
        this.text = text;
    }

    public int getCode(){
        return this.code;
    }

    public static String getNameByCode(int code){

        for(IPState type:values()){
            if(type.code == code){
                return type.text;
            }
        }
        return  "unknow";
    }

    public static int getCodeByName(String name){

        for(IPState type:values()){
            if(type.text.equalsIgnoreCase(name)){
                return type.code;
            }
        }
        return 0;
    }

    public static IPState getStateByCode(int code){

        for(IPState type:values()){
            if(type.code == code){
                return type;
            }
        }
        return FREE;
    }

    public static IPState getStateByName(String name){

        for(IPState type:values()){
            if(type.text.equalsIgnoreCase(name)){
                return type;
            }
        }
        return FREE;
    }
}
