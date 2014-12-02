package frontlinesms.flashiermessages
import grails.test.mixin.*

@TestFor(FlashierMessagesTagLib)
@Mock([FlashierMessagesService])
class FlashierMessagesTagLibTests {
	
	void "test the use of withMessage method in the taglib"(){
		
		when:
			def flashMessageService = Mock(FlashierMessagesService)
			flashMessageService.
			tagLib.flashMessageService = flashMessageService
			def template = '<flash:withMessage>message ${it}<br/></flash:withMessage>'
			def result = applyTemplate(template)
		then:
			result == "message"
		
	}
}