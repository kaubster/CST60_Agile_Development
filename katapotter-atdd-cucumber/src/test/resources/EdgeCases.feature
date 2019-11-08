Feature: Buy a Different Books

  Scenario Outline: Buy several where smaller set is cheaper
    Given the user chose <b1_count> of book 1
    Given the user chose <b2_count> of book 2
    Given the user chose <b3_count> of book 3
    Given the user chose <b4_count> of book 4
    Given the user chose <b5_count> of book 5
    When the user checks out
    Then the system should charge <float> EUR

    Examples: 
      | b1_count | b2_count | b3_count | b4_count | b5_count | float |
      |        2 |        2 |        2 |        1 |        1 |  51.2 |
      #|        5 |        5 |        4 |        5 |        4 | 141.2 |
