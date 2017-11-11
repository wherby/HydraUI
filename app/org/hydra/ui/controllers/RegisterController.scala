package org.hydra.ui.controllers

import java.util.logging.Logger
import javax.inject._

import org.hydra.ui.models.AppRequest
import org.hydra.ui.services.HydraCluster
import play.api.mvc.{AbstractController, _}
import hydra.cluster.common.msg.DeployService.DeployReq

import scala.concurrent.Future
import org.hydra.ui.models.AppFormats
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * For HydraUI
  * Created by TaoZhou(187225577@qq.com) on 25/10/2017. 
  */
@Singleton
class RegisterController @Inject()(cc: ControllerComponents, cluster:HydraCluster) extends AbstractController(cc) with AppFormats {
  val log = Logger.getLogger(this.getClass.toString)
  def registerApp= Action.async(BodyParsers.parse.json){
    request => Future{
      try{
        request.body.asOpt[AppRequest] match {
          case Some(appRequest) =>
            val reqStr= request.body.toString()
            log.info(s"Send Deploy request $reqStr")
            cluster.deployServiceProxy ! DeployReq(reqStr)
        }
        Ok("success")
      }catch {
        case e:Exception => BadRequest(s"The query option is not correct. format is ${e.getMessage}")
      }

    }
  }
}
