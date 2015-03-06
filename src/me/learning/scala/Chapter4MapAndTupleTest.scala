package me.learning.scala

object Chapter4MapAndTupleTest extends App {
  
  //�����һ�����ɱ��Map[String, Int]
  val scores = Map("eric" -> 10, "lili" -> 3, "cindy" -> 8)
  //�����һ���ɱ��Map
  val scores2 = scala.collection.mutable.Map("eric" -> 10, "lili" -> 3, "cindy" -> 8)
  //�յ�ӳ�䣬��Ҫѡ��һ��ӳ��ʵ��
  val scores3 = new scala.collection.mutable.HashMap[String, Int]
  
  //Scala�У�ӳ���Ƕ�ż�ļ��ϣ�ʹ�ò�������������ż
  println("eric" -> 10) //=("Alice", 10)
  
  //->�����Ÿ��׶�һ�㣬Ҳ�����ϴ�Ҷ�ӳ���ֱ�۸о�����keyӳ�䵽value�ĺ������������ں�������ֵ��ӳ��ֻ����ѯ
  val scores4 = Map(("eric", 10), ("Bob", 3))
  
  //���������key������׳��쳣
  var bobScore = scores4("Bob")
  
  bobScore = if (scores4.contains("Bob")) scores4("Bob") else 0
  bobScore = scores4.getOrElse("Bob", 0)
  val scoreOption = scores4.get("Bob")//����Option
  
  scores2("eric") = 10//�޸�
  scores2("bob") = 89//����
  
  scores2 += ("Bob" -> 7, "Fred" -> 9)
  
  scores2 -= "eric"
  
    //ӳ���������scores��ͬ��ӳ���ϵ������eric�����£�fred������˽���
  var newScores = scores + ("eric" -> 10, "Fred" -> 7)
  //ȥ��һ�����ɱ�ӳ��ļ�
  newScores = scores - "eric"
  
  //key����Set��values����һ��Iterable
  println(newScores.keySet)
  
  for (value <- newScores.values) println(value)
  
  for ((key, value) <- newScores) println(key + " " + value)
  //��תһ��ӳ��
  println(for ((key, value) <- newScores) yield (value, key))
  //���ε�ӳ�䣬��Ҫ����˳��������еļ�
  val scores5 = scala.collection.immutable.SortedMap("eric" -> 10, "lili" -> 3, "cindy" -> 8)
  
  //���ղ���˳��������м���ʹ��LinkedHashMap
  val months = scala.collection.mutable.LinkedHashMap[String, Int]()
  
  /**
   * ��java�Ļ�����
   */
  
  import scala.collection.JavaConversions.mapAsScalaMap
  //Scalaû�пɱ������ӳ�䣬������java����ʹ��
  val scores6: scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int]
  
  import scala.collection.JavaConversions.propertiesAsScalaMap
  val props: scala.collection.Map[String, String] = System.getProperties()
  
  /**
   * Ԫ��
   * ��ż��Ԫ����򵥵���ʽ��Ԫ���ǲ�ͬ���͵�ֵ�ľۼ�
   */
  println((1, 3.14, "fred"))//����ΪTuple3[Int, Double, String]
  
  //ʹ��_1 _2����������Ԫ
  val t = (1, 3.14, "fred")
  println(t._2)
  
  //ʹ��ģʽʶ������ȡԪ���е���Ԫ
  val (first, second, third) = t
  
  //����������е���Ԫ����Ҫ������ʹ��_��ռλ
  val (first2, _, third2) = t
  
  //����һ��Ԫ�棬�ֱ�������ĳ�������Ͳ�����ĳ���������ַ�
  println("New York".partition(_.isUpper))
  
  /**
   * ��������
   */
  val symbols = Array("<", "=", ">")
  val counts = Array(2, 10, 2)
  val pairs = symbols.zip(counts)//���ض�ż������
  pairs.foreach(println)
  
  for ((s, n) <- pairs) Console.print(s * n)
}