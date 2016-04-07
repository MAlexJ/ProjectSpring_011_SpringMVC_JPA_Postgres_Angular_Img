package com.malex.model.dto;

import com.malex.model.enums.ImageType;

import java.io.Serializable;
import java.util.Arrays;

public class ImagesDTO implements Serializable {

    private Long id;

    private String name;

    private byte[] img;

    private boolean isAvailable;

    private ImageType type;

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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public ImageType getType() {
        return type;
    }

    public void setType(ImageType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImagesDTO dto = (ImagesDTO) o;

        if (isAvailable != dto.isAvailable) return false;
        if (id != null ? !id.equals(dto.id) : dto.id != null) return false;
        if (name != null ? !name.equals(dto.name) : dto.name != null) return false;
        if (!Arrays.equals(img, dto.img)) return false;
        return type == dto.type;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(img);
        result = 31 * result + (isAvailable ? 1 : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
