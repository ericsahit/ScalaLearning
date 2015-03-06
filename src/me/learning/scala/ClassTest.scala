package me.learning.scala

import java.nio.IntBuffer
import scala.beans.BeanProperty

object ClassTest {
	def main(args: Array[String]) {
	  
	  //新建类如果有默认构造器，()可选
	  val myCounter = new Counter//()可选
	  
	  //一般来说，对修改类里值的方法带括号；对取值的方法不带括号
	  myCounter.increment() //()可选
	  myCounter.currVal //()可选
	  myCounter.currtent //()不可选
	  
	  myCounter.age = 5 //调用myCounter.age=(5)
	  println(myCounter.age) //调用myCounter.age()
	  
	  myCounter.age2 = 30
	  myCounter.age2 = 20 
	  println(myCounter.age2)//30
	}
}

//在Scala中，类并不需要声明public，一个文件可以包含多个类，具是的公开
class Counter {
  
  //必须初始化字段
  private var value = 0 
  
  //方法默认公开
  def increment() {value+=1}
  
  //
  def currVal() = value
  
  //定义中不带有()，强制调用
  def currtent = value
  
  //每个字段都隐含有getter和setter方法，getter叫age，setter叫age_=
  var age = 0
  
  //可以重新定义getter和setter方法
  private var privateAge2 = 0
  def age2 = privateAge2
  def age2_=(newAge: Int) {
    if (newAge > privateAge2) privateAge2 = newAge
  }
  
  //如果字段是私有的，则getter和setter方法也是私有的
  //如果字段是val，则只有getter方法生成
  //如果你不需要任何getter和setter，将字段声明成private[this]
  private[this] var privateAge3 = 0
  
  //val会生成私有的final字段和一个getter方法，没有setter
  val timeStamp = new java.util.Date
  
  /**
   * var foo
   * val foo
   * 自定义foo, foo_=方法
   * 自定义foo
   */
  /**
   * 方法可以访问该类的所有对象的私有字段，所以private称为类私有字段
   * 加了private[this]，则称之为“对象私有”字段，就是纯粹对象私有的
   * private[类名或者包名]修饰符可以定义仅有指定类或者包的方法可以访问这个字段
   * 
   * 类私有字段，scala生成私有的getter和setter方法，对象私有字段，不生成getter和setter方法，参见
   */
  def isLess(other: Counter) = value < other.value
  
  private[this] var value2 = 0
  //private[Person] var value3 = 0
  
  
  //会生成getXXX和setXXX
  @BeanProperty var name: String = _
}


