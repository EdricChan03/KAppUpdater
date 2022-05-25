package io.github.edricchan03.appupdater.source

import io.github.edricchan03.appupdater.data.UpdateResult
import io.github.edricchan03.appupdater.data.UpdaterConfig

abstract class UpdateSource(internal val config: UpdaterConfig) {
    abstract suspend fun doUpdate(): UpdateResult
}
