package hr.fer.pjava.domain.jpa.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Igor Farszky on 23.1.2018..
 */
@Entity
@Table(name = "image")
public class Image {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "thumbnail")
    private byte[] thumbnail;

    @Column(name = "resolution") // example: 128x128x3
    private String resolution;

    @Column(name = "size")
    private Integer size;

    @OneToMany(mappedBy = "image", cascade = CascadeType.ALL)
    private List<KeyWords> keyWords;

    public Image() {
    }

    public Image(String title, String description, byte[] image, byte[] thumbnail, String resolution, Integer size) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.thumbnail = thumbnail;
        this.resolution = resolution;
        this.size = size;
    }

    public Image(String title, String description, byte[] image, byte[] thumbnail, String resolution, Integer size,
                 List<KeyWords> keyWords) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.thumbnail = thumbnail;
        this.keyWords = keyWords;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<KeyWords> getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(List<KeyWords> keyWords) {
        this.keyWords = keyWords;
    }

}
