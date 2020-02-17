import CodeGenerationLib.CglibProxy;
import CodeGenerationLib.UserDao;
import JDK_Dynamic_Proxy.B_UserDao;
import JDK_Dynamic_Proxy.I_UserDao;
import JDK_Dynamic_Proxy.JdkProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args){

        System.out.println("hello world");
        Main m = new Main();
//        m.test_JdkProxy();
//        m.test_Cglib();
//        m.test_aop_based_proxy();
//        m.test_aspectj_xml();
        m.test_aspectj_annotation();
    }


    public void test_JdkProxy(){
        JdkProxy jdkProxy = new JdkProxy();
        I_UserDao userDao = new B_UserDao();
        I_UserDao userDao1 = (I_UserDao)jdkProxy.createProxy(userDao);

        userDao1.addUser();
        userDao1.deleteUser();
    }

    public void test_Cglib(){
        CglibProxy cglibProxy = new CglibProxy();
        UserDao userDao = new UserDao();
        UserDao userDao1 = (UserDao)cglibProxy.createProxy(userDao);
        userDao1.addUser();
        userDao1.deleteUser();
    }

    public void test_aop_based_proxy(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("AOP_Based_Proxy/applicationContext.xml");
        I_UserDao test = (I_UserDao)applicationContext.getBean("userDaoProxy");
        test.addUser();
        test.deleteUser();
    }

    /*
    *
    * res：
    * 前置通知：模拟执行权限检查...，目标类是：com.yyf.aspectj.xml.target.B_UserDao@3a7442c7，被植入增强处理的目标方法为：addUser
    * 环绕开始：执行目标方法之前，模拟开启事务...
    * 添加用户
    * 最终通知：模拟方法结束后的释放资源
    * 环绕结束，执行目标方法之后，模拟关闭事务...
     * 后置通知，模拟记录日志...，被植入增强处理的目标方法为：addUser
    * */
    public void test_aspectj_xml(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/yyf/aspectj/xml/applicationContext.xml");
        com.yyf.aspectj.xml.target.I_UserDao test = (com.yyf.aspectj.xml.target.I_UserDao)applicationContext.getBean("UserDao");
        test.addUser();
    }

    public void test_aspectj_annotation(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/yyf/aspectj/annotation/applicationContext.xml");
        com.yyf.aspectj.annotation.target.I_UserDao test = (com.yyf.aspectj.annotation.target.I_UserDao)applicationContext.getBean("userDao");
        test.addUser();
    }
}



