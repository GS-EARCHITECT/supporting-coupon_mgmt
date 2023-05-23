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
import coupons_mgmt.model.dto.PromoRuleApplDetailsDTO;
import coupons_mgmt.services.I_PromoRuleApplDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/promoAppDetailRuleApplDetails")
public class Promo_Rule_App_Details_Controller 
{

	private static final Logger logger = LoggerFactory.getLogger(Promo_Rule_App_Details_Controller.class);

	@Autowired
	private I_PromoRuleApplDetailsService promoRuleApplDetailsServ;
	
	@PostMapping("/new")
	public ResponseEntity<PromoRuleApplDetailsDTO> newpromoAppDetail(@RequestBody PromoRuleApplDetailsDTO promoAppDetailDTO) {
		PromoRuleApplDetailsDTO promoAppDetailDTO2 = promoRuleApplDetailsServ.newPromoRuleApplDetails(promoAppDetailDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(promoAppDetailDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllpromoAppDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PromoRuleApplDetailsDTO>> getAllPromoRuleApplDetailss() {
		ArrayList<PromoRuleApplDetailsDTO> promoAppDetailDTOs = promoRuleApplDetailsServ.getAllPromoRuleApplDetails();
		return new ResponseEntity<>(promoAppDetailDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getById/{prseqno}", produces = { MediaType.APPLICATION_JSON_VALUE })	
	public ResponseEntity<PromoRuleApplDetailsDTO> getPromoRuleApplDetailsById(@PathVariable Long prSeqNo) 
	{
		PromoRuleApplDetailsDTO promoAppDetailAccNoDTOs = promoRuleApplDetailsServ.getPromoRuleApplDetailsById(prSeqNo);		
		return new ResponseEntity<>(promoAppDetailAccNoDTOs, HttpStatus.OK);
	}
	
	@PutMapping("/updpromoAppDetail")
	public void updatepromoAppDetail(@RequestBody PromoRuleApplDetailsDTO promoAppDetailDTO) 
	{
		promoRuleApplDetailsServ.updPromoRuleApplDetails(promoAppDetailDTO);	
		return;
	}

	@DeleteMapping("/delpromoAppDetail/{prseqno}")
	public void deletepromoAppDetail(@PathVariable Long prseqno) 
	{
		promoRuleApplDetailsServ.delPromoRuleApplDetails(prseqno);
	}

	@DeleteMapping("/delSelectpromoAppDetails")
	public void deleteSelectpromoAppDetails(@RequestBody ArrayList<Long> rulesSeqNoList) {
		promoRuleApplDetailsServ.delSelectPromoRules(rulesSeqNoList);
		return;
	}
	
	@DeleteMapping("/delAllpromoAppDetail")
	public void deleteAllpromoAppDetails() {
		promoRuleApplDetailsServ.getAllPromoRuleApplDetails();
		return;
	}
	}