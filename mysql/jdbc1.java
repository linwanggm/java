下面代码code1在mysql 5.1 windows环境测试，插入的数据通过select 查看 各个列的值均为NULL，感觉这个地方prepareStatement 使用上有问题，待分析。
:: 原因为String sql = "INSERT INTO  student(ID,age,name,FM) values(ID=?, age=?, name=?, FM=?)";  需要修改为
   String sql = "INSERT INTO  student(ID,age,name,FM) values(?, ?, ?, ?)"; 

而code2则没问题可以正常执行。


// code 1
import java.lang.Class;  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.Statement;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
public class MySQLTest{  
    public static void main(String [] args){          
      
        String[] ID = { "2008", "2009", "2008", "2012", "2015", "2015"};  
		int[] age = { 16, 18, 20, 18, 22, 21 }; 
        String[] name = { "Wang", "Hui", "Wan", "Yuan", "Yuan", "Yang"};  
        String[] FM = {"F", "F", "M", "M", "M", "F"};  
        String url = "jdbc:mysql://localhost:3306/testdb";  
        String username = "testuser";  
        String password = "testuser123";  
          
        String sql = "INSERT INTO  student(ID,age,name,FM) values(ID=?, age=?, name=?, FM=?)";  //need modify to : values(?,?,?,?)
        String querysql = "SELECT * FROM  student WHERE name LIKE 'a';";  
          
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
        }catch(ClassNotFoundException e)  
        {  
            System.out.println("JDBC LOAD DRIVE fail");  
            e.printStackTrace();  
        }  
          
        try{              
            Connection con = DriverManager.getConnection(url,username,password); //MySQL connect object        
            Statement stmt = con.createStatement();  
            PreparedStatement prest = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);  
	    //PreparedStatement prest = con.prepareStatement(sql);  
            for(int i=0; i < ID.length; i++){  
                prest.setString(1, ID[i]);  
                prest.setInt(2, age[i]);  
				prest.setString(3, name[i]);  
                prest.setString(4,FM[i]);  
                prest.addBatch();  
				 
            }  
              
            prest.executeBatch();  
            ResultSet rs = stmt.executeQuery(querysql);  
            while(rs.next()){  
                String qname = rs.getString("name");  
                String qage = rs.getString(3);  
                System.out.println(qname +  "\t" + qage);  
            }  
              
            //int rows = stmt.executeUpdate("DELETE FROM  student;");  
            //System.out.println(rows);  
            if(rs != null){  
                rs.close();  
            }  
            if(stmt != null){  
                stmt.close();  
            }  
            if(con != null){  
                con.close();  
            }             
        }catch(SQLException e){  
            e.printStackTrace();  
        }         
    }     
}  





//code2

import java.lang.Class;  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.Statement;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
public class MySQLTest{  
    public static void main(String [] args){          
      
   try {  
             
            Class.forName("com.mysql.jdbc.Driver");  
              
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","testuser","testuser123");  
             
            Statement state=con.createStatement();  
             
            String sql="insert into student values('id01', 1, 'aaa1', 'f')";  
            state.executeUpdate(sql);  
              
            String sql1="update student set ID='id001' where name='aaa1'";  
             state.executeUpdate(sql1);  
             
            String sql3="update student set NAME='aaa01' where ID='id001'";  
            state.executeUpdate(sql3);  
            
            //String sql2="select stuID,stuName from student where stuID='001'";  
              
            String sql2="select * from student";  
            ResultSet rs=state.executeQuery(sql2);  
            while(rs.next()){  
                String uID=rs.getString("ID");  
                String uName=rs.getString("name");  
                  
                System.out.println("stuID:"+uID+"  "+"stuName:"+uName );  
            }
			rs.close();
            System.out.println("Operator success...");  
            state.close();  
            con.close();  
              
        } catch (Exception e) {   
            e.printStackTrace();  
        }  
    }     
}  

