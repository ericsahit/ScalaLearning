package me.learning.scala

object BasicTest extends App {
	  
	/**
	 * 
	 * 常用类型
	 * 
	 */
  
  //1也是对象，不需要包装类型。
  //在基本类型和包装类型之间的转换是Scala编译器的工作
  println(1.toString())
  
  //val arr = Int[](1,2,3)
  
  //产生Range对象
  println(1.to(10))
  
  //Scala用底层的java.lang.String来表示字符串，不过它通过StringOps类给字符串追加了上百种的操作
  //Hello被隐式地转换为一个StringOps对象，接着StringOps类的intersect被调用
  //隐式转换：implicit def augmentString(x: String): StringOps = new StringOps(x)
  println("Hello".intersect("World"))
  
//  Scala还提供RichInt、RichDouble、RichChar等类，前面的to方法就是RichInt类的方法，也是隐式转换
  
  //使用方法而不是强制转换来做类型转换
  99.44.toInt
  99.toChar
  "99.44".toDouble
  
  1 to 10// =1.to(10)
  
  1 + 2//=1.+(2)
  
  //Scala没有提供++和--，只能使用+=；因为在Scala中Int类也是不可变的，并不能实现这个方法来改变某个整数类型的值
  
//  BigInt和BigDecimal对象
  val x: BigInt = 1234567890
  println(x * x * x)
  
  /**
   * 
   * 调用函数和方法
   * 
   */
  
  //Scala提供方法和函数，函数则不需要从某个类调用它的静态方法
  import scala.math._ //Scala中，_是通配符，类似于Java中的*
  println(sqrt(2))
  println(pow(2, 4))
  println(min(3, Pi))
  
  //Scala中没有静态方法，不够它有个类似的特性，叫单例对象。通常一个类对应一个伴生对象，其方法就跟Java中的静态方法一样
  println(BigInt.probablePrime(100, scala.util.Random))
  
  //不带参数的scala方法通常不使用圆括号。一般，没有参数且不改变当前对象的方法不带圆括号
  println("Hello".distinct)
  
  /**
   * 
   * apply方法
   */
  
  //实际使用StringOps类的def apply(n: Int): Char
  println("Hello"(4))
  println("Hello".apply(4))//同上
  
  BigInt("1234567890")//=BigInt.apply("1234567890")
  BigInt("1234567890") * BigInt("1234567890")
  Array(1, 4, 9)
  
  //方法可以作为参数传递
  println("HellsoiUing".count(_.isUpper))
  
  val myString = new MyStringOps("Hello")
  println(myString * 3)
  println(myString.count(_.isLetter))
  
    /**
   * 练习P11
   */
  println("crazy" * 3)
  println(10 max 2)
  println(BigInt(2) pow 1024)
  
  println(BigInt(scala.util.Random.nextInt).toString(36))
  
  "Hello"(0)//最高效
  "Hello".take(1)//过程比较复杂
  
  "Hello".last//最高效
  "Hello".reverse.take(1)
  "Hello".takeRight(1)
  
}

class MyStringOps(val repr: String) {
  
  //类似StringOpts的*的实现
  def *(n: Int): String = {
    val buf = new StringBuilder
    for (i <- 0 until n) buf append repr
    buf.toString
  }
  
  //类似StringOps的count实现
  def count(p: (Char) => Boolean) : Int = {
    var cnt = 0
    for (x <- repr) {
      if (p(x)) cnt += 1
    }
    cnt
  }
}