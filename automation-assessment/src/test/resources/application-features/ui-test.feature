Feature: UI - Test Assessment

  @Assessment-UI
  Scenario: Validate mandatory email address message in checkout page
    Given I navigate to home page url
    When I checkout as guest without email id
    Then I should see mandatory email address error message
