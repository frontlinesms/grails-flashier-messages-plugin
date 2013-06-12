class GrailsFlashierMessagesGrailsPlugin {
	def version = '1.0-SNAPSHOT'
	def grailsVersion = "2.0 > *"
	def dependsOn = [:]
	def pluginExcludes = [
		"grails-app/views/error.gsp"
	]
	def observe = ['controllers']
	def title = 'Grails Flashier Messages Plugin'
	def author = 'Sitati Kituyi'
	def authorEmail = ""
	def description = 'Alternative to flash.message, that works between redirects and across multiple browser windows'
	def documentation = "http://grails.org/plugin/grails-flashier-messages"
	def license = "APACHE"
	def organization = [name:"FrontlineSMS", url:"http://www.frontlinesms.com/" ]

        def doWithDynamicMethods = { ctx ->
		applyDynamicMethods(application)
	}

	def onChange = { event ->
		applyDynamicMethods(application)
	}

        void applyDynamicMethods(application) {
                def svc = application.mainContext.oneTimeDataService
		application.controllerClasses.each { cc ->
			cc.clazz.metaClass.getFlash = { ->
				return application.mainContext.flashierMessageService	
			}
		}
        }
}

