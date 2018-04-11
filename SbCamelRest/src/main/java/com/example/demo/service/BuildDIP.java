package com.example.demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import com.example.demo.model.RequestDIBBuild;


@Service
public class BuildDIP {

	public BuildDIP() {
		
	}	

	public String  readRequest (RequestDIBBuild requestDIBBuild)
	{

		System.out.println(requestDIBBuild.getClass());
		// Copie des fichiers du repertoire vers 
		
		Path psource = Paths.get(requestDIBBuild.getRepInMetada());
	    Path pdestination = Paths.get(requestDIBBuild.getRepOutDip());
	    try {
			Path result = Files.copy(psource, pdestination, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
			System.out.println("Resultat " + result.toAbsolutePath());
			return " entree " + psource.getNameCount() + " " +  psource.getFileName() + " result " + result.toAbsolutePath(); 
		} catch (IOException e) {
			
			e.printStackTrace();
			return  e.getMessage();
		}
		
		
	}

}
