class DocumentAttachment(document: Document) : Attachment {
    override val type: String = "document"
    override val attached: Document = document

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