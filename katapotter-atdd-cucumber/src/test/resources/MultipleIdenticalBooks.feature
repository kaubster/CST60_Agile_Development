Feature: Buy multiple identical books testing simple discounts

  Scenario Outline: Buy many of single book
    Given the user chose <count> of book <book>
    When the user checks out
    Then the system should charge <cost> EUR

    Examples: 
      | book | count | cost |
      |    1 |     2 |   16 |
      |    2 |     3 |   24 |
      |    3 |     4 |   32 |
      |    4 |     5 |   40 |
      |    5 |     6 |   48 |
