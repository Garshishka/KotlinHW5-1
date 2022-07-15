data class Comment(
    val count: Int = 0,
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
    val comment: Comment,
    val copyright: String? = null,
    val likes: Likes,
    val reposts: Reposts? = null,
    val views: Int = 0,
    val postType: String = "post",
    val signerId: Int? = null,
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false
) {
}

object WallService {
    private var posts = emptyArray<Post>()
    private var postId = 0

    //adding new posts with growing ID number
    fun add(post: Post): Post {
        postId++
        posts += post.copy(id = postId)
        return posts.last()
    }

    //updating existing post by finding it by its ID
    fun update(post: Post): Boolean {
        for ((index, postedPosts) in posts.withIndex()) {
            if (postedPosts.id == post.id) {
                posts[index] = post.copy(ownerId = posts[index].ownerId, date = posts[index].date)
                return true
            }
        }
        return false
    }

    //For showing all posts in main
    fun showAllPosts(): Boolean {
        if (posts.isNotEmpty()) {
            for (post in posts) {
                println(post)
            }
            return true
        } else {
            println("There are no posts!")
            return false
        }
    }

    //For testing purposes cleaning the array in signleton
    fun clearPosts() {
        postId = 0
        posts = emptyArray<Post>()
    }
}

fun main() {
    val postingPost1 = Post(
        ownerId = 846412,
        fromId = 231230,
        date = 234124,
        text = "Hi all!",
        comment = Comment(),
        reposts = Reposts(),
        likes = Likes()
    )

    val postingPost2 = Post(
        ownerId = 846412,
        fromId = 231230,
        date = 234124,
        text = "This is my second post",
        comment = Comment(),
        reposts = Reposts(),
        likes = Likes()
    )

    println(WallService.add(postingPost1))
    println(WallService.add(postingPost2))

    val postingPost2updated = Post(
        id = 2,
        ownerId = 846412,
        fromId = 231230,
        date = 234124,
        text = "This is my second post, and now I updated it!",
        comment = Comment(),
        reposts = Reposts(),
        likes = Likes()
    )

    WallService.update(postingPost2updated)

    WallService.showAllPosts()
}