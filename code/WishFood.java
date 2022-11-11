
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
public class WishFood extends CartFood
{
    
    private int basePrice;
    void setPrice(int newPrice)
    {
        basePrice=newPrice;
    }
    
    int getPrice()
    {
        return basePrice;
    }
    
    
    //add to Wish List
    void addToCart() throws Exception
     {
        
        java.util.Scanner sc=new java.util.Scanner(System.in);
        
        System.out.println("Addding Items to the Wish List:");
        System.out.println("________________________________________");
        //int total=0;
        int opt =1;
        while(opt !=0)
        {
            System.out.println("Enter the uID from the Menu Table to add");
            opt = sc.nextInt();
            System.out.println("Enter the Quantity of the item:");
            String restdb;
            String itemdb;
            int pricedb;
            int quantitydb=sc.nextInt();
            
            GetRestData g=new GetRestData();
            restdb=g.nameData(opt);           
            itemdb=g.itemData(opt);
            pricedb=g.priceData(opt);
            int temp=(pricedb)*(quantitydb);
            //total=total+temp;
            System.out.println("Restaurent Name:"+restdb);
            System.out.println("Food Item:"+itemdb);
            System.out.println("Price:"+pricedb);
            System.out.println("Quantity:"+quantitydb);
            int tempPrice=pricedb*quantitydb;
            System.out.println("Total :"+tempPrice);
            
            
            String url="jdbc:mysql://localhost:3306/fooddb";
            String uname="root";//user
            String password="12345";//password
            
            String sqlQuery = " insert into wishList(id,restName, item, price, quantity)" + " values (?,?, ?, ?, ?)";
            
                try
                {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection(url,uname,password);  
                PreparedStatement preparedStmt = con.prepareStatement(sqlQuery);
                preparedStmt.setInt (1,opt);
                preparedStmt.setString (2,restdb);
                preparedStmt.setString (3,itemdb);
                preparedStmt.setInt (4,pricedb);
                preparedStmt.setInt (5,quantitydb);
                preparedStmt.execute();

                con.close();
                 }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                System.out.println("Do you want to add more Food items to the Cart:\n"+
                        "1. Yes\n"+
                        "2. No\n");
                int choice = sc.nextInt();
                if(choice==1)
                {
                  opt=1;   
                }
                else
                {
                  opt=0;  
                }
        }
           
    }
    
    //view Wish
    void viewCart() throws Exception
    {

        String url="jdbc:mysql://localhost:3306/fooddb";
        String uname="root";//user
        String password="12345";//password
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =DriverManager.getConnection(url, uname, password);
         
 
        Statement stmt=con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from wishList");
        System.out.println("id\tRestName\titemName\tprice\tquantity\t Total");
        System.out.println("__________________________________________________________________________");
        while(rs.next())
        {
        int pr=rs.getInt(4);
        int qty=rs.getInt(5);
        int tp=pr*qty;
        System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5)+"\t"+tp); 
        }
        con.close();
        
    }
    
        void discardCart() throws Exception
    {

        String url="jdbc:mysql://localhost:3306/fooddb";
        String uname="root";//user
        String password="12345";//password
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =DriverManager.getConnection(url, uname, password);
        String sql="DELETE FROM wishList"; 
        
        Statement stmt=con.createStatement();  
        stmt.executeUpdate(sql);
        
      /*  String QueryCheck="select * from cartList";
        ResultSet rs=stmt.executeQuery(QueryCheck);
        System.out.println("id\tRestName\titemName\tprice\tquantity");
        System.out.println("__________________________________________________________________________");
        while(rs.next())  
        System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5));   */
        con.close();
        
    }
    
    int priceCalculation() throws Exception
            
    {

        String url="jdbc:mysql://localhost:3306/fooddb";
        String uname="root";//user
        String password="12345";//password
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =DriverManager.getConnection(url, uname, password);
         
 
        Statement stmt=con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from wishList");
        int total=0;
        
        System.out.println("itemName\tprice\tquantity\tTotal");
        System.out.println("__________________________________________________________________________");
        while(rs.next())  
        {        
        int price=rs.getInt(4);
        int quantity=rs.getInt(5);
        int temp=price*quantity;
        total=total+temp;
        System.out.println(rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5)+"\t"+temp);

 
        }
        con.close();
        setPrice(total);
       return getPrice(); 
    }
    
    
    int restid() throws Exception
            
    {

        String url="jdbc:mysql://localhost:3306/fooddb";
        String uname="root";//user
        String password="12345";//password
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =DriverManager.getConnection(url, uname, password);
         
 
        Statement stmt=con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from wishList");
        String restName="";
        while(rs.next())  
        {
        restName=rs.getString(2);
        }
        con.close();
        
        int rid=getid(restName);
        return rid;
       
    }
    
    
    int getid(String restName) throws Exception
            
    {

        String url="jdbc:mysql://localhost:3306/fooddb";
        String uname="root";//user
        String password="12345";//password
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =DriverManager.getConnection(url, uname, password);
        String sql="SELECT * FROM Reslogin WHERE RestName='"+restName+ "'";
        Statement stmt=con.createStatement();  
        ResultSet rs=stmt.executeQuery(sql);
        int rid=0;
        while(rs.next())  
        {
        rid=rs.getInt(1);
        }
        con.close();
        
        return rid; 
    }
    
}