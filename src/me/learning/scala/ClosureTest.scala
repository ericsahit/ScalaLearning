package me.learning.scala

import javax.swing.JButton
import java.awt.event.ActionListener
import java.awt.event.ActionEvent

object ClosureTest extends App {
  //闭包中局部变量是引用而非拷贝
  def say667 = {
    var num = 666
    def sayAlert = Console.println(num)
    num += 1
    sayAlert
  }
  
  val sayAlert = say667 _
  sayAlert()
  
  def setupGlobals = {
    var num = 666
    
    def alertNumber = Console.println(num)
    def increaseNumber = num += 1
    def setNumber = (x: Int) => num = x
  }
  
  def mulBy(factor: Double) = (x: Double) => factor * x
  
  val triple = mulBy(3)
  val half = mulBy(0.5)
  
  println(triple(14) + " " + half(14))
  
  //传统的添加事件监听的方法，是用接口传递
  var counter = 0
  val button = new JButton("Increment")
  button.addActionListener(new ActionListener {
	  override def actionPerformed(e: ActionEvent) {counter += 1}
  	} 
  )
  
  //想要达到这样一种简洁的效果
  //button.addActionListener((event: ActionEvent) => counter += 1)
  
  //使用隐式转换，将这个lambda函数可以直接转换为可以直接传递lambda匿名函数
  
  implicit def makeAction(action: (ActionEvent) => Unit) = 
    new ActionListener {
	  override def actionPerformed(event: ActionEvent) { action(event) }
  	}
  
  //有了这个隐士的转换，就可以在所有预期ActionListener对象的地方传入任何(ActionEvent)=>Unit函数
  button.addActionListener((event: ActionEvent) => counter += 1)
  
  
  
}