/**
 * ����ģʽ
 * ȱ�㣺������̲߳��е���ʱ�ᴴ�����ʵ��
 *
 * Created by zhongyi on 2017/12/18.
 */

public class Singleton_0 {
    private static Singleton_0 instance;
    private Singleton_0(){}
    public static Singleton_0 getInstance() {
        if (instance == null) {
            instance = new Singleton_0();
        }
        return instance;
    }
}
