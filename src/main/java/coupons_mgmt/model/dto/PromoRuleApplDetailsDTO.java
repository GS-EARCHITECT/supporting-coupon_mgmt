package coupons_mgmt.model.dto;

import java.io.Serializable;

public class PromoRuleApplDetailsDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -595267415865835872L;

	private long ruleLineSeqNo;
	private long ruleAppSeqNo;
	private long ruleSeqNo;
	private long resourceSeqNo;
	private long providerSeqNo;
	private String instrument_code;
	private long customer_seq_no;
	private float amtDisc;
	private float exactAmt;
	private float maxAmt;
	private float minAmt;
	private Float percDisc;
	private String couponNarration;
	private Character selectable;

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

	public PromoRuleApplDetailsDTO() {
		super();
	}

	public long getRuleLineSeqNo() {
		return ruleLineSeqNo;
	}

	public void setRuleLineSeqNo(long ruleLineSeqNo) {
		this.ruleLineSeqNo = ruleLineSeqNo;
	}

	public Character getSelectable() {
		return selectable;
	}

	public void setSelectable(Character selectable) {
		this.selectable = selectable;
	}

	public PromoRuleApplDetailsDTO(long ruleLineSeqNo, long ruleAppSeqNo, long ruleSeqNo, long resourceSeqNo,
			long providerSeqNo, String instrument_code, long customer_seq_no, float amtDisc, float exactAmt,
			float maxAmt, float minAmt, Float percDisc, String couponNarration, Character selectable) {
		super();
		this.ruleLineSeqNo = ruleLineSeqNo;
		this.ruleAppSeqNo = ruleAppSeqNo;
		this.ruleSeqNo = ruleSeqNo;
		this.resourceSeqNo = resourceSeqNo;
		this.providerSeqNo = providerSeqNo;
		this.instrument_code = instrument_code;
		this.customer_seq_no = customer_seq_no;
		this.amtDisc = amtDisc;
		this.exactAmt = exactAmt;
		this.maxAmt = maxAmt;
		this.minAmt = minAmt;
		this.percDisc = percDisc;
		this.couponNarration = couponNarration;
		this.selectable = selectable;
	}

}