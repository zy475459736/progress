/**
 * ����ʽ
 * static final field
 * static final�����ڵ�һ�μ����ൽ�ڴ��о�����˳�ʼ����
 * �ô��Ǵ���ʵ���������̰߳�ȫ�ģ����������ʵ���Ĵ��������������������ļ����޷����á�
 * Created by zhongyi on 2017/12/18.
 */
public class Singleton_4 {
    //�����ʱ�ͳ�ʼ��
    private static final Singleton_4 instance = new Singleton_4();

    private Singleton_4(){}

    public static Singleton_4 getInstance(){
        return instance;
    }
}
