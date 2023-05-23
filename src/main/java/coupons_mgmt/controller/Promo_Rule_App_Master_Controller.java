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
import coupons_mgmt.model.dto.PromoRuleApplMasterDTO;
import coupons_mgmt.model.dto.PromoTxnDetailsDTO;
import coupons_mgmt.services.I_PromoRuleApplMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/promoRuleApplMasterManagement")
public class Promo_Rule_App_Master_Controller {

	private static final Logger logger = LoggerFactory.getLogger(Promo_Rule_App_Master_Controller.class);

	@Autowired
	private I_PromoRuleApplMasterService promoRuleApplMasterServ;

	@GetMapping(value = "/applyPromoRules/{companySeqNo}/{frDtTm}/{toDtTm}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Double> applyPromoRules(@PathVariable long companySeqNo, @PathVariable String frDtTm,
			@PathVariable String toDtTm, @RequestBody PromoTxnDetailsDTO promoTxnDetails) {
		Double calcResult = promoRuleApplMasterServ.applyPromoRule(companySeqNo, frDtTm, toDtTm, promoTxnDetails);
		return new ResponseEntity<>(calcResult, HttpStatus.OK);
	}

	@PostMapping("/new")
	public ResponseEntity<PromoRuleApplMasterDTO> newpromoAppMaster(
			@RequestBody PromoRuleApplMasterDTO promoAppMasterDTO) {
		PromoRuleApplMasterDTO promoAppMasterDTO2 = promoRuleApplMasterServ.newPromoRuleApplMaster(promoAppMasterDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(promoAppMasterDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllpromoAppMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PromoRuleApplMasterDTO>> getAllPromoRuleApplMasters() {
		ArrayList<PromoRuleApplMasterDTO> promoAppMasterDTOs = promoRuleApplMasterServ.getAllPromoRuleApplMasters();
		return new ResponseEntity<>(promoAppMasterDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getById/{promoAppMasterSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<PromoRuleApplMasterDTO> getPromoRuleApplMasterById(@PathVariable Long promoAppMasterSeqNo) {
		PromoRuleApplMasterDTO promoAppMasterAccNoDTOs = promoRuleApplMasterServ
				.getPromoRuleApplMasterById(promoAppMasterSeqNo);
		return new ResponseEntity<>(promoAppMasterAccNoDTOs, HttpStatus.OK);
	}

	@PutMapping("/updpromoAppMaster")
	public void updatepromoAppMaster(@RequestBody PromoRuleApplMasterDTO promoAppMasterDTO) {
		promoRuleApplMasterServ.updPromoRuleApplMaster(promoAppMasterDTO);
		return;
	}

	@DeleteMapping("/delpromoAppMaster/{promoAppMasterSeqNo}")
	public void deletepromoAppMaster(@PathVariable Long promoAppMasterSeqNo) {
		promoRuleApplMasterServ.delPromoRuleApplMaster(promoAppMasterSeqNo);
	}

	@DeleteMapping("/delSelectpromoAppMasters")
	public void deleteSelectpromoAppMasters(@RequestBody ArrayList<Long> rulesSeqNoList) {
		promoRuleApplMasterServ.delSelectPromoRules(rulesSeqNoList);
		return;
	}

	@DeleteMapping("/delAllpromoAppMaster")
	public void deleteAllpromoAppMasters() {
		promoRuleApplMasterServ.delAllPromoRuleApplMasters();
		;
		return;
	}
}