# SSM_Base_Beans_AOP(Project_T2)

JDK动态代理的实质：
使用JDK的反射机制，构造一个目标类的代理类
对于目标类中的每一个方法，使用Method调用的方法，进行前后增强
留下这个代理类的调用接口


基于annotation的AspectJ真的是太酷炫了，后面要好好复习研究。

问题记录：
1. 在使用JDK动态代理的过程中，JdkProxy实现的接口InvocationHandler中的invoke方法，找不到是在哪里调用的
