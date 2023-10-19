package exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

// BEGIN
@AllArgsConstructor
@Getter
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            ObjectNode carNode = objectMapper.createObjectNode();
            carNode.put("id", id);
            carNode.put("brand", brand);
            carNode.put("model", model);
            carNode.put("color", color);

            ObjectNode ownerNode = objectMapper.createObjectNode();
            ownerNode.put("id", owner.getId());
            ownerNode.put("firstName", owner.getFirstName());
            ownerNode.put("lastName", owner.getLastName());
            ownerNode.put("age", owner.getAge());

            carNode.set("owner", ownerNode);

            return objectMapper.writeValueAsString(carNode);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static Car unserialize(String jsonRepresentation) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Car car = objectMapper.readValue(jsonRepresentation, Car.class);
            return car;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    // END
}
