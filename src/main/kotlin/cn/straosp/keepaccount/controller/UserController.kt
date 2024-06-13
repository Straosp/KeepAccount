package cn.straosp.keepaccount.controller

import cn.straosp.keepaccount.bean.LoginUser
import cn.straosp.keepaccount.config.HttpResult
import cn.straosp.keepaccount.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(@Autowired val userService: UserService) {
    
    @GetMapping("/getAllUser")
    fun getAllUser():HttpResult<*> {
        try {
            val users = userService.list()
            return HttpResult.ok(users)
        }catch(e:Exception){
            return HttpResult(code = 100, message = "error", data = null)
        }
    }

    @PostMapping("/login")
    fun userLogin(@RequestBody(required = true) loginUser: LoginUser?): HttpResult<*> {
        try {
            if (null == loginUser || loginUser.username.isBlank() || loginUser.phone.isBlank()){
                return HttpResult.paramsError("phone","username")
            }else{
                val user = userService.userLogin(loginUser)
                user?.let {

                    return HttpResult.ok(user)
                }
                return HttpResult(code = 100, message = "error", data = null)
            }
        }catch (e:Exception){
            return HttpResult(code = 100, message = "error", data = null)
        }
    }

    @GetMapping("/tokenFailed")
    fun tokenFailed():HttpResult<*> = HttpResult.error("token 已过期")

    
}