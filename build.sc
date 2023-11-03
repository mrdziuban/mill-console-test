import mill._
import mill.scalalib._

trait TestModule extends ScalaModule {
  def scalaVersion = "3.3.1"
}
object test extends TestModule
