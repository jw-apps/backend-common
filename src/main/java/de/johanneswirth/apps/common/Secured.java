package de.johanneswirth.apps.common;

import javax.ws.rs.NameBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates a method or class that can only be accessed when authenticated
 * <p>
 * Authorization needs to be done by the service method depending on the request
 *
 * @author Johannes Wirth
 */
@NameBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Secured {
}
