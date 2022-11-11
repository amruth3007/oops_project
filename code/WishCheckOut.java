
package com.mycompany.fooddelivery;

/**
 *
 * @author HAREESH
 */
public class WishCheckOut extends CartCheckOut

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
    

  
    public int payment(int uid) throws Exception
    {
    java.util.Scanner sc=new java.util.Scanner(System.in);
    
    System.out.println("Your Order Details\n");
    WishFood wf=new WishFood();
    int basebill=wf.priceCalculation();
    System.out.println("TOTAL (BASE BILL): "+basebill);    
    if(basebill==0)
    {
        System.out.println("Sorry,You don't have any items in wishList");
        return 0;
    }
    if(basebill<100)
    {
        System.out.println("Sorry,Minimum Order value >100");
        return 0;
    }
    //restID
    int rid=wf.restid();
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
        int a,c,d;
        double b;
        System.out.println("Enter the Upi ID");
        a=sc.nextInt();
        b=getAmount();
        System.out.println("Amount to be Paid:"+b);
        
        System.out.println("Enter OTP from your registered contact number");
        c=sc.nextInt();
        System.out.println("Enter 1 for submit");
        System.out.println("Enter 2 for cancel");
        e=sc.nextInt();
    }
    else if(i==2)
    {
        int a,b,d;
        double c;
        System.out.println("Enter your card number:");
        a=sc.nextInt();
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
                int a,b,c;
                double d;
        
        System.out.println("Enter the acc number:");
        a=sc.nextInt();
        System.out.println("Enter the net banking Id'");
        b=sc.nextInt();
        System.out.println("Enter the OTP from your registered contact number:");
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
    
    
  
    
}

