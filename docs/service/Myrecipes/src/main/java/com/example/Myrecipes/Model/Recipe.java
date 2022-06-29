package com.example.Myrecipes.Model;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Objects;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String category;
    private Integer nop;
    private Integer cookingTime;
    private Integer cookingDegree;
    private Blob picture;
    private Integer users_id;

    public Recipe() {
    }

    public Recipe(String title, String category, Integer nop, Integer cookingTime, Integer cookingDegree, Blob picture, Integer users_id) {
        this.title = title;
        this.category = category;
        this.nop = nop;
        this.cookingTime = cookingTime;
        this.cookingDegree = cookingDegree;
        this.picture = picture;
        this.users_id = users_id;
    }



    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public Integer getNop() {
        return nop;
    }

    public Integer getCookingTime() {
        return cookingTime;
    }

    public Integer getCookingDegree() {
        return cookingDegree;
    }

    public Blob getPicture() {
        return picture;
    }

    public Integer getUsers_id() {
        return users_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) { this.title = title;}

    public void setCategory(String category) {
        this.category = category;
    }

    public void setNop(Integer nop) {
        this.nop = nop;
    }

    public void setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
    }

    public void setCookingDegree(Integer cookingDegree) {
        this.cookingDegree = cookingDegree;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    public void setUsers_id(Integer users_id) {
        this.users_id = users_id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe)) return false;
        Recipe recipe = (Recipe) o;
        return getId().equals(recipe.getId()) && getTitle().equals(recipe.getTitle()) && Objects.equals(getCategory(), recipe.getCategory()) && getNop().equals(recipe.getNop()) && getCookingTime().equals(recipe.getCookingTime()) && getCookingDegree().equals(recipe.getCookingDegree()) && getPicture().equals(recipe.getPicture()) && getUsers_id().equals(recipe.getUsers_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getCategory(), getNop(), getCookingTime(), getCookingDegree(), getPicture(), getUsers_id());
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", nop=" + nop +
                ", cookingTime=" + cookingTime +
                ", cookingDegree=" + cookingDegree +
                ", picture=" + picture +
                ", users_id=" + users_id +
                '}';
    }
}

