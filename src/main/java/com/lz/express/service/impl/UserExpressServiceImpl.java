package com.lz.express.service.impl;
/**
* <p>
* 物流表 服务类
* </p>
*
* @author quyixiao
* @since 2021-12-06
*/

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lz.express.entity.UserExpress;
import com.lz.express.mapper.UserExpressMapper;
import com.lz.express.service.UserExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserExpressServiceImpl extends ServiceImpl<UserExpressMapper, UserExpress> implements UserExpressService {


    @Autowired
	private UserExpressMapper userExpressMapper;



	@Override
	public UserExpress selectUserExpressById(Long id){
		return userExpressMapper.selectUserExpressById(id);
	}



	@Override
	public Long insertUserExpress(UserExpress userExpress){
		return userExpressMapper.insertUserExpress(userExpress);
	}



	@Override
	public Long insertOrUpdateUserExpress(UserExpress userExpress){
		return userExpressMapper.insertOrUpdateUserExpress(userExpress);
	}



	@Override
	public int updateUserExpressById(UserExpress userExpress){
		return userExpressMapper.updateUserExpressById(userExpress);
	}



	@Override
	public int updateCoverUserExpressById(UserExpress userExpress){
		return userExpressMapper.updateCoverUserExpressById(userExpress);
	}



	@Override
	public int deleteUserExpressById(Long id){
		return userExpressMapper.deleteUserExpressById(id);
	}



}
