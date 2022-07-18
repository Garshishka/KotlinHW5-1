class NoteAttachment(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val text: String,
    val date: Int,
    val comments: Int = 0
) : Attachment {
    override val type: String = "note"
    override val attached: Note = Note(id, ownerId, title, text, date)
    override fun toString(): String {
        return (type + ": '" + attached.title + "'")
    }
}

data class Note(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val text: String,
    val date: Int,
    val comments: Int = 0
)