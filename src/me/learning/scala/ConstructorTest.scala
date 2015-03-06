package me.learning.scala

object ConstructorTest extends App {
  println("Hello world")
  
  val p1 = new Person
  val p2 = new Person("fred")
  val p3 = new Person("fred", 20)
  
  val p4 = new Person2("eric", 28)
}

/**
 * 主构造器只有一个，辅助构造器可以有多个
 * 主构造器不以this方法定义，与类定义交织在一起
 * 如果类名后没有参数，则没有显示定义主构造器，自动拥有一个无参的主构造器，这个构造器仅仅是简单的执行类体中的所有语句而已
 * 辅助构造器的名字叫this，必须以调用主构造器或者另一个辅助构造器开始
 */
class Person {//使用默认主构造器的一个类
	private var name = ""
    private var age = 0
    
    def this(name: String) { //一个辅助构造器
	  this()//调用主构造器
	  this.name = name
	}
	
	def this(name: String, age: Int) {//另一个辅助构造器
	  this(name) //调用前一个辅助构造器
	  this.age = age
	}
}

class Person2(val name: String, val age:Int) {
  //主构造器的参数被编译成字段，初始化为构造时传入的参数
  //主构造器会执行类定义中的所有语句
  println("Just constructed another person")
  def description = name + " is " + age + " years old"
}

//使用默认参数来避免使用过多的附辅助构造器
//构造器的参数可以使用任意形态
class Person3(val name: String = "", private var age: Int = 0){}

//构造参数也可以是普通的方法参数，不带val或var
//如果至少被一个方法使用，它将被提升为字段；否则不被保存为字段
class Person4(name: String, age: Int){
  //name和age被初始化为不可变的字段，都是对象私有，等同于private[this] val
  def description = name + " is " + age + " years old"
}

//让主构造器变成私有，这样必须通过辅助构造器来构造Person对象
class Person5 private(val id: Int) {}


