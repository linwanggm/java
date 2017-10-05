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

3.System.getproperties

/*
* ShowProperties.java
*/

public class ShowProperties
{
    public static void main(String[] args)
    {
        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.path"));
    }
}

结果输出：
-- listing properties --
java.runtime.name=OpenJDK Runtime Environment
sun.boot.library.path=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0...
java.vm.version=25.131-b12
java.vm.vendor=Oracle Corporation
java.vendor.url=http://java.oracle.com/
path.separator=:
java.vm.name=OpenJDK 64-Bit Server VM
file.encoding.pkg=sun.io
user.country=US
sun.java.launcher=SUN_STANDARD
sun.os.patch.level=unknown
java.vm.specification.name=Java Virtual Machine Specification
user.dir=/home/wln/java/1005
java.runtime.version=1.8.0_131-b12
java.awt.graphicsenv=sun.awt.X11GraphicsEnvironment
java.endorsed.dirs=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0...
os.arch=amd64
java.io.tmpdir=/tmp
line.separator=

java.vm.specification.vendor=Oracle Corporation
os.name=Linux
sun.jnu.encoding=ANSI_X3.4-1968
java.library.path=/home/wln/pg/installpg962/lib::/usr/j...
java.specification.name=Java Platform API Specification
java.class.version=52.0
sun.management.compiler=HotSpot 64-Bit Tiered Compilers
os.version=3.10.0-327.36.3.el7.x86_64
user.home=/home/wln
user.timezone=
java.awt.printerjob=sun.print.PSPrinterJob
file.encoding=ANSI_X3.4-1968
java.specification.version=1.8
user.name=wln
java.class.path=.
java.vm.specification.version=1.8
sun.arch.data.model=64
java.home=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0...
sun.java.command=ShowProperties
java.specification.vendor=Oracle Corporation
user.language=en
awt.toolkit=sun.awt.X11.XToolkit
java.vm.info=mixed mode
java.version=1.8.0_131
java.ext.dirs=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0...
sun.boot.class.path=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0...
java.vendor=Oracle Corporation
file.separator=/
java.vendor.url.bug=http://bugreport.sun.com/bugreport/
sun.cpu.endian=little
sun.io.unicode.encoding=UnicodeLittle
sun.cpu.isalist=
wln
/home/wln/pg/installpg962/lib::/usr/java/packages/lib/amd64:/usr/lib64:/lib64:/lib:/usr/lib

参考：
http://www.cnblogs.com/sigh-differ/archive/2012/12/25/java-system-getproperty.html

/*
* SystemProperties.java
*/

import java.util.Properties;  
import java.util.Set; 

public class SystemProperties
{
    public static void main(String[] args)
    {
             
        Properties prop = System.getProperties();  
        Set<Object> keySet = prop.keySet();  
        for(Object obj : keySet)
        {  
            System.out.println(obj.toString()+"="+System.getProperty(obj.toString()));  
 
        }
    }

}




