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
 ************************************************************************/

import com.randarlabs.common.TextReader;

import java.util.Scanner;

import static sun.nio.ch.IOStatus.EOF;

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
      userGroup = new String[MAX_ARRAY];
      while(fileReader.hasNext())
      {
         usernameArray[index] = fileReader.getNextWord();
         passwordArray[index] = fileReader.getNextWord();
         passwordClearTextArray[index] = fileReader.getNextWord();
         userGroup[index] = fileReader.getNextWord();
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
         return userGroup[index];
      } else {
         return null;
      }
   }
   
   public final String getUserGroupClearText(){
      if(isValidAccountClearText()) {
         return userGroup[index];
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
      userGroup = null;
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
   private String[] userGroup;
   private int index;
   private int maxIndex;
   private static final int MAX_ARRAY = 10;
   private static TextReader fileReader = new TextReader();
}