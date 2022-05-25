package io.github.edricchan03.appupdater.data

open class UpdateResult(open val currentVersion: UpdateVersion) {
    data class Available(
        override val currentVersion: UpdateVersion,
        val availableVersion: UpdateVersion
    ) : UpdateResult(currentVersion)

    data class NotAvailable(override val currentVersion: UpdateVersion, val reason: String) :
        UpdateResult(currentVersion)

    data class Error(override val currentVersion: UpdateVersion, val error: Throwable)
        : UpdateResult(currentVersion)
}
