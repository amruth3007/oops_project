package com.mycompany.fooddelivery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author HAREESH
 */
public class Ulogin extends Login
{
    private int useID;
    int getUID()
    {
        return useID;
    }
    
    void setUID(int newuID)
    {
       useID=newuID; 
    }
    
    Ulogin()
    {
       int uid=useID; 
    }
    
    void uloginDetails() throws Exception
    {
        String url="jdbc:mysql://localhost:3306/fooddb";
        String uname="root";//user
        String password="12345";//password
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =DriverManager.getConnection(url, uname, password);
        Class.forName("com.mysql.jdbc.Driver");  
 
        Statement stmt=con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from userlogin");  
        while(rs.next())
        {
        System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)); 
        }
        con.close();  
    }
    
     
    public boolean usercheck(String email,String pwd) throws Exception
    {
         boolean login=false;     
         String sql="SELECT * FROM userlogin WHERE mail='"+email+ "'";  
         String url="jdbc:mysql://localhost:3306/fooddb";
         String userMysql="root";
         String pwdMysql="12345";
         String dbPwd; 
         String dbmail; 
         int dbUID;

        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,userMysql,pwdMysql);  
        Statement stmt=con.createStatement(); 
        ResultSet rs=stmt.executeQuery(sql);


        while(rs.next())
        {
            dbUID=rs.getInt("userID");
            setUID(dbUID);
            dbmail=rs.getString("mail");
            dbPwd=rs.getString("password");
            if(dbmail.equals(email)&&dbPwd.equals(pwd))
                {                      
                    login=true;
                }
        }
        con.close(); 
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return login;
        
    }        

    void regUser(int uid, String uname, String pwd, String phone, String mail) 
    {   
         String sqlQuery = " insert into userlogin(userID, username, password, phone, mail)"
        + " values (?, ?, ?, ?, ?)";
         String url="jdbc:mysql://localhost:3306/fooddb";
         String userMysql="root";
         String pwdMysql="12345";
         String dbPwd; 
         int dbUser;

        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,userMysql,pwdMysql);  
        //Statement stmt=con.createStatement();         
        
    
        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = con.prepareStatement(sqlQuery);
        preparedStmt.setInt (1,uid);
        preparedStmt.setString (2,uname);
        preparedStmt.setString (3,pwd);
        preparedStmt.setString (4,phone);
        preparedStmt.setString (5,mail);
        preparedStmt.execute();

        con.close();
          }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    void coupon(int uid) 
    {   
         String sqlQuery = " insert into coupon(userID,c50,c20)"
        + " values (?, ?, ?)";
         String url="jdbc:mysql://localhost:3306/fooddb";
         String userMysql="root";
         String pwdMysql="12345";
 

        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,userMysql,pwdMysql);  
        //Statement stmt=con.createStatement();         
        
    
        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = con.prepareStatement(sqlQuery);
        preparedStmt.setInt (1,uid);
        preparedStmt.setInt (2,1);
        preparedStmt.setInt (3,1);

        preparedStmt.execute();

        con.close();
          }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
        boolean couponCheck(int uid,int cp) 
     {   
         
         boolean check=false;     
         String sql="SELECT * FROM coupon WHERE userID='"+uid+ "'";
         
 
         String url="jdbc:mysql://localhost:3306/fooddb";
         String userMysql="root";
         String pwdMysql="12345";


        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,userMysql,pwdMysql);  
        //Statement stmt=con.createStatement();          
        Statement stmt=con.createStatement(); 
        ResultSet rs=stmt.executeQuery(sql);
        int c1=0;
        int c2=0;
    
         while(rs.next())
         {
            c1=rs.getInt(2);//save 50 coupon
            c2=rs.getInt(3);//save 20 coupon
            
         }
         
         if(cp==1)
         {
             if(c1==1)
             {
                 check=true; 
             }
         }
         
         if(cp==2)
         {
             if(c2==1)
             {
                 check=true; 
             }
         }

        con.close();
          }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return check;
    }
        
        
    void couponUpdate(int uid,int cp) 
     {   
        
         int dec=0; //coupon decrease
         String sql="update coupon set c50='"+dec+"' WHERE userID='"+uid+ "'";
         
         if(cp==1)//coupon1 50
         {
         sql="update coupon set c50='"+dec+"' WHERE userID='"+uid+ "'";
         }
         
         if(cp==2)//coupon1 50
         {
         sql="update coupon set c20='"+dec+"' WHERE userID='"+uid+ "'";
         }
 
         String url="jdbc:mysql://localhost:3306/fooddb";
         String userMysql="root";
         String pwdMysql="12345";


        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,userMysql,pwdMysql);  
        //Statement stmt=con.createStatement();          
        Statement stmt=con.createStatement(); 
        
        stmt.executeUpdate(sql);

        

        con.close();
          }
        catch(Exception e)
        {
            System.out.println(e);
        }
      
    }
}
