package com.malex.model.entity;

import com.malex.model.entity.templ.BaseEntity;
import com.malex.model.enums.ImageType;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "images")
public class ImagesEntity extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Lob
    @Column(name = "img", nullable = false)
    private byte[] img;

    @Column(name = "avalible", nullable = false)
    private boolean isAvalible;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private ImageType type;

    @OneToOne(mappedBy = "image")
    private ArticleEntity article;

    public ImagesEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public boolean isAvalible() {
        return isAvalible;
    }

    public void setAvalible(boolean avalible) {
        isAvalible = avalible;
    }

    public ImageType getType() {
        return type;
    }

    public void setType(ImageType type) {
        this.type = type;
    }

    public ArticleEntity getArticle() {
        return article;
    }

    public void setArticle(ArticleEntity article) {
        this.article = article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImagesEntity entity = (ImagesEntity) o;

        if (isAvalible != entity.isAvalible) return false;
        if (name != null ? !name.equals(entity.name) : entity.name != null) return false;
        if (!Arrays.equals(img, entity.img)) return false;
        if (type != entity.type) return false;
        return article != null ? article.equals(entity.article) : entity.article == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(img);
        result = 31 * result + (isAvalible ? 1 : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (article != null ? article.hashCode() : 0);
        return result;
    }
}
