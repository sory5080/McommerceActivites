package com.expedition.web.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.expedition.dao.ExpeditionDao;
import com.expedition.model.Expedition;
import com.expedition.web.exceptions.BadRequestExpeditionException;
import com.expedition.web.exceptions.ExpeditionNotFoundException;

@RestController
public class ExpeditionController {
	
	@Autowired
	private ExpeditionDao expDao;
	
	@GetMapping(value="/Expeditions")
	public List<Expedition> listeExpedition() {
		
		return expDao.findAll(); 
	}
	
	@PostMapping(value="/Expeditions")
	public ResponseEntity<Expedition> newExpedition(@RequestBody Expedition expedition) throws URISyntaxException {
		
		//On s'assure que l'expédition reçu est nouvelle avant de l'ajouter
		if (expedition.getId() == null) {
			throw new BadRequestExpeditionException("KUne nouvelle expédition ne peut avoir d'id !");
		}
		Expedition result = expDao.save(expedition);
		
		return ResponseEntity.created(new URI("/Expeditions/" + result.getId()))
				.header("idCommande", String.valueOf(result.getIdCommande()))
				.body(result);
	}
	
	@GetMapping(value="/Expeditions/{idExp}")
	public Optional<Expedition> findOneExpedition(@PathVariable Long idExp) {
		
		Optional<Expedition> expedition = expDao.findById(idExp);
		
		if (!expedition.isPresent()) {
			throw new ExpeditionNotFoundException("L'expédition avec comme id " + idExp + " n'existe pas");
		}
		
		return expedition;
	}
	
	@PutMapping(value="/Expeditions")
	public ResponseEntity<Expedition> updateExpedition(@RequestBody Expedition expedition) {
		
		//On s'assure que l'expédition reçu possède un ID, pour pouvoir la mettre à jour
		if (expedition.getId() == null) {
			throw new BadRequestExpeditionException("Cette expédition ne peut être mis à jour! car elle n'a pas d'id");
		}
		
		Expedition result = expDao.save(expedition);
		
		return ResponseEntity.ok(result);
				
	}

}
