package me.learning.scala

object CovariantAndContravariantTest extends App {
  
  val s:AnyRef = "str"
  
  //list֧��Э�䣬�����ܸ�ֵ�ɹ�
  //[+T], covariant (or ��flexible��) in its type parameter T������Java�е�(? extends T), ��������T��T���������滻T�������滻ԭ��
  //Э��ķ�����[+A]����ζ��֧�ַ���A�����༯����A���и�ֵ��
  var list:List[AnyRef] = List[String]("str1", "str2")
  
  //[T], invariant  in its type parameter T
  //MutableList�ǲ����
  
  //���󣬲���������ֵ
  import scala.collection.mutable._  
  //val a : MutableList[AnyRef] = MutableList[String]("abc") 
  
  //[-T], contravariant, ����(? supers T) ���
  //if T is a subtype of type S, this would imply that Queue[S] is a subtype of Queue[T] ֻ����T�ĸ������滻T�����������滻ԭ��
  
  //����OutputChannel[String], ֧�ֵĲ����������һ��string, 
  //ͬ��OutputChannel[AnyRef]Ҳһ������֧�����һ��string, ��Ϊ��֧���������һ��AnyRef(��Ҫ��ı�OutputChannel[String]��) ��
  //���������Ͳ���, OutputChannel[String]ֻ�����String, ��Ȼ�����滻OutputChannel[AnyRef]
  trait OutputChannel[-T]{ }
  
  
  
}