package hr.fer.pjava.model;


import java.io.Serializable;

/**
 * Created by Igor Farszky on 8.2.2018..
 */
public class UpdateImageDto implements Serializable {

    public String title;
    public String desc;
    public String keywords;

    public UpdateImageDto() {
    }

    public UpdateImageDto(String title, String desc, String keywords) {
        this.title = title;
        this.desc = desc;
        this.keywords = keywords;
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
}
