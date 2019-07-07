package io.pointgenesis.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs {
	private String result = "";
	private static final Logger log = LogManager.getLogger();
	
	@When("I provide a raw string: {string}, a padding direction: {string}, a padding character: {string}, and an overall length: {int}")
	public void i_provide_a_raw_string_a_padding_direction_a_padding_character_and_an_overall_length(String input, String direction, String character, Integer length) {
		result = "left".contentEquals(direction) ? Pad.left(input, character.charAt(0), length) : Pad.right(input, character.charAt(0), length);
		log.debug("result: {} -> input: {} | direction: {} | character: {} | length: {}", result, input, direction, character, length);
	}

	@Then("a properly padded string: {string} is returned")
	public void a_properly_padded_string_is_returned(String output) {
		Assert.assertTrue(result.equals(output));
		log.debug("Is the string properly formatted: {} -> Result: {} Expected: {}", result.equals(output), result, output);
	}
}
