package com.example.webpushsandboxapi

import cats.effect.Sync
import cats.implicits.*
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl

object WebpushsandboxapiRoutes:

  def jokeRoutes[F[_]: Sync](J: Jokes[F]): HttpRoutes[F] =
    val dsl = new Http4sDsl[F]{}
    import dsl._
    HttpRoutes.of[F] {
      case GET -> Root / "joke" => {
        val publicKey = "BAU8tTZozk7GwhJv3xm0b0wrEiW8_Bx5hDLnRYc1epSwpPei4hecZW4gvYKxj5Y7KoD6Wpjmo78Xjzei1n0bBbs"
        val privateKey = "I4N9R6XoQ7_w6R1n1RNisc75LVnaT_M2Pq3Lssvgmg"

        for {
          joke <- J.get
          resp <- Ok(joke)
        } yield resp
      }
    }

  def helloWorldRoutes[F[_]: Sync](H: HelloWorld[F]): HttpRoutes[F] =
    val dsl = new Http4sDsl[F]{}
    import dsl._
    HttpRoutes.of[F] {
      case GET -> Root / "hello" / name =>
        for {
          greeting <- H.hello(HelloWorld.Name(name))
          resp <- Ok(greeting)
        } yield resp
    }
