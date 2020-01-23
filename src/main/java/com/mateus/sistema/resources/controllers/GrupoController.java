package com.mateus.sistema.resources.controllers;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mateus.sistema.converters.GrupoToGrupoDto;
import com.mateus.sistema.domain.produto.Grupo;
import com.mateus.sistema.dto.produto.subgrupo.GrupoDTO;
import com.mateus.sistema.services.amqp.GrupoService;

public class GrupoController {
	private static final Logger log = LogManager.getLogger(GrupoController.class);

    private GrupoService grupoService;

    private GrupoToGrupoDto grupoToGrupoDto;



    @Autowired
    public void setProductToProductForm(GrupoToGrupoDto grupoToGrupoDto) {
        this.grupoToGrupoDto = grupoToGrupoDto;
    }

    @Autowired
    public void setProductService(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/grupo/list";
    }

    @RequestMapping({"/grupo/list", "/grupo"})
    public String listProducts(Model model){
        model.addAttribute("grupo", grupoService.listAll());
        return "grupo/list";
    }

    @RequestMapping("/grupo/show/{id}")
    public String getProduct(@PathVariable String id, Model model){
        model.addAttribute("grupo", grupoService.getById(Long.valueOf(id)));
        return "grupo/show";
    }

    @RequestMapping("grupo/edit/{id}")
    public String edit(@PathVariable String id, Model model){
    	Grupo grupo = grupoService.getById(Long.valueOf(id));
        GrupoDTO grupoDto = grupoToGrupoDto.convert(grupo);

        model.addAttribute("grupoForm", grupoDto);
        return "grupo/grupoform";
    }

    @RequestMapping("/grupo/new")
    public String newProduct(Model model){
        model.addAttribute("grupoForm", new GrupoDTO());
        return "grupo/grupoform";
    }

    @RequestMapping(value = "/grupo", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Valid GrupoDTO grupoDto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "grupo/grupoform";
        }

        Grupo savedProduct = grupoService.saveOrUpdateGrupoForm(grupoDto);

        return "redirect:/grupo/show/" + savedProduct.getId();
    }

    @RequestMapping("/grupo/delete/{id}")
    public String delete(@PathVariable String id){
    	grupoService.delete(Long.valueOf(id));
        return "redirect:/grupo/list";
    }

    @RequestMapping("/grupo/indexProduct/{id}")
    public String indexProduct(@PathVariable String id){
    	grupoService.sendProductMessage(id);
        return "redirect:/grupo/show/"+id;
    }
}
