package com.malex.model.entity;

import com.malex.model.entity.templ.BaseEntity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "article_block")
public class ArticleBlockEntity extends BaseEntity {

    @Column(name = "text")
    private String text;

    @OneToOne(mappedBy = "block")
    private ArticleEntity articleEntity;

    @OneToMany(mappedBy = "block")
    private List<ImagesEntity> images;

    public ArticleBlockEntity() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArticleEntity getArticleEntity() {
        return articleEntity;
    }

    public void setArticleEntity(ArticleEntity articleEntity) {
        this.articleEntity = articleEntity;
    }

    public List<ImagesEntity> getImages() {
        return images;
    }

    public void setImages(List<ImagesEntity> images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleBlockEntity that = (ArticleBlockEntity) o;

        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (articleEntity != null ? !articleEntity.equals(that.articleEntity) : that.articleEntity != null)
            return false;
        return images != null ? images.equals(that.images) : that.images == null;

    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (articleEntity != null ? articleEntity.hashCode() : 0);
        result = 31 * result + (images != null ? images.hashCode() : 0);
        return result;
    }
}
