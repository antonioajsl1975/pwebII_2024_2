package br.edu.ifto.aula03.controller;

import br.edu.ifto.aula03.model.entity.Veiculo;
import br.edu.ifto.aula03.model.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("veiculo")
public class VeiculoController {

    @Autowired
    VeiculoRepository repository;

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("veiculos", repository.veiculos());
        return new ModelAndView("/veiculo/list");
    }

    @GetMapping("/form")
    public String form(Veiculo veiculo) {
        return "veiculo/form";
    }

    @PostMapping("/save")
    public ModelAndView save(Veiculo veiculo) {
        repository.save(veiculo);
        return new ModelAndView("redirect:/veiculo/list");
    }

    //@PathVariable é utilizado quando o valor da variável é passada diretamente na URL
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {
        repository.remove(id);
        return new ModelAndView("redirect:/veiculo/list");
    }

    //@PathVariable é utilizado quando o valor da variável é passada diretamente na URL
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("veiculo", repository.veiculo(id));
        return new ModelAndView("/veiculo/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Veiculo veiculo) {
        repository.save(veiculo);
        return new ModelAndView("redirect:/veiculo/list");
    }
}
