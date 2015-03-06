package me.learning.scala

import scala.collection.mutable.ArrayBuffer

object NestedClassTest extends App {
  val chatter = new Network
  val myface = new Network
  
  val fred = chatter.join("fred")
  val wilma = chatter.join("Wilma")
  fred.contacts += wilma
  val barney = myface.join("barney")
  //fred.contacts += barney 类型为myface.Member，不是chatter.Members
}

class Network {
  class Member(val name: String) {
    val contacts = new ArrayBuffer[Member]
  }
  
  private val members = new ArrayBuffer[Member]
  
  def join(name: String) = {
    val m = new Member(name)
    members += m
    m
  }
}