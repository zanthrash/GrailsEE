package grailsee

import grailsee.Logr

class FooService {

    boolean transactional = true

	@Logr
    public String go(message) {
		log.debug "In the FooService.go method"
		this.doSomthingExpensive()
		return message
    }

	public String doSomthingExpensive() {
		log.debug "starting the expensive thing"
		Thread.sleep(5 * 1000)
		log.debug "finishing up the expensive thing"
		"done"
	}
}
