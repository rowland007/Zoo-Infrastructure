# Pseudocode

* **Program:** Zoo Authentication Infrastructure
* **Author:** Randall Rowland
* **Class:** IT-145 Foundations in App Development
* **Instructor:** Jim Barringer
* **Date:** 26 Jan 2019
* **Input:**
    * stdin
    * credentials file
    * text file
* **Output:** stdout
* **License:** [GNU General Public License v3.0](https://github.com/rowland007/Zoo-Infrastructure/blob/master/LICENSE.md)

----

## Description

For security-minded professionals, it is important that only the appropriate people gain access to data in a computer system. This is called authentication. Once users gain entry, it is also important that they only see data related to their role in a computer system. This is called authorization. For the zoo, you will develop an authentication system that manages both authentication and authorization. You have been given a credentials file that contains credential information for authorized users. You have also been given three files, one for each role: zookeeper, veterinarian, and admin. Each role file describes the data the particular role should be authorized to access. Create an authentication system that does all of the following: takes in a username and password and compares it to the credentials file. Allow the user to exit the program. Exit the program after three failed logins. Display the users text file after successfully logging in.

----

## Pseudocode

Start LOOP<br>
└─DISPLAY login/exit menu on the screen<br>
&nbsp;&nbsp;&nbsp;&nbsp;├─EXIT will allow the user to quit the program<br>
&nbsp;&nbsp;&nbsp;&nbsp;└─LOGIN will ask for username and password<br>
END LOOP upon successful LOGIN; 3 failures will quit the program

LOGIN<br>
└─ASK for username and password<br>
&nbsp;&nbsp;&nbsp;&nbsp;├─CHECK username against `credential file`<br>
&nbsp;&nbsp;&nbsp;&nbsp;├─IF username does not exists go back to DISPLAY LOOP<br>
&nbsp;&nbsp;&nbsp;&nbsp;└─IF username does exist, convert plaintext password into MD5 hash<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;├─COMPARE MD5 hash against `credential file`<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;├─IF MD5 hash does not match, go back to DISPLAY LOOP<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;├─FIND `text file` that matches  username<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;├─DISPLAY `text file` to screen<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─QUIT Program