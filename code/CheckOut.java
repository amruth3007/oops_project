
package com.mycompany.fooddelivery;

/**
 *
 * @author HAREESH
 */
abstract class CheckOut 
{
   abstract int payment(int uid) throws Exception;
   abstract int coupons(int total,int uid);
}
