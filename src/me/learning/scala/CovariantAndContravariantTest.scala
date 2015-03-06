package me.learning.scala

object CovariantAndContravariantTest extends App {
  
  val s:AnyRef = "str"
  
  //list支持协变，所以能赋值成功
  //[+T], covariant (or “flexible”) in its type parameter T，类似Java中的(? extends T), 即可以用T和T的子类来替换T，里氏替换原则。
  //协变的符号是[+A]，意味着支持泛型A的子类集合向A进行赋值。
  var list:List[AnyRef] = List[String]("str1", "str2")
  
  //[T], invariant  in its type parameter T
  //MutableList是不变的
  
  //错误，不能这样赋值
  import scala.collection.mutable._  
  //val a : MutableList[AnyRef] = MutableList[String]("abc") 
  
  //[-T], contravariant, 类似(? supers T) 逆变
  //if T is a subtype of type S, this would imply that Queue[S] is a subtype of Queue[T] 只能用T的父类来替换T。是逆里氏替换原则。
  
  //对于OutputChannel[String], 支持的操作就是输出一个string, 
  //同样OutputChannel[AnyRef]也一定可以支持输出一个string, 因为它支持输出任意一个AnyRef(它要求的比OutputChannel[String]少) 。
  //但反过来就不行, OutputChannel[String]只能输出String, 显然不能替换OutputChannel[AnyRef]
  trait OutputChannel[-T]{ }
  
  
  
}