package co.touchlab.kmmbridgekickstartandroid

import co.touchlab.kmmbridgekickstart.Analytics

class AndroidAnalytics : Analytics {
    override fun sendEvent(eventName: String, eventArgs: Map<String, Any>) {
        println("$eventName - $eventArgs")
    }
}
