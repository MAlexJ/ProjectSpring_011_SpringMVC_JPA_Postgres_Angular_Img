package com.malex.model.dto;

import com.malex.model.enums.ArticleCategory;

import java.io.Serializable;
import java.util.List;


public class ImagesDataDTO implements Serializable{

    private List<String> nameImg;

    private List<ArticleCategory> enumList;

    public ImagesDataDTO() {
    }

    public List<String> getNameImg() {
        return nameImg;
    }

    public void setNameImg(List<String> nameImg) {
        this.nameImg = nameImg;
    }

    public List<ArticleCategory> getEnumList() {
        return enumList;
    }

    public void setEnumList(List<ArticleCategory> enumList) {
        this.enumList = enumList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImagesDataDTO that = (ImagesDataDTO) o;
        return nameImg != null ? nameImg.equals(that.nameImg) : that.nameImg == null && (enumList != null ? enumList.equals(that.enumList) : that.enumList == null);

    }

    @Override
    public int hashCode() {
        int result = nameImg != null ? nameImg.hashCode() : 0;
        result = 31 * result + (enumList != null ? enumList.hashCode() : 0);
        return result;
    }
}
