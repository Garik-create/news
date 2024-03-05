package ru.home.news.dto;

import ru.home.news.model.NewsType;

import java.util.Objects;

public class NewsDto {

    private String name;

    private String shortDescription;

    private String description;

    private NewsType type;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NewsType getType() {
        return type;
    }

    public void setType(NewsType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsDto newsDto = (NewsDto) o;
        return Objects.equals(getName(), newsDto.getName()) && Objects.equals(getShortDescription(), newsDto.getShortDescription()) && Objects.equals(getDescription(), newsDto.getDescription()) && Objects.equals(getType(), newsDto.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getShortDescription(), getDescription(), getType());
    }
}
