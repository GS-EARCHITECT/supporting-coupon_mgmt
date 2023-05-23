package deal_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import deal_mgmt.model.details.PromoDetails;
import deal_mgmt.model.details.PromoDetailsPK;

@Repository("promoDetailsRepo")
public interface PromoDetailsRepo extends CrudRepository<PromoDetails, PromoDetailsPK> 
{
	@Query(value = "SELECT * FROM PROMO_DETAILS a WHERE a.promo_seq_no in :ids order by promo_seq_no", nativeQuery = true)
	ArrayList<PromoDetails> getSelectPromos(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM PROMO_DETAILS a WHERE a.rule_seq_no in :ids order by promo_seq_no", nativeQuery = true)
	ArrayList<PromoDetails> getSelectPromosByRules(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM PROMO_DETAILS WHERE a.promo_type_seq_no in :ids", nativeQuery = true)
	void delSelectPromos(@Param("ids") ArrayList<Long> ids);
}
