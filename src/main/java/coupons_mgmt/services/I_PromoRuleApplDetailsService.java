package coupons_mgmt.services;

import java.util.ArrayList;
import coupons_mgmt.model.dto.PromoRuleApplDetailsDTO;

public interface I_PromoRuleApplDetailsService
{
	abstract public PromoRuleApplDetailsDTO newPromoRuleApplDetails(PromoRuleApplDetailsDTO promoDetailsDTO);
    abstract public ArrayList<PromoRuleApplDetailsDTO> getAllPromoRuleApplDetails();    
    abstract public PromoRuleApplDetailsDTO getPromoRuleApplDetailsById(Long prSeqNo);
    abstract public void updPromoRuleApplDetails(PromoRuleApplDetailsDTO promoRuleApplDetailsDTO);
    abstract public void delPromoRuleApplDetails(Long prSeqNo);
    abstract public void delAllPromoRuleApplDetails();    
    abstract public void delSelectPromoRules(ArrayList<Long> ids);    
}