package com.malex.model.vo;

import com.malex.model.enums.ArticleCategory;

public class CreateArticleVO {

    private String title;

    private String description;

    private String imageName;

    private ArticleCategory enumType;

    public CreateArticleVO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public ArticleCategory getEnumType() {
        return enumType;
    }

    public void setEnumType(ArticleCategory enumType) {
        this.enumType = enumType;
    }
}
