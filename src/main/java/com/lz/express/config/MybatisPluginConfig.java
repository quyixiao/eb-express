package com.lz.express.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.lz.mybatis.plugin.config.ResolverBeanPostProcessor;
import com.lz.mybatis.plugins.interceptor.*;
import com.lz.mybatis.plugins.interceptor.utils.PSpringContextUtils;
import com.lz.mybatis.plugins.interceptor.utils.t.PPTuple;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Configuration
public class MybatisPluginConfig {
    public static final org.slf4j.Logger log = LoggerFactory.getLogger(SqlLogInterceptor.class);


    //初始化变量
    @PostConstruct
    public void postConstruct() {
        log.info("开始初始化表数据");
        EncryptTableConfig.tableConfig.put("lt_user_phone", new PPTuple(Arrays.asList(new String[]{"real_name_en", "user_name_en", "id_number_en"}),
                Arrays.asList(new String[]{})));

    }


    @Bean
    public ResolverBeanPostProcessor resolverBeanPostProcessor() {

        return new ResolverBeanPostProcessor(new MyBatisBaomidouServiceImpl());
    }


    //更新数据恢复
    @Bean("restoreDataScopeInterceptor")
    public RestoreDataScopeInterceptor restoreDataScopeInterceptor() {
        return new RestoreDataScopeInterceptor();
    }

    //查询数据恢复
    @Bean("restoreQueryDataScopeInterceptor")
    @DependsOn("restoreDataScopeInterceptor")
    public RestoreQueryDataScopeInterceptor restoreQueryDataScopeInterceptor() {
        return new RestoreQueryDataScopeInterceptor();
    }

    //结果集数据解密
    @Bean("queryDecryptScopeInterceptor")
    @DependsOn("restoreQueryDataScopeInterceptor")
    public QueryDecryptScopeInterceptor queryDecryptScopeInterceptor() {
        return new QueryDecryptScopeInterceptor();
    }


    //打印日志
    @Bean("sqlLogInterceptor")
    @DependsOn("queryDecryptScopeInterceptor")
    public SqlLogInterceptor sqlLogInterceptor() {
        return new SqlLogInterceptor();
    }

    //数据加密
    @Bean("dataEncryptScopeInterceptor")
    @DependsOn("sqlLogInterceptor")
    public DataEncryptScopeInterceptor dataEncryptScopeInterceptor() {
        return new DataEncryptScopeInterceptor();
    }

    // 分页
    @Bean("paginationInterceptor")
    @DependsOn("dataEncryptScopeInterceptor")
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


    @Bean
    public PSpringContextUtils pSpringContextUtils() {
        return new PSpringContextUtils();
    }


}
