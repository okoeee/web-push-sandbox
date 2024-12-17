package com.example.webpushsandboxapi

import cats.effect.Sync
import cats.implicits.*
import nl.martijndwars.webpush.Subscription.Keys
import nl.martijndwars.webpush.{Notification, PushService, Subscription, Utils}
import org.bouncycastle.jce.provider.BouncyCastleProvider
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl

import java.security.{KeyPair, Security}

object WebpushsandboxapiRoutes:

  def webPushRoutes[F[_]: Sync](): HttpRoutes[F] =
    val dsl = new Http4sDsl[F] {}
    import dsl._
    HttpRoutes.of[F] {
      case GET -> Root / "joke" => {

        Security.addProvider(new BouncyCastleProvider())

        val publicKeyStr  = ""
        val privateKeyStr = ""

        val publicKey  = Utils.loadPublicKey(publicKeyStr)
        val privateKey = Utils.loadPrivateKey(privateKeyStr)

        val keyPair = KeyPair(
          publicKey,
          privateKey
        )

        val endpoint = ""
        val p256dh   = ""
        val auth     = ""

        val subscription = new Subscription(
          endpoint,
          Keys(
            p256dh,
            auth
          )
        )

        val notification = new Notification(
          subscription,
          """{"title": "Hello"}"""
        )

        val pushService = new PushService(keyPair)

        try {
          val result = pushService.send(notification)
          println(s"result: $result")
        } catch {
          case e: Exception => println(s"error: $e")
        }

        for {
          joke <- J.get
          resp <- Ok(joke)
        } yield resp
      }
    }

  def helloWorldRoutes[F[_]: Sync](H: HelloWorld[F]): HttpRoutes[F] =
    val dsl = new Http4sDsl[F] {}
    import dsl._
    HttpRoutes.of[F] { case GET -> Root / "hello" / name =>
      for {
        greeting <- H.hello(HelloWorld.Name(name))
        resp <- Ok(greeting)
      } yield resp
    }
