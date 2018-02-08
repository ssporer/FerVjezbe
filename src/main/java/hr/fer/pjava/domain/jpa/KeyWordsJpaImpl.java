package hr.fer.pjava.domain.jpa;

import hr.fer.pjava.domain.KeyWordsDao;
import hr.fer.pjava.domain.jpa.entity.KeyWords;
import hr.fer.pjava.domain.jpa.repository.KeyWordsRepository;
import hr.fer.pjava.model.KeyWordsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Igor Farszky on 23.1.2018..
 */
@Repository
@Transactional
public class KeyWordsJpaImpl implements KeyWordsDao {

    private final KeyWordsRepository keyWordsRepository;

    @Autowired
    public KeyWordsJpaImpl(KeyWordsRepository keyWordsRepository) {
        this.keyWordsRepository = keyWordsRepository;
    }

    @Override
    public List<KeyWordsDto> getAllKeyWords() {
        return keyWordsRepository.findAll().stream().map(kw -> new KeyWordsDto()).collect(Collectors.toList());
    }

    @Override
    public List<KeyWordsDto> getKeyWordsByImage(Long imageId) {
        List<KeyWords> kwList = keyWordsRepository.findByImageId(imageId);
        List<KeyWordsDto> kwDtoList = new ArrayList<>();
        for (KeyWords kw : kwList) {
            KeyWordsDto kwDto = new KeyWordsDto();
            // TODO: kreirati novi kwDto
            kwDtoList.add(kwDto);
        }
        return kwDtoList;
    }

    @Override
    public List<KeyWordsDto> getKeyWordsByWord(String keyWord) {
        return keyWordsRepository.findByKeyword(keyWord).stream()
                .filter(distinctByKey(KeyWords::getImage))
                .map(k -> new KeyWordsDto(k.getId(), k.getImage(), k.getKeyWord()))
                .collect(Collectors.toList());
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    @Override
    public KeyWordsDto getKeyWordById(Long keyWordsId) {
        KeyWords kw = keyWordsRepository.findOne(keyWordsId);
        if (kw == null) return null;
        KeyWordsDto kwDto = new KeyWordsDto();
        // TODO: kreiraj KeyWordDto od KeyWords
        return kwDto;
    }

    @Override
    public void saveKeyWord(KeyWordsDto keyWordDto) {
        KeyWords kw = new KeyWords();
        // TODO: kreirat KeyWords od KeyWordsDto
        keyWordsRepository.save(kw);
    }

    @Override
    public void saveKeyWords(List<KeyWordsDto> keyWordsDto) {
        for (KeyWordsDto kwDto: keyWordsDto) {
            KeyWords kw = new KeyWords();
            kw.setImage(kwDto.getImage());
            kw.setKeyWord(kwDto.getKeyWord());
            keyWordsRepository.save(kw);
        }
    }

}
