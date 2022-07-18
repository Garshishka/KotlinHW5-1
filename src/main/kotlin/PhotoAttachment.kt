class PhotoAttachment(
    val id: Int,
    val ownerId: Int,
    val text: String,
    val date: Int,
    val width: Int,
    val height: Int,
    val albumId: Int? = null,
    val userId: String? = null
) : Attachment {
    override val type: String = "photo"
    override val attached: Photo = Photo(id, ownerId, text, date, width, height, albumId, userId)

    override fun toString(): String {
        return (type + ": '" + attached.text + "' " + width + "x" + height)
    }
}

data class Photo(
    val id: Int,
    val ownerId: Int,
    val text: String,
    val date: Int,
    val width: Int,
    val height: Int,
    val albumId: Int?,
    val userId: String?
)