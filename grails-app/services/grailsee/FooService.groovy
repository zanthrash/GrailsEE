package grailsee

import grailsee.Logr

class FooService {

    boolean transactional = true

	@Logr
    public String go(message) {
		log.debug "In the FooService.go method"
		Thread.sleep(5 * 1000)
		return message
    }
}
