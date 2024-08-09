package org.test02JAVAEEIJGZ.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.test02JAVAEEIJGZ.modelos.OrdenIJGZ;
import org.test02JAVAEEIJGZ.servicios.interfaces.IOrdenIJGZService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("ordenes")
public class OrdenIJGZController {
    @Autowired
    private IOrdenIJGZService ordenIJGZService;
  
    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1) - 1; // si no está seteado se asigna 0
        int pageSize = size.orElse(5); // tamaño de la página, se asigna 5
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<OrdenIJGZ> ordenes = ordenIJGZService.buscarTodosPaginados(pageable);
        model.addAttribute("ordenes", ordenes);

        int totalPages = ordenes.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "orden/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("orden", new OrdenIJGZ());
        return "orden/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("orden") OrdenIJGZ orden, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute("orden", orden);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "orden/create";
        }

        ordenIJGZService.crearOEditar(orden);
        attributes.addFlashAttribute("msg", "Marca creada correctamente");
        return "redirect:/ordenes";
    }

    @GetMapping("/details/{id}")
public String details(@PathVariable("id") Long id, Model model) {
    OrdenIJGZ orden = ordenIJGZService.buscarPorId(id).get();
    model.addAttribute("orden", orden);
    return "orden/details";
}


  
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        OrdenIJGZ orden = ordenIJGZService.buscarPorId(id).get();
        model.addAttribute("orden", orden);
        return "orden/edit";
    }
    @PostMapping("/edit")
    public String update(@ModelAttribute("orden") OrdenIJGZ orden, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute("orden", orden);
            attributes.addFlashAttribute("error", "No se pudo modificar debido a un error.");
            return "orden/edit";
        }

        ordenIJGZService.crearOEditar(orden);
        attributes.addFlashAttribute("msg", "Marca modificada correctamente");
        return "redirect:/ordenes";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id, Model model){
        OrdenIJGZ orden = ordenIJGZService.buscarPorId(id).get();
        model.addAttribute("orden", orden);
        return "orden/delete";
    }

    @PostMapping("/delete")
    public String delete(OrdenIJGZ orden, RedirectAttributes attributes){
        ordenIJGZService.eliminarPorId(orden.getId());
        attributes.addFlashAttribute("msg", "marca eliminada correctamente");
        return "redirect:/ordenes";
    }
}
