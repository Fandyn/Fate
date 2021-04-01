package com.typemoon.fate.service;

import com.typemoon.fate.entity.Mio;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fandz
 * @since 2021-03-30
 */
public interface IMioService extends IService<Mio> {

    public void checkLogin(String user, String password) throws Exception;

}
