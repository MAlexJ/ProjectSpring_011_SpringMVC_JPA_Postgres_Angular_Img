package com.malex.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.Arrays;

@Entity
@Table(name = "article")
public class ArticleEntity extends BaseEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "desctiption", nullable = false)
    private String desctiption;

    @Lob
    @Column(name = "data")
    private byte[] data;

    public ArticleEntity() {
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

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleEntity that = (ArticleEntity) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (desctiption != null ? !desctiption.equals(that.desctiption) : that.desctiption != null) return false;
        return Arrays.equals(data, that.data);

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (desctiption != null ? desctiption.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
}
