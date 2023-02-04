package com.musalasoft.dronesdispatcher.config;

import java.util.HashMap;
import java.util.Map;

public enum DroneModelEnum {
    LIGHWEIGHT("Lightweight"),
    MIDDLEWEIGHT("Middleweight"),
    CRUISERWEIGHT("Cruiserweight"),
    HEAVYWEIGHT("Heavyweight");

    private static final Map<String, DroneModelEnum> BY_LABEL = new HashMap<>();

    static {
        for (DroneModelEnum e : values()) {
            BY_LABEL.put(e.label, e);
        }
    }
    private DroneModelEnum(String label) {
        this.label = label;
    }
    public final String label;

   public static DroneModelEnum valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }

}
