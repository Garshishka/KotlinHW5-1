import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    val testPost1 = Post(
        ownerId = 100,
        fromId = 200,
        date = 100_000,
        text = "Test post 1",
    )

    val testPost2 = Post(
        ownerId = 100,
        fromId = 200,
        date = 100_001,
        text = "Test Post 2",
    )

    val testPost3 = Post(  //with right ID for udpate
        id = 2,
        ownerId = 100,
        fromId = 200,
        date = 100_002,
        text = "Test Post 3",
    )

    val testPost4 = Post(  //with wrong ID for update
        id = 100,
        ownerId = 100,
        fromId = 200,
        date = 100_002,
        text = "Test Post 4",
    )

    @Test
    fun add_newIdNotZero() {
        WallService.clearPosts()
        val result = WallService.add(testPost1).id

        assertTrue(result!=0)
        WallService.clearPosts()
    }

    @Test
    fun update_foundPost() {
        WallService.clearPosts()
        WallService.add(testPost1).id
        WallService.add(testPost2).id

        val result = WallService.update(testPost3)
        assertTrue(result)
    }

    @Test
    fun update_foundNoPost() {
        WallService.clearPosts()
        WallService.add(testPost1).id
        WallService.add(testPost2).id

        val result = WallService.update(testPost4)
        assertFalse(result)
    }

    @Test
    fun showAllPosts_notEmpty(){
        WallService.clearPosts()
        WallService.add(testPost1)
        assertTrue(WallService.showAllPosts())
    }

    @Test
    fun showAllPosts_isEmpty(){
        WallService.clearPosts()
        assertFalse(WallService.showAllPosts())
    }

    //Comments testing

    val testComment1 = Comment(
        fromId = 100,
        date = 200,
        text = "test comment 1"
    )
    @Test
    fun createComment_addComment(){
        WallService.clearPosts()
        WallService.add(testPost1).id

        val result = WallService.createComment(1,testComment1)
        assertEquals(result.thread.count,1)
    }

    @Test(expected = WallService.PostNotFoundException::class)
    fun createComment_addCommentNoId(){
        WallService.clearPosts()
        WallService.add(testPost1).id

        WallService.createComment(100,testComment1)
    }

    @Test
    fun showAllComments_notEmpty(){
        WallService.clearPosts()
        WallService.add(testPost1)
        WallService.createComment(1,testComment1)
        assertTrue(WallService.showAllComments())
    }

    @Test
    fun showAllComments_isEmpty(){
        WallService.clearPosts()
        WallService.add(testPost1)
        assertFalse(WallService.showAllComments())
    }
}