import com.randarlabs.utilities.PasswordConverter;

public class Md5Tester {
   
   public static void main(String[] args) {
      
      System.out.println("START TESTING:");
      
      System.out.println(pc.convertToHash(passwd1));
      assert (pc.convertToHash(passwd1).equals("108de81c31bf9c622f76876b74e9285f")) : "TEST FAILED: alphabet soup != 108de81c31bf9c622f76876b74e9285f";
   
      System.out.println(pc.convertToHash(passwd2));
      assert (pc.convertToHash(passwd2).equals("3e34baa4ee2ff767af8c120a496742b5")) : "TEST FAILED: animal doctor != 3e34baa4ee2ff767af8c120a496742b5";
   
      System.out.println(pc.convertToHash(passwd3));
      assert (pc.convertToHash(passwd3).equals("a584efafa8f9ea7fe5cf18442f32b07b")) : "TEST FAILED: secret password != a584efafa8f9ea7fe5cf18442f32b07b";
   
      System.out.println(pc.convertToHash(passwd4));
      assert (pc.convertToHash(passwd4).equals("17b1b7d8a706696ed220bc414f729ad3")) : "TEST FAILED: M0nk3y business != 17b1b7d8a706696ed220bc414f729ad3";
   
      System.out.println(pc.convertToHash(passwd5));
      assert (pc.convertToHash(passwd5).equals("3adea92111e6307f8f2aae4721e77900")) : "TEST FAILED: grizzly1234 != 3adea92111e6307f8f2aae4721e77900";
   
      System.out.println(pc.convertToHash(passwd6));
      assert (pc.convertToHash(passwd6).equals("0d107d09f5bbe40cade3de5c71e9e9b7")) : "TEST FAILED: letmein != 0d107d09f5bbe40cade3de5c71e9e9b7";
      
      System.out.println("TESTS COMPLETE");
   
   }
   
   private static PasswordConverter pc = new PasswordConverter();
   private final static String passwd1 = "alphabet soup";
   private final static String passwd2 = "animal doctor";
   private final static String passwd3 = "secret password";
   private final static String passwd4 = "M0nk3y business";
   private final static String passwd5 = "grizzly1234";
   private final static String passwd6 = "letmein";
}