package co.touchlab.brownfield

import co.touchlab.brownfieldsdk.Analytics

class AndroidAnalytics : Analytics {
    override fun sendEvent(eventName: String, eventArgs: Map<String, Any>) {
        println("$eventName - $eventArgs")
    }
}
