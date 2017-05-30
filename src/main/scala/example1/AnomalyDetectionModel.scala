package example1

import org.apache.spark.mllib.linalg._
import org.apache.spark.rdd.RDD

/**
  * Created by sk on 2017/5/30.
  */
class AnomalyDetectionModel (
                              val means: Vector,
                              val variances: Vector,
                              val epsilon: Double) extends Serializable
{
  /**
    *
    * @param point
    * @return
    */
  def predict(point: Vector): Boolean = {
    AnomalyDetection.predict(point, means, variances, epsilon)
  }

  def predict(points: RDD[Vector]): RDD[(Vector, Boolean)] = {
    points.map(p => (p,AnomalyDetection.predict(p, means, variances, epsilon)))
  }

}