fun main() {
    val photoAttachment1 = PhotoAttachment(
        2341,
        34512,
        "Some photo",
        244151,
        640,
        480
    )

    val photoAttachment2 = PhotoAttachment(
        2523,
        34512,
        "And another photo",
        244429,
        640,
        480
    )

    val audioAttachment1 = AudioAttachment(
        1414,
        35512,
        "Some dude with a piano",
        "Doing some music",
        3454,
        234543
    )

    val linkAttachment1 = LinkAttachment(
        "https://google.com",
        "where to look for stuff",
        "a link to google"
    )

    val linkAttachment2 = LinkAttachment(
        "https://somewhere.com",
        "some link",
        "a link to whatever page",
        "probably works"
    )

    val postingPost1 = Post(
        ownerId = 846412,
        fromId = 231230,
        date = 234124,
        text = "Hi all!",
        comment = Comment(),
        reposts = Reposts(),
        likes = Likes(),
        attachments = arrayOf(photoAttachment1, photoAttachment2)
    )

    val postingPost2 = Post(
        ownerId = 846412,
        fromId = 231230,
        date = 234124,
        text = "This is my second post",
        comment = Comment(),
        reposts = Reposts(),
        likes = Likes(),
        attachments = arrayOf(audioAttachment1,linkAttachment1,linkAttachment2)
    )

    WallService.add(postingPost1)
    WallService.add(postingPost2)

    WallService.showAllPosts()

/*
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

    WallService.showAllPosts()*/
}