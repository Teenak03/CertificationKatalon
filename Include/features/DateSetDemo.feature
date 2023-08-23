Feature: Set date function
  
  Scenario Outline: set date on the website
    Given user navigated to the website
    When verify text and click date
    And sets <date> according to choice
    Then close the browser
    
    Examples:
    |date|
    |19-November-2023|
