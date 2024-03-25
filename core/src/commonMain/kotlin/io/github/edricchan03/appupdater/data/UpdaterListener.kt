package io.github.edricchan03.appupdater.data

/** Listener configuration for the [com.edricchan.appupdater.Updater]. */
public interface UpdaterListener<Version : AbstractUpdateVersion> {
    /** Called when an update is available. */
    public fun onUpdateAvailable(data: UpdateResult.Available<Version>)

    /** Called when an update is not available. */
    public fun onUpdateNotAvailable(data: UpdateResult.NotAvailable<Version>)

    /** Called when an update results in an error. */
    public fun onUpdateError(data: UpdateResult.Error<Version>)

    /** Called when an update is checked. */
    public fun onUpdateCheck()
}

/** Creates an instance of [UpdaterListener] using the given lambdas. */
public inline fun <Version : AbstractUpdateVersion> updaterListener(
    crossinline onUpdateAvailable: (UpdateResult.Available<Version>) -> Unit = {},
    crossinline onUpdateNotAvailable: (UpdateResult.NotAvailable<Version>) -> Unit = {},
    crossinline onUpdateError: (UpdateResult.Error<Version>) -> Unit = {},
    crossinline onUpdateCheck: () -> Unit = {}
): UpdaterListener<Version> = object : UpdaterListener<Version> {
    override fun onUpdateAvailable(data: UpdateResult.Available<Version>) {
        onUpdateAvailable(data)
    }

    override fun onUpdateNotAvailable(data: UpdateResult.NotAvailable<Version>) {
        onUpdateNotAvailable(data)
    }

    override fun onUpdateError(data: UpdateResult.Error<Version>) {
        onUpdateError(data)
    }

    override fun onUpdateCheck() {
        onUpdateCheck()
    }

}

/** Sets a listener on the given [UpdaterConfig.Builder]. */
public inline fun <Version : AbstractUpdateVersion> UpdaterConfig.Builder.setListener(
    crossinline onUpdateAvailable: (UpdateResult.Available<Version>) -> Unit = {},
    crossinline onUpdateNotAvailable: (UpdateResult.NotAvailable<Version>) -> Unit = {},
    crossinline onUpdateError: (UpdateResult.Error<Version>) -> Unit = {},
    crossinline onUpdateCheck: () -> Unit = {}
) {
    listener = updaterListener(
        onUpdateAvailable,
        onUpdateNotAvailable,
        onUpdateError,
        onUpdateCheck
    )
}
