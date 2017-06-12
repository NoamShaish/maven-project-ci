package ci.example

import org.scalatest.{BeforeAndAfterAllConfigMap, ConfigMap, FlatSpec, Matchers}

/**
  * Created by G53120 on 6/12/2017.
  */
trait CallerBasedTest extends FlatSpec with Matchers with BeforeAndAfterAllConfigMap{
  val executionType = "execution.type"
  val dir = "dir"
  var call: (String, Seq[String]) => CommandLineProcessStatus = null
  var scriptDir: String = ""
  val osScriptEnding: String = if(System.getProperty("os.name").toLowerCase.indexOf("win") >= 0) "cmd" else "sh"

  override def beforeAll(configMap: ConfigMap): Unit = {
    super.beforeAll(configMap)
    scriptDir = configMap.getRequired[String](dir).replaceAll("\\\\", "//")
    val actualCall = Caller.run(configMap.getRequired[String](executionType))
    call = (scriptName, args) => actualCall(s"$scriptDir/$scriptName.$osScriptEnding", args)
  }
}
