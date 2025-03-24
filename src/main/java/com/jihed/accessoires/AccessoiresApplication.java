package com.jihed.accessoires;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jihed.accessoires.entities.Accessoire;
import com.jihed.accessoires.service.AccessoireService;

@SpringBootApplication
public class AccessoiresApplication implements CommandLineRunner{
	
	@Autowired
	AccessoireService accessoireService;

	public static void main(String[] args) {
		SpringApplication.run(AccessoiresApplication.class, args);
		System.out.println("jihed");
	}

	@Override
	public void run(String... args) throws Exception {
		accessoireService.saveAccessoire(new Accessoire("tapis","jaune",50.0,new Date()));
		accessoireService.saveAccessoire(new Accessoire("camera","mauve",670.0,new Date()));
		accessoireService.saveAccessoire(new Accessoire("ecran","noir",830.0,new Date()));
		
	}

}
