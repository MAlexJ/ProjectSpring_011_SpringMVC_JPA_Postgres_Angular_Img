package com.malex.model.vo;

import com.malex.model.dto.ArticleFindDTO;
import com.malex.model.enums.ArticleCategory;

import java.util.Map;

public class FindArticleVO {
    private Map<ArticleCategory, ArticleFindDTO> map;

    public FindArticleVO() {
    }

    public Map<ArticleCategory, ArticleFindDTO> getMap() {
        return map;
    }

    public void setMap(Map<ArticleCategory, ArticleFindDTO> map) {
        this.map = map;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FindArticleVO that = (FindArticleVO) o;

        return map != null ? map.equals(that.map) : that.map == null;

    }

    @Override
    public int hashCode() {
        return map != null ? map.hashCode() : 0;
    }
}
