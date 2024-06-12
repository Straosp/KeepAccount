package cn.straosp.keepaccount.mapper

import cn.straosp.keepaccount.bean.User
import com.baomidou.mybatisplus.core.mapper.BaseMapper

interface UserMapper : BaseMapper<User> {
    
    fun selectByPhone(phone:String):User?
    
}