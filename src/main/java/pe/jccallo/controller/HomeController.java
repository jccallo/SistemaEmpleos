package pe.jccallo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pe.jccallo.model.Vacante;

//ctrl + shift + o importamos automaticamente

@Controller 
public class HomeController 
{
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante> lista = this.getVacantes();
		model.addAttribute("vacantes", lista);
		
		return "tabla";
	}
	
	@GetMapping("/detalle")
	public String mostrarDetalle(Model model)
	{
		Vacante vacante = new Vacante();
		vacante.setNombre("Ingeniero de comunicaciones");
		vacante.setDescripcion("Se solicita ingeniero para dar soporte");
		vacante.setFecha(new Date());
		vacante.setSalario(9700.0);
		
		model.addAttribute("vacante", vacante);
		
		return "detalle";
	}
	
	@GetMapping("/listado")
	public String mostrarListado(Model model)
	{
		List<String> lista = new LinkedList<String>();
		lista.add("Ingenieiro de Sistemas");
		lista.add("Auxiliar de Contabilidad");
		lista.add("Arquitecto");
		
		model.addAttribute("empleos", lista);
		
		return "listado";
	}
	
	@GetMapping("/")
	public String mostrarHome(Model model) 
	{
		/*
		model.addAttribute("mensaje", "Bienvenido a DVDExpress!!!");
		model.addAttribute("fecha", new Date());
		*/
		
		String nombre = "Auxiliar";
		Date fecha = new Date();
		Double salario = 9000.0;
		Boolean vigente = true;
		
		model.addAttribute("nombre", nombre);
		model.addAttribute("fecha", fecha);
		model.addAttribute("salario", salario);
		model.addAttribute("vigente", vigente);
		
		return "home";
	}
	
	private List<Vacante> getVacantes() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		List<Vacante> lista = new LinkedList<Vacante>();
		try {
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero 1");
			vacante1.setDescripcion("Se solicita ingeniero para dar soporte 1");
			vacante1.setFecha(sdf.parse("08-02-2019"));
			vacante1.setSalario(9700.0);
			vacante1.setDestacado(0);
			vacante1.setImagen("empresa1.png");
			
			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Ingeniero 2");
			vacante2.setDescripcion("Se solicita ingeniero para dar soporte2");
			vacante2.setFecha(sdf.parse("09-02-2019"));
			vacante2.setSalario(12000.0);
			vacante2.setDestacado(1);
			
			Vacante vacante3 = new Vacante();
			vacante3.setId(2);
			vacante3.setNombre("Ingeniero 3");
			vacante3.setDescripcion("Se solicita ingeniero para dar soporte3");
			vacante3.setFecha(sdf.parse("09-02-2019"));
			vacante3.setSalario(15000.0);
			vacante3.setDestacado(0);
			vacante3.setImagen("empresa3.png");
			
			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
		} 
		catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		return lista;
	}
}
