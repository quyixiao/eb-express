package com.lz.express.config.datasources;

import java.lang.annotation.*;

/**
 * <b>功能描述:多数据源注解</b>
 *
 * @author : guqy
 * <b>创建日期 :</b>
 * @date 2018/12/20 16:43
 * <b>修改历史:</b>(修改人,修改时间,修改原因/内容)
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default "";
}
