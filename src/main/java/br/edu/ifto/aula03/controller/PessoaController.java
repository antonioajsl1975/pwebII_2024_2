package br.edu.ifto.aula03.controller;

import br.edu.ifto.aula03.model.entity.Pessoa;
import br.edu.ifto.aula03.model.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("pessoa")
public class PessoaController {

    @Autowired
    PessoaRepository repository;

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("pessoas", repository.pessoas());
        return new ModelAndView("/pessoa/list");
    }

    @GetMapping("/form")
    public String form(Pessoa pessoa) {
        return "pessoa/form";
    }

    @PostMapping("/save")
    public ModelAndView save(Pessoa pessoa) {
        repository.save(pessoa);
        return new ModelAndView("redirect:/pessoa/list");
    }

    //@PathVariable é utilizado quando o valor da variável é passada diretamente na URL
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {
        repository.remove(id);
        return new ModelAndView("redirect:/pessoa/list");
    }

    //@PathVariable é utilizado quando o valor da variável é passada diretamente na URL
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("pessoa", repository.pessoa(id));
        return new ModelAndView("/pessoa/form", model);
    }

    @Transactional
    @PostMapping("/update")
    public ModelAndView update(Pessoa pessoa) {
        repository.update(pessoa);
        return new ModelAndView("redirect:/pessoa/list");
    }
}
