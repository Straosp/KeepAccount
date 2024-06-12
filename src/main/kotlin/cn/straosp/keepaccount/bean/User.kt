package cn.straosp.keepaccount.bean

import kotlinx.serialization.Serializable

@Serializable
data class User(val id:Int,val username:String,val phone:String)

@Serializable
data class LoginUser(val username: String,val phone: String)