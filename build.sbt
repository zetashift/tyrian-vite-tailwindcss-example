import org.scalajs.linker.interface.ModuleSplitStyle

val Versions = new {
  val Scala = "3.1.3"
  val Tyrian = "0.5.1"
}

val fastLinkOutputDir = taskKey[String]("output directory for `npm run dev`")
val fullLinkOutputDir = taskKey[String]("output directory for `npm run build`")

lazy val app = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    scalaVersion := Versions.Scala,
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
    },
    libraryDependencies += "io.indigoengine" %%% "tyrian-io" % Versions.Tyrian,

    // Return the path to the development-friendly output file
    fastLinkOutputDir := {
      (Compile / fastLinkJS).value
      (Compile / fastLinkJS / scalaJSLinkerOutputDirectory).value
        .getAbsolutePath()
    },

    // Return the path to the production-ready output file
    fullLinkOutputDir := {
      (Compile / fullLinkJS).value
      (Compile / fullLinkJS / scalaJSLinkerOutputDirectory).value
        .getAbsolutePath()
    }
  )
