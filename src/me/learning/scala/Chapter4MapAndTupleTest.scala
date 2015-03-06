package me.learning.scala

object Chapter4MapAndTupleTest extends App {
  
  //构造出一个不可变的Map[String, Int]
  val scores = Map("eric" -> 10, "lili" -> 3, "cindy" -> 8)
  //构造出一个可变的Map
  val scores2 = scala.collection.mutable.Map("eric" -> 10, "lili" -> 3, "cindy" -> 8)
  //空的映射，需要选定一个映射实现
  val scores3 = new scala.collection.mutable.HashMap[String, Int]
  
  //Scala中，映射是对偶的集合，使用操作符来创建对偶
  println("eric" -> 10) //=("Alice", 10)
  
  //->比括号更易读一点，也更符合大家对映射的直观感觉：将key映射到value的函数。区别在于函数计算值，映射只做查询
  val scores4 = Map(("eric", 10), ("Bob", 3))
  
  //如果不包含key，则会抛出异常
  var bobScore = scores4("Bob")
  
  bobScore = if (scores4.contains("Bob")) scores4("Bob") else 0
  bobScore = scores4.getOrElse("Bob", 0)
  val scoreOption = scores4.get("Bob")//返回Option
  
  scores2("eric") = 10//修改
  scores2("bob") = 89//新增
  
  scores2 += ("Bob" -> 7, "Fred" -> 9)
  
  scores2 -= "eric"
  
    //映射包含了与scores相同的映射关系，此外eric被更新，fred被添加了进来
  var newScores = scores + ("eric" -> 10, "Fred" -> 7)
  //去掉一个不可变映射的键
  newScores = scores - "eric"
  
  //key返回Set，values返回一个Iterable
  println(newScores.keySet)
  
  for (value <- newScores.values) println(value)
  
  for ((key, value) <- newScores) println(key + " " + value)
  //反转一个映射
  println(for ((key, value) <- newScores) yield (value, key))
  //树形的映射，需要按照顺序访问所有的键
  val scores5 = scala.collection.immutable.SortedMap("eric" -> 10, "lili" -> 3, "cindy" -> 8)
  
  //按照插入顺序访问所有键，使用LinkedHashMap
  val months = scala.collection.mutable.LinkedHashMap[String, Int]()
  
  /**
   * 与java的互操作
   */
  
  import scala.collection.JavaConversions.mapAsScalaMap
  //Scala没有可变的树形映射，可以用java的来使用
  val scores6: scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int]
  
  import scala.collection.JavaConversions.propertiesAsScalaMap
  val props: scala.collection.Map[String, String] = System.getProperties()
  
  /**
   * 元祖
   * 对偶是元祖最简单的形式，元祖是不同类型的值的聚集
   */
  println((1, 3.14, "fred"))//类型为Tuple3[Int, Double, String]
  
  //使用_1 _2来访问其组元
  val t = (1, 3.14, "fred")
  println(t._2)
  
  //使用模式识别来获取元祖中的组元
  val (first, second, third) = t
  
  //如果不是所有的组元都需要，可以使用_来占位
  val (first2, _, third2) = t
  
  //返回一个元祖，分别是满足某个条件和不满足某个条件的字符
  println("New York".partition(_.isUpper))
  
  /**
   * 拉链操作
   */
  val symbols = Array("<", "=", ">")
  val counts = Array(2, 10, 2)
  val pairs = symbols.zip(counts)//返回对偶的数组
  pairs.foreach(println)
  
  for ((s, n) <- pairs) Console.print(s * n)
}