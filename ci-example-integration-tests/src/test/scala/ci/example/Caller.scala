package ci.example

import scala.collection.Seq
import scala.sys.process.{Process, ProcessLogger}

/**
  * Created by G53120 on 6/11/2017.
  */
object Caller {
  def run(callerType: String): (String, Seq[String]) => CommandLineProcessStatus = callerType match {
    case c: String if c.toLowerCase == "local" => runLocal
    case c: String if c.toLowerCase == "remote" => runRemote
    case _ => throw new IllegalArgumentException("Unsupported caller type")
  }

  def runLocal(in: String, args: Seq[String]): CommandLineProcessStatus = {
    val qb = Process(in, args)
    var out = List[String]()
    var err = List[String]()

    val exit = qb ! ProcessLogger((s) => out ::= s, (s) => err ::= s)

    CommandLineProcessStatus(out.reverse, err.reverse, exit)
  }

  def runRemote(in: String, args: Seq[String]): CommandLineProcessStatus = ???
}

case class CommandLineProcessStatus(stdOut: Seq[String], stdErr: Seq[String], exitCode: Int)