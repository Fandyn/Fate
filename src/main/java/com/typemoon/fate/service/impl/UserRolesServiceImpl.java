package com.typemoon.fate.service.impl;

import com.typemoon.fate.entity.UserRoles;
import com.typemoon.fate.mapper.UserRolesMapper;
import com.typemoon.fate.service.IUserRolesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色权限表 服务实现类
 * </p>
 *
 * @author fandz
 * @since 2021-04-19
 */
@Service
public class UserRolesServiceImpl extends ServiceImpl<UserRolesMapper, UserRoles> implements IUserRolesService {

}
