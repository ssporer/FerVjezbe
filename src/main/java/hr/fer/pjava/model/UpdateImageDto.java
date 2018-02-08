package hr.fer.pjava.model;

/**
 * Created by Igor Farszky on 7.2.2018..
 */
public class UpdateImageDto {

    private String filename;
    private String title;
    private String desc;
    private String keywords;

    public UpdateImageDto() {
    }

    public UpdateImageDto(String filename, String title, String desc, String keywords) {
        this.filename = filename;
        this.title = title;
        this.desc = desc;
        this.keywords = keywords;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
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
