package services

import java.time.{Clock, Instant}
import javax.inject._

import com.typesafe.config.ConfigFactory
import akka.cluster.singleton.{ClusterSingletonProxy, ClusterSingletonProxySettings}

import scala.concurrent.Future
import akka.actor.{ActorSystem, Props}

/**
  * This class demonstrates how to run code when the
  * application starts and stops. It starts a timer when the
  * application starts. When the application stops it prints out how
  * long the application was running for.
  *
  * This class is registered for Guice dependency injection in the
  * [[Module]] class. We want the class to start when the application
  * starts, so it is registered as an "eager singleton". See the code
  * in the [[Module]] class to see how this happens.
  *
  * This class needs to run code when the server stops. It uses the
  * application's [[ApplicationLifecycle]] to register a stop hook.
  */
@Singleton
class HydraCluster @Inject()( ) {
  val config = ConfigFactory.parseString("akka.remote.netty.tcp.port=0" ).
    withFallback(ConfigFactory.load())
  // Create an Akka system
  val system = ActorSystem("ClusterSystem", config)

  val deployServiceProxy = system.actorOf(ClusterSingletonProxy.props(
    singletonManagerPath = "/user/deployservice",
    settings = ClusterSingletonProxySettings(system)),
    name = "deployserviceProxyUI")

}