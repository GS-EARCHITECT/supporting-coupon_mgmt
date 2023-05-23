package coupons_mgmt.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import coupons_mgmt.model.dto.PromoRuleAppliedDTO;
import coupons_mgmt.model.dto.PromoTxnDetailsDTO;


public class TestRules 
{
	private static final Logger logger = LoggerFactory.getLogger(TestRules.class);
	
	// Flat Discount 
		public float R1() 
		{
			logger.info("gaurav");
			
			return 0;
		}

		// Slab Discount
		public float R2() 
		{
			logger.info("ajay");
			return 1;
		}

		// Min Amount
		public float R3()
		{
			logger.info("dan");
			return 3;
		}


	// Flat Discount without any conditions 
	public float R1(PromoRuleAppliedDTO promoRuleAppliedDTO, PromoTxnDetailsDTO promoTxnDetailsDTO, Float amt) 
	{
		Float amtNew = amt - ((amt*promoRuleAppliedDTO.getPercDisc())/100);
		logger.info("flat disscount perc for gaurav :"+promoRuleAppliedDTO.getPercDisc());
		logger.info("Calc Amount is :"+amtNew);
		return amtNew;
	}

	// Slab Discount
	public float R2(PromoRuleAppliedDTO promoRuleAppliedDTO, PromoTxnDetailsDTO promoTxnDetailsDTO, Float amt) 
	{
		Float amtNew = amt;
		if((promoTxnDetailsDTO.getAmt()>=promoRuleAppliedDTO.getMinAmt()) && (promoTxnDetailsDTO.getAmt()<=promoRuleAppliedDTO.getMaxAmt()))
		{
		amtNew = amt - promoRuleAppliedDTO.getAmtDisc();
		logger.info("slab discount for ajay at min :"+promoRuleAppliedDTO.getMinAmt()+" max :"+promoRuleAppliedDTO.getMaxAmt()+" disc amt  :"+promoRuleAppliedDTO.getAmtDisc());
		logger.info("Calc Amount is :"+amtNew);
		}
		else 
		{
		logger.info("Slab disc not applied");	
		}
		return amtNew;
	}

	// Min Amount
	public float R3(PromoRuleAppliedDTO promoRuleAppliedDTO, PromoTxnDetailsDTO promoTxnDetailsDTO, Float amt)
	{
		Float amtNew = amt;
		if(promoTxnDetailsDTO.getAmt()>=promoRuleAppliedDTO.getMinAmt())
		{		
		amtNew = amt - ((amt*promoRuleAppliedDTO.getPercDisc())/100);
		logger.info("slab discount for dan at min amount :"+promoRuleAppliedDTO.getMinAmt()+" disc %  :"+promoRuleAppliedDTO.getPercDisc());
		logger.info("Calc Amount is :"+amtNew);
		}
		else 
		{
		logger.info("Min disc not applied");	
		}
		return amtNew;
	}

}
