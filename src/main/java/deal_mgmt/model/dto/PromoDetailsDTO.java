package deal_mgmt.model.dto;

import java.io.Serializable;


public class PromoDetailsDTO implements Serializable 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5390569320413220707L;
	private long promoSeqNo;
	private long ruleSeqNo;
	
	public long getPromoSeqNo() {
		return promoSeqNo;
	}
	public void setPromoSeqNo(long promoSeqNo) {
		this.promoSeqNo = promoSeqNo;
	}
	public long getRuleSeqNo() {
		return ruleSeqNo;
	}
	public void setRuleSeqNo(long ruleSeqNo) {
		this.ruleSeqNo = ruleSeqNo;
	}
	public PromoDetailsDTO(long promoSeqNo, long ruleSeqNo) {
		super();
		this.promoSeqNo = promoSeqNo;
		this.ruleSeqNo = ruleSeqNo;
	}
	public PromoDetailsDTO() {
		super();
	}
		
}