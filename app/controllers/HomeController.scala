package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import java.text.SimpleDateFormat
import java.util.Calendar
import java.io._
/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {
  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def addEmail = Action { request =>
    val valueOpt = request.body.asFormUrlEncoded
    valueOpt match {
      case Some(value) =>
        val email = value.get("email").map(_.head)
        email match {
          case Some(value) =>
            val file = new File("emails/" + System.currentTimeMillis.toString + ".txt")
            val bw = new BufferedWriter(new FileWriter(file))
            bw.write(value.toString)
            bw.close()
          case None => println("none")
        }
      case None => println("default")
    }
    Ok("Success")
  }

}
