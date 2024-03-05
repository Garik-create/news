package ru.home.news.dto;

import java.util.Objects;

public class NewsTypeDto {

    private String typeName;

    private String typeColour;


    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeColour() {
        return typeColour;
    }

    public void setTypeColour(String typeColour) {
        this.typeColour = typeColour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsTypeDto that = (NewsTypeDto) o;
        return Objects.equals(getTypeName(), that.getTypeName()) && Objects.equals(getTypeColour(), that.getTypeColour());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTypeName(), getTypeColour());
    }
}
