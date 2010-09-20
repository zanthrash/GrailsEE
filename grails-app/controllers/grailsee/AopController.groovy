package grailsee


class AopController {
	def fooService
	
    def index = { }

	def foo = {
		fooService.go("This Should be Logged")
		render "Exercising FooService.go() method"
	}
}
