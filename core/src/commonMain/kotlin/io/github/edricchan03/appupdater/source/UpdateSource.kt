package io.github.edricchan03.appupdater.source

import io.github.edricchan03.appupdater.data.UpdateResult
import io.github.edricchan03.appupdater.data.AbstractUpdateVersion
import io.github.edricchan03.appupdater.data.UpdaterConfig

/** An update source to retrieve updates from. */
abstract class UpdateSource<Version : AbstractUpdateVersion>(internal val config: UpdaterConfig) {
    /** Retrieves the list of updates, if any. */
    abstract suspend fun listUpdates(): List<Version>
    /** Called to check for updates. */
    abstract suspend fun doUpdate(): UpdateResult<Version>
}
