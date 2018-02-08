package hr.fer.pjava.model;

/**
 * Created by Igor Farszky on 23.1.2018..
 */
public class ImageDto {

    private Long id;
    private String title;
    private String desc;
    private byte[] image;
    private byte[] thumbnail;
    private String resolution;
    private Integer size;

    public ImageDto() {
    }

    public ImageDto(Long id, String title, String desc, byte[] image, byte[] thumbnail, String resolution, Integer size) {
        this.title = title;
        this.desc = desc;
        this.image = image;
        this.thumbnail = thumbnail;
        this.resolution = resolution;
        this.size = size;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
