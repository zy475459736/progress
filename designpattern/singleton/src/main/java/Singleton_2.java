/**
 * ����ģʽ
 * ˫�ؼ�����
 * volatile��ָֹ���������Ż�
 * ȱ�㣺`instance = new Singleton()`����ԭ�Ӳ�����
 *       1���� instance �����ڴ�
 *       2������ Singleton �Ĺ��캯������ʼ����Ա����
 *       3����instance����ָ�������ڴ�ռ䣨ִ�����ⲽ instance ��Ϊ�� null �ˣ�
 * Created by zhongyi on 2017/12/18.
 */

public class Singleton_2 {
    private static Singleton_2 instance;
    private Singleton_2(){}

    public static Singleton_2 getSingleton() {
        if (instance == null) {                         //Single Checked
            synchronized (Singleton_2.class) {
                if (instance == null) {                 //Double Checked
                    instance = new Singleton_2();
                }
            }
        }
        return instance;
    }
}
