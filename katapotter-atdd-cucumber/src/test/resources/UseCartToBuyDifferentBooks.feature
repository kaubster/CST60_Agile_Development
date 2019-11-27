Feature: Cart discounts encourage buying multiple books in the series

  Scenario Outline: Customer buys 2 of seperate books for 5% discount
    Given the user chose <b1_count> of book 1
    Given the user chose <b2_count> of book 2
    Given the user chose <b3_count> of book 3
    Given the user chose <b4_count> of book 4
    Given the user chose <b5_count> of book 5
    When the user checks out
    Then the system should charge <float> EUR

    Examples: 
      | b1_count | b2_count | b3_count | b4_count | b5_count | float |
      |        1 |        1 |        0 |        0 |        0 |  15.2 |
      |        1 |        0 |        1 |        0 |        1 |  21.6 |
      |        1 |        1 |        1 |        1 |        0 |  25.6 |
      |        1 |        1 |        1 |        1 |        1 |    30 |

  Scenario Outline: Customer buys 3 of seperate books for 10% discount
    Given the user chose <b1_count> of book 1
    Given the user chose <b2_count> of book 2
    Given the user chose <b3_count> of book 3
    Given the user chose <b4_count> of book 4
    Given the user chose <b5_count> of book 5
    When the user checks out
    Then the system should charge <float> EUR

    Examples: 
      | b1_count | b2_count | b3_count | b4_count | b5_count | float |
      |        1 |        0 |        1 |        0 |        1 |  21.6 |

  Scenario Outline: Customer buys 4 of seperate books for 20% discount
    Given the user chose <b1_count> of book 1
    Given the user chose <b2_count> of book 2
    Given the user chose <b3_count> of book 3
    Given the user chose <b4_count> of book 4
    Given the user chose <b5_count> of book 5
    When the user checks out
    Then the system should charge <float> EUR

    Examples: 
      | b1_count | b2_count | b3_count | b4_count | b5_count | float |
      |        1 |        1 |        1 |        1 |        0 |  25.6 |

  Scenario Outline: Customer buys all 5 of books for 25% discount
    Given the user chose <b1_count> of book 1
    Given the user chose <b2_count> of book 2
    Given the user chose <b3_count> of book 3
    Given the user chose <b4_count> of book 4
    Given the user chose <b5_count> of book 5
    When the user checks out
    Then the system should charge <float> EUR

    Examples: 
      | b1_count | b2_count | b3_count | b4_count | b5_count | float |
      |        1 |        1 |        1 |        1 |        1 |    30 |
