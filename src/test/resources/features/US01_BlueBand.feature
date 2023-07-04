Feature: Selecting checkbox in PrimeReact DataTable
@wip
  Scenario: Select checkbox against the row with the name "Blue Band"

    Given I navigate to the url
    Then I should be on the DataTable selection page
    When I scroll down until Checkbox selection
    And I select the checkbox against the row with the name "Blue Band"
    And the checkbox for "Blue Band" should be selected