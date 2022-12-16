package com.example.requestdebugger.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.filter.CommonsRequestLoggingFilter

@Configuration
class LoggingConfiguration {

    @Bean
    fun logFilter(): CommonsRequestLoggingFilter {
        val filter = CommonsRequestLoggingFilter()
        filter.setIncludeQueryString(true)
        filter.setIncludePayload(true)
        filter.setIncludeHeaders(true)
        filter.setIncludeClientInfo(true)
        filter.setMaxPayloadLength(10000)
        return filter
    }
}