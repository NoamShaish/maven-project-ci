package ci.example

/**
  * Created by G53120 on 6/11/2017.
  */
class BarTest extends CallerBasedTest {
  behavior of "Bar application"

  it should "greet Min as VIP" in {
    call(s"EnterBarAs", Seq("Min")).stdOut.last should be("Min IS IN THE HOUSE!!!")
  }

  it should "greet Derek as Common" in {
    call(s"EnterBarAs", Seq("Derek")).stdOut.last should be("Derek arrived yey...")
  }
}
