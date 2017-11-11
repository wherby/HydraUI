package org.hydra.ui.services

import javax.inject._

import akka.actor.ActorSystem
import akka.cluster.singleton.{ClusterSingletonProxy, ClusterSingletonProxySettings}
import com.typesafe.config.ConfigFactory

/**
  * For HydraUI
  * Created by TaoZhou(187225577@qq.com) on 25/10/2017.
  */

/**
  * This the the HydraCluster service which will connect to Hydra Cluster.
  */
@Singleton
class HydraCluster @Inject()( ) {
  val config = ConfigFactory.load()

  // Create an Akka system
  val system = ActorSystem("ClusterSystem", config)

  val deployServiceProxy = system.actorOf(ClusterSingletonProxy.props(
    singletonManagerPath = "/user/deployservice",
    settings = ClusterSingletonProxySettings(system)),
    name = "deployserviceProxyUI")

}