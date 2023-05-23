package coupons_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the PROMO_RULE_APPL_DETAILS database table.
 * 
 */
@Entity
@Table(name = "PROMO_RULE_APPL_DETAILS")
public class PromoRuleApplDetails implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5850431986608278135L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RULE_LINE_SEQUENCE")
	@SequenceGenerator(name = "RULE_LINE_SEQUENCE", sequenceName = "RULE_LINE_SEQUENCE", allocationSize = 1)
	@Column(name = "RULE_LINE_SEQ_NO")
	private long ruleLineSeqNo;

	@Column(name = "RULE_APP_SEQ_NO")
	private long ruleAppSeqNo;

	@Column(name = "RULE_SEQ_NO")
	private long ruleSeqNo;

	@Column(name = "RESOURCE_SEQ_NO")
	private long resourceSeqNo;

	@Column(name = "PROVIDER_SEQ_NO")
	private long providerSeqNo;

	@Column(name = "INSTRUMENT_CODE")
	private String instrument_code;

	@Column(name = "SELECTABLE")
	private Character selectable;

	@Column(name = "CUSTOMER_SEQ_NO")
	private long customer_seq_no;

	@Column(name = "AMT_DISC")
	private float amtDisc;

	@Column(name = "EXACT_AMT")
	private float exactAmt;

	@Column(name = "MAX_AMT")
	private float maxAmt;

	@Column(name = "MIN_AMT")
	private float minAmt;

	@Column(name = "PERC_DISC")
	private Float percDisc;

	@Column(name = "COUPON_NARRATION")
	private String couponNarration;

	public long getRuleLineSeqNo() {
		return ruleLineSeqNo;
	}

	public void setRuleLineSeqNo(long ruleLineSeqNo) {
		this.ruleLineSeqNo = ruleLineSeqNo;
	}

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

	public float getAmtDisc() {
		return amtDisc;
	}

	public void setAmtDisc(float amtDisc) {
		this.amtDisc = amtDisc;
	}

	public float getExactAmt() {
		return exactAmt;
	}

	public void setExactAmt(float exactAmt) {
		this.exactAmt = exactAmt;
	}

	public float getMaxAmt() {
		return maxAmt;
	}

	public void setMaxAmt(float maxAmt) {
		this.maxAmt = maxAmt;
	}

	public float getMinAmt() {
		return minAmt;
	}

	public void setMinAmt(float minAmt) {
		this.minAmt = minAmt;
	}

	public Float getPercDisc() {
		return percDisc;
	}

	public void setPercDisc(Float percDisc) {
		this.percDisc = percDisc;
	}

	public String getCouponNarration() {
		return couponNarration;
	}

	public void setCouponNarration(String couponNarration) {
		this.couponNarration = couponNarration;
	}

	public PromoRuleApplDetails(long ruleLineSeqNo, long ruleAppSeqNo, long ruleSeqNo, long resourceSeqNo,
			long providerSeqNo, String instrument_code, Character selectable, long customer_seq_no, float amtDisc,
			float exactAmt, float maxAmt, float minAmt, Float percDisc, String couponNarration) {
		super();
		this.ruleLineSeqNo = ruleLineSeqNo;
		this.ruleAppSeqNo = ruleAppSeqNo;
		this.ruleSeqNo = ruleSeqNo;
		this.resourceSeqNo = resourceSeqNo;
		this.providerSeqNo = providerSeqNo;
		this.instrument_code = instrument_code;
		this.selectable = selectable;
		this.customer_seq_no = customer_seq_no;
		this.amtDisc = amtDisc;
		this.exactAmt = exactAmt;
		this.maxAmt = maxAmt;
		this.minAmt = minAmt;
		this.percDisc = percDisc;
		this.couponNarration = couponNarration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amtDisc);
		result = prime * result + ((couponNarration == null) ? 0 : couponNarration.hashCode());
		result = prime * result + (int) (customer_seq_no ^ (customer_seq_no >>> 32));
		result = prime * result + Float.floatToIntBits(exactAmt);
		result = prime * result + ((instrument_code == null) ? 0 : instrument_code.hashCode());
		result = prime * result + Float.floatToIntBits(maxAmt);
		result = prime * result + Float.floatToIntBits(minAmt);
		result = prime * result + ((percDisc == null) ? 0 : percDisc.hashCode());
		result = prime * result + (int) (providerSeqNo ^ (providerSeqNo >>> 32));
		result = prime * result + (int) (resourceSeqNo ^ (resourceSeqNo >>> 32));
		result = prime * result + (int) (ruleAppSeqNo ^ (ruleAppSeqNo >>> 32));
		result = prime * result + (int) (ruleLineSeqNo ^ (ruleLineSeqNo >>> 32));
		result = prime * result + (int) (ruleSeqNo ^ (ruleSeqNo >>> 32));
		result = prime * result + ((selectable == null) ? 0 : selectable.hashCode());
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
		PromoRuleApplDetails other = (PromoRuleApplDetails) obj;
		if (Float.floatToIntBits(amtDisc) != Float.floatToIntBits(other.amtDisc))
			return false;
		if (couponNarration == null) {
			if (other.couponNarration != null)
				return false;
		} else if (!couponNarration.equals(other.couponNarration))
			return false;
		if (customer_seq_no != other.customer_seq_no)
			return false;
		if (Float.floatToIntBits(exactAmt) != Float.floatToIntBits(other.exactAmt))
			return false;
		if (instrument_code == null) {
			if (other.instrument_code != null)
				return false;
		} else if (!instrument_code.equals(other.instrument_code))
			return false;
		if (Float.floatToIntBits(maxAmt) != Float.floatToIntBits(other.maxAmt))
			return false;
		if (Float.floatToIntBits(minAmt) != Float.floatToIntBits(other.minAmt))
			return false;
		if (percDisc == null) {
			if (other.percDisc != null)
				return false;
		} else if (!percDisc.equals(other.percDisc))
			return false;
		if (providerSeqNo != other.providerSeqNo)
			return false;
		if (resourceSeqNo != other.resourceSeqNo)
			return false;
		if (ruleAppSeqNo != other.ruleAppSeqNo)
			return false;
		if (ruleLineSeqNo != other.ruleLineSeqNo)
			return false;
		if (ruleSeqNo != other.ruleSeqNo)
			return false;
		if (selectable == null) {
			if (other.selectable != null)
				return false;
		} else if (!selectable.equals(other.selectable))
			return false;
		return true;
	}

	public Character getSelectable() {
		return selectable;
	}

	public void setSelectable(Character selectable) {
		this.selectable = selectable;
	}

	public PromoRuleApplDetails() {
		super();
	}

}