package coupons_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the CATALOG_MASTER database table.
 * 
 */
@Entity
@Table(name = "PROMO_RULE_MASTER")
public class PromoRuleMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1287700338569867988L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROMO_RULE_SEQ_NO")
	@SequenceGenerator(name = "PROMO_RULE_SEQ_NO", sequenceName = "PROMO_SEQ_NO", allocationSize = 1)
	@Column(name = "RULE_SEQ_NO")
	private long ruleSeqNo;

	@Column(name = "FUNCTION_NAME")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((functionName == null) ? 0 : functionName.hashCode());
		result = prime * result + (int) (ruleSeqNo ^ (ruleSeqNo >>> 32));
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
		PromoRuleMaster other = (PromoRuleMaster) obj;
		if (functionName == null) {
			if (other.functionName != null)
				return false;
		} else if (!functionName.equals(other.functionName))
			return false;
		if (ruleSeqNo != other.ruleSeqNo)
			return false;
		return true;
	}

	public PromoRuleMaster(long ruleSeqNo, String functionName) {
		super();
		this.ruleSeqNo = ruleSeqNo;
		this.functionName = functionName;
	}

	public PromoRuleMaster() {
		super();
	}

}