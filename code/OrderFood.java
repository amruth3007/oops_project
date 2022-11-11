
package com.mycompany.fooddelivery;

/**
 *
 * @author HAREESH
 */
abstract class OrderFood 
{
    abstract void addTocart() throws Exception;
    abstract void deleteFromcart() throws Exception;
    abstract void discardCart() throws Exception;
    abstract void viewCart() throws Exception;
}
