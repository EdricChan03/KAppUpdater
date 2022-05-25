package io.github.edricchan03.appupdater

import io.github.edricchan03.appupdater.data.UpdaterConfig
import io.github.edricchan03.appupdater.dsl.UpdaterSources
import io.github.edricchan03.appupdater.source.UpdateSource

class Updater {
    private val sources = mutableListOf<UpdateSource>()
    private var config = UpdaterConfig()

    /** Sets the sources to use. */
    fun sources(init: UpdaterSources.() -> Unit) {
        sources += UpdaterSources().apply(init).sources
    }

    /** Sets the config for the updater. */
    fun config(init: UpdaterConfig.Builder.() -> Unit) {
        config = UpdaterConfig.build(init)
    }
}
