package de.johanneswirth.apps.common;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
public class ContainerFilter implements DynamicFeature {

    private VerificationHelper verificationHelper;

    public ContainerFilter(VerificationHelper verificationHelper) {
        this.verificationHelper = verificationHelper;
    }

    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {
        if (resourceInfo.getResourceMethod().getAnnotation(Secured.class) != null) {
            context.register(new AuthenticationFilter(verificationHelper));
        }
        context.register(new HeaderFilter());
    }
}
