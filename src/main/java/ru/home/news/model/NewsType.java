package ru.home.news.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "news_type")
public class NewsType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type_name", unique = true, nullable = false)
    private String typeName;

    @Column(name = "type_colour", nullable = false)
    private String typeColour;


    public NewsType() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
    public String toString() {
        return "NewsType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", typeColour='" + typeColour + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsType newsType = (NewsType) o;
        return getId() == newsType.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
