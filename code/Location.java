
package com.mycompany.fooddelivery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author HAREESH
 */
public class Location 
{
    private double lat_confirm;
    private double lon_confirm;
    
    void setLatitude(double newLat)
    {
       lat_confirm=newLat; 
    }
    
    void setLongitude(double newLon)
    {
       lon_confirm=newLon; 
    }
            
    double getLatitude()
    {
        return lat_confirm;
    }
    double getLongitude()
    {
        return lon_confirm;
    }
    void delAddress() throws Exception
    {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Current Location:");
        System.out.println("No.201,Dwarak Sector-3.Delhi");
        System.out.println("\n");
        System.out.println("Saved Addresses:");
        System.out.println("\n");
        viewLocations();
        System.out.println("\n");
        System.out.println("Choose option:\n"+
                    "1. Confirm the Delivery Address of Current Location \n"+
                    "2. Select from Saved Addresses\n"+
                    "3. Add New Address");
        
         int choice = sc.nextInt();
         if(choice==1)
         {
             double lat=28.607800;
             double lon=77.040600;
             
             setLatitude(lat);
             setLongitude(lon);
             
         }
         else if(choice==2)
         {
            System.out.println("Choose  Address ID for the current Delivery:"); 
            int addID=sc.nextInt();

            
                String url="jdbc:mysql://localhost:3306/fooddb";
                String uname="root";//user
                String password="12345";//password
                Class.forName("com.mysql.jdbc.Driver");
                Connection con =DriverManager.getConnection(url, uname, password);
                
                Statement stmt=con.createStatement();

                ResultSet rs=stmt.executeQuery("select * from userAddress WHERE addressID='"+addID+ "'");
                while(rs.next())
                {
                    double lat=rs.getFloat(3);
                    double lon=rs.getFloat(4);
                    setLatitude(lat);
                    setLongitude(lon);
               }

            
         }
         else
         {
              System.out.println("Enter Address ID:"); 
              int addID=sc.nextInt();
              System.out.println("Enter Address:"); 
              String add=sc.next();
              System.out.println("Enter Latitude(xx.xxxxxx):"); 
              Float lat=sc.nextFloat();
              System.out.println("Enter Longitude(xx.xxxxxx):"); 
              Float lon=sc.nextFloat();
              
                String url="jdbc:mysql://localhost:3306/fooddb";
                String uname="root";//user
                String password="12345";//password
                Class.forName("com.mysql.jdbc.Driver");
                Connection con =DriverManager.getConnection(url, uname, password);
                
                String sqlQuery = " insert into userAddress(addressID,userAddress,latitude,longitude)" + " values (?,?,?,?)";  
                PreparedStatement preparedStmt = con.prepareStatement(sqlQuery);
                preparedStmt.setInt (1,addID);
                preparedStmt.setString (1,add);
                preparedStmt.setFloat (2,lat);
                preparedStmt.setFloat (3,lon);
                
             con.close();
              
             setLatitude(lat);
             setLongitude(lon);
         }   
    }
    
    void viewLocations() throws Exception
    {

                String url="jdbc:mysql://localhost:3306/fooddb";
                String uname="root";//user
                String password="12345";//password
                Class.forName("com.mysql.jdbc.Driver");
                Connection con =DriverManager.getConnection(url, uname, password);
                
                Statement stmt=con.createStatement();

                ResultSet rs=stmt.executeQuery("select * from userAddress");
                System.out.println("AddressID  Address          Latitude  Longitude");
                System.out.println("_________________________________________________");
                while(rs.next()) 
                {
                  System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getFloat(4));         
                }

             con.close();       
    }
    
    
}
