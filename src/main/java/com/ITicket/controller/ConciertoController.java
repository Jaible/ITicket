package com.ITicket.controller;

import com.ITicket.entity.Concierto;
import com.ITicket.service.IConciertoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConciertoController {
    
    @Autowired
    private IConciertoService conciertoService;
    
    @GetMapping("/concierto")
    public String index (Model model){
        List<Concierto> listaConcierto = conciertoService.getAllConcierto();
        model.addAttribute("titulo","Historial de conciertos");
        model.addAttribute("concierto",listaConcierto);
        return "concierto";
    }
    
    @GetMapping("/conciertoN")
    public String crearConcierto (Model model){
        List<Concierto> listaConcierto = conciertoService.getAllConcierto();
        model.addAttribute("concierto",new Concierto());
        return "crear";
    }
    
    @PostMapping("/save")
    public String guardarConcierto (@ModelAttribute Concierto concierto){
        conciertoService.saveConcierto(concierto);
        return "redirect:/concierto";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteConcierto(@PathVariable("id") Long idConcierto){
        conciertoService.delete(idConcierto);
        return "redirect:/concierto";
    }
}
