package br.com.fatecararas.f290_dsm_tp2_cringe_dictionary_helper.controllers;

import br.com.fatecararas.f290_dsm_tp2_cringe_dictionary_helper.model.Word;
import br.com.fatecararas.f290_dsm_tp2_cringe_dictionary_helper.services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cadastration")
public class CadastController {

    @Autowired
    private WordService service;

    @GetMapping
    public String cadastration(Model model) {
        model.addAttribute("word", new Word());
        return "cadastration";
    }

    @PostMapping("/cadastrate")
    public String cadastrar(@ModelAttribute("word") Word word) {
        System.out.println(word);
        service.cadastration(word);
        return "redirect:/dictionary";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {
        Word word = service.searchAll(id);
        model.addAttribute("word", word);
        return "cadastration";
    }
}
