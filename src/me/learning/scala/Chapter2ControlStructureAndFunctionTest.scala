package me.learning.scala

import java.text.MessageFormat
import java.net.URL
import java.net.MalformedURLException
import java.io.IOException

object ControlStructureAndFunctionTest extends App {
  
  /**
   * 条件表达式
   */
  
  var x = 4
  val s = if (x > 0) 1 else -1
  
  //scala中的表达式，每个都可以有自己的类型
  //返回的类型是两个分支类型的公共超类型，这里是Any
  val r = if (x > 0) "positive" else -1
  println(r.getClass)
  
  //else部分缺失了，可能没有输出值。但在Scala中，每个表达式都应该有某个值，解决方案是引入一个Unit类，写作()
  //可以把()当是表示“无有用值”的占位符，当成void
  var b = if (x < 0) 1//=if(x>0) 1 else ()
  println(b)
  println(b.getClass)
  
  /**
   * 语句终止
   */
  
  //同行多条语句，中间使用分号隔开
  if (x > 0) {x * s; x -= 1}
  
  //较长的语句，要确保第一行以一个不能用作语句结束的符号结尾
  x = x + //加号告诉编译器这里不是语句的末尾
		  s;
  
  //
  
  /**
   * 块表达式和赋值
   * 
   */
  //{}块包含一系列表达式，结果也是也是一个表达式。块最后一个表达式的值就是块的值
  var y = 3
  val z = 4
  val x0, y0 = 0
  import scala.math._
  val distance = { val dx = z - x0; val dy = y - y0; sqrt(dx * dx + dy * dy)} //值是最后一个表达式值
  println(distance)
  
  //而赋值表达式的值是Unit，所以下面的表达式错误，是把Unit类型赋值给x
  //x = y = 1
  
  /**
   * 输入和输出
   */
  //格式化输出
  printf("hello, %s! you are %d years old.\n", "eric", 28)
  
  //数据读入
//  val name = readLine("your name: ")
//  print("your age: ")
//  val age = readInt()
//  printf("hello!, %s! next year, you will be %d.\n", name, age+1)
  
  /**
   * 循环
   */
  while (x > 0) {
    y = y * x
    x -= 1
  }
  //等价上面。<-表示让变量i遍历右边的表达式的所有值。其中i是集合元素类型，作用域一直持续到循环结束
  for (i <- 1 to x) {
    y *= x
  }
  
  val str = "Hello"
  var sum = 0
  for (i <- 0 until str.length) {//最后i的取值是s.length - 1 
    sum += str(i)
  }
  
  for (ch <- "Hello") sum += ch //当不需要下标的时候
  
  //scala中，对循环的使用并不如其他语言那么频繁，通常我们可以通过对序列中的所有值应用某个函数的方式来处理它们，只需要一次方法调用
  
  //scala中，并没有break和continue来退出循环，可以：
  //1.使用Boolean控制变量。2.使用嵌套函数，从函数中return。2.使用Breaks对象中的break方法
  import scala.util.control.Breaks._
  breakable {//通过抛出和捕获异常来实现
    for (ch <- "Hello") {
      if (ch == 'l') break;
    }
  }
  
  //for循环里的多个生成器，分号隔开
  for (i <- 1 to 3; j <- 1 to 3) print((10 * i + j) + " ")
  
  //每个生成器都可以带一个守卫，以if开头的表达式
  for (i <- 1 to 3; j <- 1 to 3 if i != j) print((10 * i + j) + " ")
  
  //可以使用任意多的定义，引入可以循环中使用的变量
  for (i <- 1 to 3; from = 4 - i; j <- from to 3) print("\r\n" + (10 * i + j) + " ")
  
  //如果for循环的循环体以yield开始，则该循环会构造出一个集合，每次迭代生成集合中那个的一个值
  //生成Vector(1, 2, 0, 1, 2, 0, 1, 2, 0, 1)
  println(for (i <- 1 to 10) yield i % 3)
  //这类循环叫做for推导式
  
  //for推导式生成的集合与它的第一个生成器是类型兼容的
  //HIeflmlmop
  println(for (c <- "Hello"; i <- 0 to 1) yield (c+i).toChar) 
  //Vector(H, e, l, l, o, I, f, m, m, p)
  println(for (i <- 0 to 1; c <- "Hello") yield (c+i).toChar)
  
  //也可包含在花括号里，并可以以换行的方式而不用分号来分隔
  for {
    i <- 1 to 3
    from = 4 - i
    j <- from to 3
  } print("\r\n" + (10 * i + j) + " ")
  
  /**
   * 函数
   * 方法对对象进行操作，而函数不是，java中使用静态方法来模拟
   */
  
  //需要指定参数的类型，但一般不需要指定返回值类型，除非是递归函数
  def abs(x: Double) = if (x>=0) x else -x
  
  //代码块中最后一个表达式的值就是函数的返回值。举例来说，下面的这个函数返回值位于for循环之后的r的值
  //不经常使用return
  def fac(n: Int) = {
    var r = 1
    for (i<-1 to n) r=r*i
    r
  }
  
  //递归函数，必须指定返回类型
  def fac2(n: Int): Int = if (n<=0) 1 else n*fac(n-1)
  
  //默认参数
  def decorate(str: String, left: String = "[", right: String = "]") = 
    left+str+right
  
  println(decorate("Hello"))
  println(decorate("Hello", "<<<["))
  println(decorate("Hello", "<<<", ">>>"))
  //可以指定参数名，顺序不需要一致
  println(decorate(left="<<<", str="Hello", right=">>>"))
  println(decorate("Hello", right="]<<<"))
  
  def sum(args: Int*) = {
    var result = 0
    for (arg <- args) result+=arg
    result
  }
  //变长参数，函数得到的是一个类型为Seq的参数
  var sumval = sum(1, 4, 9, 16, 25)
  println(sumval)
  
  //错误，会被当成单个参数
  //sumval = sum(1 to 5)
  
  //告诉编译器你希望这个参数被当作参数序列处理，追加:_*
  sumval = sum(1 to 5: _*)
  
  def recursiveSum(args: Int*): Int = {
    if (args.length == 0) 0
    else args.head+recursiveSum(args.tail:_*)
  }
  
  //调用变长参数且参数类型为Object的java方法，需要手工对基本类型进行转换
  val strval = MessageFormat.format("the answer to {0} is {1}", "everything", 42.asInstanceOf[AnyRef])
  
  /**
   * 过程
   * Scala对于不返回值的函数有特殊的表示法
   * 如果函数体包含在花括号里，但没有前面的=号，那么返回类型就是Unit。这样的函数称为过程
   */
  def box(s: String) { //没有=号
    var border = "-" * s.length+"--\n"
    println(border+ "|"+s+"|\n"+border)
  }
  
  box("Hello")
  
  /**
   * 懒值
   * val被声明为lazy时，它的初始化将被推迟，直到我们对它首次取值
   * 对于开销比较大的初始化语句十分有用
   */
  def testLazy = {
	  //可以把懒值看作是介于val和def的中间状态。
	  //被定义时即被取值
	  val words1 = scala.io.Source.fromFile("words.txt").mkString
	  	//在首次使用时候被取值
			  lazy val words2 = scala.io.Source.fromFile("words.txt").mkString
			  //在每一次被使用时取值
			  def words3 = scala.io.Source.fromFile("words.txt").mkString
  }
  
  /**
   * 异常
   * throw表达式的类型是Nothing，ifelse中，如果一个分支是Nothing，那么if表达式类型就是另一个分支的类型
   */
  val ifval = 5
  if (ifval > 0) {
    sqrt(x)
  } else throw new IllegalArgumentException("x should not be negative")
  
  //捕获异常使用的是模式匹配的语法
  val url = "http://www.baidu.com"
  try {
    new URL(url)
  } catch {
    //如果不需要使用捕获的异常对象，可以使用_来替代变量名
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
   * 练习P27
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