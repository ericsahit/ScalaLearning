package me.learning.scala

import java.nio.IntBuffer
import scala.beans.BeanProperty

object ClassTest {
	def main(args: Array[String]) {
	  
	  //�½��������Ĭ�Ϲ�������()��ѡ
	  val myCounter = new Counter//()��ѡ
	  
	  //һ����˵�����޸�����ֵ�ķ��������ţ���ȡֵ�ķ�����������
	  myCounter.increment() //()��ѡ
	  myCounter.currVal //()��ѡ
	  myCounter.currtent //()����ѡ
	  
	  myCounter.age = 5 //����myCounter.age=(5)
	  println(myCounter.age) //����myCounter.age()
	  
	  myCounter.age2 = 30
	  myCounter.age2 = 20 
	  println(myCounter.age2)//30
	}
}

//��Scala�У��ಢ����Ҫ����public��һ���ļ����԰�������࣬���ǵĹ���
class Counter {
  
  //�����ʼ���ֶ�
  private var value = 0 
  
  //����Ĭ�Ϲ���
  def increment() {value+=1}
  
  //
  def currVal() = value
  
  //�����в�����()��ǿ�Ƶ���
  def currtent = value
  
  //ÿ���ֶζ�������getter��setter������getter��age��setter��age_=
  var age = 0
  
  //�������¶���getter��setter����
  private var privateAge2 = 0
  def age2 = privateAge2
  def age2_=(newAge: Int) {
    if (newAge > privateAge2) privateAge2 = newAge
  }
  
  //����ֶ���˽�еģ���getter��setter����Ҳ��˽�е�
  //����ֶ���val����ֻ��getter��������
  //����㲻��Ҫ�κ�getter��setter�����ֶ�������private[this]
  private[this] var privateAge3 = 0
  
  //val������˽�е�final�ֶκ�һ��getter������û��setter
  val timeStamp = new java.util.Date
  
  /**
   * var foo
   * val foo
   * �Զ���foo, foo_=����
   * �Զ���foo
   */
  /**
   * �������Է��ʸ�������ж����˽���ֶΣ�����private��Ϊ��˽���ֶ�
   * ����private[this]�����֮Ϊ������˽�С��ֶΣ����Ǵ������˽�е�
   * private[�������߰���]���η����Զ������ָ������߰��ķ������Է�������ֶ�
   * 
   * ��˽���ֶΣ�scala����˽�е�getter��setter����������˽���ֶΣ�������getter��setter�������μ�
   */
  def isLess(other: Counter) = value < other.value
  
  private[this] var value2 = 0
  //private[Person] var value3 = 0
  
  
  //������getXXX��setXXX
  @BeanProperty var name: String = _
}


