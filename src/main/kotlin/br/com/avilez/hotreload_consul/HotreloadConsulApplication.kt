package br.com.avilez.hotreload_consul

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
@EnableDiscoveryClient
class HotreloadConsulApplication() {

	@Bean
	fun getRestTemplate(): RestTemplate {
		return RestTemplate()
	}

}

fun main(args: Array<String>) {
	runApplication<HotreloadConsulApplication>(*args)
}
