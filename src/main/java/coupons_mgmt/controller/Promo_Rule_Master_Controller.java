package coupons_mgmt.controller;

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
import coupons_mgmt.model.dto.PromoRuleMasterDTO;
import coupons_mgmt.services.I_PromoRuleMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/promoRuleManagement")
public class Promo_Rule_Master_Controller 
{

	private static final Logger logger = LoggerFactory.getLogger(Promo_Rule_Master_Controller.class);

	@Autowired
	private I_PromoRuleMasterService promoRuleMasterServ;
	
	@PostMapping("/new")
	public ResponseEntity<PromoRuleMasterDTO> newpromo(@RequestBody PromoRuleMasterDTO promoDTO) {
		PromoRuleMasterDTO promoDTO2 = promoRuleMasterServ.newPromoRuleMaster(promoDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(promoDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllpromos", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PromoRuleMasterDTO>> getAllPromoRuleMasters() {
		ArrayList<PromoRuleMasterDTO> promoDTOs = promoRuleMasterServ.getAllPromoRuleMasters();
		return new ResponseEntity<>(promoDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getById/{promoSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })	
	public ResponseEntity<PromoRuleMasterDTO> getPromoRuleMasterById(@PathVariable Long promoSeqNo) 
	{
		PromoRuleMasterDTO promoAccNoDTOs = promoRuleMasterServ.getPromoRuleMasterById(promoSeqNo);		
		return new ResponseEntity<>(promoAccNoDTOs, HttpStatus.OK);
	}
	
	@PutMapping("/updpromo")
	public void updatepromo(@RequestBody PromoRuleMasterDTO promoDTO) 
	{
			promoRuleMasterServ.updPromoRuleMaster(promoDTO);	
		return;
	}

	@DeleteMapping("/delpromo/{promoSeqNo}")
	public void deletepromo(@PathVariable Long promoSeqNo) {
		promoRuleMasterServ.delPromoRuleMaster(promoSeqNo);
	}

	@DeleteMapping("/delSelectpromos")
	public void deleteSelectpromos(@RequestBody ArrayList<Long> rulesSeqNoList) {
		promoRuleMasterServ.delSelectPromoRules(rulesSeqNoList);
		return;
	}
	
	@DeleteMapping("/delAllpromo")
	public void deleteAllpromos() {
		promoRuleMasterServ.delAllPromoRuleMasters();;
		return;
	}
	}