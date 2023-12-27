package com.brionac.aop;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.ObjectUtil;
import com.brionac.entity.domain.Role;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.brionac.constants.Common.USER_ROLE;

@Aspect
@Component
public class HasRoleAspect {


    // 定义一个切面，括号内写入第1步中自定义注解的路径
    @Pointcut("@annotation(com.brionac.aop.HasRole)")
    private void roleCheck() {
    }

    @Before("roleCheck()")
    public void checkUserRole(JoinPoint joinPoint) {
        HasRole hasRole = getHasRoleAnnotation(joinPoint);

        //得到注解信息
        if (hasRole != null) {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();

            List<String> userRole;

            if(ObjectUtil.isNull(request.getSession().getAttribute(USER_ROLE))){
                throw new RuntimeException("无身份信息, 请检查是否登录了");
            }else{
                try {
                    //拿到session中的role数据
                    userRole = (List<String>) request.getSession().getAttribute(USER_ROLE);
                }catch (Exception e){
                    throw new RuntimeException("身份信息异常, 请检查是否登录了");
                }

            }

            //如果HasRole中的数据不是Session中的数据的子集,则表示权限不足
            if (!CollectionUtil.containsAll(userRole, CollectionUtil.toList(hasRole.value()))) {
                throw new RuntimeException("权限不足");
            }
        }
    }


    /**
     * 获取方法或类上的HasRole注解对象。该方法通过JoinPoint对象获取目标类和方法的信息，并使用Java反射获取相应的HasRole注解对象。
     * @param joinPoint
     * @return
     */
    private HasRole getHasRoleAnnotation(JoinPoint joinPoint) {
        Class<?> targetClass = joinPoint.getTarget().getClass();
        HasRole hasRole = targetClass.getAnnotation(HasRole.class);

        if (hasRole != null) {
            return hasRole;
        }

        String methodName = joinPoint.getSignature().getName();
        //getParameterTypes方法用于获取方法参数的类型数组
        Class<?>[] parameterTypes = getParameterTypes(joinPoint);
        try {
            targetClass = joinPoint.getTarget().getClass();
            return targetClass.getMethod(methodName, parameterTypes).getAnnotation(HasRole.class);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    /**
     * getParameterTypes方法用于获取方法参数的类型数组，
     * 并在getHasRoleAnnotation方法中使用。
     * 它通过JoinPoint对象获取方法的参数，并将参数的类型存储在数组中。
     * @param joinPoint
     * @return
     */
    private Class<?>[] getParameterTypes(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Class<?>[] parameterTypes = new Class<?>[args.length];
        for (int i = 0; i < args.length; i++) {
            parameterTypes[i] = args[i].getClass();
        }
        return parameterTypes;
    }
}