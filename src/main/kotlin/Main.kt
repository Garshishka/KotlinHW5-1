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