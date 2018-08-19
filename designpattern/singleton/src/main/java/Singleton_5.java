/**
 * ��̬�ڲ��� static nested class
 *
 * ����д����Ȼʹ��JVM������Ʊ�֤���̰߳�ȫ���⣻���� SingletonHolder ��˽�еģ�
 * ���� getInstance() ֮��û�а취�������������������ʽ�ģ�
 * ͬʱ��ȡʵ����ʱ�򲻻����ͬ����û������ȱ�ݣ�Ҳ������ JDK �汾��
 *
 * Created by zhongyi on 2017/12/18.
 */
public class Singleton_5 {

    private static class SingletonHolder {
        private static final Singleton_5 INSTANCE = new Singleton_5();
    }

    private Singleton_5 (){}

    public static final Singleton_5 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
