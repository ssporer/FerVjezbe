package hr.fer.pjava.service;

import hr.fer.pjava.domain.ImageDao;
import hr.fer.pjava.domain.KeyWordsDao;
import hr.fer.pjava.domain.jpa.entity.Image;
import hr.fer.pjava.model.ImageDto;
import hr.fer.pjava.model.KeyWordsDto;
import hr.fer.pjava.model.UpdateImageDto;
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

    public void saveImage(MultipartFile file) {

        ImageDto imageDto = new ImageDto();

        imageDto.setTitle(file.getOriginalFilename());
        imageDto.setDesc(file.getOriginalFilename());
        try {
            imageDto.setImage(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayInputStream bis = null;
        byte[] resThumb = null;
        try {

            resThumb = file.getBytes();
            bis = new ByteArrayInputStream(file.getBytes());
            BufferedImage bufferedImage = ImageIO.read(bis);
            bufferedImage = getScaledInstance(bufferedImage, 256, 256, RenderingHints.VALUE_INTERPOLATION_BICUBIC, true);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write( bufferedImage, "png", baos );
            baos.flush();
            resThumb = baos.toByteArray();
            baos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        imageDto.setThumbnail(resThumb);
        imageDto.setResolution("");
        imageDto.setSize(Long.valueOf(file.getSize()).intValue());

        imageDao.saveImage(imageDto);

    }

    public void updateImage(UpdateImageDto updateImageDto) {
        Image updatedImage = imageDao.updateImage(updateImageDto);
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

    private static BufferedImage getScaledInstance(BufferedImage img, int targetWidth, int targetHeight, Object hint,
                                                   boolean higherQuality) {

        int type = (img.getTransparency() == Transparency.OPAQUE) ? BufferedImage.TYPE_INT_RGB
                : BufferedImage.TYPE_INT_ARGB;
        BufferedImage ret = (BufferedImage) img;
        if (ret.getHeight() < targetHeight || ret.getWidth() < targetWidth) {
            higherQuality = false;
        }
        int w, h;
        if (higherQuality) {
            // Use multi-step technique: start with original size, then
            // scale down in multiple passes with drawImage()
            // until the target size is reached
            w = img.getWidth();
            h = img.getHeight();
        } else {
            // Use one-step technique: scale directly from original
            // size to target size with a single drawImage() call
            w = targetWidth;
            h = targetHeight;
        }

        do {
            if (higherQuality && w > targetWidth) {
                w /= 2;
                if (w < targetWidth) {
                    w = targetWidth;
                }
            }

            if (higherQuality && h > targetHeight) {
                h /= 2;
                if (h < targetHeight) {
                    h = targetHeight;
                }
            }

            BufferedImage tmp = new BufferedImage(w, h, type);
            Graphics2D g2 = tmp.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, hint);
            g2.drawImage(ret, 0, 0, w, h, null);
            g2.dispose();

            ret = tmp;
        } while (w != targetWidth || h != targetHeight);

        return ret;
    }

}
