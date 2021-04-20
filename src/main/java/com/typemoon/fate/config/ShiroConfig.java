package com.typemoon.fate.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.realm.jdbc.JdbcRealm;
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
    //寻不得一种方法可以解释所有事物

    /**
     *命运究竟是什么呢？
     * 是按照既定的道路一昧的活着，还是生来就具有的一种使命
     * 所谓屈服于命运，是指厌倦了什么呢？争斗？傲慢？还是说害怕着什么呢？失去？死亡？
     * 毛虫破茧涅槃，是对命运的屈从还是反抗呢？
     * 庶民的只需屈服即可，这就是他们的命运，是他们的使命，是他们唯一的价值
     *权贵如此说道
     * 不，我们要反抗，我们需要英雄
     * 英雄的使命便是革命，这是英雄的命运
     * 命运难道不是一种被他人强加的期望吗
     * 无论这期望是当救世的英雄，还是做卑微的奴隶
     * 命运，枷锁尔！
     * 有人甘之如饴，有人视若砒霜
     * 有人怒斥命运的不公
     * 命运却笑出了声
     * 不甘，傲慢，嫉妒，贪婪，诸般大罪缠绕其身，吞噬其心，最终化为
     *
     */

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
        filterMap.put("/login", "anon");
        filterMap.put("/index", "anon");
        filterMap.put("/mio/login", "anon");
        filterMap.put("/**", "authc");
        filter.setFilterChainDefinitionMap(filterMap);
        return filter;
    }
}
