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
public data class UpdaterConfig(
    var checkInterval: Duration = INTERVAL_DEFAULT,
    var listener: UpdaterListener? = null
) {
    private constructor(builder: Builder) : this(
        builder.checkInterval,
        builder.listener
    )

    public companion object {
        /** The default interval to use. (5 hours) */
        public val INTERVAL_DEFAULT: Duration = 5.hours

        public inline fun build(block: Builder.() -> Unit): UpdaterConfig =
            Builder().apply(block).build()
    }

    public class Builder {
        /** How often to check for updates. */
        public var checkInterval: Duration = INTERVAL_DEFAULT
        public var listener: UpdaterListener? = null

        public fun build(): UpdaterConfig = UpdaterConfig(this)
    }
}
