package io.github.edricchan03.appupdater.data

public sealed class UpdateResult<Version : AbstractUpdateVersion>(public open val currentVersion: Version) {
    public data class Available<Version : AbstractUpdateVersion>(
        override val currentVersion: Version,
        val availableVersion: Version
    ) : UpdateResult<Version>(currentVersion)

    public data class NotAvailable<Version : AbstractUpdateVersion>(
        override val currentVersion: Version,
        val reason: String
    ) :
        UpdateResult<Version>(currentVersion)

    public data class Error<Version : AbstractUpdateVersion>(
        override val currentVersion: Version,
        val error: Throwable
    ) : UpdateResult<Version>(currentVersion)
}
