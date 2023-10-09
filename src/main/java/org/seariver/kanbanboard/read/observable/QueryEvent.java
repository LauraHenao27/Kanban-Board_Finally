package org.seariver.kanbanboard.read.observable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.seariver.kanbanboard.common.InternalEvent;
import org.seariver.kanbanboard.read.dominio.application.Query;
import org.seariver.kanbanboard.write.dominio.excepciones.DomainException;

import java.util.HashMap;
import java.util.Map;

public class QueryEvent extends InternalEvent {

    private final Query query;

    public QueryEvent(Query query) {
        startTimer();
        this.query = query;
    }

    public Query getQuery() {
        return query;
    }

    @Override
    public Object getSource() {
        return getQuery();
    }

    @Override
    public String toJson() {

        try {
            var mapper = new ObjectMapper();
            Map<String, Object> message = new HashMap<>(Map.of("evento", getOrigin()));
            message.put("contenido", getQuery());
            message.put("elapsedTimeInMilli", getElapsedTimeInMilli());

            if (hasError()) {
                message.put("mensaje", getException().getMessage());

                if (getException() instanceof DomainException domainException && domainException.hasError()) {
                    message.put("errores", domainException.getErrors().toString());
                }
            }

            return mapper.writeValueAsString(message);

        } catch (JsonProcessingException jsonException) {
            return String.format("%s - %s", query, jsonException);
        }
    }

}
