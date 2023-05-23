package deal_mgmt.model.dto;

import java.io.Serializable;

public class PromoMasterDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8106804693274217335L;
	private long promoSeqNo;
	private String remarks;
	private String status;
	private String promoid;

	
	
	public long getPromoSeqNo() {
		return promoSeqNo;
	}

	public void setPromoSeqNo(long promoSeqNo) {
		this.promoSeqNo = promoSeqNo;
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
	
	public PromoMasterDTO() {
		super();
	}

	public String getPromoid() {
		return promoid;
	}

	public void setPromoid(String promoid) {
		this.promoid = promoid;
	}

	public PromoMasterDTO(long promoSeqNo, String remarks, String status, String promoid) {
		super();
		this.promoSeqNo = promoSeqNo;
		this.remarks = remarks;
		this.status = status;
		this.promoid = promoid;
	}


}