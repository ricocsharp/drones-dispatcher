package com.musalasoft.dronesdispatcher.config;

import java.util.HashMap;
import java.util.Map;

public enum DroneStateEnum {

    EXHAUSTED ("EXHAUSTED "),
    IDLE("IDLE"),
    LOADING("LOADING"),
    LOADED("LOADED"),
    DELIVERING("DELIVERING"),
    DELIVERED("DELIVERED"),
    RETURNING("RETURNING");

    private static final Map<String, DroneStateEnum> BY_LABEL = new HashMap<>();

    static {
        for (DroneStateEnum e : values()) {
            BY_LABEL.put(e.label, e);
        }
    }
    private DroneStateEnum(String label) {
        this.label = label;
    }
    public final String label;

    public static DroneStateEnum valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }


}
