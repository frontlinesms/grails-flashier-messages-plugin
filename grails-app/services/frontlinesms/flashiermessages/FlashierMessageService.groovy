package frontlinesms.flashiermessages

import org.codehaus.groovy.grails.web.util.WebUtils

class FlashierMessageService {
	public static final String OTDS_FLASH_VARIABLE_KEY = "flashy"
	def oneTimeDataService	
	def setValue(key, value) {
		oneTimeDataService.store(getRequest(), OTDS_FLASH_VARIABLE_KEY, { delegate."$key" = value })
	}

	def getValue(key) {
		return oneTimeDataService.getOneTimeData(OTDS_FLASH_VARIABLE_KEY, getRequest())?.key
	}

	private def getRequest() {
		WebUtils.retrieveGrailsWebRequest().getCurrentRequest()
	}

	def propertyMissing(String name, value) {
		setValue(name, value)
	}


	def propertyMissing(String name) {
		getValue(name)
	}
}
