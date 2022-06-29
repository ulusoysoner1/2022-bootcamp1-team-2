package com.example.Myrecipes.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String text;
    private Integer c_users_id;
    private Integer c_recipes_id;

    public Comment() {
    }

    public Comment(String title, String text, Integer c_users_id, Integer c_recipes_id) {
        this.title = title;
        this.text = text;
        this.c_users_id = c_users_id;
        this.c_recipes_id = c_recipes_id;
    }

    public Comment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getC_users_id() {
        return c_users_id;
    }

    public void setC_users_id(Integer c_users_id) {
        this.c_users_id = c_users_id;
    }

    public Integer getC_recipes_id() {
        return c_recipes_id;
    }

    public void setC_recipes_id(Integer c_recipes_id) {
        this.c_recipes_id = c_recipes_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return getId().equals(comment.getId()) && getTitle().equals(comment.getTitle()) && getText().equals(comment.getText()) && getC_users_id().equals(comment.getC_users_id()) && getC_recipes_id().equals(comment.getC_recipes_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getText(), getC_users_id(), getC_recipes_id());
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", c_users_id=" + c_users_id +
                ", c_recipes_id=" + c_recipes_id +
                '}';
    }
}
