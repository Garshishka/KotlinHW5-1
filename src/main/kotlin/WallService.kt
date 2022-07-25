object WallService {
    private var posts = emptyArray<Post>()
    private var postId = 0
    private var comments = emptyArray<Comment>()
    private var reports = emptyArray<Report>()

    fun findPostById(postId: Int):Post?{
        for(post in posts){
            if(post.id == postId){
                return post
            }
        }
        return null
    }

    fun findCommentById(postId: Int):Comment?{
        for(comment in comments){
            if(comment.id == postId){
                return comment
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
        val post = findPostById(postId)?: throw PostNotFoundException("no post with $postId")
        post.commentInfo.count++
        comments += comment.copy(id =post.commentInfo.count , parentStack = comments, thread = post.commentInfo)
        return comments.last()
    }

    fun createReport(commentId: Int, reason: Int?=null): Boolean{
        val comment = findCommentById(commentId)?: throw CommentNotFoundException("no comment with $commentId")
        val reasonText :String = when(reason){
            null ->"нет причины"
            0 -> "спам"
            1 -> "детская порнография"
            2 -> "экстремизм"
            3 -> "насилие"
            4 -> "пропоганда наркотиков"
            5 -> "материал для взрослых"
            6 -> "оскорбление"
            8 -> "призыв к суициду"
            else -> throw  WrongReportReasonException("wrong number for a report reason")
        }
        reports += Report(comment.fromId,comment.id,reasonText)
        return true
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

    //For showing all reports in main
    fun showAllReports(): Boolean {
        if (reports.isNotEmpty()) {
            for (report in reports) {
                println(report)
            }
            return true
        } else {
            println("There are no reports!")
            return false
        }
    }

    //For testing purposes cleaning the array in signleton
    fun clearPosts() {
        postId = 0
        posts = emptyArray()
        comments = emptyArray()
        reports = emptyArray()
    }

    class PostNotFoundException(message: String): RuntimeException(message)
    class CommentNotFoundException(message: String): RuntimeException(message)
    class WrongReportReasonException(message: String): RuntimeException(message)
}