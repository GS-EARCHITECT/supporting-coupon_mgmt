package coupons_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import coupons_mgmt.model.master.PromoRuleMaster;

@Repository("promoRuleAppliedRepo")
public interface PromoRuleAppliedRepo extends CrudRepository<PromoRuleMaster, Long> 
{
	@Query(value = "SELECT * FROM PROMO_RULE_MASTER a WHERE a.rule_seq_no in :ids order by rule_seq_no", nativeQuery = true)
	ArrayList<PromoRuleMaster> getSelectPromoRules(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM PROMO_RULE_MASTER WHERE a.rule_seq_no in :ids", nativeQuery = true)
	void delSelectPromoRules(@Param("ids") ArrayList<Long> ids);
}
