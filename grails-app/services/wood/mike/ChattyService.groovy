package wood.mike

import grails.gorm.transactions.Transactional

@Transactional
class ChattyService {

    def saySomething() {
        log.info("Something")
    }

    def sayThis(thingToSay) {
        log.info(thingToSay)
    }
}
