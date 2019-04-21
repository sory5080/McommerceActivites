package com.clientui.proxies;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.clientui.beans.ExpeditionBean;

@FeignClient(name="zuul-server")
@RibbonClient(name="microservice-expedition")
public interface MicroserviceExpeditionProxy {
	
	@GetMapping(value="/microservice-expedition/Expeditions")
	public List<ExpeditionBean> listeExpedition();
	
	@PostMapping(value="/microservice-expedition/Expeditions")
	public ResponseEntity<ExpeditionBean> newExpedition(@RequestBody ExpeditionBean expedition);
	
	@GetMapping(value="/microservice-expedition/Expeditions/{idExp}")
	public Optional<ExpeditionBean> findOneExpedition(@PathVariable Long idExp);
	
	@PutMapping(value="/microservice-expedition/Expeditions")
	public ResponseEntity<ExpeditionBean> updateExpedition(@RequestBody ExpeditionBean expedition);

}
