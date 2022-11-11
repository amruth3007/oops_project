
package com.mycompany.fooddelivery;

/**
 *
 * @author HAREESH
 */
abstract  class Login 
{
    abstract public boolean usercheck(String email,String pwd) throws Exception;
    abstract void regUser(int uid, String uname, String pwd, String phone, String mail)throws Exception ;
}
