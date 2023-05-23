package deal_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CATALOG_MASTER database table.
 * 
 */
@Entity
@Table(name="PROMO_MASTER")
public class PromoMaster implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4861458634087527750L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROMO_SEQ_NO")
	@SequenceGenerator(name="PROMO_SEQ_NO", sequenceName="PROMO_SEQ_NO", allocationSize = 1)		
	@Column(name="PROMO_SEQ_NO")
	private long promoSeqNo;

	@Column(name="REMARKS")
	private String remarks;

	@Column(name="PROMO_ID")
	private String promoid;
	
	@Column(name="STATUS")
	private String status;

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

	public PromoMaster() {
		super();
	}

	public String getPromoid() {
		return promoid;
	}

	public void setPromoid(String promoid) {
		this.promoid = promoid;
	}

	public PromoMaster(long promoSeqNo, String remarks, String promoid, String status) {
		super();
		this.promoSeqNo = promoSeqNo;
		this.remarks = remarks;
		this.promoid = promoid;
		this.status = status;
	}
	
	
	
}