package org.tritsch.scala.util

import com.weiglewilczek.slf4s.Logging

object Profiler extends Logging {
  var elapseTime: Long = 0

  def time0[R](block: => R): R = {
    val startTime = System.currentTimeMillis
    val result = block
    val endTime = System.currentTimeMillis
    elapseTime = endTime - startTime
    logger.info("Elapsed time (ms): " + elapseTime)
    result
  }

  def time1[R](block: => R): (R, Long) = {
    val startTime = System.currentTimeMillis
    val result = block
    val endTime = System.currentTimeMillis
    elapseTime = endTime - startTime
    (result, elapseTime)
  }

  def time1(f: => Unit) = {
    val startTime = System.currentTimeMillis
    f
    val endTime = System.currentTimeMillis
    elapseTime = endTime - startTime
    elapseTime
  }
}
