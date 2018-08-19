/**
 * ����ģʽ
 * �̰߳�ȫ
 * ȱ�㣺ͬ�����������ڵ�һ�ε���ʱ��Ҫsynchronize������
 *       ���沢����Ҫ
 * Created by zhongyi on 2017/12/18.
 */

public class Singleton_1 {
    private static Singleton_1 instance;
    private Singleton_1(){}
    public static synchronized Singleton_1 getInstance() {
        if (instance == null) {
            instance = new Singleton_1();
        }
        return instance;
    }
}
