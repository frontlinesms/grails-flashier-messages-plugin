package frontlinesms.flashiermessages

import org.codehaus.groovy.grails.web.util.WebUtils

class FlashierMessageService {
	private static final String OTDS_FLASH_VARIABLE_KEY = "flashy"
	def oneTimeDataService	
	def setValue(key, value) {
		println "########## setValue ##########"
		oneTimeDataService.store(getRequest(), OTDS_FLASH_VARIABLE_KEY, { "$key" = value } )
	}

	def getValue(key) {
		println "########## getValue ##########"
		oneTimeDataService.getOneTimeData(key, getRequest())
	}

	private def getRequest() {
		WebUtils.retrieveGrailsWebRequest().getCurrentRequest()
	}
}
