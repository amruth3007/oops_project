# oops_project
Online Food Ordering System

************************************************

Food Delivery(Java):

Amuru Hareesh(MT21009)
Elapanti Sri Sai Chaithanya
Anmol Aggarwal
Chandan Saini

************************************************
Contents:
Project Implementation
OOPD Concepts
Profiling  (FoodDeliveryProf.pdf)
Doxygen (doxygen Folder)
Packaging Maven Project (foodDelivery Folder)
Video   (foodDbGroup62.mp4)
UML Diagram  (fdUML.jpeg )
Appendix -A (SQL queries)
*************************************************
Project Implementation: (Food Delivery)

Language:Java 16.0.2
IDE:NetBeans,Intelli J
Database:MySQL (MySQL Server,WorkBench)
Project Type:Maven Project

The implementation starts from Fooddelivey.java where the main class exists
We have three options here: 1.UserLogin
                            2.Sign Up(New User)
                            3.Exit
We could create new User (SignUp) and login using email and Password.
Authentication checks in Ulogin(Ulogin.Java) class.

Once we login,we have to select the delivery address.
We have three options,here :1.Select current Location
                            2.Select from Saved Addresss
                            3.Create new Address
This is implemented in Location(Location.java) class

Once we select the address,we get Restaurents near by,with estimated delivey time
and we also get the menu Table
This is implented using ViewMenu(ViewMenu.java) class

Once we get Menu ,we have three options :1. Order Now (Add to Cart)
                                         2. Order Later(Add to WishList)
                                         3. Order from WishList

If we choose OrderNow(Add to Cart),
We again have multiple options: 1. Add to the Cart
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
                Next we have two options to apply coupons:SAVE 50
                                                          SAVE 20 (once per user)
                Estimates final bill and proceeds to Payment,
                where we have multiple options: 1.UPI Payment
                                                2.Debit/Credit Card Payment
                                                3.Net Banking
                After the Payment is done,we will track the order.

                //Track
                This is implemented using OrderTrack (OrderTrack.java) class
                Once the tracking starts,we could track the order after some time
                If the time exceeds by 10% of estimated time,then user have two options 1.Cancel the order
                                                                                        2.Wait for the arrival
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


DATABASE TABLES:Appendix-A

***********************************************************************

OOPD Concepts

Abstraction:

Login  ----> Ulogin (class)
CheckOut ----> CartCheckOut (class)
OrderFood ---->CartFood (class)
Dcal ---->distCal (class)
Track ---->orderTrack (class)


Inheritance:

WishCheckOut extends CartCheckOut
WishFood extends CartFood
ViewMenu extends DistanceCal
Reslogin extends Ulogin


Encapsulation:

//Getter and Setter Methods
//classes

Ulogin 
CartCheckOut
WishCheckOut
Location
Fooddelivery
DistCal
GetRestData
CartFood
WishFood
OrderTrack

Polymorphism:


payment(),setTime(),getTime() 
    methods implemented with same name in CartCheckOut and WishCheckOut (RunTime Polymorphism)
addToCart()
viewCart()
PriceCalculation()
int restid()
int getid()
    methods implemented with same name in CartFood and WishFood (RunTime Polymorphism)

*****************************************************************************************
Profiling: FoodDeliveryProf.pdf

Profiling File Available in FoodDeliveryProf.pdf,where all the results collected and put it in a file

*****************************************************************************************
Doxygen : doxygen Folder

All html files in Doxygen Folder

*****************************************************************************************
Created in NetBeans 
Packaging Maven Project: foodDelivery Folder
Jar File: foodDelivery\target\foodDelivery-1.0-SNAPSHOT.jar
Sample Output for jar(Screenshot):foodDelivery\target\jarOutScreenshot
Output Command for jar:
java -jar "C:\Users\HAREESH\Documents\NetBeansProjects\foodDelivery\target\foodDelivery-1.0-SNAPSHOT.jar" 


*****************************************************************************************
Video :foodDbGroup62.mp4

00:00   --->Introduction
00:34   --->Code,UML and OOPS Concepts used
07:01   ---> SQL Tables
08:07   --->Execution of the Project
14:17   --->Doxygen and Profiling


*****************************************************************************************
UML Diagram
fdUML.jpeg 

**************************Appendix -A (SQL queries)***************************************

mysql requirements to run in jdbc:
database:fooddb
user:root
password:12345

***********Tables**********

CREATE TABLE userlogin (
    userID int,
    username varchar(255),
    password varchar(255),
    phone varchar(255),
    mail varchar(255)
);



CREATE TABLE coupon (
    userID int,
    c50 int,
    c20 int
);


CREATE TABLE Reslogin (
    RestID int,
    RestName varchar(255),
    password varchar(255),
    phone varchar(255),
    mail varchar(255)
);


CREATE TABLE menuTotal (
    uID int,
    RestID int,
    RestName varchar(255),
    itemID int,
    itemName varchar(255),
    price int,
    quantity varchar(255)
);


CREATE TABLE restAddress(
     RestID int,
     RestAddress varchar(255),
     latitude FLOAT( 10, 6 ) NOT NULL,  
     longitude FLOAT( 10, 6 ) NOT NULL
);


CREATE TABLE userAddress(
     addressID int,
     userAddress varchar(255),
     latitude FLOAT( 10, 6 ) NOT NULL,  
     longitude FLOAT( 10, 6 ) NOT NULL
);


CREATE TABLE wishList(
     id int,
     restName varchar(255),
     item varchar(255),
     price int,
     quantity int
);

CREATE TABLE cartList(
     id int,
     restName varchar(255),
     item varchar(255),
     price int,
     quantity int
);

**************Queries to insert(Few Tables):****************

INSERT INTO userlogin (userID, username, password, phone, mail)
VALUES (201, 'user101', 'user101201', '1234567890', 'user101@gmail.com');

INSERT INTO userlogin (userID, username, password, phone, mail)
VALUES (202, 'user102', 'user102202', '1234567890', 'user102@gmail.com');

INSERT INTO userlogin (userID, username, password, phone, mail)
VALUES (203, 'user103', 'user103203', '1234567890', 'user103@gmail.com');



INSERT INTO coupon (userID,c50,c20)
VALUES (201,1,1);

INSERT INTO coupon (userID,c50,c20)
VALUES (202,1,1);

INSERT INTO coupon (userID,c50,c20)
VALUES (203,1,1);




INSERT INTO Reslogin (RestID, RestName, password, phone, mail)
VALUES (1001, 'Two Pots Kitchen', 'res1001', '1234567890', 'tpk1001@gmail.com');

INSERT INTO Reslogin (RestID, RestName, password, phone, mail)
VALUES (1002, 'Latitude 28 Delhi', 'res1002', '1234567890', 'lat1002@gmail.com');

INSERT INTO Reslogin (RestID, RestName, password, phone, mail)
VALUES (1003, 'Raasta Green Park', 'res1003', '1234567890', 'rgp1003@gmail.com');

INSERT INTO Reslogin (RestID, RestName, password, phone, mail)
VALUES (1004, 'Amour Bistro Delhi', 'res1004', '1234567890', 'ab1004@gmail.com');

INSERT INTO Reslogin (RestID, RestName, password, phone, mail)
VALUES (1005, 'Smoke House Delhi', 'res1005', '1234567890', 'shd1005@gmail.com');

INSERT INTO Reslogin (RestID, RestName, password, phone, mail)
VALUES (1006, 'ABC New Delhi', 'res1006', '1234567890', 'abc1006@gmail.com');

INSERT INTO Reslogin (RestID, RestName, password, phone, mail)
VALUES (1007, 'Anand Bhavan Delhi', 'res1007', '1234567890', 'ab1007@gmail.com');




INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (001, 1001, 'Two Pots Kitchen', 1001001, 'ChillyLemonFish', 120,'250 gms');
INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (002,1001, 'Two Pots Kitchen', 1001002, 'ChickenStar', 100,'250 gms');
INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (003,1001, 'Two Pots Kitchen', 1001003, 'OrangeGingerMojito', 150,'250 ml');
INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (004,1001, 'Two Pots Kitchen', 1001004, 'MezzePlatter', 250,'250 gms');
INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (005,1001, 'Two Pots Kitchen', 1001005, 'PitaPockets', 90,'100 gms');

INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (006, 1002, 'Latitude 28 Delhi', 1002001, 'ClassicTiramisu', 190,'250 ml');
INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (007,1002, 'Latitude 28 Delhi', 1002002, 'ChocolateGanache', 190,'150 gms');
INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (008,1002, 'Latitude 28 Delhi', 1002003, 'MangoCheeseCake', 150,'150 gms');
INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (009,1002, 'Latitude 28 Delhi', 1002004, 'Lasagne', 190,'250 gms');
INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (010,1002, 'Latitude 28 Delhi', 1002005, 'Prawn', 190,'150 gms');

INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (011, 1003,'Raasta Green Park', 1003001, 'Jambalaya', 90,'100 gms');
INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (012,1003, 'Raasta Green Park', 1003002, 'SaintLucia', 85,'150 gms');
INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (013,1003, 'Raasta Green Park', 1003003, 'GrilledChicken', 100,'150 gms');
INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (014,1003, 'Raasta Green Park', 1003004, 'GooeyCake', 95,'150 gms');
INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (015,1003, 'Raasta Green Park', 1003005, 'AllMeatPizza', 150,'small');


INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (016, 1004, 'Amour Bistro', 1004001, 'Sangria', 90,'150 ml');
INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (017,1004, 'Amour Bistro', 1004002, 'Martini', 110,'150 ml');
INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (018,1004, 'Amour Bistro', 1004003, 'OldMonk', 80,'150 ml');
INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (019,1004, 'Amour Bistro', 1004004, 'JackDaniels', 110,'150 ml');
INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (020,1004, 'Amour Bistro', 1004005, 'Budweiser', 90,'150 ml');


INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (021, 1005, 'Smoke House Delhi', 1005001, 'BrocolliCheddar', 90,'100 gms');
INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (022,1005, 'Smoke House Delhi', 1005002, 'CottageSteak ', 80,'100 gms');
INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (023,1005, 'Smoke House Delhi', 1005003, 'TerracottaScrambled', 65,'1 N0.');
INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (024,1005, 'Smoke House Delhi', 1005004, 'Omlette', 45,'1 No.');
INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (025,1005, 'Smoke House Delhi', 1005005, 'LemonMascarponePolenta', 150,'100 gms');


INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (026, 1006, 'ABC New Delhi', 1006001, 'Idli', 30,'2 no.');
INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (027, 1006, 'ABC New Delhi', 1006002, 'Biryani', 100,'100 gms');
INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (028, 1006, 'ABC New Delhi', 1006003, 'Lassi', 35,'100 ml');

INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (029, 1007,'Anand Bhavan Delhi', 1007001, 'Dosa', 30,'1 no.');
INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (030, 1007,'Anand Bhavan Delhi', 1007002, 'Chapati', 50,'5 no.');
INSERT INTO menuTotal (uID, RestID, RestName, itemID, itemName, price,quantity)
VALUES (031, 1007,'Anand Bhavan Delhi', 1007003, 'DahiWada', 30,'2 no.');





INSERT INTO restAddress(RestID,RestAddress,latitude,longitude)
VALUES (1001,'Janakpuri, New Delhi',28.626551,77.092430);

INSERT INTO restAddress(RestID,RestAddress,latitude,longitude)
VALUES (1002,'Khan Market, Central Delhi',28.648980,77.210200);

INSERT INTO restAddress(RestID,RestAddress,latitude,longitude)
VALUES (1003,'Green Park, New Delhi',28.561359,77.211937);

INSERT INTO restAddress(RestID,RestAddress,latitude,longitude)
VALUES (1004,'Chanakyapuri, New Delhi',28.598280,77.180939);

INSERT INTO restAddress(RestID,RestAddress,latitude,longitude)
VALUES (1005,'DLF Promenade Mall, Vasant Kunj',28.546010,77.160120);

INSERT INTO restAddress(RestID,RestAddress,latitude,longitude)
VALUES (1006,'Okhla Phase-1 Delhi',28.522300,77.284900);

INSERT INTO restAddress(RestID,RestAddress,latitude,longitude)
VALUES (1007,'Indirapuram Delhi',28.646000,77.369500);





INSERT INTO userAddress(addressID,userAddress,latitude,longitude)
VALUES (001,'No. 201 Dwarak Sector-3 Delhi',28.607800,77.040600);

INSERT INTO userAddress(addressID,userAddress,latitude,longitude)
VALUES (002,'No. 503 OkhlaPhase-1 Delhi',28.522300,77.284900);

INSERT INTO userAddress(addressID,userAddress,latitude,longitude)
VALUES (003,'No. 110 Lajpat Nagar Delhi',28.564900,77.240300);

INSERT INTO userAddress(addressID,userAddress,latitude,longitude)
VALUES (004,'No. 110 GovindPuri Delhi',28.535400,77.263900);

