package br.com.avilez.hotreload_consul.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.context.annotation.Configuration

@RefreshScope
@Configuration
@ConfigurationProperties("my")
class MyProperties {
    lateinit var prop: String
}