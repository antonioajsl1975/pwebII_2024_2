package br.edu.ifto.aula03.controller;

import br.edu.ifto.aula03.model.entity.Veiculo;
import br.edu.ifto.aula03.model.repository.MarcaRepository;
import br.edu.ifto.aula03.model.repository.ModeloRepository;
import br.edu.ifto.aula03.model.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("veiculo")
public class VeiculoController {

    @Autowired
    VeiculoRepository veiculoRepository;

    @Autowired
    MarcaRepository marcaRepository;

    @Autowired
    ModeloRepository modeloRepository;

    //Método para gerar a lista de anos
    private List<Integer> gerarListaAnos() {
        int anoSeguinte = Year.now().getValue() + 1;
        return IntStream.rangeClosed(1990, anoSeguinte)
                .boxed().collect(Collectors.toList());
    }

    // Método para listar veículos com paginação
    @GetMapping("/list")
    public ModelAndView listar(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "5") int size,
                               ModelMap model) {
        List<Veiculo> veiculos = veiculoRepository.veiculos(page, size);

        // Calculando o número total de veículos para a paginação
        long totalVeiculos = veiculoRepository.count();
        int totalPages = (int) Math.ceil((double) totalVeiculos / size);

        model.addAttribute("veiculos", veiculos);
        model.addAttribute("modelos", modeloRepository.modelos());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageSize", size);

        return new ModelAndView("/veiculo/list", model);
    }

    @GetMapping("/form")
    public ModelAndView form(Veiculo veiculo, ModelMap model) {
        model.addAttribute("marcas", marcaRepository.marcas());
        model.addAttribute("modelos", modeloRepository.modelos());

        // Adiciona a lista de anos ao ModelAndView
        model.addAttribute("anos", gerarListaAnos());
        return new ModelAndView("veiculo/form", model);
    }

    @PostMapping("/save")
    public ModelAndView save(Veiculo veiculo) {
        veiculoRepository.save(veiculo);
        return new ModelAndView("redirect:/veiculo/list");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {
        veiculoRepository.remove(id);
        return new ModelAndView("redirect:/veiculo/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("modelos", modeloRepository.modelos());
        model.addAttribute("veiculo", veiculoRepository.veiculo(id));
        model.addAttribute("anos", gerarListaAnos());
        return new ModelAndView("/veiculo/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Veiculo veiculo) {
        veiculoRepository.save(veiculo);
        return new ModelAndView("redirect:/veiculo/list");
    }

//    @GetMapping("/form")
//    public ModelAndView mostrarForm() {
//        // Cria o ModelAndView e define o nome da view "veiculo/form"
//        ModelAndView modelAndView = new ModelAndView("veiculo/form");
//
//        // Adiciona a lista de anos ao ModelAndView
//        int anoSeguinte = Year.now().getValue() + 1;
//        modelAndView.addObject("anos", IntStream.rangeClosed(1980, anoSeguinte)
//                .boxed().collect(Collectors.toList()));
//
//        // Adiciona um objeto Veiculo vazio ao ModelAndView
//        modelAndView.addObject("veiculo", new Veiculo());
//        return modelAndView;
//    }
}

