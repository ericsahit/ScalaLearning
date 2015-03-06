package me.learning.scala

object Chapter3ArrayTest extends App {
  //定长数组
  val nums = new Array[Int](10)
  
  val strs = new Array[String](10)
  
  //长度为2的Array[String]，类型是推断出来的
  val s = Array("Hello", "World", "aa")
  println(s)
  
  //jvm中，Scala的Array以Java数组方式实现。以上为java.lang.String[]
  
  /**
   * 变长数组，数组缓冲ArrayBuffer，等效于ArrayList，vector
   */
  import scala.collection.mutable.ArrayBuffer
  val b = ArrayBuffer[Int]()
  
  b+=1
  
  //追加多个元素
  b += (2,3,4,5)
  
  //追加集合
  b ++= Array(8, 13, 21)
  
  b.trimEnd(5)
  println(b)
  
  b.insert(2, 6)
  b.insert(2, 7, 8, 9)
  b.remove(2)
  b.remove(2, 3)//从第二个元素开始移除3个元素
  
  val buf2arr = b.toArray
  val arr2buf = buf2arr.toBuffer
  
  /**
   * 遍历
   */
  
  for (i <- 0 until s.length)
    println(i + ": " + s(i))
  
  for (elem <- s) println(elem)
  
  val arra = ArrayBuffer(2, 3, -4, 5, -8, 7, -19, 11)
  //yield创建一个类型和原始集合相同的新集合;数组会得到一个数组
  var result = for (elem <- arra) yield 2*elem
  println(result)
  
  result = for (elem <- arra if elem % 2 == 0) yield 2*elem
  result = arra.filter(_ % 2 == 0).map(2*_)
  result = arra.filter {_ % 2 == 0} map {2*_}
  
  //去掉除了第一个负数之外的所有负数，有效方法p34
  var first = true
  val indexes = for (i <- 0 until arra.length if first || arra(i) >= 0) yield {
    if (arra(i) < 0) first = false; i
  }
  for (j <- 0 until indexes.length) arra(j) = arra(indexes(j))
  arra.trimEnd(arra.length - indexes.length)
  arra.foreach(println(_))
  
  val sorted = arra.sortWith(_ < _)
  sorted.foreach(println)
  
  //min，max，quickSort方法，元素类型必须支持比较操作，带有Ordered特质的类型
  //只能对Array排序，不能对数组缓冲
  println(arra.min)
  val arrb = arra.toArray
  scala.util.Sorting.quickSort(arrb)
  arrb.foreach(println(_))
  
  println(arra.mkString(" and "))
  println(arra.mkString("<", ",", ">"))
  
  /**
   * 解读Scaladoc，p36
   */
  
  def appendAll(xs: TraversableOnce[Int]): Unit = {
    
  }
  
  /**
   * 多维数组
   */
  val matrix = Array.ofDim[Double](3, 4)
  matrix(2)(2) = 42
  
  //创建不规则的数组，每一行的长度各不相同
  val triangle = new Array[Array[Int]](10)
  for (i <- 0 until triangle.length)
    triangle(i) = new Array[Int](i+1)
  
  /**
   * 与java的互操作，引入隐式的转换
   */
  import scala.collection.JavaConversions.bufferAsJavaList
  //ProcessBuilder接收List，但是通过隐式的转换，ArrayBuffer被包装成了一个实现List接口的Java类的对象
  //可以查看bufferAsJavaList的代码
  val command = ArrayBuffer("ls", "-al", "/home/eric")
  val pb = new ProcessBuilder(command)
  
  import scala.collection.JavaConversions.asScalaBuffer
  import scala.collection.mutable.Buffer
  val cmd: Buffer[String] = pb.command()
  
    
}