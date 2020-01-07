package net.halflite.sqslambda.dto;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

public class MessageDtoTest {

  private ObjectMapper mapper;
  
  @BeforeEach
  void setUp() throws Exception {
    mapper = new ObjectMapper()
        .setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
  }

  @Test
  void testMessageDto() {
    try {
      MessageDto dto = new MessageDto(999L, "START");
      String json = mapper.writeValueAsString(dto);
      assertNotNull(json);
      String expected = "{\"id\":999,\"status_type\":\"START\"}";
      assertEquals(expected, json);
    } catch (JsonProcessingException e) {
      fail(e.getMessage());
    }
  }

  @Test
  void testToString() {
    MessageDto dto = new MessageDto(999L, "START");
    String str = dto.toString();
    String expected = "MessageDto[id=999, statusType=START]";
    assertEquals(expected, str);
  }

}
