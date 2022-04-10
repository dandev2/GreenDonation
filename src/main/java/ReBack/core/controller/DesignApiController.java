package ReBack.core.controller;

import ReBack.core.data.Category;
import ReBack.core.data.Design;
import ReBack.core.data.Material;
import ReBack.core.dto.DesignDTO;
import ReBack.core.service.CategoryService;
import ReBack.core.service.CategoryServiceImpl;
import ReBack.core.service.DesignServiceImpl;
import ReBack.core.service.MaterialServiceImpl;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@Log4j2
public class DesignApiController {

    @Value("${spring.servlet.multipart.location}")
    private String uploadPath;

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @Autowired
    private MaterialServiceImpl materialServiceImpl;

    @Autowired
    private DesignServiceImpl designServiceImpl;

    @PostMapping(value = "/design/addpost", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String addPost(
            @RequestParam(name = "designName")
                    String designName,
            @RequestParam(name = "designEx")
                    String designEx,
            @RequestParam(name = "designImagePath")
                    MultipartFile designImagePath,
            @RequestParam(name = "category")
                    Long category,
            @RequestParam(name = "designState")
                    boolean designState,
            @RequestParam(name = "material")
                    Long material,
            HttpServletRequest request
    ) throws IOException {
        System.out.println("designImagePath : " + designImagePath);
        System.out.println("designState = " + designState);
        String path = request.getSession().getServletContext().getRealPath("\\");
        String fileName = UUID.randomUUID() + designImagePath.getOriginalFilename();
        String pathName = path + "\\static\\images" + fileName;
        File file = new File(pathName);
        designImagePath.transferTo(file);
        System.out.println("category = " + category);
        System.out.println("material = " + material);
        Category findCategory = categoryServiceImpl.findCategoryId(category);

        Material findMaterial = materialServiceImpl.findMaterialId(material);

        System.out.println("designImagePath : " + designImagePath);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);

        System.out.println("material = " + findMaterial);
        System.out.println("category = " + findCategory);

        Design inputDesign = new Design(designName, designEx, findCategory, fileName, localDateTime, designState, findMaterial);
        System.out.println("g");
        designServiceImpl.save(inputDesign);
        System.out.println("inputDesign : " + inputDesign);


        if (inputDesign != null) {
            return "<h2>디자인 등록이 완료되었습니다. </h2>"
                    + "<meta http-equiv=\"refresh\" content=\"2;url=/design/list\" />";
        } else {
            return "<h2>디자인 등록 실패. </h2>"
                    + "<meta http-equiv=\"refresh\" content=\"2;url=/design/addpost\" />";
        }
    }

//    @ResponseBody
//    @PostMapping("/design/addpost")

//    @PostMapping("/design/addpost")
//    public void designAddpost(MultipartFile[] uploadFiles) {
//        for (MultipartFile uploadFile : uploadFiles) {
//            if(uploadFile.getContentType().startsWith("image")==false) {
//                log.warn("this file is not image type");
//                return;
//            }
//
//            String originalName = uploadFile.getOriginalFilename();
//            String fileName = originalName.substring(originalName.lastIndexOf("\\") + 1);
//            System.out.println("originalName = " + originalName);
//            System.out.println("fileName = " + fileName);
//
//            String folderPath = makeFolder();
//            String uuid = UUID.randomUUID().toString();
//
//            String saveName = uploadPath+File.separator+folderPath+File.separator+uuid+"_"+fileName;
//            System.out.println("saveName = " + saveName);
//
//            Path savePath = Paths.get(saveName);
//            System.out.println("savePath = " + savePath);
//            try{
//                uploadFile.transferTo(savePath);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }// end for
//    }
//
//    private String makeFolder() {
//        String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
//
//        String folderPath = str.replace("/", File.separator);
//
//        File uploadPathFolder = new File(uploadPath, folderPath);
//
//        if(uploadPathFolder.exists()==false) {
//            uploadPathFolder.mkdirs();
//        }
//        return folderPath;
//    }

//
//    @PostMapping(value = "/design/matching")
//    public String matching(
//            @RequestParam(name = "consultingPlace")
//                    String consultingPlace,
//            @RequestParam(name = "consultingStartingTime")
//                    String consultingStartingTime,
//            @RequestParam(name = "consultingEndTime")
//                    Long consultingEndTime,
//            HttpServletRequest request
//    ) throws IOException {
//        DesignDTO mathing = new DesignDTO(consultingPlace, consultingStartingTime, consultingEndTime);
//        designServiceImpl.save(inputDesign);
//        System.out.println("inputDesign : " + inputDesign);
//
//        if (inputDesign != null) {
//            return "<h2>디자인 등록이 완료되었습니다. </h2>"
//                    + "<meta http-equiv=\"refresh\" content=\"2;url=/design/list\" />";
//        } else {
//            return "<h2>디자인 등록 실패. </h2>"
//                    + "<meta http-equiv=\"refresh\" content=\"2;url=/design/addpost\" />";
//        }

}