package hr.fer.pjava.domain.jpa;

import hr.fer.pjava.domain.ImageDao;
import hr.fer.pjava.domain.jpa.entity.Image;
import hr.fer.pjava.domain.jpa.repository.ImageRepository;
import hr.fer.pjava.model.ImageCardsDto;
import hr.fer.pjava.model.ImageDto;
import hr.fer.pjava.model.KeyWordsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<ImageCardsDto> getAllImages() {
        return imageRepository.findAll().stream().map(i -> new ImageCardsDto(i.getId(), i.getTitle(), i.getDescription(),
                i.getKeywordsAsString(),
                Base64.getEncoder().encodeToString(i.getThumbnail()), Base64.getEncoder().encodeToString(i.getImage())
        )).collect(Collectors.toList());
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
    public Image saveImage(ImageDto imageDto) {
        Image image = new Image(imageDto.getTitle(), imageDto.getDesc(), imageDto.getImage(),
                imageDto.getThumbnail(), imageDto.getResolution(), imageDto.getSize(), new Date());
        imageRepository.save(image);

        return image;
    }

    @Override
    public Image updateImage(ImageDto imageDto, Long updateImageId) {

        Image image = imageRepository.findOne(updateImageId);

        image.setTitle(imageDto.getTitle());
        image.setDescription(imageDto.getDesc());
        image.setImage(imageDto.getImage());
        image.setImage(imageDto.getThumbnail());
        image.setResolution(imageDto.getResolution());
        image.setSize(image.getSize());
        image.setUploadDate(new Date());

        imageRepository.save(image);

        return image;
    }
}
