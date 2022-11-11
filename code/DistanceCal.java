
package com.mycompany.fooddelivery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author HAREESH
 */
public class DistanceCal extends DCal
{
    
    private double distance;
    
    double getDistance()
    {
        return distance;
    }
    void setDistance(double newDist)
    {
       distance=newDist; 
    }
    
   void distCal() throws Exception
    {
        String url="jdbc:mysql://localhost:3306/fooddb";
        String uname="root";//user
        String password="12345";//password
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =DriverManager.getConnection(url, uname, password);
        Statement stmt=con.createStatement();
        //System.out.println("Restaurents and their distances:");
        ResultSet rs=stmt.executeQuery("select * from restAddress");
        System.out.println("RestID   RestAddress   Distance(kms)  Duration(min)");
        System.out.println("_________________________________________________");
        while(rs.next()) 
        {
          int  rid=rs.getInt(1);
          int dist=(int) distance(rid);
          int time=(int) (dist*1.5); //40 kms per hr
          System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+dist+"\t"+time);         
        }
        
    }
    
    
    
    double distance(int rid) throws Exception
    {
 
        String url="jdbc:mysql://localhost:3306/fooddb";
        String uname="root";//user
        String password="12345";//password
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =DriverManager.getConnection(url, uname, password);
           
        Class.forName("com.mysql.jdbc.Driver");
           
 
        Statement stmt=con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from restAddress WHERE RestID='"+rid+ "'");
        
        double lat1=0;
        double lon1 = 0;
        
        while(rs.next())
        {
        lat1 = rs.getFloat(3);
        lon1 = rs.getFloat(4);
        }
        double lat2=28.607800;
        double lon2=77.040600;
 
        con.close(); 
        
        //distance calculation
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;//kms
        
        setDistance(dist);
        return getDistance();
    }
        double deg2rad(double deg)
        {
            return (deg * Math.PI / 180.0);
        }
        double rad2deg(double rad)
        {
            return (rad * 180.0 / Math.PI);
        }
}
