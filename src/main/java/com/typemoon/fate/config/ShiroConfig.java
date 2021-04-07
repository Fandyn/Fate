package com.typemoon.fate.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }

    @Bean
    public JdbcRealm getJdbcRealm(DataSource dataSource) {
        JdbcRealm jdbcRealm = new JdbcRealm();
        //jdbcRealm从数据库查询用户及权限数据（数据库及表需要符合jdbcRealm规范）
        jdbcRealm.setDataSource(dataSource);
        //jdbcRealm默认开启认证功能，需要手动开启授权功能
        jdbcRealm.setPermissionsLookupEnabled(true);
        return jdbcRealm;
    }
//    public IniRealm getIniRealm() {
//        IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
//        return iniRealm;
//    }

    @Bean
//    public DefaultWebSecurityManager getDefaultWebSecurityManager(IniRealm iniRealm) {
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        //DefaultWebSecurityManager要完成检验需要IniRealm
//        securityManager.setRealm(iniRealm);
//        return securityManager;
//    }
    public DefaultWebSecurityManager getDefaultWebSecurityManager(JdbcRealm jdbcRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //DefaultWebSecurityManager要完成检验需要jdbcRealm
        securityManager.setRealm(jdbcRealm);
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
        filterMap.put("/index.html", "anon");
        filterMap.put("/login.html", "anon");
        filterMap.put("/regist.html", "anon");
        filterMap.put("/mio/login", "anon");
        filterMap.put("/**", "authc");
        filter.setFilterChainDefinitionMap(filterMap);

        return filter;
    }
}
