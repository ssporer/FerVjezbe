package hr.fer.pjava.service;

import hr.fer.pjava.domain.ImageDao;
import hr.fer.pjava.domain.KeyWordsDao;
import hr.fer.pjava.domain.jpa.entity.Image;
import hr.fer.pjava.domain.jpa.entity.KeyWords;
import hr.fer.pjava.model.ImageCardsDto;
import hr.fer.pjava.model.ImageDto;
import hr.fer.pjava.model.KeyWordsDto;
import hr.fer.pjava.model.UpdateImageDto;
import hr.fer.pjava.service.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Igor Farszky on 23.1.2018..
 */
@Service
public class ImageService {

    private final ImageDao imageDao;
    private final KeyWordsDao keyWordsDao;

    @Autowired
    public ImageService(ImageDao imageDao, KeyWordsDao keyWordsDao) {
        this.imageDao = imageDao;
        this.keyWordsDao = keyWordsDao;
    }

    public void saveImage(ImageDto imageDto, String keywords) {

        if (imageDto.getImage() == null) {
            return;
        }

        byte[] resThumb = imageDto.getImage();
        try {
            resThumb = Utils.getScaledInstance(resThumb, 256, 256, RenderingHints.VALUE_INTERPOLATION_BICUBIC, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        imageDto.setThumbnail(resThumb);
        imageDto.setResolution("");

        Image image = imageDao.saveImage(imageDto);

        String[] keyWordsSplit = keywords.trim().split(" ");

        List<KeyWordsDto> keyWordsDtoList = new ArrayList<>();
        for (String s : keyWordsSplit) {
            KeyWordsDto kwDto = new KeyWordsDto();
            kwDto.setImage(image);
            kwDto.setKeyWord(s);
            keyWordsDtoList.add(kwDto);
        }

        keyWordsDao.saveKeyWords(keyWordsDtoList);

    }

    public List<ImageCardsDto> getAllImages() {
        return imageDao.getAllImages();
    }

    public void updateImage(UpdateImageDto updateImageDto) {

        ImageDto imageDto = new ImageDto();
        imageDto.setTitle(updateImageDto.getTitle());
        imageDto.setDesc(updateImageDto.getDesc());

        Image updatedImage = imageDao.updateImage(imageDto, 1L);
        String[] keyWordsSplit = updateImageDto.getKeywords().trim().split(" ");

        List<KeyWordsDto> keyWordsDtoList = new ArrayList<>();
        for (String s : keyWordsSplit) {
            KeyWordsDto kwDto = new KeyWordsDto();
            kwDto.setImage(updatedImage);
            kwDto.setKeyWord(s);
            keyWordsDtoList.add(kwDto);
        }

        keyWordsDao.saveKeyWords(keyWordsDtoList);
    }

    public List<ImageCardsDto> getImagesByKeyword(String keyword) {
        return keyWordsDao.getKeyWordsByWord(keyword).stream()
                .map(k -> new ImageCardsDto(k.getImage()))
                .collect(Collectors.toList());
    }

}
