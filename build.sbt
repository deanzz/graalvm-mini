
enablePlugins(GraalVMNativeImagePlugin)

name := "graalvm-mini"

version := "0.1"

scalaVersion := "2.12.8"

graalVMNativeImageOptions ++= Seq(
  "--report-unsupported-elements-at-runtime",
  //"-H:+ReportUnsupportedElementsAtRuntime",
  "-H:+ReportExceptionStackTraces",
  "--verbose",
  //"--allow-incomplete-classpath",
  "--initialize-at-build-time",
  "--no-fallback",
  //"--static",
  //"--force-fallback"
)
mainClass in Compile := Some("graalvm.mini.Main")

mainClass in assembly := Some("graalvm.mini.Main")
assemblyJarName in assembly := "graalvm-mini.jar"