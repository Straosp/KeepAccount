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

        fun error() = HttpResult(code = 100, message = "失败",data = null)
        fun error(message: String) = HttpResult(code = 101, message = message,data = null)
        fun paramsError(vararg params:String) = HttpResult(code = 102, message = params.joinToString(),data = null)
    }
}