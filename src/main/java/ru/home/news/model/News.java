package ru.home.news.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "short_description", unique = true, nullable = false)
    private String shortDescription;

    @Column(unique = true,nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "news_type", referencedColumnName = "id")
    private NewsType type;


//    public News() {
//    }

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getShortDescription() {
//        return shortDescription;
//    }
//
//    public void setShortDescription(String shortDescription) {
//        this.shortDescription = shortDescription;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public NewsType getType() {
//        return type;
//    }
//
//    public void setType(NewsType type) {
//        this.type = type;
//    }
//
//    @Override
//    public String toString() {
//        return "News{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", shortDescription='" + shortDescription + '\'' +
//                ", description='" + description + '\'' +
//                ", type=" + type +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        News news = (News) o;
//        return getId() == news.getId();
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId());
//    }
}
