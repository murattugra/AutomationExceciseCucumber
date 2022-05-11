Feature: Register User

  Scenario: User register


  Given Navigate to url "automation_url"
  And Verify that home page is visible successfully
  And Click on 'Signup / Login' button
  Then Verify 'New User Signup!' is visible
  And Enter name and email address
  When Click 'Signup' button
  Then Verify that 'ENTER ACCOUNT INFORMATION' is visible
  And Fill details: Title, Name, Email, Password, Date of birth
  And Select checkbox 'Sign up for our newsletter!'
  Then Select checkbox 'Receive special offers from our partners!'
  And Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
  Then Click 'Create Account button' button
  And Verify that 'ACCOUNT CREATED!' is visible
  When Click 'Continue' button
  Then Verify that 'Logged in as username' is visible
  And Click 'Delete Account' button
  And Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
