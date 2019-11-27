Feature: Cart allows for buying a single book without discount

  Scenario Outline: Customer buys book 1
    Given the user chose book <book>
    When the user checks out
    Then the system should charge <cost> EUR

    Examples: 
      | book | cost |
      |    1 |    8 |

  Scenario Outline: Customer buys book 2
    Given the user chose book <book>
    When the user checks out
    Then the system should charge <cost> EUR

    Examples: 
      | book | cost |
      |    2 |    8 |

  Scenario Outline: Customer buys book 3
    Given the user chose book <book>
    When the user checks out
    Then the system should charge <cost> EUR

    Examples: 
      | book | cost |
      |    3 |    8 |

  Scenario Outline: Customer buys book 4
    Given the user chose book <book>
    When the user checks out
    Then the system should charge <cost> EUR

    Examples: 
      | book | cost |
      |    4 |    8 |

  Scenario Outline: Customer buys book 5
    Given the user chose book <book>
    When the user checks out
    Then the system should charge <cost> EUR

    Examples: 
      | book | cost |
      |    5 |    8 |
