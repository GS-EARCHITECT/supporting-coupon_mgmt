package coupons_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import coupons_mgmt.model.master.PromoRuleApplDetails;

@Repository("promoRuleApplDetailsRepo")
public interface PromoRuleApplDetailsRepo extends CrudRepository<PromoRuleApplDetails, Long> 
{
	@Query(value = "SELECT * FROM PROMO_RULE_APPL_DETAILS a WHERE (a.selectable=0 and a.rule_app_seq_no = :id) order by rule_seq_no", nativeQuery = true)
	ArrayList<PromoRuleApplDetails> getDefaultPromoAppDetails(@Param("id") Long id);
	
	@Query(value = "SELECT * FROM PROMO_RULE_APPL_DETAILS a WHERE a.rule_line_seq_no = :id order by rule_seq_no", nativeQuery = true)
	PromoRuleApplDetails getSelectPromoAppDetails(@Param("id") Long id);
	
	@Query(value = "DELETE FROM PROMO_RULE_MASTER WHERE a.rule_seq_no in :ids", nativeQuery = true)
	void delSelectPromoRules(@Param("ids") ArrayList<Long> ids);
}
