package ci

/**
  * Created by G53120 on 6/10/2017.
  */
package object example {
  sealed trait Visitor

  case class VIP(name: String) extends Visitor

  case class Common(name: String) extends Visitor
}
