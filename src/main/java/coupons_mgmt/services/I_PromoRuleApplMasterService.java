package coupons_mgmt.services;

import java.util.ArrayList;
import coupons_mgmt.model.dto.PromoRuleApplMasterDTO;
import coupons_mgmt.model.dto.PromoTxnDetailsDTO;

public interface I_PromoRuleApplMasterService
{
	abstract public PromoRuleApplMasterDTO newPromoRuleApplMaster(PromoRuleApplMasterDTO promoMasterDTO);
    abstract public ArrayList<PromoRuleApplMasterDTO> getAllPromoRuleApplMasters();    
    abstract public PromoRuleApplMasterDTO getPromoRuleApplMasterById(Long promoSeqNo);
    abstract public void updPromoRuleApplMaster(PromoRuleApplMasterDTO PromoRuleApplMasterDTO);
    abstract public void delPromoRuleApplMaster(Long DocumentSeqNo);
    abstract public void delAllPromoRuleApplMasters();    
    abstract public void delSelectPromoRules(ArrayList<Long> ids);
    abstract public double applyPromoRule(Long companySeqNo, String frDtTm, String toDtTm, PromoTxnDetailsDTO promoTxnDetails);
}