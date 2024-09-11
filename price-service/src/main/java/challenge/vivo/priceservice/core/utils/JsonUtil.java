package challenge.vivo.priceservice.core.utils;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import challenge.vivo.priceservice.core.dto.Event;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JsonUtil {
  private final ObjectMapper objectMapper;

  public String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception ex) {
            return "";
        }
    }

  public Event toEvent(String json) {
        try {
            return objectMapper.readValue(json, Event.class);
        } catch (Exception ex) {
            return null;
        }
    }
}
