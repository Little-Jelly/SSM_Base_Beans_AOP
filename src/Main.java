import CodeGenerationLib.CglibProxy;
import CodeGenerationLib.UserDao;
import JDK_Dynamic_Proxy.B_UserDao;
import JDK_Dynamic_Proxy.I_UserDao;
import JDK_Dynamic_Proxy.JdkProxy;

public class Main {
    public static void main(String[] args){

        System.out.println("hello world");
        Main m = new Main();
//        m.test_JdkProxy();
        m.test_Cglib();
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
}



