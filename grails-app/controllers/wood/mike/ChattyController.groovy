package wood.mike

import org.springframework.beans.factory.annotation.Value

class ChattyController {

    @Value( '${appEnv}' )
    def appEnv

    def chattyService

    def index() {
        log.info("Welcome to index")
        log.info("Logging configured from {}", grailsApplication.config.logging.config)
        log.info("Environment is $appEnv")
        chattyService.saySomething()
        render 'done'
    }
}
