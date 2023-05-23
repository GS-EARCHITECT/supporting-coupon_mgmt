package deal_mgmt.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import deal_mgmt.model.dto.PromoDetailsDTO;
import deal_mgmt.service.I_PromoDetailsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/promoDetailsManagement")
public class Promo_Details_Controller {

//	private static final Logger logger = LoggerFactory.getLogger(PromoDetails_Controller.class);

	@Autowired
	private I_PromoDetailsService promoDetailsServ;
	
	@PostMapping("/new")
	public ResponseEntity<PromoDetailsDTO> newpromo(@RequestBody PromoDetailsDTO promoDTO) {
		PromoDetailsDTO promoDTO2 = promoDetailsServ.newPromoDetails(promoDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(promoDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllpromos", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PromoDetailsDTO>> getAllPromoDetailss() {
		ArrayList<PromoDetailsDTO> promoDTOs = promoDetailsServ.getAllPromoDetails();
		return new ResponseEntity<>(promoDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectPromos", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PromoDetailsDTO>> getSelectPromoDetailss(@RequestBody ArrayList<Long> promoSeqNos) {
		ArrayList<PromoDetailsDTO> promoDTOs = promoDetailsServ.getSelectPromos(promoSeqNos);		
		return new ResponseEntity<>(promoDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectPromosByRules", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PromoDetailsDTO>> getSelectPromoDetailssByRules(@RequestBody ArrayList<Long> cos) {
		ArrayList<PromoDetailsDTO> promoDTOs = promoDetailsServ.getSelectPromosByRules(cos);		
		return new ResponseEntity<>(promoDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getById/{promoSeqNo}/{ruleSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })	
	public ResponseEntity<PromoDetailsDTO> getPromoDetailsById(@PathVariable Long promoSeqNo, @PathVariable Long ruleSSeqNo) 
	{
		PromoDetailsDTO promoAccNoDTOs = promoDetailsServ.getPromoDetailsById(promoSeqNo, ruleSSeqNo);		
		return new ResponseEntity<>(promoAccNoDTOs, HttpStatus.OK);
	}
	
	@PutMapping("/updpromo")
	public void updatepromo(@RequestBody PromoDetailsDTO promoDTO) 
	{
		promoDetailsServ.updPromoDetails(promoDTO);	
		return;
	}

	@DeleteMapping("/delpromo")
	public void deletepromo(@RequestBody PromoDetailsDTO lDetails) {
		promoDetailsServ.delPromoDetails(lDetails);
	}

	@DeleteMapping("/delSelectpromo")
	public void deleteSelectpromo(@RequestBody ArrayList<Long> promoSeqNoList) {
		promoDetailsServ.delSelectPromos(promoSeqNoList);;
		return;
	}
	
	@DeleteMapping("/delAllpromo")
	public void deleteAllpromos() {
		promoDetailsServ.delAllPromoDetails();
		return;
	}
	}