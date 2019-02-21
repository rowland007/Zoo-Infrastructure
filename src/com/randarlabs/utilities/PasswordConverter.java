package com.randarlabs.utilities;

/************************************************************************
 Program:           Zoo Infrastructure
 Author:            Randall Rowland
 Class:             IT-145 Foundations in App Development
 Instructor:        Jim Barringer
 Date:              27 Jan 2019
 Description:       Converts a string into a MD5 hash
 Input:             stdin
 Output:            stdout
 Known bugs:        Vulnerable to collision and preimage attacks
 Missing features:
 
 License:           GNU General Public License v3.0
 Modifications:
    Date                      Comment
 ---------   ------------------------------------------------
 27Jan2019   Derived from the provided MD5Digest file
 21FEB2019   Add javadoc comments
 ************************************************************************/

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Used to open and read text files
 * @author Randall Rowland
 * @version 1.0
 */
public class PasswordConverter {
   
   /**
    * Creates a message digest with the MD5 algorithm.
    *
    * @param plainText the String that needs to be hashed
    * @return the MD5 hashed text
    * @throws NoSuchAlgorithmException if the algorithm is not installed or supported
    */
   public  String convertToHash(String plainText) {
      try {
         MessageDigest md = MessageDigest.getInstance("MD5");
         md.update(plainText.getBytes());
         byte[] digest = md.digest();
         StringBuffer sb = new StringBuffer();
         for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
         }
         return sb.toString();
      }
      catch (NoSuchAlgorithmException e) {
         System.err.println("MD5 is not a valid message digest algorithm");
      }
      return null;
   }
   
}

