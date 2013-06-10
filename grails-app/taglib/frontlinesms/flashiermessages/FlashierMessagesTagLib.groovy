package frontlinesms.flashiermessages

class FlashierMessagesTagLib {
	static namespace = 'flash'
	def oneTimeDataService

        def message = { att ->
                def msg = oneTimeDataService.getOneTimeData('message', request)?.text
                if (!msg) return
                if(!att?.textOnly) {
                        def divClasses= att?.customClasses?: 'flash message'
                        out << "<div class=\"$divClasses\">"
                }   
                out << msg 
                if(!att?.textOnly) {
                        if(att?.addHider)
                                out << '<a class="hider hide-flash">x</a>'
                        out << '</div>'
                }   
        }
}
