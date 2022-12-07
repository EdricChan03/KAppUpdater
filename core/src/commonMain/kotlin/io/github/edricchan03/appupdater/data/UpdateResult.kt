package io.github.edricchan03.appupdater.data

sealed class UpdateResult<Version : AbstractUpdateVersion>(open val currentVersion: Version) {
    data class Available<Version : AbstractUpdateVersion>(
        override val currentVersion: Version,
        val availableVersion: Version
    ) : UpdateResult<Version>(currentVersion)

    data class NotAvailable<Version : AbstractUpdateVersion>(
        override val currentVersion: Version,
        val reason: String
    ) :
        UpdateResult<Version>(currentVersion)

    data class Error<Version : AbstractUpdateVersion>(
        override val currentVersion: Version,
        val error: Throwable
    ) : UpdateResult<Version>(currentVersion)
}
