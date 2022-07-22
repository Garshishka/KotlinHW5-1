data class Post(
    val id: Int = 0,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int? = null,
    val date: Int,
    val text: String,
    val replyOwnerId: Int? = null,
    val replyPostId: Int? = null,
    val friendsOnly: Boolean = false,
    val commentInfo: CommentsInfo = CommentsInfo(), //changing from vk name for clearer name
    val copyright: String? = null,
    val likes: Likes = Likes(),
    val reposts: Reposts? = null,
    val views: Int = 0,
    val postType: String = "post",
    val signerId: Int? = null,
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,

    val attachments: Array<Attachment>? = null,
)

data class Comment(
    val id: Int = 0,
    val fromId: Int,
    val date: Int,
    val text: String,
    val parentStack : Array<Comment> = emptyArray(),
    val thread : CommentsInfo = CommentsInfo(),
    val attachments: Array<Attachment>? = null,
    val replyToUser: Int? = null,
    val replyToComment: Int? = null
)

data class CommentsInfo(
    var count: Int = 0,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = true,
    val canOpen: Boolean = true,
    val canClose: Boolean = true
)

data class Likes(
    val count: Int = 0,
    val userLikes: Boolean = false,
    val canLike: Boolean = true,
    val canPublish: Boolean = true
)

data class Reposts(
    val count: Int = 0,
    val userReposted: Boolean = false,
)