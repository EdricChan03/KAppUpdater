package io.github.edricchan03.appupdater.data

/**
 * Data class used to represent a version.
 * @property version The version
 * @property releaseNotes Release notes for the version, if any.
 * @property downloadUrl The download URL for the version.
 */
data class UpdateVersion(
    val version: String,
    val releaseNotes: String,
    val downloadUrl: String
)
