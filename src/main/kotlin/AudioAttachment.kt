class AudioAttachment(audio: Audio) : Attachment {
    override val type: String = "audio"
    override val attached: Audio = audio

    override fun toString(): String {
        return (type + ":  '" + attached.title + "' by  " + attached.artist)
    }
}

data class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
    val date: Int,
    val isHq: Boolean = true
)