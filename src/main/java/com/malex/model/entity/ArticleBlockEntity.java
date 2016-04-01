package com.malex.model.entity;

import com.malex.model.entity.templ.BaseEntity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "article_block")
public class ArticleBlockEntity extends BaseEntity {

    @Column(name = "text")
    private String text;

    @Column(name = "index")
    private int index;

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    private ArticleEntity articleEntity;

    public ArticleBlockEntity() {
    }

    public ArticleEntity getArticleEntity() {
        return articleEntity;
    }

    public void setArticleEntity(ArticleEntity articleEntity) {
        this.articleEntity = articleEntity;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleBlockEntity that = (ArticleBlockEntity) o;

        if (index != that.index) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        return articleEntity != null ? articleEntity.equals(that.articleEntity) : that.articleEntity == null;

    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + index;
        result = 31 * result + (articleEntity != null ? articleEntity.hashCode() : 0);
        return result;
    }
}
