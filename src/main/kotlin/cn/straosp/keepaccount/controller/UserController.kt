package cn.straosp.keepaccount.controller

import cn.straosp.keepaccount.bean.LoginUser
import cn.straosp.keepaccount.bean.User
import cn.straosp.keepaccount.config.HttpResult
import cn.straosp.keepaccount.service.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "账户相关APi")
@RequestMapping("/user")
class UserController(@Autowired val userService: UserService) {
    
    @PostMapping("/getAllUser")
    fun getAllUser():HttpResult<List<User>> {
        try {
            val users = userService.list()
            return HttpResult.ok(users)
        }catch(e:Exception){
            return HttpResult<List<User>>(code = 100, message = "error", data = emptyList())
        }
    }
    
}