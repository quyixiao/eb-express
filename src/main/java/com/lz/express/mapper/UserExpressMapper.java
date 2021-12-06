package com.lz.express.mapper;
/**
* <p>
* 物流表 服务类
* </p>
*
* @author quyixiao
* @since 2021-12-06
*/

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lz.express.entity.UserExpress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserExpressMapper extends BaseMapper<UserExpress> {


	UserExpress selectUserExpressById(@Param("id") Long id);


	Long insertUserExpress(UserExpress userExpress);


	Long insertOrUpdateUserExpress(UserExpress userExpress);


	int updateUserExpressById(UserExpress userExpress);


	int updateCoverUserExpressById(UserExpress userExpress);


	int deleteUserExpressById(@Param("id") Long id);


}
