import org.junit.Assert.assertNotNull
import org.junit.Test

class Test {
    @Test
    fun getRepo(){
      val response =   ApiClint.api.getRepo("Beast-max","Medium").execute()
        assertNotNull(response.body()?.name)
    }
    @Test
    fun `Get Branshs`(){
        val response = ApiClint.api.getBranch("Beast-max","Medium").execute()
        assertNotNull(response.body())
    }
    @Test
    fun `Get Commits`(){
        val response = ApiClint.api.getCommits("Beast-max","Medium","594629d5e4900438647a0471cb7bb2278398cf3d").execute()
        assertNotNull(response.body())
    }
  @Test
    fun `Get Issue`(){
      val response = ApiClint.api.getIssue("Flutter","flutter","open").execute()
       assertNotNull(response.body())
    }
}