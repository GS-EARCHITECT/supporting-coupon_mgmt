package deal_mgmt.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;


public class OfferingsPromoDetailsDTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -595267415865835872L;
	private long promoSeqNo;
	private Long offeringSeqNo;
	private String frDttm;
	private String remarks;
	private String status;
	private String toDttm;
	private BigDecimal frequency;

	public long getPromoSeqNo() {
		return promoSeqNo;
	}
	public void setPromoSeqNo(long promoSeqNo) {
		this.promoSeqNo = promoSeqNo;
	}
	public Long getOfferingSeqNo() {
		return offeringSeqNo;
	}
	public void setOfferingSeqNo(Long offeringSeqNo) {
		this.offeringSeqNo = offeringSeqNo;
	}
	public String getFrDttm() {
		return frDttm;
	}
	public void setFrDttm(String frDttm) {
		this.frDttm = frDttm;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getToDttm() {
		return toDttm;
	}
	public void setToDttm(String toDttm) {
		this.toDttm = toDttm;
	}
	
	
	
	public OfferingsPromoDetailsDTO(long promoSeqNo, Long offeringSeqNo, String frDttm, String remarks, String status,
			String toDttm, BigDecimal frequency) {
		super();
		this.promoSeqNo = promoSeqNo;
		this.offeringSeqNo = offeringSeqNo;
		this.frDttm = frDttm;
		this.remarks = remarks;
		this.status = status;
		this.toDttm = toDttm;
		this.frequency = frequency;
	}
	public BigDecimal getFrequency() {
		return frequency;
	}
	public void setFrequency(BigDecimal frequency) {
		this.frequency = frequency;
	}
	
	public OfferingsPromoDetailsDTO() {
		super();
	}

		
}