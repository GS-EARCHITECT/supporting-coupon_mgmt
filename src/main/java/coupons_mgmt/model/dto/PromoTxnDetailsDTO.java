package coupons_mgmt.model.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class PromoTxnDetailsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6952488451190692673L;
	private long txnNo;
	private long customerSeqNo;
	private long companySeqNo;
	private long providerSeqNo;
	private long instrumentCode;
	private String txnDate;
	private long productSeqNo;
	private float amt;
	private ArrayList<Long> ruleLineSeqNos;

	public long getTxnNo() {
		return txnNo;
	}

	public void setTxnNo(long txnNo) {
		this.txnNo = txnNo;
	}

	public long getCompanySeqNo() {
		return companySeqNo;
	}

	public void setCompanySeqNo(long companySeqNo) {
		this.companySeqNo = companySeqNo;
	}

	public String getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(String txnDate) {
		this.txnDate = txnDate;
	}

	public long getProductSeqNo() {
		return productSeqNo;
	}

	public void setProductSeqNo(long productSeqNo) {
		this.productSeqNo = productSeqNo;
	}

	public float getAmt() {
		return amt;
	}

	public void setAmt(float amt) {
		this.amt = amt;
	}

	public PromoTxnDetailsDTO() {
		super();
	}

	public long getCustomerSeqNo() {
		return customerSeqNo;
	}

	public void setCustomerSeqNo(long customerSeqNo) {
		this.customerSeqNo = customerSeqNo;
	}

	public ArrayList<Long> getRuleLineSeqNos() {
		return ruleLineSeqNos;
	}

	public long getProviderSeqNo() {
		return providerSeqNo;
	}

	public void setProviderSeqNo(long providerSeqNo) {
		this.providerSeqNo = providerSeqNo;
	}

	public long getInstrumentCode() {
		return instrumentCode;
	}

	public void setInstrumentCode(long instrumentCode) {
		this.instrumentCode = instrumentCode;
	}

	public void setRuleLineSeqNos(ArrayList<Long> ruleLineSeqNos) {
		this.ruleLineSeqNos = ruleLineSeqNos;
	}

	public PromoTxnDetailsDTO(long txnNo, long customerSeqNo, long companySeqNo, long providerSeqNo,
			long instrumentCode, String txnDate, long productSeqNo, float amt, ArrayList<Long> ruleLineSeqNos) {
		super();
		this.txnNo = txnNo;
		this.customerSeqNo = customerSeqNo;
		this.companySeqNo = companySeqNo;
		this.providerSeqNo = providerSeqNo;
		this.instrumentCode = instrumentCode;
		this.txnDate = txnDate;
		this.productSeqNo = productSeqNo;
		this.amt = amt;
		this.ruleLineSeqNos = ruleLineSeqNos;
	}
	
}