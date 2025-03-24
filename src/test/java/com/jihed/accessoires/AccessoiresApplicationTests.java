package com.jihed.accessoires;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.jihed.accessoires.entities.Accessoire;
import com.jihed.accessoires.repos.AccessoireRepository;
import com.jihed.accessoires.service.AccessoireService;

@SpringBootTest
class AccessoiresApplicationTests {


	@Autowired 
	private AccessoireRepository AccessoireRepository; 
	@Autowired
	private AccessoireService Accessoireservice; 
	
	@Test 
	public void testCreateAccessoire() { 
	Accessoire access = new Accessoire("casque","blanc",190.0,new Date()); 
	AccessoireRepository.save(access); 
	}

	@Test 
	public void testUpdateAccessoire() 
	{ 
		Accessoire a = AccessoireRepository.findById(1L).get(); 
		a.setPrixAccess(199.0); 
		AccessoireRepository.save(a); 
		System.out.println(a);
	}
	
	@Test
	public void testDeleteProduit() 
	  { 
	   AccessoireRepository.deleteById(1L);
	    
	  } 

	    
	@Test 
	 public void testListerTousProduits() 
	  { 
	   List<Accessoire>  access = AccessoireRepository.findAll();   
	   for (Accessoire a : access) 
	   { 
	    System.out.println(a); 
	   }   
	  } 
	
	@Test
	public void testFindByNomAccessoireContains() {
	    // Getting the Page of Accessoires
	    Page<Accessoire> access = Accessoireservice.getAllAccessoireParPage(1, 1);

	    // Printing some details about the Page
	    System.out.println("Page size: " + access.getSize()); 
	    System.out.println("Total elements: " + access.getTotalElements()); 
	    System.out.println("Total pages: " + access.getTotalPages()); 

	    access.getContent().forEach(accessoire -> {
	        System.out.println(accessoire); 
	    });

	    // Alternative approach using a for loop:
	    /* 
	    List<Accessoire> prods = access.getContent();
	    for (Accessoire p : prods) {
	        System.out.println(p); // Assuming Accessoire has a proper toString() method
	    } 
	    */
	}

}
