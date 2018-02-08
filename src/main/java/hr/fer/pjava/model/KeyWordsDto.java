package hr.fer.pjava.model;

import hr.fer.pjava.domain.jpa.entity.Image;

/**
 * Created by Igor Farszky on 23.1.2018..
 */
public class KeyWordsDto {

    private Long id;
    private Image image;
    private String keyWord;

    public KeyWordsDto() {
    }

    public KeyWordsDto(Long id, Image image, String keyWord) {
        this.id = id;
        this.image = image;
        this.keyWord = keyWord;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
