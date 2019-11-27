Feature: Cart permits buying many of a single book but does not provide a discount

  Scenario Outline: Customer buys 1 book
    Given the user chose <count> of book <book>
    When the user checks out
    Then the system should charge <cost> EUR

    Examples: 
      | book | count | cost |
      |    1 |     1 |   8 |

  Scenario Outline: Customer buys 2 of book one
    Given the user chose <count> of book <book>
    When the user checks out
    Then the system should charge <cost> EUR

    Examples: 
      | book | count | cost |
      |    1 |     2 |   16 |
    
  Scenario Outline: Customer buys 3 of book one
    Given the user chose <count> of book <book>
    When the user checks out
    Then the system should charge <cost> EUR

    Examples: 
      | book | count | cost |  
      |    2 |     3 |   24 |
