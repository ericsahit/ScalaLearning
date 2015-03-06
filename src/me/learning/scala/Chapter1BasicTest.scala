package me.learning.scala

object BasicTest extends App {
	  
	/**
	 * 
	 * ��������
	 * 
	 */
  
  //1Ҳ�Ƕ��󣬲���Ҫ��װ���͡�
  //�ڻ������ͺͰ�װ����֮���ת����Scala�������Ĺ���
  println(1.toString())
  
  //val arr = Int[](1,2,3)
  
  //����Range����
  println(1.to(10))
  
  //Scala�õײ��java.lang.String����ʾ�ַ�����������ͨ��StringOps����ַ���׷�����ϰ��ֵĲ���
  //Hello����ʽ��ת��Ϊһ��StringOps���󣬽���StringOps���intersect������
  //��ʽת����implicit def augmentString(x: String): StringOps = new StringOps(x)
  println("Hello".intersect("World"))
  
//  Scala���ṩRichInt��RichDouble��RichChar���࣬ǰ���to��������RichInt��ķ�����Ҳ����ʽת��
  
  //ʹ�÷���������ǿ��ת����������ת��
  99.44.toInt
  99.toChar
  "99.44".toDouble
  
  1 to 10// =1.to(10)
  
  1 + 2//=1.+(2)
  
  //Scalaû���ṩ++��--��ֻ��ʹ��+=����Ϊ��Scala��Int��Ҳ�ǲ��ɱ�ģ�������ʵ������������ı�ĳ���������͵�ֵ
  
//  BigInt��BigDecimal����
  val x: BigInt = 1234567890
  println(x * x * x)
  
  /**
   * 
   * ���ú����ͷ���
   * 
   */
  
  //Scala�ṩ�����ͺ�������������Ҫ��ĳ����������ľ�̬����
  import scala.math._ //Scala�У�_��ͨ�����������Java�е�*
  println(sqrt(2))
  println(pow(2, 4))
  println(min(3, Pi))
  
  //Scala��û�о�̬�������������и����Ƶ����ԣ��е�������ͨ��һ�����Ӧһ�����������䷽���͸�Java�еľ�̬����һ��
  println(BigInt.probablePrime(100, scala.util.Random))
  
  //����������scala����ͨ����ʹ��Բ���š�һ�㣬û�в����Ҳ��ı䵱ǰ����ķ�������Բ����
  println("Hello".distinct)
  
  /**
   * 
   * apply����
   */
  
  //ʵ��ʹ��StringOps���def apply(n: Int): Char
  println("Hello"(4))
  println("Hello".apply(4))//ͬ��
  
  BigInt("1234567890")//=BigInt.apply("1234567890")
  BigInt("1234567890") * BigInt("1234567890")
  Array(1, 4, 9)
  
  //����������Ϊ��������
  println("HellsoiUing".count(_.isUpper))
  
  val myString = new MyStringOps("Hello")
  println(myString * 3)
  println(myString.count(_.isLetter))
  
    /**
   * ��ϰP11
   */
  println("crazy" * 3)
  println(10 max 2)
  println(BigInt(2) pow 1024)
  
  println(BigInt(scala.util.Random.nextInt).toString(36))
  
  "Hello"(0)//���Ч
  "Hello".take(1)//���̱Ƚϸ���
  
  "Hello".last//���Ч
  "Hello".reverse.take(1)
  "Hello".takeRight(1)
  
}

class MyStringOps(val repr: String) {
  
  //����StringOpts��*��ʵ��
  def *(n: Int): String = {
    val buf = new StringBuilder
    for (i <- 0 until n) buf append repr
    buf.toString
  }
  
  //����StringOps��countʵ��
  def count(p: (Char) => Boolean) : Int = {
    var cnt = 0
    for (x <- repr) {
      if (p(x)) cnt += 1
    }
    cnt
  }
}