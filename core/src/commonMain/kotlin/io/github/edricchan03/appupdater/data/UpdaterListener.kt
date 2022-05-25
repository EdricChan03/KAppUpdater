package io.github.edricchan03.appupdater.data

/** Listener configuration for the [com.edricchan.appupdater.Updater]. */
interface UpdaterListener {
    /** Called when an update is available. */
    fun onUpdateAvailable(data: UpdateResult.Available)

    /** Called when an update is not available. */
    fun onUpdateNotAvailable(data: UpdateResult.NotAvailable)

    /** Called when an update results in an error. */
    fun onUpdateError(data: UpdateResult.Error)

    /** Called when an update is checked. */
    fun onUpdateCheck()
}

/** Creates an instance of [UpdaterListener] using the given lambdas. */
inline fun updaterListener(
    crossinline onUpdateAvailable: (UpdateResult.Available) -> Unit = {},
    crossinline onUpdateNotAvailable: (UpdateResult.NotAvailable) -> Unit = {},
    crossinline onUpdateError: (UpdateResult.Error) -> Unit = {},
    crossinline onUpdateCheck: () -> Unit = {}
) = object : UpdaterListener {
    override fun onUpdateAvailable(data: UpdateResult.Available) {
        onUpdateAvailable(data)
    }

    override fun onUpdateNotAvailable(data: UpdateResult.NotAvailable) {
        onUpdateNotAvailable(data)
    }

    override fun onUpdateError(data: UpdateResult.Error) {
        onUpdateError(data)
    }

    override fun onUpdateCheck() {
        onUpdateCheck()
    }

}

inline fun UpdaterConfig.Builder.setListener(
    crossinline onUpdateAvailable: (UpdateResult.Available) -> Unit = {},
    crossinline onUpdateNotAvailable: (UpdateResult.NotAvailable) -> Unit = {},
    crossinline onUpdateError: (UpdateResult.Error) -> Unit = {},
    crossinline onUpdateCheck: () -> Unit = {}
) {
    listener = updaterListener(
        onUpdateAvailable,
        onUpdateNotAvailable,
        onUpdateError,
        onUpdateCheck
    )
}
