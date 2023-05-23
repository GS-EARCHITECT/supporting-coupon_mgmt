package deal_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PROMO_DETAILS database table.
 * 
 */
@Embeddable
public class OfferingsPromoDetailsPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PROMO_SEQ_NO")
	private long promoSeqNo;

	@Column(name="OFFERING_SEQ_NO")
	private long offeringSeqNo;

	public OfferingsPromoDetailsPK() {
	}
	
	public long getPromoSeqNo() {
		return this.promoSeqNo;
	}
	public void setPromoSeqNo(long promoSeqNo) {
		this.promoSeqNo = promoSeqNo;
	}
	public long getOfferingSeqNo() {
		return this.offeringSeqNo;
	}
	public void setOfferingSeqNo(long offeringSeqNo) {
		this.offeringSeqNo = offeringSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OfferingsPromoDetailsPK)) {
			return false;
		}
		OfferingsPromoDetailsPK castOther = (OfferingsPromoDetailsPK)other;
		return 
			(this.promoSeqNo == castOther.promoSeqNo)
			&& (this.offeringSeqNo == castOther.offeringSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.promoSeqNo ^ (this.promoSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.offeringSeqNo ^ (this.offeringSeqNo >>> 32)));
		
		return hash;
	}
	public OfferingsPromoDetailsPK(long promoSeqNo, long offeringSeqNo) {
		super();
		this.promoSeqNo = promoSeqNo;
		this.offeringSeqNo = offeringSeqNo;
	}
}