package hr.fer.pjava.domain.jpa;

import hr.fer.pjava.domain.ImageDao;
import hr.fer.pjava.domain.jpa.repository.ImageRepository;
import hr.fer.pjava.model.ImageDto;
import hr.fer.pjava.model.KeyWordsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Igor Farszky on 23.1.2018..
 */
@Repository
@Transactional
public class ImageJpaImpl implements ImageDao {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageJpaImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public List<ImageDto> getAllImages() {
        return null;
    }

    @Override
    public List<ImageDto> getImageById(Long id) {
        return null;
    }

    @Override
    public ImageDto getImageByKeyWordId(Long keyWordId) {
        return null;
    }

    @Override
    public ImageDto getImageByKeyWord(KeyWordsDto keyWordDto) {
        return null;
    }

    @Override
    public List<ImageDto> getImagesByKeyWord(String keyWord) {
        return null;
    }

    @Override
    public List<ImageDto> getImagesByKeyWords(List<String> keyWords) {
        return null;
    }

    @Override
    public void saveImage(ImageDto imageDto) {

    }
}
