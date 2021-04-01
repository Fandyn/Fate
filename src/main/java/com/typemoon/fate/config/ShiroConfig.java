package com.typemoon.fate.config;

import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public IniRealm getIniRealm() {
        IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
        return iniRealm;
    }

    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(IniRealm iniRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //DefaultWebSecurityManager要完成检验需要IniRealm
        securityManager.setRealm(iniRealm);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean factoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean filter = new ShiroFilterFactoryBean();
        //过滤器是shiro权限校验的核心，进行认证和授权需要DefaultWebSecurityManager
        filter.setSecurityManager(securityManager);
        //设置shiro的拦截规则
        Map<String, String> filterMap = new HashMap<>();
        filterMap.put("/", "anon");
        filterMap.put("/login1.html", "anon");
        filterMap.put("/regist.html", "anon");
        filterMap.put("/mio/login", "anon");
        filterMap.put("/**", "authc");
        filter.setFilterChainDefinitionMap(filterMap);

        return filter;
    }
}
