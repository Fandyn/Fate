package com.typemoon.fate.service.impl;

import com.typemoon.fate.entity.UserInfo;
import com.typemoon.fate.mapper.UserInfoMapper;
import com.typemoon.fate.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author fandz
 * @since 2021-04-19
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
