package com.malex.model.entity;

import com.malex.model.entity.templ.BaseEntity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "article")
public class ArticleEntity extends BaseEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "desctiption", nullable = false)
    private String desctiption;

    @OneToMany(mappedBy = "articleEntity", fetch = FetchType.EAGER)
    private List<ArticleBlockEntity> blockEntityList;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleEntity that = (ArticleEntity) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (desctiption != null ? !desctiption.equals(that.desctiption) : that.desctiption != null) return false;
        return blockEntityList != null ? blockEntityList.equals(that.blockEntityList) : that.blockEntityList == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (desctiption != null ? desctiption.hashCode() : 0);
        result = 31 * result + (blockEntityList != null ? blockEntityList.hashCode() : 0);
        return result;
    }
}