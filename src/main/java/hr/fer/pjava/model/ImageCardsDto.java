package hr.fer.pjava.model;

import hr.fer.pjava.domain.jpa.entity.Image;

import java.io.Serializable;
import java.util.Base64;

/**
 * Created by Igor Farszky on 8.2.2018..
 */
public class ImageCardsDto implements Serializable {

    private Long id;
    private String title;
    private String desc;
    private String keywords;
    private String thumbnail;
    private String image;

    public ImageCardsDto() {
    }

    public ImageCardsDto(Long id, String title, String desc, String keywords, String  thumbnail, String image) {
        this.title = title;
        this.desc = desc;
        this.keywords = keywords;
        this.thumbnail = thumbnail;
        this.image = image;
    }

    public ImageCardsDto(Image image) {
        this.id = image.getId();
        this.title = image.getTitle();
        this.desc = image.getDescription();
        this.keywords = image.getKeywordsAsString();
        this.thumbnail = Base64.getEncoder().encodeToString(image.getThumbnail());
        this.image = Base64.getEncoder().encodeToString(image.getImage());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
