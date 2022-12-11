Feature: Creating an account on Software testing board webpage

  Scenario Outline: Creating new customer account

    Given New user is on "https://magento.softwaretestingboard.com/"

    When User clicks on Create an Account in the top menu bar

    And  User enters "<firstname>", "<lastname>", "<email>", "<password>", "<confirmPassword>"

    And Clicks on Create and Account button

    Then  User account has been created nad user is logged into his account

    Examples:
    |firstname  |lastname     |email            |password       |confirmPassword  |
    |Ala        | Kowalska    |ala.k@wp.pl      |Password!1     |Password!1       |
#    |Kacper     | Tuk         |kacper.t@wp.pl   |Password!2     |Password!2       |