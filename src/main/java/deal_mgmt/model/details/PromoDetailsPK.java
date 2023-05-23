package deal_mgmt.model.details;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PROMO_DETAILS database table.
 * 
 */
@Embeddable
public class PromoDetailsPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PROMO_SEQ_NO")
	private long promoSeqNo;

	@Column(name="RULE_SEQ_NO")
	private long ruleSeqNo;

	public PromoDetailsPK() {
	}
	public long getPromoSeqNo() {
		return this.promoSeqNo;
	}
	public void setPromoSeqNo(long promoSeqNo) {
		this.promoSeqNo = promoSeqNo;
	}
	public long getRuleSeqNo() {
		return this.ruleSeqNo;
	}
	public void setRuleSeqNo(long ruleSeqNo) {
		this.ruleSeqNo = ruleSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PromoDetailsPK)) {
			return false;
		}
		PromoDetailsPK castOther = (PromoDetailsPK)other;
		return 
			(this.promoSeqNo == castOther.promoSeqNo)
			&& (this.ruleSeqNo == castOther.ruleSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.promoSeqNo ^ (this.promoSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.ruleSeqNo ^ (this.ruleSeqNo >>> 32)));
		
		return hash;
	}
	public PromoDetailsPK(long promoSeqNo, long ruleSeqNo) {
		super();
		this.promoSeqNo = promoSeqNo;
		this.ruleSeqNo = ruleSeqNo;
	}
	
	
}