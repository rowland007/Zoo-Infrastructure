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
 2FEB2019    Added a variable for user input & used variable for method arguments
 2FEB2019    Added a sleep timer before program exits
 ************************************************************************/

import com.randarlabs.common.TextReader;
import com.randarlabs.common.UserCredential;
import com.randarlabs.security.SecureAccountManager;
import com.randarlabs.utilities.PasswordConverter;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
   
   public static void main(String[] args) throws IOException {
      
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
               try {
                  // Trying to pause the window from closing but close anyway if it can't pause
                  TimeUnit.SECONDS.sleep(10);
                  System.exit(0);
               } catch (InterruptedException e) {
                  System.exit(0);
               }
            default:
               System.out.println("Invalid choice, please try again");
         }
      } while (failedLogins < 3);
      
      systemUsers.closeFile();
   }
   
   private static void logInScreen() {
      System.out.println("Welcome to Zoo Command & Control\nPlease enter your username ");
      userInput = scanner.next();
      user.setUsername(userInput);
      sam.findUsername(user.getUsername());
      System.out.println("Please enter your password");
      userInput = scanner.next();
      user.setPassword(hasher.convertToHash(userInput));
      if(!sam.doesUsernameMatch(user.getUsername()) || !sam.doesPasswordMatch(user.getPassword())) {
         failedLogin();
      }
      else {
         showUserFile(user.getUsername());
      }
   }
   
   private static void showUserFile(String username) {
      //TODO take username and match it to the file name after removing txt
      // - Then display file to screen
      userFile.setFile(username + ".txt");
      System.out.println(userFile.getFile());
      userFile.closeFile();
   }
   
   private static void failedLogin() {
      failedLogins++;
      System.out.println("Username or password is incorrect!");
   }
   
   
   
   private static UserCredential user = new UserCredential();
   private static PasswordConverter hasher = new PasswordConverter();
   private static TextReader userFile = new TextReader();
   private static TextReader systemUsers = new TextReader();
   private static SecureAccountManager sam = new SecureAccountManager();
   private static Scanner scanner = new Scanner(System.in);
   private static int failedLogins = 0;
   private static String userInput = "";
}
