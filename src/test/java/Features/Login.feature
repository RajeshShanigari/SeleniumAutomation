Feature: Login feature

  Scenario Outline: Login with valid credentials
    Given the user navigates to the login page
    When the user enters username "<username>" and password "<password>"
    And user clicks the login button
    Then the user should be redirected to the dashboard

    Examples:
      | username | password |
      | Admin    | admin123 |


  Scenario Outline: Login with Excel data
    Given the user navigates to the login page
    When the user logs in using Excel data row <row>
    And user clicks the login button
    Then the user should be redirected to the dashboard

    Examples:
      | row |
      | 1   |

