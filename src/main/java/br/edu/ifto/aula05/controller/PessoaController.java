package br.edu.ifto.aula05.controller;

import br.edu.ifto.aula05.model.entity.Pessoa;
import br.edu.ifto.aula05.model.entity.PessoaFisica;
import br.edu.ifto.aula05.model.entity.PessoaJuridica;
import br.edu.ifto.aula05.model.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Transactional
@Controller
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping("/form")
    public String form(Model model) {

        model.addAttribute("tipoPessoa");
        return "pessoa/form";
    }

    @PostMapping("/save")
    public String save(Pessoa pessoa, String tipoPessoa, String nome, String cpf, String razaoSocial, String cnpj, String telefone, String email) {
        pessoa.setTelefone(telefone);
        pessoa.setEmail(email);
        if (tipoPessoa.equalsIgnoreCase("fisica") && pessoa instanceof PessoaFisica) {
            ((PessoaFisica)pessoa).setNome(nome);
            ((PessoaFisica)pessoa).setCpf(cpf);
        } else if (tipoPessoa.equalsIgnoreCase("juridica") && pessoa instanceof PessoaJuridica) {
            ((PessoaJuridica) pessoa).setRazaoSocial(razaoSocial);
            ((PessoaJuridica) pessoa).setCnpj(cnpj);
        }
        pessoaRepository.save(pessoa);
        return "redirect:/pessoa/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("pessoas", pessoaRepository.findAll());
        return "pessoa/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Pessoa pessoa = pessoaRepository.findById(id);
        if(pessoa == null) {
            throw new RuntimeException("Pessoa não encontrada");
        }
        model.addAttribute("pessoa", pessoa);
        return "pessoa/form";
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable Long id, Model model) {
        pessoaRepository.remove(id);
        return  new ModelAndView("redirect:/pessoa/list");
    }
}
