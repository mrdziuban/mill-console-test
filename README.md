# mill console test

Thie demonstrates an issue with [mill](https://github.com/com-lihaoyi/mill) and running `console` without `-i`.

To reproduce, clone this repo, `cd` into it, then run:

```bash
./mill test.console
```

You should see:

```
Exception in thread "main" java.lang.IllegalStateException: Unable to create a system terminal
  at org.jline.terminal.TerminalBuilder.doBuild(TerminalBuilder.java:323)
  at org.jline.terminal.TerminalBuilder.build(TerminalBuilder.java:265)
  at dotty.tools.repl.JLineTerminal.<init>(JLineTerminal.scala:25)
  at dotty.tools.repl.ReplDriver.runUntilQuit(ReplDriver.scala:143)
  at dotty.tools.repl.ReplDriver.tryRunning(ReplDriver.scala:134)
  at dotty.tools.repl.Main$.main(Main.scala:7)
  at dotty.tools.repl.Main.main(Main.scala)
1 targets failed
test.console java.lang.Exception: Interactive Subprocess Failed (exit code 1)
    mill.util.Jvm$.runSubprocess(Jvm.scala:184)
    mill.util.Jvm$.runSubprocessWithBackgroundOutputs(Jvm.scala:152)
    mill.util.Jvm$.runSubprocess(Jvm.scala:88)
    mill.scalalib.ScalaModule.$anonfun$console$2(ScalaModule.scala:369)
    scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.scala:18)
    scala.util.DynamicVariable.withValue(DynamicVariable.scala:59)
    scala.Console$.withErr(Console.scala:193)
    mill.api.SystemStreams$.$anonfun$withStreams$2(SystemStreams.scala:62)
    scala.util.DynamicVariable.withValue(DynamicVariable.scala:59)
    scala.Console$.withOut(Console.scala:164)
    mill.api.SystemStreams$.$anonfun$withStreams$1(SystemStreams.scala:61)
    scala.util.DynamicVariable.withValue(DynamicVariable.scala:59)
    scala.Console$.withIn(Console.scala:227)
    mill.api.SystemStreams$.withStreams(SystemStreams.scala:60)
    mill.scalalib.ScalaModule.$anonfun$console$1(ScalaModule.scala:374)
    mill.define.Task$TraverseCtx.evaluate(Task.scala:71)
```
