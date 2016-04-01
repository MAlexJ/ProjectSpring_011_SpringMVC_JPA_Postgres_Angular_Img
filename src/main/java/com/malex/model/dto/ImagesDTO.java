package com.malex.model.dto;

import java.io.Serializable;
import java.util.Arrays;

public class ImagesDTO implements Serializable {

    private Long id;

    private String name;

    private byte[] img;

    public ImagesDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        ImagesDTO dto = (ImagesDTO) o;
        return id != null ? id.equals(dto.id) : dto.id == null && (name != null ? name.equals(dto.name) : dto.name == null && Arrays.equals(img, dto.img));

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(img);
        return result;
    }
}
