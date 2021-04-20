package com.typemoon.fate.service.impl;

import com.typemoon.fate.entity.Users;
import com.typemoon.fate.mapper.UsersMapper;
import com.typemoon.fate.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录表 服务实现类
 * </p>
 *
 * @author fandz
 * @since 2021-04-19
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
