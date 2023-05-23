package coupons_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PROMO_RULE_APPL_DETAILS database table.
 * 
 */
@Embeddable
public class PromoRuleApplDetailsPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="RULE_APP_SEQ_NO")
	private long ruleAppSeqNo;

	@Column(name="RULE_SEQ_NO")
	private long ruleSeqNo;

	@Column(name="RESOURCE_SEQ_NO")
	private long resourceSeqNo;

	@Column(name="PROVIDER_SEQ_NO")
	private long providerSeqNo;
	
	@Column(name="INSTRUMENT_CODE")
	private String instrument_code;

	@Column(name="CUSTOMER_SEQ_NO")
	private long customer_seq_no;

	public long getRuleAppSeqNo() {
		return ruleAppSeqNo;
	}

	public void setRuleAppSeqNo(long ruleAppSeqNo) {
		this.ruleAppSeqNo = ruleAppSeqNo;
	}

	public long getRuleSeqNo() {
		return ruleSeqNo;
	}

	public void setRuleSeqNo(long ruleSeqNo) {
		this.ruleSeqNo = ruleSeqNo;
	}

	public long getResourceSeqNo() {
		return resourceSeqNo;
	}

	public void setResourceSeqNo(long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	public long getProviderSeqNo() {
		return providerSeqNo;
	}

	public void setProviderSeqNo(long providerSeqNo) {
		this.providerSeqNo = providerSeqNo;
	}

	public String getInstrument_code() {
		return instrument_code;
	}

	public void setInstrument_code(String instrument_code) {
		this.instrument_code = instrument_code;
	}

	public long getCustomer_seq_no() {
		return customer_seq_no;
	}

	public void setCustomer_seq_no(long customer_seq_no) {
		this.customer_seq_no = customer_seq_no;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (customer_seq_no ^ (customer_seq_no >>> 32));
		result = prime * result + ((instrument_code == null) ? 0 : instrument_code.hashCode());
		result = prime * result + (int) (providerSeqNo ^ (providerSeqNo >>> 32));
		result = prime * result + (int) (resourceSeqNo ^ (resourceSeqNo >>> 32));
		result = prime * result + (int) (ruleAppSeqNo ^ (ruleAppSeqNo >>> 32));
		result = prime * result + (int) (ruleSeqNo ^ (ruleSeqNo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PromoRuleApplDetailsPK other = (PromoRuleApplDetailsPK) obj;
		if (customer_seq_no != other.customer_seq_no)
			return false;
		if (instrument_code == null) {
			if (other.instrument_code != null)
				return false;
		} else if (!instrument_code.equals(other.instrument_code))
			return false;
		if (providerSeqNo != other.providerSeqNo)
			return false;
		if (resourceSeqNo != other.resourceSeqNo)
			return false;
		if (ruleAppSeqNo != other.ruleAppSeqNo)
			return false;
		if (ruleSeqNo != other.ruleSeqNo)
			return false;
		return true;
	}

	public PromoRuleApplDetailsPK(long ruleAppSeqNo, long ruleSeqNo, long resourceSeqNo, long providerSeqNo,
			String instrument_code, long customer_seq_no) {
		super();
		this.ruleAppSeqNo = ruleAppSeqNo;
		this.ruleSeqNo = ruleSeqNo;
		this.resourceSeqNo = resourceSeqNo;
		this.providerSeqNo = providerSeqNo;
		this.instrument_code = instrument_code;
		this.customer_seq_no = customer_seq_no;
	}

	public PromoRuleApplDetailsPK() {
		super();
	}
	
}