package coupons_mgmt.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import coupons_mgmt.model.dto.PromoRuleApplDetailsDTO;
import coupons_mgmt.model.master.PromoRuleApplDetails;
import coupons_mgmt.model.repo.PromoRuleApplDetailsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("promoRuleApplDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PromoRuleApplDetailsService implements I_PromoRuleApplDetailsService {
	private static final Logger logger = LoggerFactory.getLogger(PromoRuleApplDetailsService.class);

	@Autowired
	private PromoRuleApplDetailsRepo promoRuleApplDetailsRepo;

	public PromoRuleApplDetailsDTO newPromoRuleApplDetails(PromoRuleApplDetailsDTO promoRuleApplDetailsDTO) {
		promoRuleApplDetailsDTO = getPromoRuleApplDetailsDTO(
				promoRuleApplDetailsRepo.save(setPromoRuleApplDetails(promoRuleApplDetailsDTO)));
		return promoRuleApplDetailsDTO;
	}

	public ArrayList<PromoRuleApplDetailsDTO> getAllPromoRuleApplDetails() {
		ArrayList<PromoRuleApplDetails> resourceList = (ArrayList<PromoRuleApplDetails>) promoRuleApplDetailsRepo
				.findAll();
		ArrayList<PromoRuleApplDetailsDTO> lDetailsss = new ArrayList<PromoRuleApplDetailsDTO>();
		lDetailsss = resourceList != null ? this.getPromoRuleApplDetailsDTOs(resourceList) : null;
		return lDetailsss;
	}

	public PromoRuleApplDetailsDTO getPromoRuleApplDetailsById(Long prSeqNo) {
		PromoRuleApplDetailsDTO promoRuleApplDetailsDTO = null;

		if (promoRuleApplDetailsRepo.existsById(prSeqNo)) {
			promoRuleApplDetailsDTO = getPromoRuleApplDetailsDTO(promoRuleApplDetailsRepo.findById(prSeqNo).get());
		}

		return promoRuleApplDetailsDTO;
	}

	public void updPromoRuleApplDetails(PromoRuleApplDetailsDTO promoRuleApplDetailsDTO) {

		if (promoRuleApplDetailsRepo.existsById(promoRuleApplDetailsDTO.getRuleLineSeqNo())) {
			promoRuleApplDetailsDTO = getPromoRuleApplDetailsDTO(
					promoRuleApplDetailsRepo.save(setPromoRuleApplDetails(promoRuleApplDetailsDTO)));
		}

		return;
	}

	public void delPromoRuleApplDetails(Long prSeqNo) {
		if (promoRuleApplDetailsRepo.existsById(prSeqNo)) {
			promoRuleApplDetailsRepo.deleteById(prSeqNo);
		}
		return;
	}

	public void delAllPromoRuleApplDetails() {
		promoRuleApplDetailsRepo.deleteAll();
	}

	public void delSelectPromoRules(ArrayList<Long> ids) {
		if (ids != null) {
			promoRuleApplDetailsRepo.delSelectPromoRules(ids);
		}
	}

	private ArrayList<PromoRuleApplDetailsDTO> getPromoRuleApplDetailsDTOs(ArrayList<PromoRuleApplDetails> lDetailss) {
		PromoRuleApplDetailsDTO lDTO = null;
		ArrayList<PromoRuleApplDetailsDTO> lDetailsDTOs = new ArrayList<PromoRuleApplDetailsDTO>();
		for (int i = 0; i < lDetailss.size(); i++) {
			lDTO = getPromoRuleApplDetailsDTO(lDetailss.get(i));
			lDetailsDTOs.add(lDTO);
		}
		return lDetailsDTOs;
	}

	private PromoRuleApplDetailsDTO getPromoRuleApplDetailsDTO(PromoRuleApplDetails lDetails) {
		PromoRuleApplDetailsDTO lDTO = new PromoRuleApplDetailsDTO();
		lDTO.setCustomer_seq_no(lDetails.getCustomer_seq_no());
		lDTO.setSelectable(lDetails.getSelectable());
		lDTO.setInstrument_code(lDetails.getInstrument_code());
		lDTO.setProviderSeqNo(lDetails.getProviderSeqNo());
		lDTO.setResourceSeqNo(lDetails.getResourceSeqNo());
		lDTO.setRuleAppSeqNo(lDetails.getRuleAppSeqNo());
		lDTO.setRuleLineSeqNo(lDetails.getRuleLineSeqNo());
		lDTO.setRuleSeqNo(lDetails.getRuleSeqNo());
		lDTO.setAmtDisc(lDetails.getAmtDisc());
		lDTO.setExactAmt(lDetails.getExactAmt());
		lDTO.setMaxAmt(lDetails.getMaxAmt());
		lDTO.setMinAmt(lDetails.getMinAmt());
		lDTO.setPercDisc(lDetails.getPercDisc());
		return lDTO;
	}

	private PromoRuleApplDetails setPromoRuleApplDetails(PromoRuleApplDetailsDTO lDTO) {
		PromoRuleApplDetails lDetails = new PromoRuleApplDetails();
		lDetails.setCustomer_seq_no(lDTO.getCustomer_seq_no());
		lDetails.setInstrument_code(lDTO.getInstrument_code());
		lDetails.setProviderSeqNo(lDTO.getProviderSeqNo());
		lDetails.setResourceSeqNo(lDTO.getResourceSeqNo());
		lDetails.setRuleAppSeqNo(lDTO.getRuleAppSeqNo());
		lDetails.setRuleSeqNo(lDTO.getRuleSeqNo());
		lDetails.setSelectable(lDTO.getSelectable());
		lDetails.setAmtDisc(lDTO.getAmtDisc());
		lDetails.setExactAmt(lDTO.getExactAmt());
		lDetails.setMaxAmt(lDTO.getMaxAmt());
		lDetails.setMinAmt(lDTO.getMinAmt());
		lDetails.setPercDisc(lDTO.getPercDisc());
		return lDetails;
	}
}