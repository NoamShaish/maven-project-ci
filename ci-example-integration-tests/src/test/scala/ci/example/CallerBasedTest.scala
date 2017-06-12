package ci.example

import org.scalatest.{BeforeAndAfterAllConfigMap, ConfigMap, FlatSpec, Matchers}

/**
  * Created by G53120 on 6/12/2017.
  */
trait CallerBasedTest extends FlatSpec with Matchers with BeforeAndAfterAllConfigMap{
  val executionType = "execution.type"
  val dir = "dir"
  var call: (String, Seq[String]) => CommandLineProcessStatus = ???
  var scriptDir: String = ""

  override def beforeAll(configMap: ConfigMap): Unit = {
    super.beforeAll(configMap)
    call = Caller.run(configMap.getRequired(executionType))
    scriptDir = configMap.getRequired(dir)
  }
}
