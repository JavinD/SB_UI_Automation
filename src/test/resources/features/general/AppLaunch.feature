Feature: App Launch Verification
  As a tester
  I want to verify the app launches successfully
  So that I can confirm my test setup is working

  @smoke @launch
  Scenario: Verify app launches successfully
    Given the app is launched
    Then I should see the catalog page

