package br.edu.ifto.aula05.controller;

import br.edu.ifto.aula05.model.entity.Pessoa;
import br.edu.ifto.aula05.model.entity.PessoaFisica;
import br.edu.ifto.aula05.model.entity.PessoaJuridica;
import br.edu.ifto.aula05.model.entity.Venda;
import br.edu.ifto.aula05.model.repository.ItemVendaRepository;
import br.edu.ifto.aula05.model.repository.PessoaRepository;
import br.edu.ifto.aula05.model.repository.VendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Transactional
@Controller
@RequestMapping("venda")
public class VendaController {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping("/form")
    public String form(Venda venda, ModelMap model) {
        model.addAttribute("venda", venda);
        model.addAttribute("itemVenda", itemVendaRepository.itensVenda());
        return "venda/form";
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        var vendas = vendaRepository.findAll();

        for (Venda venda : vendas) {
            if (venda.getPessoa() instanceof PessoaFisica){
                venda.setTipoPessoa("PessoaFisica");
            } else if (venda.getPessoa() instanceof PessoaJuridica) {
                venda.setTipoPessoa("PessoaJuridica");
            }
        }
        model.addAttribute("vendas", vendas);
        return new ModelAndView("venda/list", model);
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Venda venda) {
        vendaRepository.save(venda);
        return new ModelAndView("redirect:/venda/list");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {
        vendaRepository.remove(id);
        return new ModelAndView("redirect:/venda/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("venda", vendaRepository.venda(id));
        return new ModelAndView("/venda/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Venda venda) {
        vendaRepository.update(venda);
        return new ModelAndView("redirect:/venda/list");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detalhe(@PathVariable Long id, ModelMap model){
        Venda venda = vendaRepository.venda(id);
        model.addAttribute("detail", venda);
        return new ModelAndView("/venda/detail", model);
    }

    @GetMapping("/date")
    public String date(Model model) {
        LocalDateTime agora = LocalDateTime.now();
        model.addAttribute("dataVenda", agora);
        return "date";
    }
}
