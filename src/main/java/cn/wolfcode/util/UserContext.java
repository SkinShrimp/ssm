package cn.wolfcode.util;

import cn.wolfcode.domain.Employee;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

public class UserContext {
    public static final String EMP_IN_SESSION = "EMP_IN_SESSION";
    public static final String EXPRESSIONS_IN_SESSION = "EXPRESSIONS_IN_SESSION";

    public static HttpSession getSession() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).
                getRequest().getSession();
    }

    public static void setCurrentEmp(Employee currentEmp) {
        getSession().setAttribute(EMP_IN_SESSION, currentEmp);
    }

    public static void setExpressions(List<String> expressions) {
        getSession().setAttribute(EXPRESSIONS_IN_SESSION, expressions);
    }

    public static Employee getCurrentEmp() {
        return (Employee) getSession().getAttribute(EMP_IN_SESSION);
    }

    public static List<String> getExpressions() {
        return (List<String>) getSession().getAttribute(EXPRESSIONS_IN_SESSION);
    }
}