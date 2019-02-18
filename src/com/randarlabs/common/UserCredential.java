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
 ************************************************************************/

public class UserCredential {
   
   public UserCredential() {
      username = "";
      password = "";
   }
   
   public void setUsername(String username) {
      try {
         this.username = username;
      }
      catch (Exception e) {
         System.err.println("Error saving username");
         this.username = null;
      }
      
   }
   
   public void setPassword(String password) {
      try {
         this.password = password;
      }
      catch (Exception e) {
         System.err.println("Error saving password");
         this.username = null;
      }
   }
   
   public final String getUsername() {
      return username;
   }
   
   public final String getPassword() {
      return password;
   }
   
   private String username;
   private String password;
}
