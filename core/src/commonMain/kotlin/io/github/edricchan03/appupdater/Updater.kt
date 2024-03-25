package io.github.edricchan03.appupdater

import io.github.edricchan03.appupdater.data.UpdaterConfig
import io.github.edricchan03.appupdater.dsl.UpdaterSources
import io.github.edricchan03.appupdater.source.UpdateSource

public class Updater {
    private val sources = mutableListOf<UpdateSource<*>>()
    private var config = UpdaterConfig()

    /** Sets the sources to use. */
    public fun sources(init: UpdaterSources.() -> Unit) {
        sources += UpdaterSources().apply(init).sources
    }

    /** Sets the config for the updater. */
    public fun config(init: UpdaterConfig.Builder.() -> Unit) {
        config = UpdaterConfig.build(init)
    }
}
