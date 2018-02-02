package hr.fer.pjava.domain;

import hr.fer.pjava.model.ImageDto;
import hr.fer.pjava.model.KeyWordsDto;

import java.util.List;

/**
 * Created by Igor Farszky on 23.1.2018..
 */
public interface ImageDao {

    List<ImageDto> getAllImages();

    List<ImageDto> getImageById(Long id); // dohvat slike po idu slike

    ImageDto getImageByKeyWordId(Long keyWordId); // dohvat po idu kljucne rijeci

    ImageDto getImageByKeyWord(KeyWordsDto keyWordDto); // dohvat po idu kljucne rijeci

    List<ImageDto> getImagesByKeyWord(String keyWord); // dohvat slika sa kljucnom rijeci

    List<ImageDto> getImagesByKeyWords(List<String> keyWords); // dohvat slika sa svim kljucnim rijecima

    void saveImage(ImageDto imageDto); // spremi sliku

}
