class DocumentAttachment(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val ext: String,
    val date: Int,
    val docType: Int = 1,
    val url: String? = null
) : Attachment {
    override val type: String = "document"
    override val attached: Document = Document(id, ownerId, title, size, ext, date, docType, url)

    override fun toString(): String {
        return (type + ": '" + attached.title + "." + attached.ext + "'")
    }
}

data class Document(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val ext: String,
    val date: Int,
    val docType: Int,
    val url: String?
)