package wood.mike

import grails.gorm.services.Service
import grails.gorm.transactions.ReadOnly

@Service(LoggingEvent)
interface LoggingEventService {

    @ReadOnly('loggingDs')
    List<LoggingEvent> findAll()

}
