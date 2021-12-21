package de.johanneswirth.apps.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SuccessStatus<T> implements IStatus {
    @Valid
    private T value;
    @NotNull
    @Min(0)
    private long version;

    private SuccessStatus(T value, long version) {
        this.value = value;
        this.version = version;
    }

    @Override
    public boolean isError() {
        return false;
    }

    @JsonProperty("value")
    public T getValue() {
        return value;
    }

    @JsonProperty("version")
    public long getVersion() {
        return version;
    }

    public static final SuccessStatus OK = SuccessStatus.OK(null, 0);

    public static <T> SuccessStatus<T> OK(T value) {
        return new SuccessStatus<>(value, 0);
    }

    public static <T> SuccessStatus<T> OK(T value, long version) {
        return new SuccessStatus<>(value, version);
    }

    public static <T> SuccessStatus<T[]> OK(T[] value, long version) {
        return new SuccessStatus<>(value, version);
    }
}


