package coupons_mgmt.model.dto;

import java.io.Serializable;

public class PromoRuleApplMasterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7846981815771708503L;
	private String class_name;
	private long company_seq_no;
	private String fr_dttm;
	private String to_dttm;
	private long rule_app_seq_no;

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public long getCompany_seq_no() {
		return company_seq_no;
	}

	public void setCompany_seq_no(long company_seq_no) {
		this.company_seq_no = company_seq_no;
	}

	public String getFr_dttm() {
		return fr_dttm;
	}

	public void setFr_dttm(String fr_dttm) {
		this.fr_dttm = fr_dttm;
	}

	public String getTo_dttm() {
		return to_dttm;
	}

	public void setTo_dttm(String to_dttm) {
		this.to_dttm = to_dttm;
	}

	public long getRule_app_seq_no() {
		return rule_app_seq_no;
	}

	public void setRule_app_seq_no(long rule_app_seq_no) {
		this.rule_app_seq_no = rule_app_seq_no;
	}

	public PromoRuleApplMasterDTO(String class_name, long company_seq_no, String fr_dttm, String to_dttm,
			long rule_app_seq_no) {
		super();
		this.class_name = class_name;
		this.company_seq_no = company_seq_no;
		this.fr_dttm = fr_dttm;
		this.to_dttm = to_dttm;
		this.rule_app_seq_no = rule_app_seq_no;
	}

	public PromoRuleApplMasterDTO() {
		super();
	}

}