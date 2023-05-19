package chat.chatapp

import mu.KotlinLogging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

private val logger = KotlinLogging.logger {}

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class ChatAppApplication

fun main(args: Array<String>) {
    runApplication<ChatAppApplication>(*args)

    // Logging
    logger.trace { "I'm trace! hello, world." }
    logger.debug { "I'm debug! Hello world." }
    logger.info { "I'm info! Hello world." }
    logger.warn { "I'm warn! Hello world." }
    logger.error { "I'm error! Hello world." }
}


// https://jsonobject.tistory.com/559
