import org.scalajs.linker.interface.ModuleSplitStyle

val Versions = new {
  val Scala = "3.1.3"
  val Tyrian = "0.5.1"
}

lazy val app = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    scalaVersion := Versions.Scala,
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
    },
    libraryDependencies += "io.indigoengine" %%% "tyrian-io" % Versions.Tyrian
  )
