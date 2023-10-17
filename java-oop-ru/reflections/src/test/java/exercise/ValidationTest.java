package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;



class ValidationTest {

    @Test
    void testValidate() {
        Address address1 = new Address("Russia", "Ufa", "Lenina", "54", null);
        List<String> result1 = Validator.validate(address1);
        List<String> expected1 = List.of();
        assertThat(result1).isEqualTo(expected1);

        Address address2 = new Address(null, "London", "1-st street", "5", "1");
        List<String> result2 = Validator.validate(address2);
        List<String> expected2 = List.of("country");
        assertThat(result2).isEqualTo(expected2);

        Address address3 = new Address("USA", null, null, null, "1");
        List<String> result3 = Validator.validate(address3);
        List<String> expected3 = List.of("city", "street", "houseNumber");
        assertThat(result3).isEqualTo(expected3);
    }

    // BEGIN
    @Test
    public void testAdvancedValidateValidObject() {
        Address address = new Address("USA", "Texas", "Main Street", "7", "2");
        Map<String, List<String>> invalidFields = Validator.advancedValidate(address);
        assertEquals(0, invalidFields.size(), "No fields should be invalid.");
    }

    @Test
    public void testAdvancedValidateNullField() {
        Address address = new Address(null, "Texas", "Main Street", "7", "2");
        Map<String, List<String>> invalidFields = Validator.advancedValidate(address);
        assertEquals(1, invalidFields.size(), "One field should be invalid.");
        List<String> errors = invalidFields.get("country");
        assertEquals(1, errors.size(), "One error message should be present.");
        assertEquals("can not be null", errors.get(0));
    }

    @Test
    public void testAdvancedValidateNullAndMinLengthFields() {
        Address address = new Address(null, "TX", null, "7", "2");
        Map<String, List<String>> invalidFields = Validator.advancedValidate(address);
        assertEquals(2, invalidFields.size(), "Two fields should be invalid.");
        List<String> countryErrors = invalidFields.get("country");
        assertEquals(1, countryErrors.size(), "One error message should be present for country.");
        assertEquals("can not be null", countryErrors.get(0));
        List<String> streetErrors = invalidFields.get("street");
        assertEquals(1, streetErrors.size(), "One error message should be present for street.");
        assertEquals("can not be null", streetErrors.get(0));
    }
    // END
}
