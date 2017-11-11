package org.hydra.ui.models

import play.api.libs.json._

/**
  * For HydraUI
  * Created by TaoZhou(187225577@qq.com) on 25/10/2017. 
  */
trait AppFormats {

  implicit object AppRequestFormat extends Format[AppRequest] {
    override def reads(json: JsValue): JsSuccess[AppRequest] = JsSuccess(AppRequest(
      (json \ "appname").as[String],
      (json \ "startcmd").as[Seq[String]]
    ))

    override def writes(apprequest: AppRequest): JsValue = JsObject(List(
      "appname" -> JsString(apprequest.appname),
      "startcmd" -> JsArray(apprequest.startCmd.map { va => JsString(va) })
    ))
  }

}
