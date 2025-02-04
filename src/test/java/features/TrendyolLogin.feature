@TrendyolAutomation
  Feature: Trendyol Automation Test Scenarios

    @AddToBasket
    Scenario: Write text to search bar and send product to basket according to that
      When Click to "TrendyolApp" Button
      When Wait for 3 seconds
      When Click to "SearchButton" Button
      When Send "gomlek" text to element "SearchButton"
      When Click to "GomlekFromResults" Button
      When Click to "product1" Button
      When Click to "AddToBasketButton" Button
      When Click to "ChooseSize" Button
      When Click to "AddToBasketButton" Button
      When Scroll down
      When Click to "AnasayfaButton" Button
      Then Press Android Back Button


    @DeleteBasket
    Scenario: Make basket empty then go to main page to initial step
      When Click to "SepetimButton" Button
      When Click to "SepetimDeleteButton" Button
      When Click to "DeleteOnayButton" Button
      When Click to "AnasayfaButton" Button
      When Click to "AnasayfaButton" Button
      When Click to "ServicesMessage" Button





