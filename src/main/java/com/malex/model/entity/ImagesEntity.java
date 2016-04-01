package com.malex.model.entity;

import com.malex.model.entity.templ.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.Arrays;

@Entity
@Table(name = "images")
public class ImagesEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "img")
    private byte[] img;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImagesEntity that = (ImagesEntity) o;
        return name != null ? name.equals(that.name) : that.name == null && Arrays.equals(img, that.img);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(img);
        return result;
    }
}
