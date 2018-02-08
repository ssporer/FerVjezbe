package hr.fer.pjava.web.controller;

import hr.fer.pjava.model.UpdateImageDto;
import hr.fer.pjava.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Igor Farszky on 2.2.2018..
 */
@RestController
public class ImageUploadController {

    private final ImageService imageService;

    @Autowired
    public ImageUploadController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/image-upload")
    public String handleFileUpload(HttpServletRequest request) {

        System.out.println("isus");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> yourFiles = multipartRequest.getFileMap();

        for (Map.Entry<String, MultipartFile> entry: yourFiles.entrySet()) {
            imageService.saveImage(entry.getValue());
        }

//        redirectAttributes.addFlashAttribute("message",
//                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    // Because first time i just upload an image, without titles, desc, keywords, cuz i dont know to do that
    // then need to make post again to manage update those things
    @PostMapping("/image-upload-update")
    public String handleUpdatedFileUpload(UpdateImageDto updateImageDto) {
        imageService.updateImage(updateImageDto);

        return "redirect:/";
    }

}
