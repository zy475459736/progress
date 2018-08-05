package me.personal.skills.json1;

/**
 * Created by zhongyi on 2017/12/11.
 */
public class demo {
    public static void main(String[] args) {

        Entity entity = new Entity();
        entity.setTestdouble(1.1);
        entity.setTestDouble(Double.valueOf(1.1));
        entity.setTestfloat(1.1f);
        entity.setTestFloat(Float.valueOf(1.1f));
        entity.setTestinteger(1);
        entity.setTestInteger(Integer.valueOf(1));
        entity.setTestlong(1L);
        entity.setTestLong(Long.valueOf(1L));

        try {
            String json = EntityAndJSON.toJSON(entity);
            System.out.println(json);
//
//            Entity con = EntityAndJSON.json2Object(json, Entity.class);
//            json = EntityAndJSON.toJSON(con);
//            System.out.println(json);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
