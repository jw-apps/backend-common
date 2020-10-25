package de.johanneswirth.apps.common;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using=ErrorSerializer.class)
public interface Error extends IStatus {
    String getError();
    boolean isCritical();

    @Override
    default boolean isError() {
        return true;
    }
}
