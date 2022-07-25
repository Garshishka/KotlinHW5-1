fun main() {
    val photo1 = Photo(
        2341,
        34512,
        "Some photo",
        244151,
        640,
        480
    )
    val photoAttachment1 = PhotoAttachment(photo1)

    val photo2 = Photo(
        2523,
        34512,
        "And another photo",
        244429,
        640,
        480
    )
    val photoAttachment2 = PhotoAttachment(photo2)

    val audio1 = Audio(
        1414,
        35512,
        "Some dude with a piano",
        "Doing some music",
        3454,
        234543
    )
    val audioAttachment1 = AudioAttachment(audio1)

    val link1 = Link(
        "https://google.com",
        "where to look for stuff",
        "a link to google"
    )
    val linkAttachment1 = LinkAttachment(link1)

    val link2 = Link(
        "https://somewhere.com",
        "some link",
        "a link to whatever page",
        "probably works"
    )
    val linkAttachment2 = LinkAttachment(link2)

    val postingPost1 = Post(
        ownerId = 846412,
        fromId = 231230,
        date = 234124,
        text = "Hi all!",
        attachments = arrayOf(photoAttachment1, photoAttachment2)
    )

    val postingPost2 = Post(
        ownerId = 846412,
        fromId = 231230,
        date = 234124,
        text = "This is my second post",
        attachments = arrayOf(audioAttachment1, linkAttachment1, linkAttachment2)
    )

    val comment1 = Comment(
        fromId = 231230,
        date = 234512,
        text = "I'm commenting!"
    )

    val comment2 = Comment(
        fromId = 846412,
        date = 234519,
        text = "I'm commenting on your comment!",
        replyToComment = 1
    )

    WallService.add(postingPost1)
    WallService.add(postingPost2)

    WallService.showAllPosts()

    WallService.createComment(1, comment1)
    WallService.createComment(1, comment2)

    WallService.showAllComments()

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