
package com.mycompany.fooddelivery;

import java.util.Scanner;

/**
 *
 * @author HAREESH
 */
public class OrderTrack extends Track
{
    
     private int estTime;
 
    
    void setTime(int newTime)
    {
        estTime=newTime;
    }
    
    int getTime()
    {
        return estTime;
    }
    
    void track(int time) throws Exception
    {
       Scanner sc=new Scanner(System.in);
       System.out.println("Estimated Delivery Time:"+time+"mins");
       
       setTime(time);
       int left=getTime();
       int start=0;
       System.out.println("Your Tracking Just Started:"+start+"min");
       System.out.println("Your Food will be delivered in "+left+"min");
       System.out.println("__________________________");
       int x=1;
        while(x!=0)
        {
        System.out.println("Enter the duration in mins after the order confirmation:");
        int temp=sc.nextInt();
        left=time-temp;
        start=temp;
        //System.out.println("Your Food will be delivered in "+left+"min");
            if(start>time*(1.1))//if Time Exceeds by 10% of estimated time
            {
              System.out.println("SORRY");  
              System.out.println("We are unable to deliver in Time");
              System.out.println("Please select your option:\n"+
                         "1. Cancel the order \n"+
                         "2. Wait for the Arrival\n");
              int choice = sc.nextInt();
              if(choice==1)
              {
                  System.out.println("Your Order is cancelled");
                  CartFood c=new CartFood();
                  c.discardCart();
                    WishFood w=new WishFood();
                    w.discardCart();
                  System.out.println("Thank You");
                  x=0;  //exit from loop
              }
              else
              {
                  System.out.println("Thank You");
                  System.out.println("We will deliver your order very  soon...");
                  System.out.println("Wait......................");
                  System.out.println("Thanks for Your patience..Your order is Delivered");
                    CartFood c=new CartFood();
                    c.discardCart();
                    System.out.println("Rate your experience with us..That will help us to improve better");
                    apprating();
                    Foodrating();
                    x=0;  //exit from loop
              }

              
            }
            else
            {

                System.out.println("Please select your option:\n"+
                         "1. Delivered \n"+
                         "2. Not Delivered\n");
                int choice = sc.nextInt();
                if(choice==1)
                {
                    System.out.println("That's Great");
                    CartFood c=new CartFood();
                    c.discardCart();
                    WishFood w=new WishFood();
                    w.discardCart();
                    System.out.println("Rate your experience with us..That will help us to improve better");
                    apprating();
                    Foodrating();
                    x=0;  //exit from loop
                }
                else
                {
                    System.out.println("Your Food will be delivered in "+left+"min");
                    System.out.println("Thank You");
                }



            }
       }
       
    }
    
    void apprating()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("****************************  APP RATING  ***************************************");
        System.out.println("Do You want to rate the Application:\n"+
                         "1. Yes \n"+
                         "2. No\n");
        int choice = sc.nextInt();
        if(choice==1)
        {
             System.out.println("Rate us out of 5 ");
             int rate=sc.nextInt();
             if(rate>=4)
             {
                 System.out.println("Thanks for your Time ");
                 System.out.println("Thank You and Visit Again");
             }
             else
             {
                 System.out.println("Sorry,We will Improve ");
                 System.out.println("Thank You and Visit Again");
                 
             }
        }
        else
        {
         System.out.println("No Problem..Have a Nice Day");
         System.out.println("Thank You and Visit Again");
        }
    }
    
    void Foodrating()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("****************************  FOOD RATING  ***************************************");
        System.out.println("Do You Want to rate the Food:\n"+
                         "1. Yes \n"+
                         "2. No \n");
        int choice = sc.nextInt();
        if(choice==1)
        {
            
             System.out.println("Rate us out of 5 ");
             int rate=sc.nextInt();
             if(rate>=4)
             {
                 System.out.println("Thanks for your Time ");
                 System.out.println("Thank You and Visit Again");
             }
             else
             {
                 System.out.println("Sorry,We will Improve ");
                 System.out.println("Thank You and Visit Again");
                 
             }
                    
        }
        else
        {
         System.out.println("No Problem..Have a Nice Day");
         System.out.println("Thank You and Visit Again");
        }
    }
    
}
