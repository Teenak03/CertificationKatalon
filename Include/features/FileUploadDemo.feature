Feature: File upload automation 

 Scenario Outline: upload file on the website
     Given user is navigated to the website
     When user chooses <file> 
     And click upload 
     Then verify upload and exit browser
 
    Examples:
       |file |
       |C:\Users\teena\OneDrive\Documents\Pictures\newimg.png|
    