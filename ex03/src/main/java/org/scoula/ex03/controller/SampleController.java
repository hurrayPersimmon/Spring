package org.scoula.ex03.controller;

import java.util.ArrayList;
import lombok.extern.log4j.Log4j2;
import org.scoula.ex03.dto.SampleDTO;
import org.scoula.ex03.dto.SampleDTOList;
import org.scoula.ex03.dto.TodoDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {

    @RequestMapping("")
    public void basic() {
        log.info("Sample Controller");
    }

    @RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST}) // url: /sample/basic
    public void basicGet() {
        log.info("basic get");
    }

    @GetMapping("/basicOnlyGet") // url: /sample/basicOnlyGet
    public void basicGet2() {
        log.info("basic get only get");
    }

    @GetMapping("/ex01")
    public String ex01(SampleDTO sampleDTO) {
        log.info(sampleDTO);
        return "ex01";
    }

    @GetMapping("/ex02")
    public void ex02(String name, @ModelAttribute("age") int age){
        log.info("name :"+ name);
        log.info("age: " + age);
    }

    @GetMapping("/ex02/List")
    public String ex02List(@RequestParam("ids")ArrayList<String> ids){
        log.info(ids);
        return "ex02/List";
    }

    @GetMapping("/ex02Bean")
    public String ex02Bean(SampleDTOList list) {
        log.info("list dtos: " + list);
        return "ex02Bean";
    }

    @GetMapping("/ex03")
    public String ex03(TodoDTO todoDTO){
        log.info(todoDTO.toString());
        return "ex03";
    }

    @GetMapping("/ex04")
    public String ex04(SampleDTO dto, int page) {
//    public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
        log.info("dto: " + dto);
        log.info("page: " + page);
        return "ex04";
    }

    @GetMapping("/ex05")
    public void ex05() {
        log.info("/ex05");
    }

    @GetMapping("/ex06")
    public String ex06(RedirectAttributes redirectAttributes) {
        log.info("/ex06");
        redirectAttributes.addAttribute("name", "hurray");
        redirectAttributes.addAttribute("age", 27);
        return "redirect:/sample/ex06-2";
    }

    @GetMapping("/ex07")
    public @ResponseBody SampleDTO ex07(){
        log.info("/ex07");

        SampleDTO sampleDTO = new SampleDTO();
        sampleDTO.setName("hurray");
        sampleDTO.setAge(27);
        return sampleDTO;
    }

    @GetMapping("/ex08")
    public ResponseEntity<String> ex08(){
        log.info("ex08");
        String message = "{\"name\":\"hurray\",\"age\":27}";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");

        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }

    @GetMapping("/exUpload")
    public void exUpload() {
        log.info("/exUpload");
    }

    @PostMapping("/exUploadPost")
    public void exUploadPost(ArrayList<MultipartFile> files) {
        for(MultipartFile file : files) {
            log.info("----------------------------------");
            log.info("name:" + file.getOriginalFilename()); // 윈도우 OS: 한글 파일명인 경우 깨짐
            log.info("size:" + file.getSize());
        }
    }

}
