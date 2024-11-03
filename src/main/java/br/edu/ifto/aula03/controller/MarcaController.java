package br.edu.ifto.aula03.controller;

import br.edu.ifto.aula03.model.entity.Marca;
import br.edu.ifto.aula03.model.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("marca")
public class MarcaController {

    @Autowired
    MarcaRepository marcaRepository;

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("marcas", marcaRepository.marcas());
        return new ModelAndView("/marca/list");
    }

    @GetMapping("/form")
    public String form(Marca marca) {
        return "marca/form";
    }

    @PostMapping("/save")
    public ModelAndView save(Marca marca) {
        marcaRepository.save(marca);
        return new ModelAndView("redirect:/marca/list");
    }

    //@PathVariable é utilizado quando o valor da variável é passada diretamente na URL
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {
        marcaRepository.remove(id);
        return new ModelAndView("redirect:/marca/list");
    }

    //@PathVariable é utilizado quando o valor da variável é passada diretamente na URL
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("marca", marcaRepository.marca(id));
        return new ModelAndView("/marca/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Marca marca) {
        marcaRepository.save(marca);
        return new ModelAndView("redirect:/marca/list");
    }
}
