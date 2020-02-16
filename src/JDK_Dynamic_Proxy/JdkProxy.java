package JDK_Dynamic_Proxy;

import JDK_Dynamic_Aspect.Aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {

    private I_UserDao userDao;
    public Object createProxy(I_UserDao userDao){
        this.userDao = userDao;

        ClassLoader classLoader = JdkProxy.class.getClassLoader();

        Class [] clazz = userDao.getClass().getInterfaces();

        return Proxy.newProxyInstance(classLoader, clazz, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Aspect aspect = new Aspect();

        aspect.check_permission();

        Object obj = method.invoke(userDao, args);

        aspect.log();
        return obj;
    }
}
