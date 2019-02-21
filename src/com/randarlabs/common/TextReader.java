package com.randarlabs.common;

/************************************************************************
 Program:           Zoo Infrastructure
 Author:            Randall Rowland
 Class:             IT-145 Foundations in App Development
 Instructor:        Jim Barringer
 Date:              30 Jan 2019
 Description:       Get input from a text file
 Input:             FileInputStream
 Output:            stdout
 Known bugs:
 Missing features:
 
 License:           GNU General Public License v3.0
 Modifications:
    Date                      Comment
 ---------   ------------------------------------------------
 2FEB2019    Added getNextXXXX methods from Scanner
 17FEB2019   Add method to set a delimiter
 20FEB2019   Remove delimiter variable from class
 20FEB2019   Add javadoc comments
 ************************************************************************/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Used to open and read text files
 * @author Randall Rowland
 * @version 1.0
 */
public class TextReader {
   
   /**
    * Default constructor that initializes private fields to <code>null</code>.
    */
   public TextReader() {
      fileByteStream = null;
      inFileStream = null;
   }
   
   /**
    * Uses a <code>FileInputStream</code> and <code>Scanner</code> to obtain
    * input bytes from a file in a file system. This creates an opening connection
    * to an actual file, the file name by the <code>fileName</code> argument.
    *
    * @param fileName the directory path and file name to be opened for reading
    * @throws IOException if the file does not exist, is a directory rather than a
    * regular file, or for some other reason cannot be opened for reading.
    */
   public void setFile(String fileName) {
      try {
         fileByteStream = new FileInputStream(fileName);
         inFileStream = new Scanner(fileByteStream);
      }
      catch (IOException e) {
         System.err.println("Error opening file at " + fileName);
         System.out.println("Please place file at that location with that name and try again.");
      }
   }
   
   /**
    * Returns the connection to the actual file in the file system being used by the <code>Scanner</code>.
    * @return Bytes from the stream are converted into characters using the underlying <code>FileInputStream</code>.
    */
   public final Scanner getFile() {
      return inFileStream;
   }
   
   /**
    * Closes this file input stream and releases any system resources associated with the stream.
    * If this stream has an associated channel then the channel is closed as well.
    * @throws IOException if an I/O error occurs.
     */
   public void closeFile() {
      try {
         fileByteStream.close();
      }
      catch (IOException e) {
         System.err.println("Error closing file");
         for(int i = 1; i <= 3; i++) {
            System.out.println("Trying to close file again, try #" + i);
            try {
               fileByteStream.close();
            }
            catch (IOException e1) {
               //ignore this exception
            }
         }
         System.out.println("Tries exhausted, giving up...");
      }
   }
   
   /**
    * Advances this scanner past the current line and returns the input that was skipped.
    * This method returns the rest of the current line, excluding any line separator at the end.
    * The position is set to the beginning of the next line.
    *
    * Since this method continues to search through the input looking for a line separator,
    * it may buffer all of the input searching for the line to skip if no line separators are present.
    *
    * @return the line that was skipped
    */
   public final String getNextLine() {
      return inFileStream.nextLine();
   }
   
   /**
    * Finds and returns the next complete token from this scanner. A complete token is preceded
    * and followed by input that matches the delimiter pattern. This method may block while
    * waiting for input to scan, even if a previous invocation of hasNext() returned true.
    *
    * @return the next token
    */
   public final String getNextWord() {
      return inFileStream.next();
   }
   
   /**
    * Scans the next token of the input as an int.
    *
    * @return the <code>int</code> scanned from the input
    */
   public final int getNextInteger() {
      return inFileStream.nextInt();
   }
   
   /**
    * Scans the next token of the input as a double.
    * This method will throw <code>InputMismatchException</code> if the next token cannot
    * be translated into a valid double value. If the translation is successful, the scanner
    * advances past the input that matched.
    *
    * If the next token matches the Float regular expression defined above then the token is
    * converted into a double value as if by removing all locale specific prefixes, group separators,
    * and locale specific suffixes, then mapping non-ASCII digits into ASCII digits via
    * <code>Character.digit</code>, prepending a negative sign (-) if the locale specific negative prefixes and
    * suffixes were present, and passing the resulting string to <code>Double.parseDouble</code>.
    * If the token matches the localized NaN or infinity strings, then either "Nan"
    * or "Infinity" is passed to <code>Double.parseDouble</code> as appropriate.
    *
    * @return the double scanned from the input
    */
   public final double getNextDouble() {
      return inFileStream.nextDouble();
   }
   
   /**
    * Scans the next token of the input as a <code>byte</code>.
    *
    *  @return the <code>byte</code> scanned from the input
    */
   public final byte getNextByte() {
      return inFileStream.nextByte();
   }
   
   /**
    * Returns true if this scanner has another token in its input.
    * This method may block while waiting for input to scan. The scanner does not advance past any input.
    *
    * @return true if and only if this scanner has another token
    */
   public final boolean hasNext() {
      return inFileStream.hasNext();
   }
   
   /**
    * Sets this scanner's delimiting pattern to a pattern constructed from the specified String.
    * An invocation of this method of the form <code>useDelimiter(pattern)</code> behaves in exactly the same
    * way as the invocation <code>useDelimiter(Pattern.compile(pattern))</code>.
    *
    * Invoking the reset() method will set the scanner's delimiter to the default.
    *
    * @param delimiter A string specifying a delimiting pattern
    */
   public void useDelimiter(String delimiter) {
      inFileStream.useDelimiter(delimiter);
   }
   
   private FileInputStream fileByteStream;
   private Scanner inFileStream;

}