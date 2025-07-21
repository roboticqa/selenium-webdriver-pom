
# language: en
Feature: RoboticQA Cart Application Functionality
  As a user, I want to interact with the RoboticQA Cart application
  to ensure all features are working as expected.

  Background:
    Given I am on the application's authentication page

  @authentication
  Scenario: Successful Login with Standard User
    Given I enter "standard_user" in the "Username or Email" field
    And I enter "password123" in the "Password" field
    When I click the "Sign In" button
    Then I should be redirected to the main dashboard
    And a success message "Welcome back!" should be displayed

  @authentication
  Scenario: Failed Login with Incorrect Password
    Given I enter "standard_user" in the "Username or Email" field
    And I enter "wrongpassword" in the "Password" field
    When I click the "Sign In" button
    Then I should remain on the login page
    And an error message "Invalid credentials. Please try again." should be displayed

  @registration
  Scenario: Successful New User Registration
    Given I navigate to the registration page
    And I enter a unique username "new_tester"
    And I enter a unique email "new_tester@example.com"
    And I enter and confirm the password "password123"
    When I click the "Create Account" button
    Then a success message "Registration successful! Note: You can only log in with the 3 pre-defined test users." should be displayed

  @dashboard_basic_controls
  Scenario: Interact with Basic Web Controls
    Given I am logged in as a "standard_user"
    And I am on the "Testing Ground" tab
    When I check the "Subscribe" checkbox
    And I select "Option Two" from the radio group
    And I type "Testing basic controls" into the text input
    Then the "Subscribe" checkbox should be checked
    And "Option Two" should be selected
    And the text input should contain "Testing basic controls"

  @dashboard_complex_controls
  Scenario: Interact with Date Picker
    Given I am logged in as a "standard_user"
    And I am on the "Testing Ground" tab
    When I open the date picker
    And I select the 15th day of the current month
    Then the date picker input should display the 15th day of the current month

  @dashboard_complex_controls
  Scenario: Interact with Multi-select Dropdown
    Given I am logged in as a "standard_user"
    And I am on the "Testing Ground" tab
    When I open the multi-select dropdown
    And I select "React" and "Vue" from the options
    Then the multi-select dropdown should show "React" and "Vue" as selected

  @dashboard_complex_controls
  Scenario: Interact with Accordion
    Given I am logged in as a "standard_user"
    And I am on the "Testing Ground" tab
    When I click on the "Is it styled?" accordion trigger
    Then the accordion content "Yes. It comes with default styles..." should be visible

  @dashboard_advanced_controls
  Scenario: Interact with Drag and Drop
    Given I am logged in as a "standard_user"
    And I am on the "Testing Ground" tab
    When I drag "Item 1" and drop it on "Item 3"
    Then "Item 1" should be positioned after "Item 2"

  @dashboard_advanced_controls
  Scenario: Interact with Shadow DOM
    Given I am logged in as a "standard_user"
    And I am on the "Testing Ground" tab
    When I type "Hello from the outside" into the input inside the Shadow DOM
    Then the value of the input inside the Shadow DOM should be "Hello from the outside"

  @dashboard_advanced_controls
  Scenario: Interact with Hover-Dependent Element
    Given I am logged in as a "standard_user"
    And I am on the "Testing Ground" tab
    When I hover over the hover-dependent element
    Then the popup "You found me!" should become visible

  @dashboard_advanced_controls
  Scenario: Interact with Simulated Authentication Popup
    Given I am logged in as a "standard_user"
    And I am on the "Testing Ground" tab
    When I click the "Trigger Auth" button
    Then the simulated authentication modal should appear
    And I enter "testuser" in the modal's username field
    And I click the modal's "Sign In" button
    Then the modal should close

  @general
  Scenario: Successful User Logout
    Given I am logged in
    When I click the "Logout" button in the header
    Then I should be redirected to the login page
