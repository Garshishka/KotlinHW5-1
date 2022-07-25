class LinkAttachment(link: Link) : Attachment {
    override val type: String = "link"
    override val attached: Link = link

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