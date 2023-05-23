package deal_mgmt.model.details;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PROMO_DETAILS database table.
 * 
 */
@Entity
@Table(name="PROMO_DETAILS")
public class PromoDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PromoDetailsPK id;

	public PromoDetails() {
	}

	public PromoDetailsPK getId() {
		return this.id;
	}

	public void setId(PromoDetailsPK id) {
		this.id = id;
	}

	public PromoDetails(PromoDetailsPK id) {
		super();
		this.id = id;
	}
	
	

}