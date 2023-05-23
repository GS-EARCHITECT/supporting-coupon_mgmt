package coupons_mgmt.services;

import java.util.ArrayList;
import coupons_mgmt.model.dto.PromoRuleMasterDTO;

public interface I_PromoRuleMasterService
{
	abstract public PromoRuleMasterDTO newPromoRuleMaster(PromoRuleMasterDTO promoMasterDTO);
    abstract public ArrayList<PromoRuleMasterDTO> getAllPromoRuleMasters();    
    abstract public PromoRuleMasterDTO getPromoRuleMasterById(Long promoSeqNo);
    abstract public void updPromoRuleMaster(PromoRuleMasterDTO PromoRuleMasterDTO);
    abstract public void delPromoRuleMaster(Long DocumentSeqNo);
    abstract public void delAllPromoRuleMasters();    
    abstract public void delSelectPromoRules(ArrayList<Long> ids);    
}