package com.jihed.accessoires.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jihed.accessoires.entities.Accessoire;
import com.jihed.accessoires.service.AccessoireService;

@Controller
public class AccessoireController {
	@Autowired
	AccessoireService AccessoireService;

	@RequestMapping("/listeAccessoire")
	public String listeAccessoires(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page, 
			@RequestParam (name="size", defaultValue = "3") int size)
	{
		
		Page<Accessoire> access = AccessoireService.getAllAccessoireParPage(page, size); 
		modelMap.addAttribute("accessoires", access); 
		modelMap.addAttribute("pages", new int[access.getTotalPages()]);  
		modelMap.addAttribute("currentPage", page);    
		modelMap.addAttribute("size", size); 
		return "liste"; 
	}

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createAccessoire";
	}

	@RequestMapping("/saveAccessoire")
	public String saveAccessoire(@ModelAttribute("accessoire") Accessoire accessoire, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		accessoire.setDateSortieAcess(dateCreation);

		Accessoire saveAccessoire = AccessoireService.saveAccessoire(accessoire);
		String msg = "produit enregistré avec Id " + saveAccessoire.getIdAccess();
		modelMap.addAttribute("msg", msg);
		return "createAccessoire";
	}

	@RequestMapping("/supprimerAccessoire")
	public String supprimerAccessoire(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page, 
			@RequestParam (name="size", defaultValue = "3") int size) 
	{
		AccessoireService.deleteAccessoireById(id);
		Page<Accessoire> access = AccessoireService.getAllAccessoireParPage(page, size); 
				 
				modelMap.addAttribute("accessoires", access);   
				modelMap.addAttribute("pages", new int[access.getTotalPages()]);  
				modelMap.addAttribute("currentPage", page);  
				modelMap.addAttribute("size", size);  
				return "liste"; 
	}

	@RequestMapping("/modifierAccessoire")
	public String editerProduit(@RequestParam("id") Long id, ModelMap modelMap) {
		Accessoire p = AccessoireService.getAccessoire(id);
		modelMap.addAttribute("accessoire", p);
		return "editerAccessoire";
	}

	@RequestMapping("/updateAccessoire")
	public String updateAccessoire(@ModelAttribute("Accessoire") Accessoire accessoire, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		accessoire.setDateSortieAcess(dateCreation);

		AccessoireService.updateAccessoire(accessoire);
		List<Accessoire> access = AccessoireService.getAllAccessoire();
		modelMap.addAttribute("accessoires", access);
		return "liste";
	}
}
