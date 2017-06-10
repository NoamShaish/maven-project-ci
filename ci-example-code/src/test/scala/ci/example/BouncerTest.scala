package ci.example

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by G53120 on 6/10/2017.
  */
class BouncerTest extends FlatSpec with Matchers {
  behavior of "Bouncer"

  it should "decide core team members are VIP" in {
    Bouncer.visitorType("Min") should be(VIP("Min"))
    Bouncer.visitorType("Simple") should be(VIP("Simple"))
    Bouncer.visitorType("Priyam") should be(VIP("Priyam"))
    Bouncer.visitorType("Oleksandr") should be(VIP("Oleksandr"))
    Bouncer.visitorType("Maksym") should be(VIP("Maksym"))
    Bouncer.visitorType("Noam") should be(VIP("Noam"))
  }

  it should "decide non core team member are Common" in {
    Bouncer.visitorType("Derek") should be(Common("Derek"))
  }

  it should "verify name is not empty before deciding" in {
    val exception = intercept[IllegalArgumentException] {
      Bouncer.visitorType("")
    }

    exception.getMessage should be("requirement failed: Missing name")
  }

  it should "verify name is not null before deciding" in {
    val exception = intercept[IllegalArgumentException] {
      Bouncer.visitorType(null)
    }

    exception.getMessage should be("requirement failed: Missing name")
  }
}
