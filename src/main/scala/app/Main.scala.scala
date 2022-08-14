package app

import scala.scalajs.js.annotation.*
import tyrian.*
import tyrian.Html.*

import cats.effect.IO

opaque type Model = String
object Model:
  def init: Model = "World"

enum Msg:
  case Update

@JSExportTopLevel("TyrianApp")
object App extends TyrianApp[Msg, Model]:
  def init(flags: Map[String, String]): (Model, Cmd[IO, Msg]) =
    (Model.init, Cmd.None)

  def update(model: Model): Msg => (Model, Cmd[IO, Msg]) =
    case Msg.Update => (model, Cmd.None)

  def view(model: Model): Html[Msg] =
    div(`class` := "content container mx-auto text-center bg-purple-300")(
      p(`class` := "text-3xl")(s"Hello, $model!")
    )

  def subscriptions(model: Model): Sub[IO, Msg] = Sub.None
