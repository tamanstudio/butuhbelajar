Feature: Test Aplikasi Saucedemo

  Scenario: Success Login
    Given Halaman login saucedemo
    When Input username
    And Input password
    And Click login button
    Then User direct to Dashboard Page

  Scenario: Failed Login
    Given Halaman login saucedemo
    When Input username
    And Input Invalid password
    And Click login button
    Then User get error message

    Scenario: Logout
      Given Halaman login saucedemo
      When Input username
      And Input password
      And Click login button
      And User direct to Dashboard Page
      When User click burger menu
      And User click Logout
      Then User Logout

  Scenario: User Add Product to Cart
    Given Halaman login saucedemo
    When Input username
    And Input password
    And Click login button
    And User Add Product
    And User Click Icon Cart
    Then User Direct to Page Cart
    And User Click Checkout Button
    When User Input Firts Name
    And User Input Last Name
    And User Input PostCode
    And User Click Continue Button
    Then User Directed to Overview Page
    And User Click Finish Button
    Then User Directed to Complete Order Page
    When User Click Back Home Button
    Then User Back to Home Page
