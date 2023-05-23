package deal_mgmt.service;

import java.util.ArrayList;

import deal_mgmt.model.dto.PromoDetailsDTO;

public interface I_PromoDetailsService
{
    abstract public PromoDetailsDTO newPromoDetails(PromoDetailsDTO promoDetailsDTO);
    abstract public ArrayList<PromoDetailsDTO> getAllPromoDetails();    
    abstract public PromoDetailsDTO getPromoDetailsById(Long promoSeqNo, Long ruleSeqNo);
    abstract public ArrayList<PromoDetailsDTO> getSelectPromosByRules(ArrayList<Long> ids);    
    abstract public ArrayList<PromoDetailsDTO> getSelectPromos(ArrayList<Long> ids);
    abstract public void updPromoDetails(PromoDetailsDTO PromoDetailsDTO);
    abstract public void delPromoDetails(PromoDetailsDTO lDetails);
    abstract public void delAllPromoDetails();    
    abstract public void delSelectPromos(ArrayList<Long> ids);
}