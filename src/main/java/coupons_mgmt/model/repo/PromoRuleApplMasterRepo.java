package coupons_mgmt.model.repo;

import java.sql.Timestamp;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import coupons_mgmt.model.master.PromoRuleApplMaster;

@Repository("promoRuleApplMasterRepo")
public interface PromoRuleApplMasterRepo extends CrudRepository<PromoRuleApplMaster, Long> 
{
	@Query(value = "SELECT * FROM PROMO_RULE_APPL_MASTER a WHERE (a.company_seq_no = :compSeqNo) and (:frDtTm > a.FR_DTTM and :toDtTm < a.TO_DTTM) order by rule_app_seq_no asc", nativeQuery = true)
	ArrayList<PromoRuleApplMaster> getSelectPromoAppRules(@Param("compSeqNo") Long compSeqNo, @Param("frDtTm") Timestamp frDtTm, @Param("toDtTm") Timestamp toDtTm);
	
	@Query(value = "DELETE FROM PROMO_RULE_MASTER WHERE a.rule_seq_no in :ids", nativeQuery = true)
	void delSelectPromoRules(@Param("ids") ArrayList<Long> ids);
}
