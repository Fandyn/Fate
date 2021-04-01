package com.typemoon.fate.service.impl;

import com.typemoon.fate.entity.Mio;
import com.typemoon.fate.mapper.MioMapper;
import com.typemoon.fate.service.IMioService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fandz
 * @since 2021-03-30
 */
@Service
public class MioServiceImpl extends ServiceImpl<MioMapper, Mio> implements IMioService {

    @Override
    public void checkLogin(String user, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user, password);
        subject.login(token);
    }
}
