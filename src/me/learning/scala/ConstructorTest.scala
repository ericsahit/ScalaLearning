package me.learning.scala

object ConstructorTest extends App {
  println("Hello world")
  
  val p1 = new Person
  val p2 = new Person("fred")
  val p3 = new Person("fred", 20)
  
  val p4 = new Person2("eric", 28)
}

/**
 * ��������ֻ��һ�������������������ж��
 * ������������this�������壬���ඨ�彻֯��һ��
 * ���������û�в�������û����ʾ���������������Զ�ӵ��һ���޲ε�������������������������Ǽ򵥵�ִ�������е�����������
 * ���������������ֽ�this�������Ե�����������������һ��������������ʼ
 */
class Person {//ʹ��Ĭ������������һ����
	private var name = ""
    private var age = 0
    
    def this(name: String) { //һ������������
	  this()//������������
	  this.name = name
	}
	
	def this(name: String, age: Int) {//��һ������������
	  this(name) //����ǰһ������������
	  this.age = age
	}
}

class Person2(val name: String, val age:Int) {
  //���������Ĳ�����������ֶΣ���ʼ��Ϊ����ʱ����Ĳ���
  //����������ִ���ඨ���е��������
  println("Just constructed another person")
  def description = name + " is " + age + " years old"
}

//ʹ��Ĭ�ϲ���������ʹ�ù���ĸ�����������
//�������Ĳ�������ʹ��������̬
class Person3(val name: String = "", private var age: Int = 0){}

//�������Ҳ��������ͨ�ķ�������������val��var
//������ٱ�һ������ʹ�ã�����������Ϊ�ֶΣ����򲻱�����Ϊ�ֶ�
class Person4(name: String, age: Int){
  //name��age����ʼ��Ϊ���ɱ���ֶΣ����Ƕ���˽�У���ͬ��private[this] val
  def description = name + " is " + age + " years old"
}

//�������������˽�У���������ͨ������������������Person����
class Person5 private(val id: Int) {}


