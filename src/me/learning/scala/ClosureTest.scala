package me.learning.scala

import javax.swing.JButton
import java.awt.event.ActionListener
import java.awt.event.ActionEvent

object ClosureTest extends App {
  //�հ��оֲ����������ö��ǿ���
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
  
  //��ͳ������¼������ķ��������ýӿڴ���
  var counter = 0
  val button = new JButton("Increment")
  button.addActionListener(new ActionListener {
	  override def actionPerformed(e: ActionEvent) {counter += 1}
  	} 
  )
  
  //��Ҫ�ﵽ����һ�ּ���Ч��
  //button.addActionListener((event: ActionEvent) => counter += 1)
  
  //ʹ����ʽת���������lambda��������ֱ��ת��Ϊ����ֱ�Ӵ���lambda��������
  
  implicit def makeAction(action: (ActionEvent) => Unit) = 
    new ActionListener {
	  override def actionPerformed(event: ActionEvent) { action(event) }
  	}
  
  //���������ʿ��ת�����Ϳ���������Ԥ��ActionListener����ĵط������κ�(ActionEvent)=>Unit����
  button.addActionListener((event: ActionEvent) => counter += 1)
  
  
  
}