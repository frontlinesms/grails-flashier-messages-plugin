package frontlinesms.flashiermessages

class FlashierMessagesTagLib {
	static namespace = 'flash'
	def flashierMessagesService

	def show = { att ->
                def msg = flashierMessagesService.getValue(att.field)
                if (!msg) return
                if(!att?.textOnly) {
                        def divClasses= att?.customClasses?: "flash ${att.field}"
                        out << "<div class=\"$divClasses\">"
                }   
                out << msg 
                if(!att?.textOnly) {
                        if(att?.addHider)
                                out << '<a class="hider hide-flash">x</a>'
                        out << '</div>'
                }
	}

	def message = { att->
		out << show(att << [field: 'message'])
	}
}
