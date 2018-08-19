/**
 * ����ģʽ
 * ˫�ؼ�����
 * ��Singleton_0 he Singleton_1�Ļ����Ͻ������
 * ȱ�㣺`instance = new Singleton()`����ԭ�Ӳ�����
 *       1���� instance �����ڴ�
 *       2������ Singleton �Ĺ��캯������ʼ����Ա����
 *       3����instance����ָ�������ڴ�ռ䣨ִ�����ⲽ instance ��Ϊ�� null �ˣ�
 * Created by zhongyi on 2017/12/18.
 */

public class Singleton_3 {

    private volatile static Singleton_3 instance;

    private Singleton_3(){}

    public static Singleton_3 getSingleton() {
        if (instance == null) {                         //Single Checked
            synchronized (Singleton_3.class) {
                if (instance == null) {                 //Double Checked
                    instance = new Singleton_3();
                }
            }
        }
        return instance;
    }
}
