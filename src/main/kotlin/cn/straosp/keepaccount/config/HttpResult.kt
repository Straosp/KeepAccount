package cn.straosp.keepaccount.config

import kotlinx.serialization.Serializable

@Serializable
data class HttpResult<T>(
    val code:Int,
    val message:String,
    val data:T?
){
    companion object {
        fun ok() = HttpResult<Nothing>(code = 200,message = "success", data = null)
        fun <T> ok(data:T) = HttpResult<T>(code = 200,message = "success", data = data)
    }
}