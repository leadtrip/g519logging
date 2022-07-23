package wood.mike

class LoggingEventController {

    def loggingEventService

    def index() {
        respond loggingEventService.findAll()
    }
}
