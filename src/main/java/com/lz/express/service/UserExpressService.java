package com.lz.express.service;
/**
* <p>
* 物流表 服务类
* </p>
*
* @author quyixiao
* @since 2021-12-06
*/
import com.baomidou.mybatisplus.service.IService;
import com.lz.express.entity.UserExpress;

public interface UserExpressService extends IService<UserExpress> {



	UserExpress selectUserExpressById(Long id);


	Long insertUserExpress(UserExpress userExpress);


	Long insertOrUpdateUserExpress(UserExpress userExpress);


	int updateUserExpressById(UserExpress userExpress);


	int updateCoverUserExpressById(UserExpress userExpress);


	int deleteUserExpressById(Long id);


}
