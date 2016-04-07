//learn from: http://www.runoob.com/java/java-files-io.html

1. 控制台输入字符
import java.io.*;

public class BBREAD {
   public static void main(String args[]) throws IOException
   {
      char c;
      // 使用 System.in 创建 BufferedReader 
      BufferedReader br = new BufferedReader(new 
                         InputStreamReader(System.in));
      System.out.println("Enter characters, 'q' to quit.");
      // 读取字符
      do {
         c = (char) br.read();
         System.out.println(c);
      } while(c != 'q');
   }
}


----
Enter characters, 'q' to quit.


2. 控制台输入字符串
import java.io.*;

public class BBREAD {
	public static void main(String args[]) throws IOException
	   {
	      // 使用 System.in 创建 BufferedReader 
	      BufferedReader br = new BufferedReader(new
	                              InputStreamReader(System.in));
	      String str;
	      System.out.println("Enter lines of text.");
	      System.out.println("Enter 'end' to quit.");
	      do {
	         str = br.readLine();
	         System.out.println(str);
	      } while(!str.equals("end"));
	   }
}

---
Enter lines of text.
Enter 'end' to quit.

