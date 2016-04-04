1. HellWorld
// my first program for java
// platforms: Eclipse
//filename: HelloWorld.java

public class HelloWorld 
{

	public static void main(String[] args) 
	{
		System.out.println("hello world,JAVA.");
	}

}

---
hello world,JAVA.

------
1. java注释同C++/C一样，"//" 和"/**/"都可以。
2. class名字同文件名同名
3. 该程序从public static void main(String[] args)开始执行。


2. enum
/*
*/
package javaExample;

public class javaExample {
	enum fruit {apple,orange,banana}
	static fruit f1=fruit.orange;
	public static void main(String[] args)
	{
		System.out.println(f1);
		System.out.println(f1.getClass().toString());  //get the type of var
	};
}

---
orange
class javaExample.javaExample$fruit




