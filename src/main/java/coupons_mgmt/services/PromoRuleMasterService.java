package coupons_mgmt.services;

import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import coupons_mgmt.model.dto.PromoRuleMasterDTO;
import coupons_mgmt.model.master.PromoRuleMaster;
import coupons_mgmt.model.repo.PromoRuleMasterRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("promoRuleMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PromoRuleMasterService implements I_PromoRuleMasterService 
{
	private static final Logger logger = LoggerFactory.getLogger(PromoRuleMasterService.class);
	
	@Autowired
	private PromoRuleMasterRepo promoRuleMasterRepo;
	
	public PromoRuleMasterDTO newPromoRuleMaster(PromoRuleMasterDTO lMaster) 
	{
		PromoRuleMaster PromoRuleMaster = promoRuleMasterRepo.save(this.setPromoRuleMaster(lMaster));
		lMaster = getPromoRuleMasterDTO(PromoRuleMaster);
		return lMaster;
	}

	public ArrayList<PromoRuleMasterDTO> getAllPromoRuleMasters() {
		ArrayList<PromoRuleMaster> resourceList = (ArrayList<PromoRuleMaster>) promoRuleMasterRepo.findAll();
		ArrayList<PromoRuleMasterDTO> lMasterss = new ArrayList<PromoRuleMasterDTO>();
		lMasterss = resourceList != null ? this.getPromoRuleMasterDTOs(resourceList) : null;
		return lMasterss;
	}

	public PromoRuleMasterDTO getPromoRuleMasterById(Long ruleSeqNo) {
		Optional<PromoRuleMaster> PromoRuleMaster = promoRuleMasterRepo.findById(ruleSeqNo);
		PromoRuleMasterDTO lMasters = null;
		if (PromoRuleMaster.isPresent()) {
			lMasters = PromoRuleMaster != null ? this.getPromoRuleMasterDTO(PromoRuleMaster.get()) : null;
		}
		return lMasters;
	}

	public void updPromoRuleMaster(PromoRuleMasterDTO lMaster) 
	{
		PromoRuleMaster promoRuleMaster = this.setPromoRuleMaster(lMaster);
		if (promoRuleMasterRepo.existsById(lMaster.getRuleSeqNo())) 
				{		
			promoRuleMaster.setRuleSeqNo(lMaster.getRuleSeqNo());			
			promoRuleMasterRepo.save(promoRuleMaster);			
		}
		return;
	}

	public void delPromoRuleMaster(Long resourceSeqNo) {
		if (promoRuleMasterRepo.existsById(resourceSeqNo)) {
			promoRuleMasterRepo.deleteById(resourceSeqNo);
		}
		return;
	}

	public void delAllPromoRuleMasters() {
		promoRuleMasterRepo.deleteAll();
	}

	public void delSelectPromoRules(ArrayList<Long> ids)
	{
		if (ids != null) {
			promoRuleMasterRepo.delSelectPromoRules(ids);
		}
	}

	
	private ArrayList<PromoRuleMasterDTO> getPromoRuleMasterDTOs(ArrayList<PromoRuleMaster> lMasters) 
	{
		PromoRuleMasterDTO lDTO = null;
		ArrayList<PromoRuleMasterDTO> lMasterDTOs = new ArrayList<PromoRuleMasterDTO>();		
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getPromoRuleMasterDTO(lMasters.get(i));			
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private PromoRuleMasterDTO getPromoRuleMasterDTO(PromoRuleMaster lMaster) 
	{		
		PromoRuleMasterDTO lDTO = new PromoRuleMasterDTO();
		
		lDTO.setRuleSeqNo(lMaster.getRuleSeqNo());
		lDTO.setFunctionName(lMaster.getFunctionName());				
		return lDTO;
	}

	private PromoRuleMaster setPromoRuleMaster(PromoRuleMasterDTO lDTO) 
	{
		PromoRuleMaster lMaster = new PromoRuleMaster();		
		lMaster.setFunctionName(lDTO.getFunctionName());				
		return lMaster;
	}
}