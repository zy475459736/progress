### servlet2.4规范中提供了8个listener接口，可以将其分为三类，分别如下：

* 与servletContext有关的listner接口。
包括：ServletContextListener、ServletContextAttributeListener
* 与HttpSession有关的Listner接口。
包括：HttpSessionListner、HttpSessionAttributeListener、HttpSessionBindingListener、HttpSessionActivationListener；
* 与ServletRequest有关的Listener接口，
包括：ServletRequestListner、ServletRequestAttributeListener


### servlet filter和spring mvc Interceptor区别：
* 拦截器是基于java的反射机制的，而过滤器是基于函数回调。
* 拦截器不依赖与servlet容器，过滤器依赖与servlet容器。
* 拦截器只能对action请求起作用，而过滤器则可以对几乎所有的请求起作用。
* 拦截器可以访问action上下文、值栈里的对象，而过滤器不能访问。
* 在action的生命周期中，拦截器可以多次被调用，而过滤器只能在容器初始化时被调用一次。
* 拦截器可以获取IOC容器中的各个bean，而过滤器就不行，这点很重要，在拦截器里注入一个service，可以调用业务逻辑。
