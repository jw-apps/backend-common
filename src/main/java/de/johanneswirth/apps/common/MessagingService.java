package de.johanneswirth.apps.common;

import org.apache.curator.x.discovery.ServiceInstance;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import java.util.List;

import static de.johanneswirth.apps.common.ServiceUtils.messaging;
import static de.johanneswirth.apps.common.ServiceUtils.client;

public class MessagingService {

    public static void sendMessage(Message message) throws Exception {
        ServiceInstance service = messaging.getInstance();
        System.out.println("http://" + service.getAddress() + ":" + service.getPort());
        WebTarget target = client.target("http://" + service.getAddress() + ":" + service.getPort() + "/messaging");
        target.request(MediaType.APPLICATION_JSON).post(Entity.entity(message, MediaType.APPLICATION_JSON));
    }

    public static void sendMessage(String service, String resource, List<String> recipients, String payload, long version) throws Exception {
        Message message = new Message(service, resource, version, recipients, payload);
        sendMessage(message);
    }
}
