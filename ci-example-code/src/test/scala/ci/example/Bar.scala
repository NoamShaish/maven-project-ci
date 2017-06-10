package ci.example

/**
  * Created by G53120 on 6/11/2017.
  */
object Bar extends App{
  println(Bouncer.visitorType(args(0)) match {
    case VIP(name) => Announcer.load(name)
    case Common(name) => Announcer.quiet(name)
  })
}
