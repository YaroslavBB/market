package com.suitcase.market.controllers;

import com.suitcase.market.modules.*;
import com.suitcase.market.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Controller
public class AdminController {
    @Autowired
    private BackpackRepository backpackRepository;
    @Autowired
    private LeatherBagsRepository leatherBagsRepository;
    @Autowired
    private PlasticRepository plasticRepository;
    @Autowired
    private TextilRepository textilRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/admin")
    public String admin(Model model) {

        return "admin";
    }

    @GetMapping("/admin/add")
    public String itemsAdd(Model model) {

        return "itemsAdd";
    }

    @PostMapping("/admin/add")
    public String itemAdd(@RequestParam String name,
                          @RequestParam String description,
                          @RequestParam Integer salaryBig,
                          @RequestParam Integer salaryAverage,
                          @RequestParam Integer salarySmall,
                          @RequestParam String material,
                          @RequestParam String anons,
                          @RequestParam("file") MultipartFile file,
                          @RequestParam("file2") MultipartFile file2,
                          @RequestParam("file3") MultipartFile file3,
                          Model model) throws IOException {

        Item item = null;
        Plastic plastic = null;
        Textile textile = null;

        if (material.equals("plastic")) {
            item = new Plastic(name, description, material, anons, salaryBig, salaryAverage, salarySmall);

        } else if (material.equals("textile")) {
            item = new Textile(name, description, material, anons, salaryBig, salaryAverage, salarySmall);

        }

        String filename;
        saveFileName(file, item);
        filename = "" + item.getFilenames() + "/";
        item.setFilenames(filename);
        saveFileName(file2, item);
        filename = item.getFilenames() + "/";
        item.setFilenames(filename);
        saveFileName(file3, item);


        if (material.equals("plastic")) {
            plastic = (Plastic) item;
            plasticRepository.save(plastic);

        } else if (material.equals("textile")) {
            textile = (Textile) item;
            textilRepository.save(textile);
        }

        return "itemsAdd";

    }

    @GetMapping("/admin/add_back")
    public String itemsAddBack(Model model) {

        return "itemsAddBack";
    }

    @PostMapping("/admin/add_back")
    public String itemAddBack(@RequestParam String name,
                              @RequestParam String description,
                              @RequestParam String material,
                              @RequestParam String anons,
                              @RequestParam Integer salary,
                              @RequestParam("file") MultipartFile file,
                              @RequestParam("file2") MultipartFile file2,
                              @RequestParam("file3") MultipartFile file3,
                              Model model) throws IOException {

        Item item = null;
        Backpacks backpacks = null;
        LeatherBags leatherBags = null;

        if (material.equals("backpack")) {
            item = new Backpacks(name, description, material, anons, salary);

        } else if (material.equals("leatherBag")) {
            item = new LeatherBags(name, description, material, anons, salary);

        }

        String filename;

        saveFileName(file, item);
        filename = "" + item.getFilenames() + "/";
        item.setFilenames(filename);
        saveFileName(file2, item);
        filename = item.getFilenames() + "/";
        item.setFilenames(filename);
        saveFileName(file3, item);


        if (material.equals("backpack")) {
            backpacks = (Backpacks) item;
            backpackRepository.save(backpacks);

        } else if (material.equals("leatherBag")) {
            leatherBags = (LeatherBags) item;
            leatherBagsRepository.save(leatherBags);
        }

        return "itemsAddBack";

    }

//    @GetMapping("/admin/edit/textile/{id}")
//    public String blogEdit(@PathVariable(value = "id") long id, Model model) {
//        if (!textilRepository.existsById(id)) {
//            return "redirect:/admin";
//        }
//
//        Optional<Textile> post = textilRepository.findById(id);
//        ArrayList<Textile> res = new ArrayList<>();
//        post.ifPresent(res::add);
//        model.addAttribute("textile", res);
//        return "textileEdit";
//    }
//
//    @PostMapping("/admin/edit/textile/{id}")
//    public String blogPostUpdate(@PathVariable(value = "id") long id,
//                                 @RequestParam String name,
//                                 @RequestParam String description,
//                                 @RequestParam String anons,
//                                 @RequestParam Integer salaryBig,
//                                 @RequestParam Integer salaryAverage,
//                                 @RequestParam Integer salarySmall,
//                                 Model model) {
//        Textile post = textilRepository.findById(id).orElseThrow();
//        post.setName(name);
//        post.setDescription(description);
//        post.setAnons(anons);
//        post.setSalaryBig(salaryBig);
//        post.setSalaryAverage(salaryAverage);
//        post.setSalarySmall(salarySmall);
//        textilRepository.save(post);
//
//        return "redirect:/admin";
//    }

    private void saveFileName(MultipartFile file, Item item) throws IOException {
        if (file != null) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            String fileNames = item.getFilenames();
            fileNames += resultFilename;
            item.setFilenames(fileNames);

        }
    }


}