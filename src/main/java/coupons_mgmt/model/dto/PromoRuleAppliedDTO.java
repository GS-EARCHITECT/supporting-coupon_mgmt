package coupons_mgmt.model.dto;

import java.io.Serializable;

public class PromoRuleAppliedDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8870847723216226759L;
	private Float amtDisc;
	private Float exactAmt;
	private Float maxAmt;
	private Float minAmt;
	private Float percDisc;
	private long ruleAppSeqNo;
	private long ruleSeqNo;
	private long ruleLineSeqNo;
	private long resourceSeqNo;
	private long providerSeqNo;
	private String instrument_code;
	private String className;

	public Float getAmtDisc() {
		return amtDisc;
	}

	public void setAmtDisc(Float amtDisc) {
		this.amtDisc = amtDisc;
	}

	public Float getExactAmt() {
		return exactAmt;
	}

	public void setExactAmt(Float exactAmt) {
		this.exactAmt = exactAmt;
	}

	public Float getMaxAmt() {
		return maxAmt;
	}

	public void setMaxAmt(Float maxAmt) {
		this.maxAmt = maxAmt;
	}

	public Float getMinAmt() {
		return minAmt;
	}

	public void setMinAmt(Float minAmt) {
		this.minAmt = minAmt;
	}

	public Float getPercDisc() {
		return percDisc;
	}

	public void setPercDisc(Float percDisc) {
		this.percDisc = percDisc;
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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public PromoRuleAppliedDTO() {
		super();
	}

	public long getRuleLineSeqNo() {
		return ruleLineSeqNo;
	}

	public void setRuleLineSeqNo(long ruleLineSeqNo) {
		this.ruleLineSeqNo = ruleLineSeqNo;
	}

	public PromoRuleAppliedDTO(Float amtDisc, Float exactAmt, Float maxAmt, Float minAmt, Float percDisc,
			long ruleAppSeqNo, long ruleSeqNo, long ruleLineSeqNo, long resourceSeqNo, long providerSeqNo,
			String instrument_code, String className) {
		super();
		this.amtDisc = amtDisc;
		this.exactAmt = exactAmt;
		this.maxAmt = maxAmt;
		this.minAmt = minAmt;
		this.percDisc = percDisc;
		this.ruleAppSeqNo = ruleAppSeqNo;
		this.ruleSeqNo = ruleSeqNo;
		this.ruleLineSeqNo = ruleLineSeqNo;
		this.resourceSeqNo = resourceSeqNo;
		this.providerSeqNo = providerSeqNo;
		this.instrument_code = instrument_code;
		this.className = className;
	}
	
}