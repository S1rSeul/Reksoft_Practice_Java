package com.reksoft.exporter.model;

import lombok.Data;

@Data
public class Player {
    private Integer id;
    private String combinedName;
    private String nickname;
    private String country;
    private String teamName;

    public String getFullName() {
        String[] parts = combinedName.trim().split("\\s+", 2);

        return String.format("%s \"%s\" %s", parts[0], nickname, parts[1]);
    }
}
