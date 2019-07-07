@tag
Feature: String Padding

  @tag1
  Scenario Outline: given <input> string and direction <direction> and padding char <character> and overall length <length> return an padded string <output>
    When I provide a raw string: "<input>", a padding direction: "<direction>", a padding character: "<character>", and an overall length: <length>
    Then a properly padded string: "<output>" is returned

    Examples: 
      | input | direction | character | length | output                                                      |
      |   123 | left      |         0 |     10 |                                                  0000000123 |
      | Start | right     | .         |     10 | Start.....                                                  |
