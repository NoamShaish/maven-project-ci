package ci.example

/**
  * Created by G53120 on 6/11/2017.
  */
class BarIntegration extends CallerBasedTest {
  behavior of "Bar application"

  it should "greet Min as VIP" in {
    call(s"$dir/EnterBarAs.sh", Seq("Min")).stdOut.head should be("Min IS IN THE HOUSE!!!")
  }
}
