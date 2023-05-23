package deal_mgmt.model.repo;

import java.sql.Timestamp;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import deal_mgmt.model.master.OfferingsPromoDetails;
import deal_mgmt.model.master.OfferingsPromoDetailsPK;

@Repository("offeringsPromoDetailsRepo")
public interface OfferingsPromoDetailsRepo extends CrudRepository<OfferingsPromoDetails, OfferingsPromoDetailsPK> 
{
	@Query(value = "SELECT * FROM OFFERING_PROMO_DETAILS a WHERE a.promo_seq_no in :ids order by promo_seq_no", nativeQuery = true)
	ArrayList<OfferingsPromoDetails> getSelectPromos(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM PROMO_MASTER a WHERE a.offering_seq_no in :ids order by promo_seq_no", nativeQuery = true)
	ArrayList<OfferingsPromoDetails> getSelectPromosByOfferings(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM PROMO_MASTER a WHERE ((:fr BETWEEN b.FROM_DTTM and b.TO_DTTM) and (:to BETWEEN b.FROM_DTTM and b.TO_DTTM)) order by promo_seq_no", nativeQuery = true)
	ArrayList<OfferingsPromoDetails> getSelectPromosBetweenTimes(@Param("fr") Timestamp fr, @Param("to") Timestamp to);
	
	@Query(value = "DELETE FROM PROMO_MASTER WHERE a.promo_type_seq_no in :ids", nativeQuery = true)
	void delSelectPromos(@Param("ids") ArrayList<Long> ids);
}
