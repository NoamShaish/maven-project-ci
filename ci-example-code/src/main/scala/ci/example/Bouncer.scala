package ci.example

/**
  * Created by G53120 on 6/10/2017.
  */
object Bouncer {
  private val coreTeam: Set[String] = Set("Min", "Simple", "Priyam", "Oleksandr", "Maksym", "Noam")

  def visitorType(name: String): Visitor = {
    require(name != null && !name.isEmpty, "Missing name")
    if(coreTeam.contains(name)) VIP(name) else Common(name)
  }
}
