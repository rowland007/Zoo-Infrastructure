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
 17FEB2019   Changed next() to nextLine() to get passwords with spaces
 17FEB2019   Set each user file to a variable and created a stream loop
 18FEB2019   Change from clear text to hashed passwords
 18FEB2019   Handle the Exception thrown from the user's file
 20FEB2019   Remove System.exit after user's file is displayed
 20FEB2019   Add extra whitespace to output for readability
 20FEB2019   Add Enter to continue and clear screen
 ************************************************************************/

import com.randarlabs.common.TextReader;
import com.randarlabs.common.UserCredential;
import com.randarlabs.security.SecureAccountManager;
import com.randarlabs.utilities.PasswordConverter;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
   
   public static void main(String[] args) {
      do {
         System.out.println("Please enter your choice:");
         System.out.println("L - Login to Zoo Command & Control");
         System.out.println("Q - Quit program");
         String choice = scanner.next();
         switch (choice) {
            case "L":
            case "l":
               scanner.nextLine();
               logInScreen();
               break;
            case "Q":
            case "q":
               System.out.println("Goodbye");
               try {
                  // Trying to pause the window from closing but close anyway if it can't pause
                  TimeUnit.SECONDS.sleep(5);
                  System.exit(0);
               } catch (Exception e) {
                  System.exit(0);
               }
            default:
               System.out.println("Invalid choice, please try again");
         }
      } while (failedLogins < 3);
   }
   
   private static void logInScreen() {
      clearScreen();
      System.out.println("Welcome to Zoo Command & Control\nPlease enter your username ");
      userInput = scanner.nextLine();
      user.setUsername(userInput);
      sam.setEnteredUsername(user.getUsername());
      System.out.println("Enter your password");
      userInput = scanner.nextLine();
      user.setPassword(userInput);
      user.setPassword(hasher.convertToHash(user.getPassword()));
      sam.setEnteredPassword(user.getPassword());
      if (sam.isValidAccount()) {
         System.out.println("\r\n");
         showUserFile();
         System.out.println("\r\n");
         pressAnyKeyToContinue();
      } else {
         failedLogin();
      }
   }
   
   private static void showUserFile() {
      if(sam.getUserGroup().equals("admin")) {
         userFile.setFile(adminTextFile);
      } else if(sam.getUserGroup().equals("veterinarian")) {
         userFile.setFile(vetTextFile);
      } else if(sam.getUserGroup().equals("zookeeper")) {
         userFile.setFile(zookeeperTextFile);
      }
      try {
         clearScreen();
         String lineOfText = "";
         while((lineOfText = userFile.getNextLine()) != null)
         {
            System.out.println(lineOfText);
         }
         userFile.closeFile();
      } catch (NoSuchElementException e) {
         // Ignore the blank space in the user's file.
      } catch (Exception e) {
         System.err.println("Error with user's file because of " + e);
      }
   }
   
   private static void failedLogin() {
      failedLogins++;
      System.out.println("Username or password is incorrect!");
   }
   
   private static void pressAnyKeyToContinue()
   {
      System.out.println("Press \"Enter\" key to continue...");
      try
      {
         System.in.read();
         clearScreen();
      }
      catch(Exception e)
      {}
   }
   
   private static void clearScreen() {
      try
      {
         final String os = System.getProperty("os.name");
      
         if (os.contains("Windows"))
         {
            Runtime.getRuntime().exec("cls");
         }
         else
         {
            Runtime.getRuntime().exec("clear");
         }
      }
      catch (final Exception e)
      {
         //  Handle any exceptions.
      }
   }
   
   private static UserCredential user = new UserCredential();
   private static PasswordConverter hasher = new PasswordConverter();
   private static TextReader userFile = new TextReader();
   private static TextReader systemUsers = new TextReader();
   private static SecureAccountManager sam = new SecureAccountManager();
   private static Scanner scanner = new Scanner(System.in);
   private static int failedLogins = 0;
   private static String userInput = "";
   private final static String adminTextFile = "Docs/Authentication/admin.txt";
   private final static String zookeeperTextFile = "Docs/Authentication/zookeeper.txt";
   private final static String vetTextFile = "Docs/Authentication/veterinarian.txt";
}