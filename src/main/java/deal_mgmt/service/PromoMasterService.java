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

import deal_mgmt.model.dto.PromoMasterDTO;
import deal_mgmt.model.master.PromoMaster;
import deal_mgmt.model.repo.PromoMasterRepo;

@Service("promoMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PromoMasterService implements I_PromoMasterService {

	@Autowired
	private PromoMasterRepo promoMasterRepo;

	public PromoMasterDTO newPromoMaster(PromoMasterDTO lMasters) {
		PromoMaster PromoMaster = promoMasterRepo.save(this.setPromoMaster(lMasters));
		lMasters = getPromoMasterDTO(PromoMaster);
		return lMasters;
	}

	public ArrayList<PromoMasterDTO> getAllPromoMasters() {
		ArrayList<PromoMaster> resourceList = (ArrayList<PromoMaster>) promoMasterRepo.findAll();
		ArrayList<PromoMasterDTO> lMasterss = new ArrayList<PromoMasterDTO>();
		lMasterss = resourceList != null ? this.getPromoMasterDTOs(resourceList) : null;
		return lMasterss;
	}

    public ArrayList<PromoMasterDTO> getSelectPromos(ArrayList<Long> ids)
	{
		ArrayList<PromoMaster> lMasters = promoMasterRepo.getSelectPromos(ids);
		ArrayList<PromoMasterDTO> promoMasterDTOs = new ArrayList<PromoMasterDTO>();
		
		if (lMasters!=null) 
		{
		promoMasterDTOs = getPromoMasterDTOs(lMasters);			
		}
		return promoMasterDTOs;
	}

	public PromoMasterDTO getPromoMasterById(Long resourceSeqNo) {
		Optional<PromoMaster> PromoMaster = promoMasterRepo.findById(resourceSeqNo);
		PromoMasterDTO lMasters = null;
		if (PromoMaster.isPresent()) {
			lMasters = PromoMaster != null ? this.getPromoMasterDTO(PromoMaster.get()) : null;
		}
		return lMasters;
	}

	public void updPromoMaster(PromoMasterDTO lMaster) 
	{
		PromoMaster promoMaster = this.setPromoMaster(lMaster);
		if (promoMasterRepo.existsById(lMaster.getPromoSeqNo())) 
				{		
			promoMaster.setPromoSeqNo(lMaster.getPromoSeqNo());			
			promoMasterRepo.save(promoMaster);			
		}
		return;
	}

	public void delPromoMaster(Long resourceSeqNo) {
		if (promoMasterRepo.existsById(resourceSeqNo)) {
			promoMasterRepo.deleteById(resourceSeqNo);
		}
		return;
	}

	public void delAllPromoMasters() {
		promoMasterRepo.deleteAll();
	}

	public void delSelectPromos(ArrayList<Long> ids)
	{
		if (ids != null) {
			promoMasterRepo.delSelectPromos(ids);
		}
	}

	
	private ArrayList<PromoMasterDTO> getPromoMasterDTOs(ArrayList<PromoMaster> lMasters) {
		PromoMasterDTO lDTO = null;
		ArrayList<PromoMasterDTO> lMasterDTOs = new ArrayList<PromoMasterDTO>();		
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getPromoMasterDTO(lMasters.get(i));			
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private PromoMasterDTO getPromoMasterDTO(PromoMaster lMaster) 
	{		
		PromoMasterDTO lDTO = new PromoMasterDTO();
		lDTO.setPromoSeqNo(lMaster.getPromoSeqNo());		
		lDTO.setRemarks(lMaster.getRemarks());
		lDTO.setStatus(lMaster.getStatus());
		lDTO.setPromoid(lMaster.getPromoid());
		return lDTO;
	}

	private PromoMaster setPromoMaster(PromoMasterDTO lDTO) {
		PromoMaster lMaster = new PromoMaster();		
		lMaster.setRemarks(lDTO.getRemarks());
		lMaster.setStatus(lDTO.getStatus());
		lMaster.setPromoid(lDTO.getPromoid());
		return lMaster;
	}
}