#Account
#User should be able to get rates of the seller.
#https://test.urbanicfarm.com/api/account/feedback/seller/getRates
#Details on the swagger document.
  @US084
  Feature: US084 As a user, I should be able to get rates of the seller.
    Scenario:US084 As a user, I should be able to get rates of the seller.
      Given  User goes to api for rates
      When User get to rates of the seller
      Then User verify success is true
