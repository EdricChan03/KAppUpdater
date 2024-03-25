package io.github.edricchan03.appupdater.data

/**
 * Abstract class used to represent a version. Implementations should
 * extend this class to provide additional metadata if necessary.
 * @property version The version
 * @property releaseNotes Release notes for the version, if any.
 * @property downloadUrl The download URL for the version.
 */
public abstract class AbstractUpdateVersion(
    public val version: String,
    public val releaseNotes: String,
    public val downloadUrl: String
) {
    /** Checks if the [other] version is higher/lower than this version. */
    public abstract operator fun compareTo(other: AbstractUpdateVersion): Int
}
