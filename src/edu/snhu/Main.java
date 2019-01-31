package edu.snhu;

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

import com.randarlabs.common.TextReader;
import com.randarlabs.common.UserCredential;
import com.randarlabs.security.SecureAccountManager;
import com.randarlabs.utilities.PasswordConverter;

import java.util.Scanner;

public class Main {
   
   public static void main(String[] args) {
      
      systemUsers.setFile("credentials.txt");
      
      do {
         System.out.println("Please enter your choice:");
         System.out.println("L - Login to Zoo Command & Control");
         System.out.println("Q - Quit program");
         String choice = scanner.next();
         switch (choice) {
            case "L":
               logInScreen();
               break;
            case "Q":
               System.out.println("Goodbye");
               //TODO add sleep for 300
               return;
            default:
               System.out.println("Invalid choice, please try again");
         }
      } while (failedLogins < 3);
      
      systemUsers.closeFile();
   }
   
   private static void logInScreen() {
      System.out.println("Welcome to Zoo Command & Control\nPlease enter your username ");
      user.setUsername(scanner.next());
      sam.findUsername(user.getUsername());
      if(!sam.doesUsernameMatch(user.getUsername())) {
         failedLogins++;
         System.out.println("Username not found!\n\n\n");
         return;
      }
      else  {
         System.out.println("Please enter your password");
         user.setPassword(hasher.convertToHash(scanner.next()));
         if(!sam.doesPasswordMatch(user.getPassword())) {
            failedLogins++;
            System.out.println("Incorrect password");
            return;
         }
         else {
            showUserFile(user.getUsername());
         }
         
      }
   }
   
   private static void showUserFile(String username) {
      //TODO take username and match it to the file name after removing txt
      // - Then display file to screen
      System.out.println(userFile.getFile());
   }
   
   
   
   private static UserCredential user = new UserCredential();
   private static PasswordConverter hasher = new PasswordConverter();
   private static TextReader userFile = new TextReader();
   private static TextReader systemUsers = new TextReader();
   private static SecureAccountManager sam = new SecureAccountManager();
   private static Scanner scanner = new Scanner(System.in);
   private static int failedLogins = 0;
}
