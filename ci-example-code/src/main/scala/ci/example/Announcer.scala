package ci.example

/**
  * Created by G53120 on 6/10/2017.
  */
object Announcer {
  def load(name: String): String = {
    require(name != null && !name.isEmpty, "Missing name")
    s"$name IS IN THE HOUSE!!!"
  }

  def quiet(name: String): String = {
    require(name != null && !name.isEmpty, "Missing name")
    s"$name arrived yey..."
  }
}
