package br.com.avilez.hotreload_consul.controller

import br.com.avilez.hotreload_consul.config.MyProperties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DistributedPropertiesController {

    @Value("\${my.prop}")
    lateinit var value: String

    @Autowired
    lateinit var properties: MyProperties

    @GetMapping("/getConfigFromValue")
    fun getConfigFromValue(): String {
        return value
    }

    @GetMapping("/getConfigFromProperty")
    fun getConfigFromProperty(): String {
        return properties.prop
    }

}