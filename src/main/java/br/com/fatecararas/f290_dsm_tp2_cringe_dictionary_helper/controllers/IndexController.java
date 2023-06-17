package br.com.fatecararas.f290_dsm_tp2_cringe_dictionary_helper.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fatecararas.f290_dsm_tp2_cringe_dictionary_helper.model.Word;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String getIndex() {
        return "index";
    }

    //http://localhost:9000/sum?a=10&b=20

    @GetMapping("/sum")
    public String sumRequestParam(@RequestParam("a") Integer a, 
    @RequestParam("b") Integer b) {
        Integer sum = a + b;
        System.out.println("@RequestParam");
        System.out.printf("A sum de %d e %d é %d.\n", a, b, sum);
        return "redirect:/";
    }

    @GetMapping("/sum/{a}/{b}")
    public String sumPathVariable(@PathVariable("a") Integer a, 
    @PathVariable("b") Integer b) {
        Integer sum = a + b;
        System.out.println("@PathVariable");
        System.out.printf("The sum of the numbers %d and %d is %d.\n", a, b, sum);
        return "redirect:/";
    }

    @PostMapping("/sum")
    public String post(@RequestBody Word word) {
        System.out.println("@PostMapping");
        System.out.println(word);
        return "index";
    }

    @DeleteMapping("/sum")
    public String delete() {
        System.out.println("@DeleteMapping");
        return "index";
    }

    @PutMapping("/sum")
    public String put() {
        System.out.println("@PutMapping");
        return "index";
    }

    @PatchMapping("/sum")
    public String patch() {
        System.out.println("@PatchMapping");
        return "index";
    }
}
