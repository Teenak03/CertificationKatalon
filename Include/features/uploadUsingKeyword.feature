Feature: uploading file using keyword
  
  Scenario Outline: use of keyword to upload my file
    Given navigate to the website
    When select the <file>
    And click the upload button
    Then Exit the browser
    
    Examples:
    |file|
    |C:\Users\teena\OneDrive\Documents\Pictures\img.jpg|
    