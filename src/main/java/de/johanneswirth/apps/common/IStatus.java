package de.johanneswirth.apps.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface IStatus {

    @JsonProperty("error")
    boolean isError();
}
