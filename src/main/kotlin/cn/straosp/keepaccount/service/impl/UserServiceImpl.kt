package cn.straosp.keepaccount.service.impl

import cn.straosp.keepaccount.bean.User
import cn.straosp.keepaccount.mapper.UserMapper
import cn.straosp.keepaccount.service.UserService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : ServiceImpl<UserMapper,User>() , UserService {


    /*
    override fun selectUserByPhone(phone: String): User?  = babaseMapper.selectById(0)

    override fun selectUserByUsername(username: String): List<User?> {
        return emptyList()
    }
    */
    
}