package coupons_mgmt.model.dto;

import java.io.Serializable;

public class PromoRuleMasterDTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4498051341339346230L;

	private long ruleSeqNo;
	private String functionName;

	public long getRuleSeqNo() {
		return ruleSeqNo;
	}

	public void setRuleSeqNo(long ruleSeqNo) {
		this.ruleSeqNo = ruleSeqNo;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public PromoRuleMasterDTO(long ruleSeqNo, String functionName) {
		super();
		this.ruleSeqNo = ruleSeqNo;
		this.functionName = functionName;
	}

	public PromoRuleMasterDTO() {
		super();
	}

}