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

import deal_mgmt.model.dto.PromoMasterDTO;
import deal_mgmt.service.I_PromoMasterService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/promoManagement")
public class Promo_Master_Controller 
{

//	private static final Logger logger = LoggerFactory.getLogger(PromoMaster_Controller.class);

	@Autowired
	private I_PromoMasterService promoMasterServ;
	
	@PostMapping("/new")
	public ResponseEntity<PromoMasterDTO> newpromo(@RequestBody PromoMasterDTO promoDTO) {
		PromoMasterDTO promoDTO2 = promoMasterServ.newPromoMaster(promoDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(promoDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllpromos", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PromoMasterDTO>> getAllPromoMasters() {
		ArrayList<PromoMasterDTO> promoDTOs = promoMasterServ.getAllPromoMasters();
		return new ResponseEntity<>(promoDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectPromos", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PromoMasterDTO>> getSelectPromoMasters(@RequestBody ArrayList<Long> promoSeqNos) {
		ArrayList<PromoMasterDTO> promoDTOs = promoMasterServ.getSelectPromos(promoSeqNos);		
		return new ResponseEntity<>(promoDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getById/{promoSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })	
	public ResponseEntity<PromoMasterDTO> getPromoMasterById(@PathVariable Long promoSeqNo) 
	{
		PromoMasterDTO promoAccNoDTOs = promoMasterServ.getPromoMasterById(promoSeqNo);		
		return new ResponseEntity<>(promoAccNoDTOs, HttpStatus.OK);
	}
	
	@PutMapping("/updpromo")
	public void updatepromo(@RequestBody PromoMasterDTO promoDTO) 
	{
			promoMasterServ.updPromoMaster(promoDTO);	
		return;
	}

	@DeleteMapping("/delpromo/{promoSeqNo}")
	public void deletepromo(@PathVariable Long promoSeqNo) {
		promoMasterServ.delPromoMaster(promoSeqNo);
	}

	@DeleteMapping("/delSelectpromos")
	public void deleteSelectpromos(@RequestBody ArrayList<Long> promoSeqNoList) {
		promoMasterServ.delSelectPromos(promoSeqNoList);
		return;
	}
	
	@DeleteMapping("/delAllpromo")
	public void deleteAllpromos() {
		promoMasterServ.delAllPromoMasters();;
		return;
	}
	}