package cn.wolfcode.web.interceptor;

import cn.wolfcode.domain.Employee;
import cn.wolfcode.util.RequiredPermission;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;

public class SecurityInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1、获取到当前登陆的用户
        Employee employee = (Employee) request.getSession().getAttribute("EMP_IN_SESSION");
        //2、当前登陆用户为超级管理员，放行
        if (employee.isAdmin()) {
            return true;
        }
        HandlerMethod hm = (HandlerMethod) handler;

        //3、判断访问方法上有没有贴RequirePermission注解，没有放行
        Method method = hm.getMethod();
        if(!method.isAnnotationPresent(RequiredPermission.class)){
            return true;
        }

        //4、判断用户拥有访问该方法的权限,放行
        String controllerName = hm.getBeanType().getName();
        String methodName = hm.getMethod().getName();
        String expression = controllerName+":"+methodName;
        List<String> list = (List<String>) request.getSession().getAttribute("EXPRESSIONS_IN_SESSION");
        if(list.contains(expression)){
            return true;
        }

        //5、跳转错误页面
        request.getRequestDispatcher("/WEB-INF/views/common/nopermission.jsp").forward(request, response);
        return false;
    }
}
