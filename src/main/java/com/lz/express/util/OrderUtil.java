package com.lz.express.util;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;

@Slf4j
public class OrderUtil {

    public static String getUserPoolOrder(String pre) {
        SimpleDateFormat dateformat = new SimpleDateFormat("SSSyyyyMMddHHmmss");
        StringBuffer sb = new StringBuffer(pre);
        return sb.
                append((int) (Math.random() * 1000)).append(dateformat.format(System.currentTimeMillis())).toString();
    }

    public static void addLogNo( ) {
        addLogNo(null,null);
    }

    public static void addLogNo(String traceId, Long time ) {
        try {
            if(traceId == null){
                traceId = getUserPoolOrder("no");
            }
            if(time == null){
                time = System.currentTimeMillis();
            }
            ch.qos.logback.classic.Logger.inheritableThreadLocalNo.set(traceId);
            ch.qos.logback.classic.Logger.inheritableThreadLocalTime.set(time);
        } catch (Exception e) {
        }

    }



    public static void removeLogNo() {
        try {
            ch.qos.logback.classic.Logger.inheritableThreadLocalNo.remove();
            ch.qos.logback.classic.Logger.inheritableThreadLocalTime.remove();
        } catch (Exception e) {
            log.error("i99ieowoie",e);
        }
    }

    public static void main(String[] args) {
        System.out.println(getUserPoolOrder("oidsoi"));
    }
}
