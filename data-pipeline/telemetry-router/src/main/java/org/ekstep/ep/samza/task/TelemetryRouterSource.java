package org.ekstep.ep.samza.task;

import java.util.Map;

import org.apache.samza.system.IncomingMessageEnvelope;
import org.ekstep.ep.samza.core.Logger;
import org.ekstep.ep.samza.domain.Event;

import com.google.gson.Gson;

public class TelemetryRouterSource {
    static Logger LOGGER = new Logger(TelemetryRouterSource.class);
    
    private IncomingMessageEnvelope envelope;

    public TelemetryRouterSource(IncomingMessageEnvelope envelope) {
        this.envelope = envelope;
    }

    public Event getEvent(){
        return new Event(getMap());
    }

    private Map<String, Object> getMap() {
        String message = (String) envelope.getMessage();
        return (Map<String, Object>) new Gson().fromJson(message, Map.class);
    }

    public String getMessage() {
        return envelope.toString();
    }
}
