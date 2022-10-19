package co.touchlab.brownfield

import co.touchlab.brownfieldsdk.Analytics

class AndroidAnalytics : Analytics {
    override fun sendEvent(eventName: String, vararg eventArgs: Pair<String, Any>) {
        println("Analytics: $eventName [${eventArgs.joinToString(separator = ", ") { "${it.first}=${it.second}" }}]")
    }
}
