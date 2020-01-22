package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;


@ActiveProfiles("kebab")
@JsonTest
public class BeerDtoKebabTest extends BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testKebab() throws JsonProcessingException {
        BeerDto dto = getDto();

        String json = objectMapper.writeValueAsString(getDto());
        System.out.println(json);
    }

    @Test
    void TestDeserialize() throws IOException {
        String json = "{\"id\":\"42555ba9-d5b1-4abe-9707-cf54e570a644\",\"beer-name\":\"BeerName\",\"beer-style\":\"Ale\",\"upc\":123123123123,\"price\":12.99,\"created-date\":\"2020-01-22T09:36:29.8685023+01:00\",\"last-updated-date\":\"2020-01-22T09:36:29.8685023+01:00\"}";

        BeerDto dto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(dto);
    }
}
