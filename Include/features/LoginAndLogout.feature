Feature: Login and logout functionality 
 
  Scenario: Check login successful!
    Given user to navigate on login page
    When text for sign in is verified
    And user click on the button
    Then user navigated to access management
    
    
  Scenario: Check logout completed    
       When user click on logout button
       And chooses the option yes
       Then user navigated to login page again
       

   