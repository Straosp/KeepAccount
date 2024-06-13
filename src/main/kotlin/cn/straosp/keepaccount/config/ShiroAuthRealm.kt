package cn.straosp.keepaccount.config

import cn.straosp.keepaccount.bean.User
import cn.straosp.keepaccount.service.UserService
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper
import org.apache.shiro.authc.AuthenticationInfo
import org.apache.shiro.authc.AuthenticationToken
import org.apache.shiro.authc.SimpleAuthenticationInfo
import org.apache.shiro.authc.UsernamePasswordToken
import org.apache.shiro.authz.AuthorizationInfo
import org.apache.shiro.realm.AuthorizingRealm
import org.apache.shiro.subject.PrincipalCollection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
open class ShiroAuthRealm  : AuthorizingRealm() {
    
    @Autowired
    lateinit var userService: UserService

    override fun doGetAuthorizationInfo(principals: PrincipalCollection?): AuthorizationInfo? = null
    
    @Throws
    override fun doGetAuthenticationInfo(token: AuthenticationToken?): AuthenticationInfo? {
        if (token is UsernamePasswordToken) {
            val queryWrapper = LambdaQueryWrapper<User>()
            queryWrapper.eq(User::phone,token.password)
            queryWrapper.last("LIMIT 1")
            val user:User? = userService.getOne(queryWrapper)
            user?.let {
                return SimpleAuthenticationInfo(user,user.phone,user.username)
            }
        }
        return null
    }
    
    
    
}