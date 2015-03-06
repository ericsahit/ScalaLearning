package me.learning.scala

import java.text.MessageFormat
import java.net.URL
import java.net.MalformedURLException
import java.io.IOException

object ControlStructureAndFunctionTest extends App {
  
  /**
   * �������ʽ
   */
  
  var x = 4
  val s = if (x > 0) 1 else -1
  
  //scala�еı��ʽ��ÿ�����������Լ�������
  //���ص�������������֧���͵Ĺ��������ͣ�������Any
  val r = if (x > 0) "positive" else -1
  println(r.getClass)
  
  //else����ȱʧ�ˣ�����û�����ֵ������Scala�У�ÿ�����ʽ��Ӧ����ĳ��ֵ���������������һ��Unit�࣬д��()
  //���԰�()���Ǳ�ʾ��������ֵ����ռλ��������void
  var b = if (x < 0) 1//=if(x>0) 1 else ()
  println(b)
  println(b.getClass)
  
  /**
   * �����ֹ
   */
  
  //ͬ�ж�����䣬�м�ʹ�÷ֺŸ���
  if (x > 0) {x * s; x -= 1}
  
  //�ϳ�����䣬Ҫȷ����һ����һ�����������������ķ��Ž�β
  x = x + //�ӺŸ��߱��������ﲻ������ĩβ
		  s;
  
  //
  
  /**
   * ����ʽ�͸�ֵ
   * 
   */
  //{}�����һϵ�б��ʽ�����Ҳ��Ҳ��һ�����ʽ�������һ�����ʽ��ֵ���ǿ��ֵ
  var y = 3
  val z = 4
  val x0, y0 = 0
  import scala.math._
  val distance = { val dx = z - x0; val dy = y - y0; sqrt(dx * dx + dy * dy)} //ֵ�����һ�����ʽֵ
  println(distance)
  
  //����ֵ���ʽ��ֵ��Unit����������ı��ʽ�����ǰ�Unit���͸�ֵ��x
  //x = y = 1
  
  /**
   * ��������
   */
  //��ʽ�����
  printf("hello, %s! you are %d years old.\n", "eric", 28)
  
  //���ݶ���
//  val name = readLine("your name: ")
//  print("your age: ")
//  val age = readInt()
//  printf("hello!, %s! next year, you will be %d.\n", name, age+1)
  
  /**
   * ѭ��
   */
  while (x > 0) {
    y = y * x
    x -= 1
  }
  //�ȼ����档<-��ʾ�ñ���i�����ұߵı��ʽ������ֵ������i�Ǽ���Ԫ�����ͣ�������һֱ������ѭ������
  for (i <- 1 to x) {
    y *= x
  }
  
  val str = "Hello"
  var sum = 0
  for (i <- 0 until str.length) {//���i��ȡֵ��s.length - 1 
    sum += str(i)
  }
  
  for (ch <- "Hello") sum += ch //������Ҫ�±��ʱ��
  
  //scala�У���ѭ����ʹ�ò���������������ôƵ����ͨ�����ǿ���ͨ���������е�����ֵӦ��ĳ�������ķ�ʽ���������ǣ�ֻ��Ҫһ�η�������
  
  //scala�У���û��break��continue���˳�ѭ�������ԣ�
  //1.ʹ��Boolean���Ʊ�����2.ʹ��Ƕ�׺������Ӻ�����return��2.ʹ��Breaks�����е�break����
  import scala.util.control.Breaks._
  breakable {//ͨ���׳��Ͳ����쳣��ʵ��
    for (ch <- "Hello") {
      if (ch == 'l') break;
    }
  }
  
  //forѭ����Ķ�����������ֺŸ���
  for (i <- 1 to 3; j <- 1 to 3) print((10 * i + j) + " ")
  
  //ÿ�������������Դ�һ����������if��ͷ�ı��ʽ
  for (i <- 1 to 3; j <- 1 to 3 if i != j) print((10 * i + j) + " ")
  
  //����ʹ�������Ķ��壬�������ѭ����ʹ�õı���
  for (i <- 1 to 3; from = 4 - i; j <- from to 3) print("\r\n" + (10 * i + j) + " ")
  
  //���forѭ����ѭ������yield��ʼ�����ѭ���ṹ���һ�����ϣ�ÿ�ε������ɼ������Ǹ���һ��ֵ
  //����Vector(1, 2, 0, 1, 2, 0, 1, 2, 0, 1)
  println(for (i <- 1 to 10) yield i % 3)
  //����ѭ������for�Ƶ�ʽ
  
  //for�Ƶ�ʽ���ɵļ��������ĵ�һ�������������ͼ��ݵ�
  //HIeflmlmop
  println(for (c <- "Hello"; i <- 0 to 1) yield (c+i).toChar) 
  //Vector(H, e, l, l, o, I, f, m, m, p)
  println(for (i <- 0 to 1; c <- "Hello") yield (c+i).toChar)
  
  //Ҳ�ɰ����ڻ�������������Ի��еķ�ʽ�����÷ֺ����ָ�
  for {
    i <- 1 to 3
    from = 4 - i
    j <- from to 3
  } print("\r\n" + (10 * i + j) + " ")
  
  /**
   * ����
   * �����Զ�����в��������������ǣ�java��ʹ�þ�̬������ģ��
   */
  
  //��Ҫָ�����������ͣ���һ�㲻��Ҫָ������ֵ���ͣ������ǵݹ麯��
  def abs(x: Double) = if (x>=0) x else -x
  
  //����������һ�����ʽ��ֵ���Ǻ����ķ���ֵ��������˵������������������ֵλ��forѭ��֮���r��ֵ
  //������ʹ��return
  def fac(n: Int) = {
    var r = 1
    for (i<-1 to n) r=r*i
    r
  }
  
  //�ݹ麯��������ָ����������
  def fac2(n: Int): Int = if (n<=0) 1 else n*fac(n-1)
  
  //Ĭ�ϲ���
  def decorate(str: String, left: String = "[", right: String = "]") = 
    left+str+right
  
  println(decorate("Hello"))
  println(decorate("Hello", "<<<["))
  println(decorate("Hello", "<<<", ">>>"))
  //����ָ����������˳����Ҫһ��
  println(decorate(left="<<<", str="Hello", right=">>>"))
  println(decorate("Hello", right="]<<<"))
  
  def sum(args: Int*) = {
    var result = 0
    for (arg <- args) result+=arg
    result
  }
  //�䳤�����������õ�����һ������ΪSeq�Ĳ���
  var sumval = sum(1, 4, 9, 16, 25)
  println(sumval)
  
  //���󣬻ᱻ���ɵ�������
  //sumval = sum(1 to 5)
  
  //���߱�������ϣ����������������������д���׷��:_*
  sumval = sum(1 to 5: _*)
  
  def recursiveSum(args: Int*): Int = {
    if (args.length == 0) 0
    else args.head+recursiveSum(args.tail:_*)
  }
  
  //���ñ䳤�����Ҳ�������ΪObject��java��������Ҫ�ֹ��Ի������ͽ���ת��
  val strval = MessageFormat.format("the answer to {0} is {1}", "everything", 42.asInstanceOf[AnyRef])
  
  /**
   * ����
   * Scala���ڲ�����ֵ�ĺ���������ı�ʾ��
   * �������������ڻ��������û��ǰ���=�ţ���ô�������;���Unit�������ĺ�����Ϊ����
   */
  def box(s: String) { //û��=��
    var border = "-" * s.length+"--\n"
    println(border+ "|"+s+"|\n"+border)
  }
  
  box("Hello")
  
  /**
   * ��ֵ
   * val������Ϊlazyʱ�����ĳ�ʼ�������Ƴ٣�ֱ�����Ƕ����״�ȡֵ
   * ���ڿ����Ƚϴ�ĳ�ʼ�����ʮ������
   */
  def testLazy = {
	  //���԰���ֵ�����ǽ���val��def���м�״̬��
	  //������ʱ����ȡֵ
	  val words1 = scala.io.Source.fromFile("words.txt").mkString
	  	//���״�ʹ��ʱ��ȡֵ
			  lazy val words2 = scala.io.Source.fromFile("words.txt").mkString
			  //��ÿһ�α�ʹ��ʱȡֵ
			  def words3 = scala.io.Source.fromFile("words.txt").mkString
  }
  
  /**
   * �쳣
   * throw���ʽ��������Nothing��ifelse�У����һ����֧��Nothing����ôif���ʽ���;�����һ����֧������
   */
  val ifval = 5
  if (ifval > 0) {
    sqrt(x)
  } else throw new IllegalArgumentException("x should not be negative")
  
  //�����쳣ʹ�õ���ģʽƥ����﷨
  val url = "http://www.baidu.com"
  try {
    new URL(url)
  } catch {
    //�������Ҫʹ�ò�����쳣���󣬿���ʹ��_�����������
    case _: MalformedURLException => println("bad url: "+url)
    case ex: IOException => ex.printStackTrace() 
  }
  
  def process: Unit = {
    var in = new URL(url).openStream()
    try {
      val i = in.available()
    } finally {
      in.close()
    }
  }
  
  /**
   * ��ϰP27
   */
  
  def signum(x: Double) = {
    if (x > 0) 1
    else if (x < 0) -1
    else 0
  }
  println(signum(5))
  println(signum(-5))
  println(signum(0))
  
  BigInt(10).signum
  
  println({})
  
  val valx = y = 1
  println(valx)
  
  for (i <- 0 to 10; j = 10 - i) println(j)
  for (i <- 0 to 10 reverse) println(i)
  
  def countdown(n: Int) = {
    (0 to n reverse).foreach(println)
    //0 to n reverse foreach println
  }
  
  var sum2 = 1l
  val strval2 = "Hello"
  for (ch <- strval2) sum2 *= ch.toLong
  println(sum2)
  
  sum2 = strval2.foldLeft(1l)((sum, ch) => sum * ch.toLong)
  println(sum2)
  
  def product(s: String) = {
    s.foldLeft(1l)((sum, ch) => sum * ch.toLong)
  }
  println(product("Hello"))
  
  def productRecursive(s: Seq[Char]): Long = {
    if (s.length == 0) 1l
    else s.head.toLong * productRecursive(s.tail)
  }
  println(productRecursive("Hello"))
  
  def product2(x: Int, n: Int) = {

  }
  
  
  
  
  
  
  
  
  
  
  
  
  
    

    
  
  
  
  
  
  
}