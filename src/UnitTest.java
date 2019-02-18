import com.randarlabs.common.TextReader;
import com.randarlabs.common.UserCredential;
import com.randarlabs.security.SecureAccountManager;
import com.randarlabs.utilities.PasswordConverter;

public class UnitTest {
   
   public static void main(String[] args) {
      user1.setUsername("griffin.keyes");
      user1.setPassword("alphabet soup");
      userTest(user1);
      
      user2.setUsername("rosario.dawson");
      user2.setPassword("animal doctor");
      userTest(user2);
      
      user3.setUsername("bernie.gorilla");
      user3.setPassword("secret password");
      userTest(user3);
      
      user4.setUsername("donald.monkey");
      user4.setPassword("M0nk3y business");
      userTest(user4);
      
      user5.setUsername("jerome.grizzlybear");
      user5.setPassword("grizzly1234");
      userTest(user5);
      
      user6.setUsername("bruce.grizzlybear");
      user6.setPassword("letmein");
      userTest(user6);
      
      System.out.println("\n\n DUMPING SAM ARRAYS");
      sam.getUserNames();
      sam.getUserPasswords();
      sam.getUserPasswordsClearText();
      sam.getUserGroups();
   }
   
   private static void userTest(UserCredential user) {
      System.out.println("TESTING USER " + user.getUsername() + " *****");
      sam.setEnteredUsername(user.getUsername());
      sam.setEnteredPassword(user.getPassword());
      System.out.println("Setting up hash");
      sam.setEnteredPassword(hasher.convertToHash(user.getPassword()));
      if(sam.isValidAccount()) {
         System.out.println("Hash found!");
         System.out.println("************************" + user.getUsername() + " TEST COMPLETE **************************");
      } else {
         System.out.println("ERROR ERROR:  HASH NOT FOUND");
         System.out.println("********************" + user.getUsername() + " TEST COMPLETE **************************");
      }
   }
   
   private static UserCredential user1 = new UserCredential();
   private static UserCredential user2 = new UserCredential();
   private static UserCredential user3 = new UserCredential();
   private static UserCredential user4 = new UserCredential();
   private static UserCredential user5 = new UserCredential();
   private static UserCredential user6 = new UserCredential();
   
   private static PasswordConverter hasher = new PasswordConverter();
   private static TextReader userFile = new TextReader();
   private static TextReader systemUsers = new TextReader();
   private static SecureAccountManager sam = new SecureAccountManager();
}

/**
 griffin.keyes	            "alphabet soup"
 rosario.dawson		      "animal doctor"
 bernie.gorilla		      "secret password"
 donald.monkey		         "M0nk3y business"
 jerome.grizzlybear		   "grizzly1234"
 bruce.grizzlybear		   "letmein"
 */