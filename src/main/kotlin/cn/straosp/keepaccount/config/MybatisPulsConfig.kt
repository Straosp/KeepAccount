package cn.straosp.keepaccount.config

import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@MapperScan("cn.straosp.keepaccount.mapper")
class MybatisPulsConfig {
    
    @Bean
    fun paginationInnerInterceptor() = PaginationInnerInterceptor()
    
}