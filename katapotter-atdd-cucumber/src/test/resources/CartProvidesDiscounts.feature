Feature: Cart permit discount combinations

  Scenario Outline: Cart discounts 5% for 2 volumes in series plus normal price for additional copy
    Given the user chose <b1_count> of book 1
    Given the user chose <b2_count> of book 2
    Given the user chose <b3_count> of book 3
    Given the user chose <b4_count> of book 4
    Given the user chose <b5_count> of book 5
    When the user checks out
    Then the system should charge <float> EUR

    Examples: 
      | b1_count | b2_count | b3_count | b4_count | b5_count | float |
      |        2 |        1 |        0 |        0 |        0 |  23.2 |
      
  Scenario Outline: Cart discounts 5% for each pair of volumes in series
    Given the user chose <b1_count> of book 1
    Given the user chose <b2_count> of book 2
    Given the user chose <b3_count> of book 3
    Given the user chose <b4_count> of book 4
    Given the user chose <b5_count> of book 5
    When the user checks out
    Then the system should charge <float> EUR

    Examples: 
      | b1_count | b2_count | b3_count | b4_count | b5_count | float |
      |        2 |        2 |        0 |        0 |        0 |  30.4 |
      
  Scenario Outline: Cart discounts 20% for 4 volumes plus 5% for 2 volumes
    Given the user chose <b1_count> of book 1
    Given the user chose <b2_count> of book 2
    Given the user chose <b3_count> of book 3
    Given the user chose <b4_count> of book 4
    Given the user chose <b5_count> of book 5
    When the user checks out
    Then the system should charge <float> EUR

    Examples: 
      | b1_count | b2_count | b3_count | b4_count | b5_count | float |
      |        2 |        1 |        2 |        1 |        0 |  40.8 |
      
   Scenario Outline: Cart discounts 25% for all 5 volumes plus the price of 2 more copies of a single volumes
    Given the user chose <b1_count> of book 1
    Given the user chose <b2_count> of book 2
    Given the user chose <b3_count> of book 3
    Given the user chose <b4_count> of book 4
    Given the user chose <b5_count> of book 5
    When the user checks out
    Then the system should charge <float> EUR

    Examples: 
      | b1_count | b2_count | b3_count | b4_count | b5_count | float |
      |        1 |        2 |        1 |        1 |        1 |    38 |
