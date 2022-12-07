package io.github.edricchan03.appupdater.data

/**
 * Abstract class used to represent a version. Implementations should
 * extend this class to provide additional metadata if necessary.
 * @property version The version
 * @property releaseNotes Release notes for the version, if any.
 * @property downloadUrl The download URL for the version.
 */
abstract class AbstractUpdateVersion(
    val version: String,
    val releaseNotes: String,
    val downloadUrl: String
) {
    /** Checks if the [other] version is higher/lower than this version. */
    abstract operator fun compareTo(other: AbstractUpdateVersion): Int
}
