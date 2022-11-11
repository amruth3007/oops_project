# oops_project
Online Food Ordering System

*************************************************

# Project Implementation: (Food Delivery)

Requirements:

  1. Language:Java 16.0.2 
  2. IDE:NetBeans,Intelli J 
  3. Database:MySQL (MySQL Server,WorkBench) 
  4. Project Type:Maven Project
  

The implementation starts from Fooddelivey.java where the main class exists
We have three options here:
  1. UserLogin
  2. Sign Up(New User)
  3. Exit
We could create new User (SignUp) and login using email and Password.
Authentication checks in Ulogin(Ulogin.Java) class.

Once we login,we have to select the delivery address.
We have three options,here :
  1. Select current Location
  2. Select from Saved Address
  3. Create new Address
This is implemented in Location(Location.java) class

Once we select the address,we get Restaurents near by,with estimated delivey time
and we also get the menu Table
This is implented using ViewMenu(ViewMenu.java) class

Once we get Menu ,we have three options :
1. Order Now (Add to Cart)
2. Order Later(Add to WishList)
3. Order from WishList

If we choose OrderNow(Add to Cart),
We again have multiple options:
1. Add to the Cart
2. Delete From Cart
3. Empty Cart
4. Check Out
5. Exit from the App



we have CartFood (CartFood.java) class,where we have implemented Add to the Cart,Delete From Cart, Empty Cart
We have used CartList Table to store the the cart items in databse
we have CartCheckOut (CartCheckOut.java) class 

//payment      
where we have implemented checkout 
First calculates the basebill,
if the basebill>100 proceeds, else returns
Next,calculates estimated time and adds delivery Charge
Next we have two options to apply coupons:
1. SAVE 50
2. SAVE 20 (once per user)

Estimates final bill and proceeds to Payment,
where we have multiple options: 
1. UPI Payment
2. Debit/Credit Card Payment
3. Net Banking
After the Payment is done,we will track the order.

//Track
This is implemented using OrderTrack (OrderTrack.java) class
Once the tracking starts,we could track the order after some time
If the time exceeds by 10% of estimated time,then user have two options 
1. Cancel the order
2. Wait for the arrival

//Ratings
Once the delivery is done,we can rate the app and the food

If we choose Order Later(Add to WishList):
This is similar to Cart,except we don't checkOut here
We have used WishList Table to store the the wishList items in databse
we have implemented this in WishFood (WishFood.java) class  (inherited from CartFood)
      


If we choose Order from WishList:
This is similar to Cart CheckOut
we have WishCheckOut (WishCheckOut.java) class (inherited from CartCheckOut)
Payment is implemented here,(if min.Order>100)
Tracking and ratings are implemented in OrderTrack (OrderTrack.java) class

If we choose exit ....

We exit the program(Exit from Application)

*************************************************

# OOPD Concepts

# Abstraction:

1. Login  ----> Ulogin (class)
2. CheckOut ----> CartCheckOut (class)
3. OrderFood ---->CartFood (class)
4. Dcal ---->distCal (class)
5. Track ---->orderTrack (class)


# Inheritance:

1. WishCheckOut extends CartCheckOut
2. WishFood extends CartFood
3. ViewMenu extends DistanceCal
4. Reslogin extends Ulogin


# Encapsulation:

Getter and Setter Methods are implemented in the folllowing classes:

1. Ulogin 
2. CartCheckOut
3. WishCheckOut
4. Location
5. Fooddelivery
6. DistCal
7. GetRestData
8. CartFood
9. WishFood
10. OrderTrack

# Polymorphism:

The following methods are implemented with same name in CartCheckOut and WishCheckOut (RunTime Polymorphism):
1. payment()
2. setTime()
3. getTime() 

The following methods are implemented with same name in CartFood and WishFood (RunTime Polymorphism):
1. addToCart()
2. viewCart()
3. PriceCalculation()
4. int restid()
5. int getid()
    
