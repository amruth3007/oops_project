
package com.mycompany.fooddelivery;

/**
 *
 * @author HAREESH
 */
public class CartCheckOut extends CheckOut
{
    private int estTime;
    private double amount;
    
    void setTime(int newTime)
    {
        estTime=newTime;
    }
    
    int getTime()
    {
        return estTime;
    }
    
    
    void setAmount(double newAmount)
    {
        amount=newAmount;
    }
    
    double getAmount()
    {
        return amount;
    }
    
    public int payment(int uid) throws Exception
    {
    java.util.Scanner sc=new java.util.Scanner(System.in);
    
    System.out.println("Your Order Details\n");
    CartFood cf=new CartFood();
    int basebill=cf.priceCalculation();
    System.out.println("TOTAL (BASE BILL): "+basebill);    
    if(basebill<100)
    {
        System.out.println("Sorry,Minimum Order value >100");
        return 0;
    }
    //restID
    int rid=cf.restid();
    DistanceCal dc=new DistanceCal();
    int dist=(int) dc.distance(rid);//DistCal
    int deliveryCharge=(int) (dist*1.5); 
    int tempTime=(int) (dist*1.5); //40 kmph
    setTime(tempTime);
    System.out.println("Delivery Fee): "+deliveryCharge); 
    int totalFee=basebill+deliveryCharge;
    System.out.println("TOTAL : "+totalFee); 
    
    //coupons

    int cpn=coupons(totalFee,uid);
    //return 1 for c50 and 2 for c20 and 0 for none
    System.out.println("****************************  PAYMENT METHOD ***************************************");
    int i;
    System.out.println("Please Enter the Payment method");
    System.out.println("Enter 1 for UPI Payment");
    System.out.println("Enter 2 for credit/debit card payment");
    System.out.println("Enter 3 for net banking");
    i=sc.nextInt();
    int e=0;
    if(i==1)
    {
        int c,d;
        double b,a;
        System.out.println("Enter the Upi ID");
        a=sc.nextDouble();
        b=getAmount();
        System.out.println("Amount to be Paid:"+b);
        
        System.out.println("Enter OTP from your registered contact number:");
        c=sc.nextInt();
        System.out.println("Enter 1 for submit");
        System.out.println("Enter 2 for cancel");
        e=sc.nextInt();
    }
    else if(i==2)
    {
        int b,d;
        double a,c;
        System.out.println("Enter your card number:");
        a=sc.nextDouble();
//        System.out.println("Enter the name on the card:");
//        String str=sc.next();
        System.out.println("Enter the expiry date:");
        b=sc.nextInt();
        c=getAmount();
        System.out.println("Amount to be Paid:"+c);
        
        System.out.println("Enter the cvv");
        d=sc.nextInt();
        System.out.println("Enter 1 for submit");
        System.out.println("Enter 2 for cancel");
        e=sc.nextInt();
        
    }
    else if(i==3)
    {
                int b,c;
                double d;
                double a;
        
        System.out.println("Enter the acc number:");
        a=sc.nextDouble();
        System.out.println("Enter the net banking Id:'");
        b=sc.nextInt();
        System.out.println("Enter the OTP from your registered contact number");
        c=sc.nextInt();
        d=getAmount();
        System.out.println("Amount to be Paid:"+d);
        
        System.out.println("Enter 1 for submit");
        System.out.println("Enter 2 for cancel");
        e=sc.nextInt();
        
    }
    else
    {
        System.out.println("Please Enter a valid payment method");
    }   
        
    if(e==1)
    {
    System.out.println("Payment has been made succesfully");
    System.out.println("uid"+uid);
    if((cpn==1)||(cpn==2))
    {
    Ulogin u=new Ulogin();
    u.couponUpdate(uid,cpn); 
    }
    return 1;
    }
    else 
    {
      System.out.println("You have cancelled the order");
      return 0;
      
    }

  }
    
    
    int coupons(int total,int uid)
   {
      java.util.Scanner sc=new java.util.Scanner(System.in);
      System.out.println("Do you want to add any coupon?");
      System.out.println("press 1 for Yes");
      System.out.println("press 2 for No");
      int i=sc.nextInt();
      
      if(i==1)
      {
          System.out.println("which offer do you want to add on this order?");
          System.out.println("press 1 for SAVE50");
          System.out.println("press 2 for SAVE20");
          int p=sc.nextInt();
          if (p==1)
          { 
              //coupon check
             int cp=1;
             Ulogin u=new Ulogin();
             boolean check=u.couponCheck(uid,cp);
             if(check)
             {
             double discount = total*0.5;
             System.out.println("Coupon Applied : 50% off "); 
             System.out.println("Discount : "+discount);
             double finalFee=total-discount;
             System.out.println("Final Amount to be Paid:"+finalFee);
             setAmount(finalFee);
             return 1;
             }
             else
             {

             System.out.println("Invalid Coupon : Coupon already Used "); 
             double finalFee=total;
             System.out.println("Final Amount to be Paid:"+finalFee);
             setAmount(finalFee);
             return 0;
             }
          }
          
          
          else if(p==2)
          {
             //coupon check
             int cp=2;
             Ulogin u=new Ulogin();
             boolean check=u.couponCheck(uid,cp);
             if(check)
             {
             double discount = total*0.2;
             System.out.println("Coupon Applied : 20% off "); 
             System.out.println("Discount : "+discount);
             double finalFee=total-discount;
             System.out.println("Final Amount to be Paid:"+finalFee);
             setAmount(finalFee);
             return 2;
             }
             else
             {

             System.out.println("Invalid Coupon : Coupon already Used "); 
             double finalFee=total;
             System.out.println("Final Amount to be Paid:"+finalFee); 
             setAmount(finalFee);
             return 0;
             }
             
           }
           else
           {

             System.out.println("No Coupon Applied "); 
             double finalFee=total;
             System.out.println("Final Amount to be Paid:"+finalFee);
             setAmount(finalFee);
             return 0;
            
           }
      }
      else
      {
             System.out.println("No Coupon Applied "); 
             double finalFee=total;
             System.out.println("Final Amount to be Paid:"+finalFee);
             setAmount(finalFee);
             return 0;
      }
      
    }
    
}

