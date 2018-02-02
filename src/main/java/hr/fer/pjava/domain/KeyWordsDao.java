package hr.fer.pjava.domain;

import hr.fer.pjava.model.KeyWordsDto;

import java.util.List;

/**
 * Created by Igor Farszky on 23.1.2018..
 */
public interface KeyWordsDao {

    List<KeyWordsDto> getAllKeyWords();

    List<KeyWordsDto> getKeyWordsByImage(Long imageId); // dohvat kljucnih rijeci za dani id slike

    List<KeyWordsDto> getKeyWordsByWord(String keyWord); // dohvat kljucnih rijeci za danu rijec (dan je dio rijeci npr.)

    KeyWordsDto getKeyWordById(Long keyWordsId); // dohvat kljucne rijeci po idu kljucne rijeci

    void saveKeyWord(KeyWordsDto keyWordDto); // spremi kljucnu rijec

    void saveKeyWords(List<KeyWordsDto> keyWordsDto); // spremi sve kljucne rijeci

}
