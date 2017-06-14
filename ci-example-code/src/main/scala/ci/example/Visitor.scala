package ci.example

/**
  * Created by G53120 on 6/14/2017.
  */
sealed trait Visitor

case class VIP(name: String) extends Visitor

case class Common(name: String) extends Visitor