package deal_mgmt.model.master;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the PROMO_MASTER database table.
 * 
 */
@Entity
@Table(name="OFFERINGS_PROMO_DETAILS")
public class OfferingsPromoDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OfferingsPromoDetailsPK id;
	
	@Column(name="FR_DTTM")
	private Timestamp frDttm;

	@Column(name="REMARKS")
	private String remarks;

	@Column(name="STATUS")
	private String status;

	@Column(name="TO_DTTM")
	private Timestamp toDttm;
	
	@Column(name="FREQUENCY")
	private BigDecimal frequency;

	public OfferingsPromoDetails() {
	}

	public OfferingsPromoDetailsPK getId() {
		return id;
	}

	public void setId(OfferingsPromoDetailsPK id) {
		this.id = id;
	}

	public Timestamp getFrDttm() {
		return frDttm;
	}

	public void setFrDttm(Timestamp frDttm) {
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

	public Timestamp getToDttm() {
		return toDttm;
	}

	public void setToDttm(Timestamp toDttm) {
		this.toDttm = toDttm;
	}
	
	public BigDecimal getFrequency() {
		return frequency;
	}

	public void setFrequency(BigDecimal frequency) {
		this.frequency = frequency;
	}

	public OfferingsPromoDetails(OfferingsPromoDetailsPK id, Timestamp frDttm, String remarks, String status,
			Timestamp toDttm, BigDecimal frequency) {
		super();
		this.id = id;
		this.frDttm = frDttm;
		this.remarks = remarks;
		this.status = status;
		this.toDttm = toDttm;
		this.frequency = frequency;
	}

	
}