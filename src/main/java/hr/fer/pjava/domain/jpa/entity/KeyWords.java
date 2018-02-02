package hr.fer.pjava.domain.jpa.entity;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Created by Igor Farszky on 23.1.2018..
 */
@Entity
@Table(name = "key_words")
public class KeyWords {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @Column(name = "key_word")
    private String keyWord;

    public KeyWords() {
    }

    public KeyWords(Image image, String keyWord) {
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
