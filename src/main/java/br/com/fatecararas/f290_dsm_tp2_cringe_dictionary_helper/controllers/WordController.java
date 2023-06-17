package br.com.fatecararas.f290_dsm_tp2_cringe_dictionary_helper.controllers;

import java.util.List;

// import javax.security.sasl.SaslServerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fatecararas.f290_dsm_tp2_cringe_dictionary_helper.model.Word;
import br.com.fatecararas.f290_dsm_tp2_cringe_dictionary_helper.services.WordService;

@Controller
@RequestMapping("/dictionary")
public class WordController {

    @Autowired
    private WordService service;

    @GetMapping
    public String home(Model model) {
        List<Word> words = service.getAll();
        model.addAttribute("titulo", "Dicionário");
        model.addAttribute("words", words);
        model.addAttribute("word", new Word());
        return "dictionary";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("word") Word word) {
        service.cadastration(word);
        return "redirect:/dictionary";
    }

    @GetMapping("/excluir/{id}")
    public String delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return "redirect:/dictionary";
    }
}
