package com.lz.express.config;


import com.baomidou.mybatisplus.MybatisMapperRegistry;
import com.lz.mybatis.plugin.service.MyBatisBaomidouService;
import com.lz.mybatis.plugin.utils.SqlParseUtils;
import com.lz.mybatis.plugin.utils.t.PluginTuple;
import com.lz.mybatis.plugin.utils.t.Tuple2;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.binding.MapperProxyFactory;
import org.apache.ibatis.reflection.ParamNameResolver;
import org.apache.ibatis.session.Configuration;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

@Slf4j
public class MyBatisBaomidouServiceImpl implements MyBatisBaomidouService {

    public static final org.slf4j.Logger logger = LoggerFactory.getLogger(SqlLogInterceptor.class);


    @Override
    public void init(List<PluginTuple> pluginTuples, Configuration configuration, Class type) {
        try {
            MybatisMapperRegistry mapperRegistry = (MybatisMapperRegistry) configuration.getMapperRegistry();
            Map<Class<?>, MapperProxyFactory<?>> knownMappers = SqlParseUtils.getFieldValue(mapperRegistry, "knownMappers");
            MapperProxyFactory mapperProxyFactory = knownMappers.get(type);
            Map<Method, MapperMethod> methodCache = mapperProxyFactory.getMethodCache();
            for (PluginTuple pluginTuple : pluginTuples) {
                Tuple2<Boolean, Method> data = pluginTuple.getData();
                Method method = data.getSecond();
                MapperMethod mapperMethod = methodCache.get(method);
                if (mapperMethod == null) {
                    if (mapperProxyFactory.getMapperInterface() != null) {
                        mapperMethod = new MapperMethod(mapperProxyFactory.getMapperInterface(), method, configuration);
                    } else {
                        mapperMethod = new MapperMethod(type, method, configuration);
                    }
                    MapperMethod.MethodSignature methodSignature = SqlParseUtils.getFieldValue(mapperMethod, "method");
                    ParamNameResolver paramNameResolver = SqlParseUtils.getFieldValue(methodSignature, "paramNameResolver");
                    SqlParseUtils.setFieldValue(paramNameResolver, "hasParamAnnotation", data.getFirst());
                    methodCache.put(method, mapperMethod);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("解析sql异常",e);
        }
    }

    @Override
    public void info(String info) {
      //  log.info(info);
    }


}
