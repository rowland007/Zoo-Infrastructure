package com.randarlabs.common;

/************************************************************************
 Program:           Zoo Infrastructure
 Author:            Randall Rowland
 Class:             IT-145 Foundations in App Development
 Instructor:        Jim Barringer
 Date:              30 Jan 2019
 Description:       Stores and returns a username and password for a single
                    user, each stored as a string
 Input:             stdin
 Output:            stdout
 Known bugs:
 Missing features:
 
 License:           GNU General Public License v3.0
 Modifications:
   Date                      Comment
 ---------   ------------------------------------------------
 20FEB2019   Add javadoc comments
 ************************************************************************/

/**
 * Used to represent a user logon
 * @author Randall Rowland
 * @version 1.0
 */
public class UserCredential {
   
   /**
    * Default constructor that initializes private variables to nothing.
    */
   public UserCredential() {
      username = "";
      password = "";
   }
   
   /**
    * Stores the username as a string.
    *
    * @param username the string used for a username
    * @throws Exception if a <code>String</code> is not passed or other error
    */
   public void setUsername(String username) {
      try {
         this.username = username;
      }
      catch (Exception e) {
         System.err.println("Error saving username");
         this.username = null;
      }
      
   }
   
   /**
    * Stores the password as a string.
    *
    * @param password the string used for a password
    * @throws Exception if a <code>String</code> is not passed or other error
    */
   public void setPassword(String password) {
      try {
         this.password = password;
      }
      catch (Exception e) {
         System.err.println("Error saving password");
         this.username = null;
      }
   }
   
   /**
    * Retrieves the username for this object.
    *
    * @return the username
    */
   public final String getUsername() {
      return username;
   }
   
   /**
    * Retrieves the password for this object.
    *
    * @return the password
    */
   public final String getPassword() {
      return password;
   }
   
   private String username;
   private String password;
}
