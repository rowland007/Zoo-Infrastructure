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
 2FEB2019    Add TextReader class for scanner/file stream methods
 9FEB2019    Add arrays to hold each field of credentials file
 9FEB2019    Add method to return user account's user group
 17FEB2019   Add delimiters when calling next() for credentials file
 18FEB2019   Refactor how arrays are initialized
 ************************************************************************/

import com.randarlabs.common.TextReader;

import java.util.Scanner;

public class SecureAccountManager {

   public SecureAccountManager() {
      fileReader.setFile(credentialFileName);
      enteredUsername = "";
      enteredPassword = "";
      index = 0;
      maxIndex = 0;
      usernameArray = new String[MAX_ARRAY];
      passwordArray = new String[MAX_ARRAY];
      passwordClearTextArray = new String[MAX_ARRAY];
      userGroupArray = new String[MAX_ARRAY];
      while(fileReader.hasNext())
      {
         String line = fileReader.getNextLine();
         Scanner scnr = new Scanner(line);
         scnr.useDelimiter("\t");
         usernameArray[index] = scnr.next();
         passwordArray[index] = scnr.next();
         passwordClearTextArray[index] = scnr.next();
         userGroupArray[index] = scnr.next();
         index++;
         maxIndex = index;
      }
   }
   
   public final boolean isValidAccount() {
      return findUsernameIndex() != -1 && doesPasswordMatch(passwordArray[index]);
   }
   
   public final boolean isValidAccountClearText() {
      return findUsernameIndex() != -1 && doesPasswordMatch(passwordClearTextArray[index]);
   }
   
   public final String getUserGroup(){
      if(isValidAccount()) {
         return userGroupArray[index];
      } else {
         return null;
      }
   }
   
   public final String getUserGroupClearText(){
      if(isValidAccountClearText()) {
         return userGroupArray[index];
      } else {
         return null;
      }
   }
   
   public void setEnteredUsername(String enteredUsername) {
      this.enteredUsername = enteredUsername;
   }
   
   public void setEnteredPassword(String enteredPassword) {
      this.enteredPassword = enteredPassword;
   }
   
   private void closeCredentialFile() {
      fileReader.closeFile();
   }
   
   public void close() {
      enteredUsername = null;
      enteredPassword = null;
      usernameArray = null;
      passwordArray = null;
      passwordClearTextArray = null;
      userGroupArray = null;
      index = 0;
      maxIndex = 0;
      closeCredentialFile();
   }
   
   private final boolean doesUsernameMatch(String username) {
      return this.enteredUsername.equals(username);
   }
   
   private final boolean doesPasswordMatch(String password) {
      return this.enteredPassword.equals(password);
   }
   
   private int findUsernameIndex() {
      for(int i = 0; i <= this.maxIndex; i++) {
         if(doesUsernameMatch(usernameArray[i])) {
            return index = i;
         }
      }
      return -1;
   }
   
   private final static String credentialFileName = "Docs/Authentication/credentials.txt";
   private String enteredUsername;
   private String enteredPassword;
   private String[] usernameArray;
   private String[] passwordArray;
   private String[] passwordClearTextArray;
   private String[] userGroupArray;
   private int index;
   private int maxIndex;
   private static final int MAX_ARRAY = 50;
   private static TextReader fileReader = new TextReader();
   
   
   // TODO The following are for testing purposes only and need to be removed before production
   public  void getUserNames() {
      for(int i = 0; i <= this.maxIndex; i++) {
         System.out.println(usernameArray[i]);
      }
   }
   public void getUserPasswords() {
      for(int i = 0; i <= this.maxIndex; i++) {
         System.out.println(passwordArray[i]);
      }
   }
   public void getUserPasswordsClearText() {
      for(int i = 0; i <= this.maxIndex; i++) {
         System.out.println(passwordClearTextArray[i]);
      }
   }
   public  void getUserGroups() {
      for(int i = 0; i <= this.maxIndex; i++) {
         System.out.println(userGroupArray[i]);
      }
   }
}