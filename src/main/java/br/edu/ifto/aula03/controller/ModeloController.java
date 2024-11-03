package br.edu.ifto.aula03.controller;

import br.edu.ifto.aula03.model.entity.Modelo;
import br.edu.ifto.aula03.model.repository.MarcaRepository;
import br.edu.ifto.aula03.model.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("modelo")
public class ModeloController {

    @Autowired
    ModeloRepository modeloRepository;
    @Autowired
    private MarcaRepository marcaRepository;

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("modelos", modeloRepository.modelos());
        return new ModelAndView("/modelo/list");
    }

    @GetMapping("/form")
    public String form(@RequestParam(value = "id", required = false) Long id, ModelMap model) {
        Modelo modelo;

        if (id != null) {
            Optional<Modelo> modeloOptional = Optional.ofNullable(modeloRepository.modelo(id));
            if(modeloOptional.isPresent()) {
                modelo = modeloOptional.get();
            } else {
                throw new IllegalArgumentException("Modelo inválido: " + id);
            }
        } else {
            // Se o id não for passado, criamos uma nova instância de Modelo para um novo registro
            modelo = new Modelo();
        }
        model.addAttribute("marcas", marcaRepository.marcas());

        model.addAttribute("modelo", modelo);
        model.addAttribute("marcas", marcaRepository.marcas());

        return "/modelo/form"; //retorna a página do formulário
    }

    @PostMapping("/save")
    public ModelAndView save(Modelo modelo) {
        modeloRepository.save(modelo);
        return new ModelAndView("redirect:/modelo/list");
    }

    //@PathVariable é utilizado quando o valor da variável é passada diretamente na URL
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {
        modeloRepository.remove(id);
        return new ModelAndView("redirect:/modelo/list");
    }

    //@PathVariable é utilizado quando o valor da variável é passada diretamente na URL
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        //adiciona o objeto Modelo ao ModelMap
        model.addAttribute("modelo", modeloRepository.modelo(id));
        //adiciona a lista de Marcas ao ModelMap
        model.addAttribute("marcas", marcaRepository.marcas());
        //retorna a view do form com o ModelMap
        return new ModelAndView("/modelo/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Modelo modelo) {
        modeloRepository.save(modelo);
        return new ModelAndView("redirect:/modelo/list");
    }
}
