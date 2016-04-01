package com.malex.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.Arrays;

@Entity
@Table(name = "article_block")
public class ArticleBlockEntity extends BaseEntity {

    @Column(name = "text")
    private String text;

    @Lob
    @Column(name = "data")
    private byte[] data;

    public ArticleBlockEntity() {
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
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

        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        return Arrays.equals(data, that.data);

    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
}
