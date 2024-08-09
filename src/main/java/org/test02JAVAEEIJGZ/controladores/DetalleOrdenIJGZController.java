package org.test02JAVAEEIJGZ.controladores;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.test02JAVAEEIJGZ.modelos.DetalleOrdenIJGZ;
import org.test02JAVAEEIJGZ.modelos.OrdenIJGZ;
import org.test02JAVAEEIJGZ.modelos.ProductoIJGZ;
import org.test02JAVAEEIJGZ.servicios.interfaces.IDetalleOrdenIJGZService;
import org.test02JAVAEEIJGZ.servicios.interfaces.IOrdenIJGZService;
import org.test02JAVAEEIJGZ.servicios.interfaces.IProductoIJGZService;

@Controller
@RequestMapping("/detallesOrden") 
public class DetalleOrdenIJGZController {
    @Autowired
    private IDetalleOrdenIJGZService detalleOrdenIJGZService; 
    @Autowired 
    private IProductoIJGZService productoIJGZService; 
    @Autowired
    private IOrdenIJGZService ordenIJGZService; 

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page,
                        @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<DetalleOrdenIJGZ> detalleOrdenes = detalleOrdenIJGZService.buscarTodosPaginados(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("detalleOrdenes", detalleOrdenes);

        int totalPages = detalleOrdenes.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "detalleOrden/index"; 
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("detalleOrden", new DetalleOrdenIJGZ());
    
        List<ProductoIJGZ> productos = productoIJGZService.obtenerTodos();
        List<OrdenIJGZ> ordenes = ordenIJGZService.obtenerTodos();
    
        model.addAttribute("productos", productos);
        model.addAttribute("ordenes", ordenes);
    
        return "detalleOrden/create"; 
    }
    

    @PostMapping("/save")
    public String save(@ModelAttribute("detalleOrden") DetalleOrdenIJGZ detalleOrden, RedirectAttributes redirectAttributes) {
        detalleOrdenIJGZService.crearOEditar(detalleOrden);
        redirectAttributes.addFlashAttribute("msg", "Detalle de orden guardado exitosamente!");
        return "redirect:/detallesOrden"; 
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        DetalleOrdenIJGZ detalleOrden = detalleOrdenIJGZService.buscarPorId(id);
        model.addAttribute("detalleOrden", detalleOrden);

        List<ProductoIJGZ> productos = productoIJGZService.obtenerTodos();
        List<OrdenIJGZ> ordenes = ordenIJGZService.obtenerTodos();

        model.addAttribute("productos", productos);
        model.addAttribute("ordenes", ordenes);

        return "detalleOrden/edit"; 
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("detalleOrden") DetalleOrdenIJGZ detalleOrden, RedirectAttributes redirectAttributes) {
        detalleOrdenIJGZService.crearOEditar(detalleOrden);
        redirectAttributes.addFlashAttribute("msg", "Detalle de orden actualizado exitosamente!");
        return "redirect:/detallesOrden"; 
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Long id, Model model) {
        DetalleOrdenIJGZ detalleOrden = detalleOrdenIJGZService.buscarPorId(id);
        model.addAttribute("detalleOrden", detalleOrden);
        return "detalleOrden/delete"; 
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        detalleOrdenIJGZService.eliminarPorId(id);
        redirectAttributes.addFlashAttribute("msg", "Detalle de orden eliminado exitosamente!");
        return "redirect:/detallesOrden"; 
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        DetalleOrdenIJGZ detalleOrden = detalleOrdenIJGZService.buscarPorId(id);
        model.addAttribute("detalleOrden", detalleOrden);
        return "detalleOrden/details"; 
    }
}
