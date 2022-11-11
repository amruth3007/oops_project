
package com.mycompany.fooddelivery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class GetRestData
{
    
    private String restName;
    private String food;
    private int price;
    
    void setRestName(String newName)
    {
        restName=newName;
    }
    
    String getRestName()
    {
        return restName;
    } 
    
    void setFoodName(String newFood)
    {
        food=newFood;
    }
    
    String getFoodName()
    {
        return food;
    }
    
    void setFoodPrice(int newPrice)
    {
        price=newPrice;
    }
    
    int getFoodPrice()
    {
        return price;
    }
            
            
            
    String nameData(int uID) throws Exception
    { 

                
        String url="jdbc:mysql://localhost:3306/fooddb";
        String uname="root";//user
        String password="12345";//password
        String sql="SELECT * FROM menuTotal WHERE uID='"+uID+ "'"; 
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =DriverManager.getConnection(url, uname, password);
        Statement stmt=con.createStatement(); 
        ResultSet rs=stmt.executeQuery(sql);
        String res="";
        while(rs.next())
        {
        res=rs.getString("RestName");
        setRestName(res);
        }
        con.close();
        return getRestName();
        
    }
    
    String itemData(int uID) throws Exception
    {
        String url="jdbc:mysql://localhost:3306/fooddb";
        String uname="root";//user
        String password="12345";//password
        String sql="SELECT * FROM menuTotal WHERE uID='"+uID+ "'"; 
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =DriverManager.getConnection(url, uname, password);
        Statement stmt=con.createStatement(); 
        ResultSet rs=stmt.executeQuery(sql);
        String res="";
        while(rs.next())
        {
        res=rs.getString("itemName");
        setFoodName(res);
        }
        con.close();
        return getFoodName();
         
    }
    
    int priceData(int uID) throws Exception
    {
        String url="jdbc:mysql://localhost:3306/fooddb";
        String uname="root";//user
        String password="12345";//password
        String sql="SELECT * FROM menuTotal WHERE uID='"+uID+ "'"; 
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =DriverManager.getConnection(url, uname, password);
        Statement stmt=con.createStatement(); 
        ResultSet rs=stmt.executeQuery(sql);
        int res=0;
        while(rs.next())
        {
        res=rs.getInt("price");
        setFoodPrice(res);
        }
        con.close();
        return getFoodPrice();    
    }
}
