package co.touchlab.brownfield

import co.touchlab.brownfieldsdk.Analytics

class AndroidAnalytics : Analytics {
    override fun sendEvent(eventName: String, eventArgs: Map<String, Any>) {
        // In a real app, you would call to your analytics backend here
        println("$eventName - $eventArgs")
    }
}
