import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    val testPost1 = Post(
        ownerId = 100,
        fromId = 200,
        createdBy = 300,
        date = 100_000,
        text = "Test post 1",
        comment = Comment(),
        reposts = Reposts(),
        likes = Likes()
    )

    val testPost2 = Post(
        ownerId = 100,
        fromId = 200,
        createdBy = 300,
        date = 100_001,
        text = "Test Post 2",
        comment = Comment(),
        reposts = Reposts(),
        likes = Likes()
    )

    val testPost3 = Post(  //with right ID for udpate
        id = 2,
        ownerId = 100,
        fromId = 200,
        createdBy = 300,
        date = 100_002,
        text = "Test Post 3",
        comment = Comment(),
        reposts = Reposts(),
        likes = Likes()
    )

    val testPost4 = Post(  //with wrong ID for update
        id = 100,
        ownerId = 100,
        fromId = 200,
        createdBy = 300,
        date = 100_002,
        text = "Test Post 4",
        comment = Comment(),
        reposts = Reposts(),
        likes = Likes()
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
}