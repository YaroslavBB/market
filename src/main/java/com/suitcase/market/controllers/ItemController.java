package com.suitcase.market.controllers;


import com.suitcase.market.modules.*;
import com.suitcase.market.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;


@Controller
public class ItemController {
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

    @GetMapping("/")
    public String itemsMain(Model model) {

        return "itemsMain";
    }

    @GetMapping("items/backpacks")
    public String backpacks(Model model) {
        Iterable<Backpacks> items = backpackRepository.findAll();
        model.addAttribute("items", items);
        return "items";
    }

    @GetMapping("items/leather_bags")
    public String leatherBags(Model model) {
        Iterable<LeatherBags> items = leatherBagsRepository.findAll();
        model.addAttribute("items", items);
        return "items";
    }

    @GetMapping("items/plastics")
    public String plastic(Model model) {
        Iterable<Plastic> items = plasticRepository.findAll();
        model.addAttribute("items", items);
        return "items";
    }

    @GetMapping("items/textile")
    public String textile(Model model) {
        Iterable<Textile> items = textilRepository.findAll();
        model.addAttribute("items", items);
        return "items";
    }


    @GetMapping("/items/backpack/{id}")
    public String backpackDetails(Model model, @PathVariable(value = "id") long id) throws NoSuchElementException {

        if (!backpackRepository.existsById(id)) {
            return "redirect:/items";
        }

        Optional<Backpacks> item = backpackRepository.findById(id);

        Backpacks finalItem = item.get();
        model.addAttribute("item", finalItem);
        return "itemDetailsBack";

    }

    @GetMapping("/items/leather_bag/{id}")
    public String leatherBagsDetails(Model model, @PathVariable(value = "id") long id) throws NoSuchElementException {

        if (!leatherBagsRepository.existsById(id)) {
            return "redirect:/items";
        }

        Optional<LeatherBags> item = leatherBagsRepository.findById(id);

        LeatherBags finalItem = item.get();
        model.addAttribute("item", finalItem);
        return "itemDetailsBack";

    }

    @GetMapping("/items/plastic/{id}")
    public String plasticDetails(Model model, @PathVariable(value = "id") long id) throws NoSuchElementException {

        if (!plasticRepository.existsById(id)) {
            return "redirect:/items";
        }

        Optional<Plastic> item = plasticRepository.findById(id);

        Plastic finalItem = item.get();
        model.addAttribute("item", finalItem);
        return "itemDetails";

    }

    @GetMapping("/items/textile/{id}")
    public String textileDetails(Model model, @PathVariable(value = "id") long id) throws NoSuchElementException {

        if (!textilRepository.existsById(id)) {
            return "redirect:/items";
        }

        Optional<Textile> item = textilRepository.findById(id);

        Textile finalItem = item.get();
        model.addAttribute("item", finalItem);
        return "itemDetails";

    }



}
