import cn.straosp.keepaccount.config.ShiroAuthRealm
import org.apache.shiro.authz.Authorizer
import org.apache.shiro.authz.ModularRealmAuthorizer
import org.apache.shiro.realm.Realm
import org.apache.shiro.spring.web.ShiroFilterFactoryBean
import org.apache.shiro.web.mgt.DefaultWebSecurityManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class ShiroConfig {
    
    @Bean
    open fun getShiroFilterFactoryBean(defaultWebSecurity: DefaultWebSecurityManager) : ShiroFilterFactoryBean {
        val shiroFilterFactoryBean = ShiroFilterFactoryBean()
        shiroFilterFactoryBean.securityManager = defaultWebSecurity
        shiroFilterFactoryBean.loginUrl = "/login"
        shiroFilterFactoryBean.unauthorizedUrl = "/tokenFailed"
        return shiroFilterFactoryBean
    }
    
    @Bean
    open fun getDefaultWebSecurityManager(realm: Realm) : DefaultWebSecurityManager = DefaultWebSecurityManager().apply {
        
        setRealm(realm)
    }
    
    @Bean
    open fun getRealm():Realm = ShiroAuthRealm()
    
    @Bean
    open fun authorizer():Authorizer = ModularRealmAuthorizer()
    
}