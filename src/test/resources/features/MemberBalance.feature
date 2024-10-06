Feature: Balance verification

  Scenario: Member balance is correctly displayed on the page
    Given user navigates to Lucky Bandit Sports section
    When user logs in
    Then user member balance is the same both on the Page and in the API