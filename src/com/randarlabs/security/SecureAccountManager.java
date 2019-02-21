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
 20FEB2019   Update link to credential file
 ************************************************************************/

import com.randarlabs.common.TextReader;

import java.util.Scanner;

/**
 * Used to compare user logon info with a credential file
 * @author Randall Rowland
 * @version 1.0
 */
public class SecureAccountManager {
   
   /**
    * Initializes everything to 0 or nothing. Sets the credential file path and
    * loads the tab delimited credential file into respective arrays for comparison.
    */
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
   
   /**
    * Compares the username and hashed password.
    *
    * @return true if and only if the username and hashed password match
    */
   public final boolean isValidAccount() {
      return findUsernameIndex() != -1 && doesPasswordMatch(passwordArray[index]);
   }
   
   /**
    * Compares the username and plain text password.
    *
    * <b>FOR TESTING PURPOSES ONLY</b>
    *
    * @return true if and only if the username and plain text password match
    */
   public final boolean isValidAccountClearText() {
      return findUsernameIndex() != -1 && doesPasswordMatch(passwordClearTextArray[index]);
   }
   
   /**
    * Returns the user's group name if the account is vaildated with username and hashed password.
    *
    * @return the user's group name or null
    */
   public final String getUserGroup(){
      String result = isValidAccount() ? userGroupArray[index] : null;
      return result;
   }
   
   /**
    * Returns the user's group name if the account is vaildated with username and plain text password.
    *
    * <b>FOR TESTING PURPOSES ONLY</b>
    *
    * @return the user's group name or null
    */
   public final String getUserGroupClearText(){
      String result = isValidAccountClearText() ? userGroupArray[index] : null;
      return result;
   }
   
   /**
    * Sets the username from the supplied String.
    *
    * @param enteredUsername the supplied String the username will be set to
    */
   public void setEnteredUsername(String enteredUsername) {
      this.enteredUsername = enteredUsername;
   }
   
   /**
    * Sets the password from the supplied String.
    *
    * @param enteredPassword the supplied String the password will be set to
    */
   public void setEnteredPassword(String enteredPassword) {
      this.enteredPassword = enteredPassword;
   }
   
   /**
    * Closes the FileStream and Scanner connected to the credential file.
    */
   private void closeCredentialFile() {
      fileReader.closeFile();
   }
   
   /**
    * Sets indexes back to zero and arrays point to null for garbage collection.
    */
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
   
   /**
    * Compares the stored username against the array of usernames.
    *
    * @param username from the credential file array
    * @return true if the two strings match
    */
   private final boolean doesUsernameMatch(String username) {
      return this.enteredUsername.equals(username);
   }
   
   /**
    * Compares the stored username against the array of usernames.
    *
    * @param password from the credential file array
    * @return true if the two strings match
    */
   private final boolean doesPasswordMatch(String password) {
      return this.enteredPassword.equals(password);
   }
   
   /**
    * Iterates through the username array to find if the username matches.
    *
    * @return index number of array where username was found
    */
   private int findUsernameIndex() {
      for(int i = 0; i <= this.maxIndex; i++) {
         if(doesUsernameMatch(usernameArray[i])) {
            return index = i;
         }
      }
      return -1;
   }
   
   private final static String credentialFileName = "../Docs/Authentication/credentials.txt";
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
}