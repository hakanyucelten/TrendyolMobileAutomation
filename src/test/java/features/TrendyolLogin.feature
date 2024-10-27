@LoginPage
  Feature: Login Page Test Scenarios

    @Check
    Scenario: Check Login Page Components
      When Click to "TrendyolApp" Button
      When Wait for 3 seconds
      When Send "gomlek" text to element "SearchButton"
      When Swipe right from "YemekButton"
      When Scroll down
      When Click to "SepetimButton" Button


#swipe su an calismiyor duzgun gerisi calisiyor