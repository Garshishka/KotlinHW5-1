class PhotoAttachment(photo: Photo) : Attachment {
    override val type: String = "photo"
    override val attached: Photo = photo

    override fun toString(): String {
        return (type + ": '" + attached.text + "' " + attached.width + "x" + attached.height)
    }
}

data class Photo(
    val id: Int,
    val ownerId: Int,
    val text: String,
    val date: Int,
    val width: Int,
    val height: Int,
    val albumId: Int? = null,
    val userId: String? = null
)