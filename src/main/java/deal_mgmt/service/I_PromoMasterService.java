package deal_mgmt.service;

import java.util.ArrayList;

import deal_mgmt.model.dto.PromoMasterDTO;

public interface I_PromoMasterService
{
    abstract public PromoMasterDTO newPromoMaster(PromoMasterDTO promoMasterDTO);
    abstract public ArrayList<PromoMasterDTO> getAllPromoMasters();    
    abstract public PromoMasterDTO getPromoMasterById(Long promoSeqNo);
    abstract public ArrayList<PromoMasterDTO> getSelectPromos(ArrayList<Long> ids);
    abstract public void updPromoMaster(PromoMasterDTO PromoMasterDTO);
    abstract public void delPromoMaster(Long DocumentSeqNo);
    abstract public void delAllPromoMasters();    
    abstract public void delSelectPromos(ArrayList<Long> ids);    	
}