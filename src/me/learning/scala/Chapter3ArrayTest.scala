package me.learning.scala

object Chapter3ArrayTest extends App {
  //��������
  val nums = new Array[Int](10)
  
  val strs = new Array[String](10)
  
  //����Ϊ2��Array[String]���������ƶϳ�����
  val s = Array("Hello", "World", "aa")
  println(s)
  
  //jvm�У�Scala��Array��Java���鷽ʽʵ�֡�����Ϊjava.lang.String[]
  
  /**
   * �䳤���飬���黺��ArrayBuffer����Ч��ArrayList��vector
   */
  import scala.collection.mutable.ArrayBuffer
  val b = ArrayBuffer[Int]()
  
  b+=1
  
  //׷�Ӷ��Ԫ��
  b += (2,3,4,5)
  
  //׷�Ӽ���
  b ++= Array(8, 13, 21)
  
  b.trimEnd(5)
  println(b)
  
  b.insert(2, 6)
  b.insert(2, 7, 8, 9)
  b.remove(2)
  b.remove(2, 3)//�ӵڶ���Ԫ�ؿ�ʼ�Ƴ�3��Ԫ��
  
  val buf2arr = b.toArray
  val arr2buf = buf2arr.toBuffer
  
  /**
   * ����
   */
  
  for (i <- 0 until s.length)
    println(i + ": " + s(i))
  
  for (elem <- s) println(elem)
  
  val arra = ArrayBuffer(2, 3, -4, 5, -8, 7, -19, 11)
  //yield����һ�����ͺ�ԭʼ������ͬ���¼���;�����õ�һ������
  var result = for (elem <- arra) yield 2*elem
  println(result)
  
  result = for (elem <- arra if elem % 2 == 0) yield 2*elem
  result = arra.filter(_ % 2 == 0).map(2*_)
  result = arra.filter {_ % 2 == 0} map {2*_}
  
  //ȥ�����˵�һ������֮������и�������Ч����p34
  var first = true
  val indexes = for (i <- 0 until arra.length if first || arra(i) >= 0) yield {
    if (arra(i) < 0) first = false; i
  }
  for (j <- 0 until indexes.length) arra(j) = arra(indexes(j))
  arra.trimEnd(arra.length - indexes.length)
  arra.foreach(println(_))
  
  val sorted = arra.sortWith(_ < _)
  sorted.foreach(println)
  
  //min��max��quickSort������Ԫ�����ͱ���֧�ֱȽϲ���������Ordered���ʵ�����
  //ֻ�ܶ�Array���򣬲��ܶ����黺��
  println(arra.min)
  val arrb = arra.toArray
  scala.util.Sorting.quickSort(arrb)
  arrb.foreach(println(_))
  
  println(arra.mkString(" and "))
  println(arra.mkString("<", ",", ">"))
  
  /**
   * ���Scaladoc��p36
   */
  
  def appendAll(xs: TraversableOnce[Int]): Unit = {
    
  }
  
  /**
   * ��ά����
   */
  val matrix = Array.ofDim[Double](3, 4)
  matrix(2)(2) = 42
  
  //��������������飬ÿһ�еĳ��ȸ�����ͬ
  val triangle = new Array[Array[Int]](10)
  for (i <- 0 until triangle.length)
    triangle(i) = new Array[Int](i+1)
  
  /**
   * ��java�Ļ�������������ʽ��ת��
   */
  import scala.collection.JavaConversions.bufferAsJavaList
  //ProcessBuilder����List������ͨ����ʽ��ת����ArrayBuffer����װ����һ��ʵ��List�ӿڵ�Java��Ķ���
  //���Բ鿴bufferAsJavaList�Ĵ���
  val command = ArrayBuffer("ls", "-al", "/home/eric")
  val pb = new ProcessBuilder(command)
  
  import scala.collection.JavaConversions.asScalaBuffer
  import scala.collection.mutable.Buffer
  val cmd: Buffer[String] = pb.command()
  
    
}