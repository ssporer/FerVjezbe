package hr.fer.pjava.web.controller;

import hr.fer.pjava.model.ImageCardsDto;
import hr.fer.pjava.model.ImageDto;
import hr.fer.pjava.model.RestDto;
import hr.fer.pjava.model.UpdateImageDto;
import hr.fer.pjava.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Igor Farszky on 2.2.2018..
 */
@RestController
public class ImageUploadController {

    private final ImageService imageService;
    private ImageDto imageDto = new ImageDto();

    @Autowired
    public ImageUploadController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/image-upload")
    public String handleFileUpload(HttpServletRequest request) {

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> yourFiles = multipartRequest.getFileMap();

        for (Map.Entry<String, MultipartFile> entry: yourFiles.entrySet()) {
            try {
                imageDto.setImage(entry.getValue().getBytes());
                imageDto.setSize(Long.valueOf(entry.getValue().getSize()).intValue());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "redirect:/";
    }

    @PostMapping("/image-upload-submit")
    public RestDto<Void> handleUpdatedFileUpload(@RequestBody @Valid UpdateImageDto updateImageDto) {

        imageDto.setTitle(updateImageDto.getTitle());
        imageDto.setDesc(updateImageDto.getDesc());

        imageService.saveImage(imageDto, updateImageDto.getKeywords());

        imageDto = new ImageDto();

        return RestDto.success("Image successfully saved");
    }

}
