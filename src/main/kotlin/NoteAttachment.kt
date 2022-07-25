class NoteAttachment(note: Note) : Attachment {
    override val type: String = "note"
    override val attached: Note = note
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