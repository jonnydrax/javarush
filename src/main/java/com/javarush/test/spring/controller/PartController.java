package com.javarush.test.spring.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.javarush.test.spring.model.Part;
import com.javarush.test.spring.service.PartService;

/**
 * @author imssbora
 */
@Controller
public class PartController {
    private final Integer maxRows = 10;

    @Autowired
    private PartService partService;

    @GetMapping("/")
    public String partForm(
            @RequestParam(required = false, defaultValue = "1", value="p") String page,
            @RequestParam(required = false, defaultValue = "a", value="s") String sort,
            @RequestParam(required = false, value="n") String name,
            Locale locale,
            Model model) {

        if(name != null && name.isEmpty())name = null;

        Integer start = (Integer.parseInt(page) - 1) * this.maxRows;

        List<Part> parts;
        Integer totalParts;

        switch(sort){
            case "r":
                parts = partService.listRequired(start, this.maxRows);
                totalParts = partService.countPartsRequired(name);
                break;
            case "o":
                parts = partService.listOptional(start, this.maxRows);
                totalParts = partService.countPartsOptional(name);
                break;
            default:
                parts = partService.listAll(start, this.maxRows, name);
                totalParts = partService.countPartsAll(name);
                break;
        }

        model.addAttribute("page", page);
        model.addAttribute("name", name);
        model.addAttribute("sort", sort);
        model.addAttribute("part", new Part());
        model.addAttribute("parts", parts);
        model.addAttribute("totalComputers", partService.countComputers());

        model.addAttribute("maxPage", (int)Math.ceil(totalParts*1.00 / this.maxRows));

        return "partForm";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id,
        Locale locale,
        Model model){
        partService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") Long id,
                         Locale locale,
                         Model model){

        model.addAttribute("part", partService.load(id));

        return "editForm";
    }


    @PostMapping("/save")
    public String savePart(@ModelAttribute("part") @Valid Part part,
                           BindingResult result, Model model) {

        if (result.hasErrors()) {

            model.addAttribute("part", part);
            //model.addAttribute("parts", partService.listAll(1, this.maxRows, null));
            return "editForm";
        }

        partService.save(part);

        return "redirect:/";
    }
}
