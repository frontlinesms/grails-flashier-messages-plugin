class GrailsFlashierMessagesGrailsPlugin {
	// the plugin version
	def version = "0.1-SNAPSHOT"
	// the version or versions of Grails the plugin is designed for
	def grailsVersion = "2.0 > *"
	// the other plugins this plugin depends on
	def dependsOn = [:]
	// resources that are excluded from plugin packaging
	def pluginExcludes = [
	"grails-app/views/error.gsp"
	]
	def observe = ['controllers']

	// TODO Fill in these fields
	def title = "Grails Flashier Messages Plugin" // Headline display name of the plugin
	def author = "FrontlineSMS"
	def authorEmail = ""
	def description = '''\
	Alternative to flash.message, that works between redirects and across multiple browser windows
	'''

	// URL to the plugin's documentation
	def documentation = "http://grails.org/plugin/grails-flashier-messages"

	// Extra (optional) plugin metadata

	// License: one of 'APACHE', 'GPL2', 'GPL3'
	//    def license = "APACHE"

	// Details of company behind the plugin (if there is one)
	//    def organization = [ name: "My Company", url: "http://www.my-company.com/" ]

	// Any additional developers beyond the author specified above.
	//    def developers = [ [ name: "Joe Bloggs", email: "joe@bloggs.net" ]]

	// Location of the plugin's issue tracker.
	//    def issueManagement = [ system: "JIRA", url: "http://jira.grails.org/browse/GPMYPLUGIN" ]

	// Online location of the plugin's browseable source code.
	//    def scm = [ url: "http://svn.grails-plugins.codehaus.org/browse/grails-plugins/" ]

	def doWithWebDescriptor = { xml ->
		// TODO Implement additions to web.xml (optional), this event occurs before
	}

	def doWithSpring = {
		// TODO Implement runtime spring config (optional)
	}

        def doWithDynamicMethods = { ctx ->
		applyDynamicMethods(application)
	}

	def doWithApplicationContext = { applicationContext ->
		// TODO Implement post initialization spring config (optional)
	}

	def onChange = { event ->
		applyDynamicMethods(application)
	}

        void applyDynamicMethods(application) {
                def svc = application.mainContext.oneTimeDataService

                        application.controllerClasses.each { cc ->
				cc.clazz.metaClass.setFlashMessage = { message ->
					delegate.oneTimeData('message') { text = message }
				}   
			}
        }

	def onConfigChange = { event ->
		// TODO Implement code that is executed when the project configuration changes.
		// The event is the same as for 'onChange'.
	}

	def onShutdown = { event ->
		// TODO Implement code that is executed when the application shuts down (optional)
	}
}
