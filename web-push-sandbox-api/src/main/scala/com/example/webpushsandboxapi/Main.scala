package com.example.webpushsandboxapi

import cats.effect.{IO, IOApp}

object Main extends IOApp.Simple:
  val run = WebpushsandboxapiServer.run[IO]
