package dev.project.restaurantmanagement.Dto;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

public class MultipartFileSerializer extends JsonSerializer<MultipartFile> {

    @Override
    public void serialize(MultipartFile value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();

        gen.writeStringField("originalFilename", value.getOriginalFilename());
        gen.writeStringField("contentType", value.getContentType());
        gen.writeNumberField("size", value.getSize());

        byte[] content = value.getBytes();
        String base64Content = Base64.getEncoder().encodeToString(content);
        gen.writeStringField("content", base64Content);

        gen.writeEndObject();
    }
}

