package de.johanneswirth.apps.common;

import io.dropwizard.discovery.DiscoveryBundle;
import io.dropwizard.discovery.client.DiscoveryClient;
import io.dropwizard.discovery.client.DiscoveryClientManager;
import io.dropwizard.setup.Environment;

import javax.ws.rs.client.Client;

public class ServiceUtils {

    static Client client;
    static DiscoveryClient messaging;

    public static void init(DiscoveryBundle discoveryBundle, Client client, Environment environment) {
        ServiceUtils.client = client;
        messaging = discoveryBundle.newDiscoveryClient("messaging-service");
        environment.lifecycle().manage(new DiscoveryClientManager(messaging));
    }
}
