package de.johanneswirth.apps.common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class ErrorSerializer extends JsonSerializer<Error> {
    @Override
    public void serialize(Error value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeBooleanField("error", value.isError());
        gen.writeBooleanField("critical", value.isCritical());
        gen.writeStringField("message", value.getError());
        gen.writeEndObject();
    }
}

