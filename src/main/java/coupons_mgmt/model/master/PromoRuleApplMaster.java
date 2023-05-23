package coupons_mgmt.model.master;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 * The persistent class for the CATALOG_MASTER database table.
 * 
 */
@Entity
@Table(name = "PROMO_RULE_APPL_MASTER")
public class PromoRuleApplMaster implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5313190779586375648L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RULE_APP_SEQ_NO")
	@SequenceGenerator(name = "RULE_APP_SEQ_NO", sequenceName = "RULE_APP_SEQ_NO", allocationSize = 1)
	@Column(name = "RULE_APP_SEQ_NO")
	private long ruleAppSeqNo;

	@Column(name = "FR_DTTM")
	private Timestamp FR_DTTM;

	@Column(name = "TO_DTTM")
	private Timestamp TO_DTTM;

	@Column(name = "CLASS_NAME")
	private String CLASS_NAME;

	@Column(name = "COMPANY_SEQ_NO")
	private long COMPANY_SEQ_NO;

	public long getRuleAppSeqNo() {
		return ruleAppSeqNo;
	}

	public void setRuleAppSeqNo(long ruleAppSeqNo) {
		this.ruleAppSeqNo = ruleAppSeqNo;
	}

	public Timestamp getFR_DTTM() {
		return FR_DTTM;
	}

	public void setFR_DTTM(Timestamp fR_DTTM) {
		FR_DTTM = fR_DTTM;
	}

	public Timestamp getTO_DTTM() {
		return TO_DTTM;
	}

	public void setTO_DTTM(Timestamp tO_DTTM) {
		TO_DTTM = tO_DTTM;
	}

	public String getCLASS_NAME() {
		return CLASS_NAME;
	}

	public void setCLASS_NAME(String cLASS_NAME) {
		CLASS_NAME = cLASS_NAME;
	}

	public long getCOMPANY_SEQ_NO() {
		return COMPANY_SEQ_NO;
	}

	public void setCOMPANY_SEQ_NO(long cOMPANY_SEQ_NO) {
		COMPANY_SEQ_NO = cOMPANY_SEQ_NO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CLASS_NAME == null) ? 0 : CLASS_NAME.hashCode());
		result = prime * result + (int) (COMPANY_SEQ_NO ^ (COMPANY_SEQ_NO >>> 32));
		result = prime * result + ((FR_DTTM == null) ? 0 : FR_DTTM.hashCode());
		result = prime * result + ((TO_DTTM == null) ? 0 : TO_DTTM.hashCode());
		result = prime * result + (int) (ruleAppSeqNo ^ (ruleAppSeqNo >>> 32));
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
		PromoRuleApplMaster other = (PromoRuleApplMaster) obj;
		if (CLASS_NAME == null) {
			if (other.CLASS_NAME != null)
				return false;
		} else if (!CLASS_NAME.equals(other.CLASS_NAME))
			return false;
		if (COMPANY_SEQ_NO != other.COMPANY_SEQ_NO)
			return false;
		if (FR_DTTM == null) {
			if (other.FR_DTTM != null)
				return false;
		} else if (!FR_DTTM.equals(other.FR_DTTM))
			return false;
		if (TO_DTTM == null) {
			if (other.TO_DTTM != null)
				return false;
		} else if (!TO_DTTM.equals(other.TO_DTTM))
			return false;
		if (ruleAppSeqNo != other.ruleAppSeqNo)
			return false;
		return true;
	}

	public PromoRuleApplMaster(long ruleAppSeqNo, Timestamp fR_DTTM, Timestamp tO_DTTM, String cLASS_NAME,
			long cOMPANY_SEQ_NO) {
		super();
		this.ruleAppSeqNo = ruleAppSeqNo;
		FR_DTTM = fR_DTTM;
		TO_DTTM = tO_DTTM;
		CLASS_NAME = cLASS_NAME;
		COMPANY_SEQ_NO = cOMPANY_SEQ_NO;
	}

	public PromoRuleApplMaster() {
		super();
	}

}