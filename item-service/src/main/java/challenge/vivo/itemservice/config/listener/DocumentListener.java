package challenge.vivo.itemservice.config.listener;

import java.time.LocalDateTime;

import org.springframework.context.ApplicationListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;
import org.springframework.stereotype.Component;

import challenge.vivo.itemservice.core.document.Validation;

@Component
public class DocumentListener implements ApplicationListener<BeforeSaveEvent<Object>>{
  @Override
    public void onApplicationEvent(BeforeSaveEvent<Object> event) {
        Object source = event.getSource();
        if (source instanceof Validation) {
            Validation myDocument = (Validation) source;
            // Por exemplo, definir um campo antes de salvar
            myDocument.setCreatedAt(LocalDateTime.now());
        }
    }
}
