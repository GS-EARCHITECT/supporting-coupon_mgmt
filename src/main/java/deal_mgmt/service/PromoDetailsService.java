package deal_mgmt.service;

import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import deal_mgmt.model.details.PromoDetails;
import deal_mgmt.model.details.PromoDetailsPK;
import deal_mgmt.model.dto.PromoDetailsDTO;
import deal_mgmt.model.repo.PromoDetailsRepo;

@Service("promoDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PromoDetailsService implements I_PromoDetailsService {

	@Autowired
	private PromoDetailsRepo promoDetailsRepo;

	public PromoDetailsDTO newPromoDetails(PromoDetailsDTO lDetails) {
		
		PromoDetailsPK promoDetailsPK = new PromoDetailsPK();
		promoDetailsPK.setPromoSeqNo(lDetails.getPromoSeqNo());
		promoDetailsPK.setRuleSeqNo(lDetails.getRuleSeqNo());
		PromoDetailsDTO promoDetailsDTO = null;
		
		if(!promoDetailsRepo.existsById(promoDetailsPK))
		{		
		promoDetailsRepo.save(this.setPromoDetails(lDetails));
		promoDetailsDTO = getPromoDetailsDTO(promoDetailsRepo.save(this.setPromoDetails(lDetails)));		
		}
		return promoDetailsDTO;
	}

	public ArrayList<PromoDetailsDTO> getAllPromoDetails() {
		ArrayList<PromoDetails> promoList = (ArrayList<PromoDetails>) promoDetailsRepo.findAll();
		ArrayList<PromoDetailsDTO> lDetailss = new ArrayList<PromoDetailsDTO>();
		lDetailss = promoList != null ? this.getPromoDetailsDTOs(promoList) : null;
		return lDetailss;
	}

	public ArrayList<PromoDetailsDTO> getSelectPromos(ArrayList<Long> ids)
	{
		ArrayList<PromoDetails> lDetails = promoDetailsRepo.getSelectPromos(ids);
		ArrayList<PromoDetailsDTO> promoDetailsDTOs = null;
		
		if (lDetails!=null) 
		{
		promoDetailsDTOs = getPromoDetailsDTOs(lDetails); 
		}
		return promoDetailsDTOs;
	}
   

	public ArrayList<PromoDetailsDTO> getSelectPromosByRules(ArrayList<Long> ids)
	{
		ArrayList<PromoDetails> lDetails = promoDetailsRepo.getSelectPromosByRules(ids);
		ArrayList<PromoDetailsDTO> promoDetailsDTOs = null;;
		
		if (lDetails!=null) 
		{
			promoDetailsDTOs = getPromoDetailsDTOs(lDetails);	
		}
		return promoDetailsDTOs;
	}

	
	public PromoDetailsDTO getPromoDetailsById(Long promoSeqNo, Long ruleSeqNo) 
	{
		PromoDetailsPK promoDetailsPK = new PromoDetailsPK();
		promoDetailsPK.setPromoSeqNo(promoSeqNo);
		promoDetailsPK.setRuleSeqNo(ruleSeqNo);		
		PromoDetailsDTO lDetails = null;
		Optional<PromoDetails> promoDetails = null;
				
		if (promoDetailsRepo.existsById(promoDetailsPK)) 
		{
			promoDetails = promoDetailsRepo.findById(promoDetailsPK); 
			lDetails = getPromoDetailsDTO(promoDetailsRepo.save(promoDetails.get()));
		}
		return lDetails;
	}

	public void updPromoDetails(PromoDetailsDTO lDetails) 
	{
		PromoDetailsPK promoDetailsPK = new PromoDetailsPK();
		promoDetailsPK.setPromoSeqNo(lDetails.getPromoSeqNo());
		promoDetailsPK.setRuleSeqNo(lDetails.getRuleSeqNo());
		PromoDetails lDetails2 = null;
		
		if (promoDetailsRepo.existsById(promoDetailsPK)) 
		{		
			lDetails2=promoDetailsRepo.findById(promoDetailsPK).get();
			lDetails2.setId(promoDetailsPK);			
			promoDetailsRepo.save(lDetails2);			
		}
		return;
	}

	public void delPromoDetails(PromoDetailsDTO lDetails) 
	{
		PromoDetailsPK promoDetailsPK = new PromoDetailsPK();
		promoDetailsPK.setPromoSeqNo(lDetails.getPromoSeqNo());
		promoDetailsPK.setRuleSeqNo(lDetails.getRuleSeqNo());
		
		
		if (promoDetailsRepo.existsById(promoDetailsPK)) {
			promoDetailsRepo.deleteById(promoDetailsPK);
		}
		return;
	}

	public void delAllPromoDetails() {
		promoDetailsRepo.deleteAll();
	}

	public void delSelectPromos(ArrayList<Long> promoSeqNos) {
		if (promoSeqNos != null) {
			promoDetailsRepo.delSelectPromos(promoSeqNos);
		}
	}

	
	private ArrayList<PromoDetailsDTO> getPromoDetailsDTOs(ArrayList<PromoDetails> lDetails) {
		PromoDetailsDTO lDTO = null;
		ArrayList<PromoDetailsDTO> lDetailsDTOs = new ArrayList<PromoDetailsDTO>();		
		for (int i = 0; i < lDetails.size(); i++) {
			lDTO = getPromoDetailsDTO(lDetails.get(i));			
			lDetailsDTOs.add(lDTO);
		}
		return lDetailsDTOs;
	}

	private PromoDetailsDTO getPromoDetailsDTO(PromoDetails lDetails) 
	{		
		PromoDetailsDTO lDTO = new PromoDetailsDTO();
		lDTO.setRuleSeqNo(lDTO.getRuleSeqNo());
		lDTO.setPromoSeqNo(lDTO.getPromoSeqNo());		
		return lDTO;
	}

	private PromoDetails setPromoDetails(PromoDetailsDTO lDTO) {
		PromoDetails lDetails = new PromoDetails();
		return lDetails;
	}
}