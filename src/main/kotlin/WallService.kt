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