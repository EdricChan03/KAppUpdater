package io.github.edricchan03.appupdater.data

import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours

/**
 * Data class to represent the configuration for [com.edricchan.appupdater.Updater].
 * @property checkInterval The interval used to determine how often to check for updates.
 * (Defaults to 5 hours)
 * @property listener Listener used to hook into the updater. (For an easier way of creating
 * a listener, see [com.edricchan.appupdater.data.updaterListener].)
 */
data class UpdaterConfig(
    var checkInterval: Duration = INTERVAL_DEFAULT,
    var listener: UpdaterListener? = null
) {
    private constructor(builder: Builder) : this(
        builder.checkInterval,
        builder.listener
    )

    companion object {
        /** The default interval to use. (5 hours) */
        val INTERVAL_DEFAULT = 5.hours

        inline fun build(block: Builder.() -> Unit) = Builder().apply(block).build()
    }

    class Builder {
        /** How often to check for updates. */
        var checkInterval = INTERVAL_DEFAULT
        var listener: UpdaterListener? = null

        fun build() = UpdaterConfig(this)
    }
}
