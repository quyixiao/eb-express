package com.lz.express.aop;

import com.alibaba.fastjson.JSON;
import com.lz.express.util.CommonUtil;
import com.lz.express.util.OrderUtil;
import org.apache.catalina.connector.ResponseFacade;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 日志aop
 * Created by wutao on 2018/10/12.
 */
@Aspect
@Component
@Order(1)
public class LogAop {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private String BLANK_SPACE = "    ";


    @Pointcut(value = "(@within(org.springframework.web.bind.annotation.RestController) " +
            "   || @within(org.springframework.stereotype.Controller))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        StringBuffer sb = new StringBuffer();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        try {
            ch.qos.logback.classic.Logger.inheritableThreadLocalNo.set(OrderUtil.getUserPoolOrder("o"));
            ch.qos.logback.classic.Logger.inheritableThreadLocalTime.set(System.currentTimeMillis());
            sb.append(recordRequestLog(point.getArgs()).toString());
            result = point.proceed();
        } catch (Exception e) {
            logger.error("threadLocalSeq set error " + sb.toString(), e);
            throw e;
        } finally {
            try {

                recordResponLog(sb, result);
            } catch (Exception e) {

            }
            ch.qos.logback.classic.Logger.inheritableThreadLocalNo.remove();
            ch.qos.logback.classic.Logger.inheritableThreadLocalTime.remove();
        }
        return result;
    }


    private StringBuffer recordRequestLog(Object[] argArrs) {
        StringBuffer sb = new StringBuffer();
        sb.setLength(0);
        sb.append("【lzapp]").append(BLANK_SPACE);
        String uri = "";
        String mediaType = "";
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        mediaType = request.getContentType();
        try {
            String args = null;
            uri = request.getRequestURI();
            List<Object> list = new ArrayList<>();
            if (argArrs != null && argArrs.length > 0) {
                for (Object arg1 : argArrs) {
                    if (arg1 instanceof HttpServletResponse) {
                        continue;
                    } else if (arg1 instanceof HttpServletRequest) {
                        continue;
                    } else if (arg1 instanceof MultipartFile) {
                        continue;
                    } else if (arg1 instanceof MultipartFile[]) {
                        continue;
                    } else if (arg1 instanceof ResponseFacade) {
                        continue;
                    } else if (arg1 instanceof org.apache.catalina.servlet4preview.http.HttpServletRequestWrapper) {
                        continue;
                    } else {
                        list.add(arg1);
                    }
                }
            }
            args = JSON.toJSONString(list);
            String reqD = Optional.ofNullable(args).map(
                    s -> org.apache.commons.lang3.StringUtils.substring(s, 0, 1000)
            ).orElse("");

            sb.append("uri=").append(request.getRequestURI()).append(BLANK_SPACE)
                    .append("rmtIP=").append(CommonUtil.getIpAddr(request)).append(BLANK_SPACE);
            sb.append("params=").append(reqD).append(BLANK_SPACE);
        } catch (Exception e) {
            logger.error("url " + request.getRequestURL() + " , uri " + uri + " ,mediaType " + mediaType + ", 打印请求日志错误" + sb.toString(), e);
        }
        return sb;
    }


    private void recordResponLog(StringBuffer sb, Object result) {
        try {
            sb.append("resp=").append(JSON.toJSONString(result));
            logger.info(sb.toString());
        } catch (Exception e) {
            logger.warn("打印响应日志错误", e);
            logger.info("响应日志错误", sb.toString());
        }
    }


}
