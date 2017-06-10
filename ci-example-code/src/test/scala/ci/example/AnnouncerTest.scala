package ci.example

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by G53120 on 6/10/2017.
  */
class AnnouncerTest extends FlatSpec with Matchers {
  behavior of "Announcer"

  it should "shout when Noam arrives" in {
    Announcer.load("Noam") should be("Noam IS IN THE HOUSE!!!")
  }

  it should "whisper when Noam arrives" in {
    Announcer.quiet("Noam") should be("Noam arrived yey...")
  }

  it should "verify input isn't empty before shouting" in {
    val exception = intercept[IllegalArgumentException] {
      Announcer.load("")
    }

    exception.getMessage should be("requirement failed: Missing name")
  }

  it should "verify input isn't empty before whispering" in {
    val exception = intercept[IllegalArgumentException] {
      Announcer.quiet("")
    }

    exception.getMessage should be("requirement failed: Missing name")
  }

  it should "verify input isn't null before shouting" in {
    val exception = intercept[IllegalArgumentException] {
      Announcer.load(null)
    }

    exception.getMessage should be("requirement failed: Missing name")
  }

  it should "verify input isn't null before whispering" in {
    val exception = intercept[IllegalArgumentException] {
      Announcer.quiet(null)
    }

    exception.getMessage should be("requirement failed: Missing name")
  }
}
