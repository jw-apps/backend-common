package de.johanneswirth.apps.common;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class Message {
    @NotEmpty
    private String service;
    @NotEmpty
    private String resource;
    @NotNull
    @Min(0)
    private long version;
    @NotEmpty
    private List<String> recipients;
    @NotEmpty
    private String payload;

    public Message(String service, String resource, long version, List<String> recipients, String payload) {
        this.service = service;
        this.resource = resource;
        this.version = version;
        this.recipients = recipients;
        this.payload = payload;
    }

    public Message(String service, String resource, long version, List<String> recipients) {
        this.service = service;
        this.resource = resource;
        this.version = version;
        this.recipients = recipients;
        this.payload = "";
    }

    public Message() {}

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
