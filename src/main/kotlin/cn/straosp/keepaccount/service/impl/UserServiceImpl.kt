package cn.straosp.keepaccount.service.impl

import cn.straosp.keepaccount.bean.LoginUser
import cn.straosp.keepaccount.bean.User
import cn.straosp.keepaccount.mapper.UserMapper
import cn.straosp.keepaccount.service.UserService
import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : ServiceImpl<UserMapper,User>() , UserService {


    override fun selectUserByPhone(phone: String): User? {
        val wrapper = KtQueryWrapper(User::class.java).eq(User::phone,phone).last("LIMIT 1")
        return baseMapper.selectList(wrapper)?.first()
    }

    override fun selectUserByUsername(username: String): List<User?> {
        val wrapper = KtQueryWrapper(User::class.java).eq(User::username,username).last("LIMIT 1")
        return baseMapper.selectList(wrapper)
    }

    override fun userLogin(loginUser: LoginUser): User? {
        val wrapper = KtQueryWrapper(User::class.java).eq(User::username,loginUser.username).eq(User::phone,loginUser.phone).last("LIMIT 1")
        return baseMapper.selectList(wrapper)?.first()
    }
    
}