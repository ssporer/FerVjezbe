package hr.fer.pjava.web.controller;

import hr.fer.pjava.model.*;
import hr.fer.pjava.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Igor Farszky on 23.1.2018..
 */
@RestController
public class ImageGalleryController {

    private final ImageService imageService;

    @Autowired
    public ImageGalleryController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/")
    public String homePage() {
        return "image gallery home page";
    }

    @GetMapping("/all-images")
    public RestDto<List<ImageCardsDto>> getAllImages() {
        return RestDto.success(imageService.getAllImages(), "Success");
    }

    @PostMapping("/search-images")
    public RestDto<List<ImageCardsDto>> getImagesByKeyword(@RequestBody @Valid SingleKeyWordDto keyWordsDto) {
        return RestDto.success(imageService.getImagesByKeyword(keyWordsDto.getKeyword()), "Success");
    }

}
