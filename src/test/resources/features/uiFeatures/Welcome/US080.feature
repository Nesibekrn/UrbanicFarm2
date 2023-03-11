Feature: US080



    #Contact us
    #The Contact us head at the top of the Welcome Page should appear
    #Contact us head should be clickable
    #When the Contact us head is clicked, the Get in Touch page should appear
    #When SEND MESSAGE is clicked without entering any information, alerts such as "Please enter a valid name, Please enter a valid email address, Please enter a message with at least 10 characters." should be displayed.
    #After entering the required information, click SEND MESSAGE
    #After the message is sent, an alert should appear that the message has been successfully delivered. ''Thanks for your message. It has been sent to us

  Background: Contact Page
    Given User goes to home page

  @UI
  @US080
  Scenario:US080_TC1 Contact Page

    And The Contact us head at the top of the Welcome Page should appear
    And Contact us head should be clickable
    And the Contact us head is clicked, the Get in Touch page should appear
    Then SEND MESSAGE is clicked without entering any information, alerts such as Please enter a valid name
    Then Please enter a valid email address,
    Then Please enter a message with at least 10 characters." should be displayed.

  #@UI
  #@US080
  #Scenario:US080_TC2 Contact Page




