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
 ************************************************************************/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class TextReader {

   public TextReader() {
      fileByteStream = null;
      inFileStream = null;
   }
   
   public void setFile(String fileName) {
      try {
         fileByteStream = new FileInputStream(fileName);
         inFileStream = new Scanner(fileByteStream);
      }
      catch (IOException e) {
         System.err.println("Error getting file");
      }
   }
   
   public final Scanner getFile() {
      return inFileStream;
   }
   
   public void closeFile() {
      try {
         fileByteStream.close();
      }
      catch (IOException e) {
         System.err.println("Error closing file");
      }
   }
   
   private FileInputStream fileByteStream;
   private Scanner inFileStream;
}