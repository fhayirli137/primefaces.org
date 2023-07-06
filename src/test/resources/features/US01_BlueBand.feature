Feature: Selecting checkbox in PrimeReact DataTable
@wip
  Scenario: Select checkbox against the row with the name "Blue Band"

    Given I navigate to the url
    When I scroll down until Checkbox selection
    And I select the checkbox against the row with the name "Blue Band" in "checkbox" section
    And the checkbox for Blue Band should be selected