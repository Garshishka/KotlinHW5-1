object WallService {
    private var posts = emptyArray<Post>()
    private var postId = 0
    private var comments = emptyArray<Comment>()

    fun findById(postId: Int):Post?{
        for(post in posts){
            if(post.id == postId){
                return post
            }
        }
        return null
    }

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

    //If there is a post with specified ID, we add a comment to the comment stack
    fun createComment(postId: Int, comment: Comment): Comment {
        val post = findById(postId)?: throw PostNotFoundException("no post with $postId")
        post.commentInfo.count++
        comments += comment.copy(id =post.commentInfo.count , parentStack = comments, thread = post.commentInfo)
        return comments.last()
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

    //For showing all comments in main
    fun showAllComments(): Boolean {
        if (comments.isNotEmpty()) {
            for (comment in comments) {
                println(comment)
            }
            return true
        } else {
            println("There are no comments!")
            return false
        }
    }

    //For testing purposes cleaning the array in signleton
    fun clearPosts() {
        postId = 0
        posts = emptyArray<Post>()
        comments = emptyArray<Comment>()
    }

    class PostNotFoundException(message: String): RuntimeException(message)
}