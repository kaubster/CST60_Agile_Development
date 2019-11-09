Feature: Buying a single book testing basics

  Scenario Outline: Buy book 1
    Given the user chose book <book>
    When the user checks out
    Then the system should charge <cost> EUR

    Examples: 
      | book | cost |
      |    1 |    8 |
      |    2 |    8 |
      |    3 |    8 |
      |    4 |    8 |
      |    5 |    8 |
