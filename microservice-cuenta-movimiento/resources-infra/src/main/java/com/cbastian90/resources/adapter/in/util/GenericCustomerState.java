package com.cbastian90.resources.adapter.in.util;

public enum GenericCustomerState {

    ACTIVE,
    INACTIVE;

    public static GenericCustomerState fromValue(String v) {
        return valueOf(v);
    }

    public String getName() {
        return name();
    }

}
