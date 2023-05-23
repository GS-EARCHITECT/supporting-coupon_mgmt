package deal_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import deal_mgmt.model.master.PromoMaster;

@Repository("promoMasterRepo")
public interface PromoMasterRepo extends CrudRepository<PromoMaster, Long> 
{
	@Query(value = "SELECT * FROM PROMO_MASTER a WHERE a.promo_seq_no in :ids order by promo_seq_no", nativeQuery = true)
	ArrayList<PromoMaster> getSelectPromos(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM PROMO_MASTER WHERE a.promo_type_seq_no in :ids", nativeQuery = true)
	void delSelectPromos(@Param("ids") ArrayList<Long> ids);
}
