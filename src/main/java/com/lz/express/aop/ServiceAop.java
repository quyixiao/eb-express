
package com.lz.express.aop;

import com.lz.express.util.StringUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 日志aop
 * Created by wutao on 2018/10/12.
 */
@Aspect
@Component
@Order(1)
public class ServiceAop {


    @Pointcut(value = "(@within(org.springframework.stereotype.Service) " +
            "   || @within(org.springframework.stereotype.Component))")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        String no = ch.qos.logback.classic.Logger.inheritableThreadLocalNo.get();
        if (StringUtil.isBlank(no)) {
            try {
                return point.proceed();
            } catch (Exception e) {
                throw e;
            }
        }

        Object result = null;
        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName();
        String key = "=>" + className + ":" + methodName;
        String oldNo = "";
        try {
            oldNo = ch.qos.logback.classic.Logger.inheritableThreadLocalNo.get();
            ch.qos.logback.classic.Logger.inheritableThreadLocalNo.set(oldNo + key);
            result = point.proceed();
            return result;
        } catch (Exception e) {
            throw e;
        } finally {
            ch.qos.logback.classic.Logger.inheritableThreadLocalNo.set(oldNo);
        }
    }


}
