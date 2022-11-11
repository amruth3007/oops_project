
package com.mycompany.fooddelivery;

/**
 *
 * @author HAREESH
 */

import java.sql.*;
import java.util.Scanner;

public class Fooddelivery
{
    private String userMail;
    private String userPwd;
    //getter and setter
    void setUserMail(String newMail)
    {
        userMail=newMail;
    }
    
    String getUserMail()
    {
        return userMail;
    } 
    
    void setUserPwd(String newPwd)
    {
        userPwd=newPwd;
    }
    
    String getUserPwd()
    {
        return userPwd;
    } 
    
    
     public static void main(String args[]) throws Exception
    {
        System.out.println("Hello World");
        Scanner sc=new Scanner(System.in);
        int s=1;
        while(s!=0)
        {
        System.out.println("\n");
        System.out.println("****************************  FOOD DELIVERY  ***************************************");
        System.out.println("\nWelcome To the Portal:");
        System.out.println("Please select your option:\n"+
                    "1. Login\n"+
                    "2. Sign Up(New User)\n"+
                    "3. Exit\n");
         int opt = sc.nextInt();
         
         if(opt==1){
                System.out.println("****************************  AUTHENTICATION ***************************************");
                System.out.println("Enter Registered Email for Login:");
                String email=sc.next();
                System.out.println("Enter Password:");
                String pwd=sc.next();
                
                Ulogin u=new Ulogin();
                boolean loginRes = u.usercheck(email,pwd);
                int uid=u.getUID();
                if(loginRes)
                {
                 System.out.println("Successfully Logged in\n");
                 System.out.println("**************************** Delivery Address ***************************************");
                 System.out.println("Confirm Your Delivery Address to Proceed:");
                 Location l=new Location();
                 l.delAddress();
                 double latU=l.getLatitude();
                 double lonU=l.getLongitude();
//                 System.out.println("L:"+latU);
//                 System.out.println("Lo:"+lonU);
                 
                 System.out.println("\n");
                 System.out.println("****************************  Restaurents  NearBy  ***************************************");
                 System.out.println("\n");
                 ViewMenu v=new ViewMenu();
                 v.distCal();
                 System.out.println("\n");
                 System.out.println("\n");
                 System.out.println("****************************  MENU ***************************************");
                 v.menu(); //view
                 
                 System.out.println("\n");
                 
                 System.out.println("****************************  ORDER  ***************************************");
           
                 System.out.println("Please select your option:\n"+
                    "1. Order Now (Add to Cart)\n"+
                    "2. Order Later(Add to WishList)\n"+
                    "3. Order from WishList\n");
                
                 
                int choice = sc.nextInt();
                if(choice==1)
                {
                   CartFood c=new CartFood();
                   c.discardCart();
                   
                    int k=1;
                    while(k!=0)
                    {
                    System.out.println("\n");  
                    System.out.println("Choose your option:\n"+
                    "1. Add to the Cart\n"+
                    "2. Delete From Cart\n"+
                    "3. Empty Cart\n"+
                    "4. Check Out\n"+
                    "5. Exit from the App");
                    int option = sc.nextInt();
                    if(option==1)
                    {
                        c.addTocart();
                        c.viewCart();
                    }
                    else if(option==2)
                    {
                        c.deleteFromcart();
                    }
                    else if(option==3)
                    {
                        c.discardCart();
                        
                    }
                    else if(option==4)
                    {
                        
                        System.out.println("****************************  CHECK OUT ***************************************");
                        //payment
                        CartCheckOut op=new CartCheckOut();
                        int pCheck=op.payment(uid);//pcheck  1 success 0 Failure
                        int eTime=op.getTime();
                        //track
                        if(pCheck==1)//payment succees
                        {
                        OrderTrack t=new OrderTrack();
                        t.track(eTime);
                        }
                        k=0;//exit
                        //s=0;//exit
                    }
                    else
                    {
                        k=0;
                        s=0;//exit
                    }
                    }
                   
                   }
                else if(choice==2)
                {
                     WishFood w=new WishFood();
                     w.discardCart();
                     w.addToCart(); 
                     w.viewCart();
                     System.out.println("\nThank You:");
                     System.out.println("VISIT AGAIN");
                     System.out.println("\n\n");
                    // s=0;//exit                   
                     
                }
                else
                {
                    //order the wishList Food
                        System.out.println("****************************  CHECK OUT ***************************************");
                        //payment
                        WishCheckOut op=new WishCheckOut();
                        int pCheck=op.payment(uid);//pcheck  1 success 0 Failure
                        int eTime=op.getTime();
                        //track
                        if(pCheck==1)//payment succees
                        {
                        OrderTrack t=new OrderTrack();
                        t.track(eTime);
                        
                        }
                        else
                        {
                        WishFood w=new WishFood();
                        w.discardCart();
                        System.out.println("\nThank You:");
                        System.out.println("VISIT AGAIN");
                        System.out.println("\n\n");
                        }
                       // s=0;//exit
                }
                
                
                 
                }
                else//login details failed
                {
                 System.out.println("Wrong Password,Try Again\n");
                 System.out.println("NEW USER... Sign Up \n");
                }
            }
         else if(opt==2)
         {
              System.out.println("****************************  USER REGISTRATION ***************************************");
                System.out.println("Enter UserID:");
                int uid=sc.nextInt();
                System.out.println("Enter Name:");
                String uname=sc.next();
                System.out.println("Enter Password:");
                String pwd=sc.next();
                System.out.println("Enter Phone Number:");
                String phone=sc.next();
                System.out.println("Enter Mail ID:");
                String mail=sc.next();
                
                Ulogin u=new Ulogin();
                u.regUser(uid,uname,pwd,phone,mail);
                u.coupon(uid);
                System.out.println("Registered Successfully");
                System.out.println("Now,Login with USERID and Password");
                
                
         }
         else if(opt>=3)
         {
             s=0;
         }
         
         
        
        }
    }
}


