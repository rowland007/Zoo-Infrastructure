package com.randarlabs.security;

/************************************************************************
 Program:           Zoo Infrastructure
 Author:            Randall Rowland
 Class:             IT-145 Foundations in App Development
 Instructor:        Jim Barringer
 Date:              30 Jan 2019
 Description:
 Input:             stdin
 Output:            stdout
 Known bugs:
 Missing features:
 
 License:           GNU General Public License v3.0
 Modifications:
 Date                      Comment
 ---------   ------------------------------------------------
 ************************************************************************/

public class SecureAccountManager {

   public SecureAccountManager() {
      //TODO Create a file scanner/parser
      credentialFileName = "";
      readUsername = "";
      readHashPassword = "";
      index = 0;
   }
   
   public boolean doesUsernameMatch(String username) {
      return this.readUsername.equals(username);
   }
   
   public boolean doesPasswordMatch(String password) {
      return this.readHashPassword.equals(password);
   }
   
   public int findUsername(String username) {
      //TODO create a iterator to cycle through usernameArray to find matching username
      // - IF username is found, return index number so can compare matching hash password
      // - IF no username found, return null and exit SAM
      return 0;
   }
   
   
   
   private String credentialFileName;
   private String readUsername;
   private String readHashPassword;
   private String usernameArray[];
   private String passwordArray[];
   private int index;





}
