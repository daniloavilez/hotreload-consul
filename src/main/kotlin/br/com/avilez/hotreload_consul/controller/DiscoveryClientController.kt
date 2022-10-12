package br.com.avilez.hotreload_consul.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.net.URI
import java.util.*
import javax.naming.ServiceUnavailableException

@RestController
class DiscoveryClientController(val discoveryClient: DiscoveryClient) {

    @Autowired
    lateinit var restTemplate: RestTemplate

    fun serviceUrl(): Optional<URI>? {
        return discoveryClient.getInstances("myApp")
                .stream()
                .findFirst()
                .map { it.uri }
    }

    @GetMapping("/discoveryClient")
    fun discoveryPing(): String {

        val service = serviceUrl()?.map { it.resolve("/ping") }

        return restTemplate.getForEntity(service!!.get(), String.javaClass)
                .body.toString()
    }

    @GetMapping("/ping")
    fun ping(): String {
        return "Pong"
    }

}