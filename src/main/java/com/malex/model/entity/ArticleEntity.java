package com.malex.model.entity;

import com.malex.model.entity.templ.BaseEntity;
import com.malex.model.enums.ArticleCategory;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "article")
public class ArticleEntity extends BaseEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "desctiption", nullable = false)
    private String desctiption;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private ArticleCategory category;

    @OneToMany(mappedBy = "articleEntity", fetch = FetchType.EAGER)
    private List<ArticleBlockEntity> blockEntityList;

    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "id_image", unique = true, nullable = false)
    private ImagesEntity image;

    public ArticleEntity() {
    }

    public List<ArticleBlockEntity> getBlockEntityList() {
        return blockEntityList;
    }

    public void setBlockEntityList(List<ArticleBlockEntity> blockEntityList) {
        this.blockEntityList = blockEntityList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesctiption() {
        return desctiption;
    }

    public void setDesctiption(String desctiption) {
        this.desctiption = desctiption;
    }

    public ImagesEntity getImage() {
        return image;
    }

    public void setImage(ImagesEntity image) {
        this.image = image;
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

        ArticleEntity that = (ArticleEntity) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (desctiption != null ? !desctiption.equals(that.desctiption) : that.desctiption != null) return false;
        if (category != that.category) return false;
        if (blockEntityList != null ? !blockEntityList.equals(that.blockEntityList) : that.blockEntityList != null)
            return false;
        return image != null ? image.equals(that.image) : that.image == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (desctiption != null ? desctiption.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (blockEntityList != null ? blockEntityList.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }
}
