package io.github.edricchan03.appupdater.dsl

import io.github.edricchan03.appupdater.source.UpdateSource

/** Data class to store the list of updater sources. */
data class UpdaterSources(internal val sources: MutableList<UpdateSource> = mutableListOf()) {
    /** Adds a source to the list of sources. */
    fun addSource(source: UpdateSource) {
        sources += source
    }

    /** DSL method to add a source. */
    fun source(source: () -> UpdateSource) {
        addSource(source())
    }
}
