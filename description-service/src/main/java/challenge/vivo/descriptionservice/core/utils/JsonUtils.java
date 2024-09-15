package challenge.vivo.descriptionservice.core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import challenge.vivo.descriptionservice.core.dto.Event;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JsonUtils {
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
