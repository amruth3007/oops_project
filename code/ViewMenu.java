
package com.mycompany.fooddelivery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ViewMenu extends DistanceCal
        
{  

    void menu() throws Exception
    {
 
        String url="jdbc:mysql://localhost:3306/fooddb";
        String uname="root";//user
        String password="12345";//password
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =DriverManager.getConnection(url, uname, password);
           
        Class.forName("com.mysql.jdbc.Driver");
           
 
        Statement stmt=con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from menuTotal");
        
        System.out.println(" uID  RestID   RestName   itemID   itemName    price   quantity  Distance(kms)  Duration(min)");
        System.out.println("_________________________________________________________________");
        
        while(rs.next()) 
        {
          int  rid=rs.getInt(2);
          int dist=(int) distance(rid);
          int time=(int) (dist*1.5); //40 kms per hr
        System.out.println(rs.getInt(1)+"\t"+rs.getInt(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t\t"+rs.getString(5)+"\t"
                                              +rs.getInt(6)+"\t"+rs.getString(7)+"\t"+dist+"\t"+time);  
        }
        con.close();  
    
    }
    
    
}
