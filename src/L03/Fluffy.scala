package L03

import L01._
import L02._

trait Fluffy[F[_]] {
  def furry[A, B](f: A => B): F[A] => F[B]
}

object Fluffy {
  implicit val ListFluffy: Fluffy[List] =
    sys.error("todo")

  implicit val OptionalFluffy: Fluffy[Optional] =
    sys.error("todo")

  implicit def Function1Fluffy[T]: Fluffy[({type l[a] = T => a]})#l] =
    sys.error("todo")
  
  ///////////////////////
  // SUPPORT LIBRARIES //
  ///////////////////////

  implicit val ScalaListFluffy: Fluffy[scala.List] =
    new Fluffy[scala.List] {
      def furry[A, B](f: A => B) =
        _ map f
    }

}
