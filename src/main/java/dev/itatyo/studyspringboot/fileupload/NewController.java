package dev.itatyo.studyspringboot.fileupload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class NewController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String saveAuto(
            @RequestPart(value = "json") JsonPojo pojo,
            @RequestParam(value = "some-random") String random,
            @RequestParam(value = "data", required = false) List<MultipartFile> files) {
        System.out.println(random);
        System.out.println(pojo.getJson());
        for (MultipartFile file : files) {
            System.out.println(file.getOriginalFilename());
        }
        return "success";
    }

    static class JsonPojo {
        private String json;

        public String getJson() {
            return json;
        }

        public void setJson(String json) {
            this.json = json;
        }

    }
}
