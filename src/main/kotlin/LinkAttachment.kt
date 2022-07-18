class LinkAttachment(
    val url: String,
    val title: String,
    val description: String,
    val caption: String? = null
) : Attachment {
    override val type: String = "link"
    override val attached: Link = Link(url, title, description, caption)

    override fun toString(): String {
        return (type + ": '" + attached.title + "' " + (attached.caption ?: ""))
    }
}

data class Link(
    val url: String,
    val title: String,
    val description: String,
    val caption: String? = null
)