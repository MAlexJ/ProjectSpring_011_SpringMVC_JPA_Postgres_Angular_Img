package com.malex.model.dto;

import com.malex.model.enums.ArticleCategory;

public class ArticleFindDTO {

    private Long id;

    private String title;

    private ArticleCategory category;

    public ArticleFindDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArticleCategory getCategory() {
        return category;
    }

    public void setCategory(ArticleCategory category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleFindDTO that = (ArticleFindDTO) o;
        return id != null ? id.equals(that.id) : that.id == null && (title != null ? title.equals(that.title) : that.title == null && category == that.category);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

}
