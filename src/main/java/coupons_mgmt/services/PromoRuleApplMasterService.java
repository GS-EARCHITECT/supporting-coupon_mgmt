package coupons_mgmt.services;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import coupons_mgmt.model.dto.PromoRuleApplMasterDTO;
import coupons_mgmt.model.dto.PromoRuleAppliedDTO;
import coupons_mgmt.model.dto.PromoTxnDetailsDTO;
import coupons_mgmt.model.master.PromoRuleApplMaster;
import coupons_mgmt.model.master.PromoRuleApplDetails;
import coupons_mgmt.model.master.PromoRuleMaster;
import coupons_mgmt.model.repo.PromoRuleApplDetailsRepo;
import coupons_mgmt.model.repo.PromoRuleApplMasterRepo;
import coupons_mgmt.model.repo.PromoRuleMasterRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("promoRuleApplMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PromoRuleApplMasterService implements I_PromoRuleApplMasterService 
{
	private static final Logger logger = LoggerFactory.getLogger(PromoRuleApplMasterService.class);

	@Autowired
	private PromoRuleMasterRepo promoRuleMasterRepo;
	
	@Autowired
	private PromoRuleApplMasterRepo promoRuleApplMasterRepo;
	
	@Autowired
	private PromoRuleApplDetailsRepo promoRuleApplDetailsRepo;
	
	public double applyPromoRule(Long companySeqNo, String frDtTm, String toDtTm, PromoTxnDetailsDTO promoTxnDetails)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");		
		LocalDateTime fdtTM = LocalDateTime.parse(frDtTm, formatter);
		LocalDateTime tdtTM = LocalDateTime.parse(toDtTm, formatter);
		Timestamp frTS = Timestamp.valueOf(fdtTM);
		Timestamp toTS = Timestamp.valueOf(tdtTM);			
		String methodName= "";
		String className= "";
		Method method=null;
			
		ArrayList<PromoRuleApplMaster> promoRuleApplMasters = promoRuleApplMasterRepo.getSelectPromoAppRules(companySeqNo, frTS, toTS);
		ArrayList<PromoRuleAppliedDTO> promoRuleAppliedCons = new ArrayList<PromoRuleAppliedDTO>(); 
		ArrayList<PromoRuleApplDetails> promoRuleApplDetails = null;
		PromoRuleApplDetails promoRuleApplDetail = null;
		PromoRuleAppliedDTO promoRuleApplliedDTO = null;
				
		if(promoRuleApplMasters!=null)
		{
		for(int ctr=0;ctr<promoRuleApplMasters.size();ctr++)
		{
		promoRuleApplDetails = promoRuleApplDetailsRepo.getDefaultPromoAppDetails(promoRuleApplMasters.get(ctr).getRuleAppSeqNo());
		className = promoRuleApplMasters.get(ctr).getCLASS_NAME();
		
		if(promoRuleApplDetails!=null)
		{
		for(int ctr2=0; ctr2<promoRuleApplDetails.size(); ctr2++)
		{
		promoRuleApplliedDTO = new PromoRuleAppliedDTO();
		promoRuleApplliedDTO.setAmtDisc(promoRuleApplDetails.get(ctr2).getAmtDisc());
		promoRuleApplliedDTO.setExactAmt(promoRuleApplDetails.get(ctr2).getMaxAmt());
		promoRuleApplliedDTO.setProviderSeqNo(promoRuleApplDetails.get(ctr2).getProviderSeqNo());
		promoRuleApplliedDTO.setResourceSeqNo(promoRuleApplDetails.get(ctr2).getResourceSeqNo());
		promoRuleApplliedDTO.setRuleAppSeqNo(promoRuleApplDetails.get(ctr2).getRuleAppSeqNo());
		promoRuleApplliedDTO.setRuleSeqNo(promoRuleApplDetails.get(ctr2).getRuleSeqNo());
		promoRuleApplliedDTO.setRuleLineSeqNo(promoRuleApplDetails.get(ctr2).getRuleLineSeqNo());
		promoRuleApplliedDTO.setInstrument_code(promoRuleApplDetails.get(ctr2).getInstrument_code());
		promoRuleApplliedDTO.setMaxAmt(promoRuleApplDetails.get(ctr2).getMaxAmt());
		promoRuleApplliedDTO.setMinAmt(promoRuleApplDetails.get(ctr2).getMinAmt());
		promoRuleApplliedDTO.setPercDisc(promoRuleApplDetails.get(ctr2).getPercDisc());		
		promoRuleApplliedDTO.setClassName(className);		
		promoRuleAppliedCons.add(promoRuleApplliedDTO);
		}
		}		
		}
		}
		
		for(int ctr7=0; ctr7<promoTxnDetails.getRuleLineSeqNos().size();ctr7++)
		{	  
		promoRuleApplDetail=promoRuleApplDetailsRepo.getSelectPromoAppDetails(promoTxnDetails.getRuleLineSeqNos().get(ctr7));
		if(promoRuleApplDetail!=null)
		{
		promoRuleApplliedDTO = new PromoRuleAppliedDTO();
		promoRuleApplliedDTO.setAmtDisc(promoRuleApplDetail.getAmtDisc());
		promoRuleApplliedDTO.setExactAmt(promoRuleApplDetail.getMaxAmt());
		promoRuleApplliedDTO.setProviderSeqNo(promoRuleApplDetail.getProviderSeqNo());
		promoRuleApplliedDTO.setResourceSeqNo(promoRuleApplDetail.getResourceSeqNo());
		promoRuleApplliedDTO.setRuleAppSeqNo(promoRuleApplDetail.getRuleAppSeqNo());
		promoRuleApplliedDTO.setRuleSeqNo(promoRuleApplDetail.getRuleSeqNo());
		promoRuleApplliedDTO.setRuleLineSeqNo(promoRuleApplDetail.getRuleLineSeqNo());
		promoRuleApplliedDTO.setInstrument_code(promoRuleApplDetail.getInstrument_code());
		promoRuleApplliedDTO.setMaxAmt(promoRuleApplDetail.getMaxAmt());
		promoRuleApplliedDTO.setMinAmt(promoRuleApplDetail.getMinAmt());
		promoRuleApplliedDTO.setPercDisc(promoRuleApplDetail.getPercDisc());		
		promoRuleApplliedDTO.setClassName(className);		
		promoRuleAppliedCons.add(promoRuleApplliedDTO);
		}
		}
				
		Class<?> classRef=null;
		Float txnAmt =promoTxnDetails.getAmt();
		
		// Call each rule function in app rule class file 
		for(int ctr4=0; ctr4<promoRuleAppliedCons.size();ctr4++)
		{
		Optional<PromoRuleMaster> promoRuleMaster = promoRuleMasterRepo.findById(promoRuleAppliedCons.get(ctr4).getRuleSeqNo()); 	
		promoRuleApplliedDTO = promoRuleAppliedCons.get(ctr4);
		methodName = promoRuleMaster.get().getFunctionName();
		methodName = methodName.trim();
		logger.info("rule :"+promoRuleAppliedCons.get(ctr4).getRuleSeqNo());
		logger.info("method name :"+methodName);
		className = promoRuleAppliedCons.get(ctr4).getClassName();
		Object instance=null;		
				    
			try {
				classRef = Class.forName(className.trim());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
			try {
				instance = classRef.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    	
				try {
					method = classRef.getDeclaredMethod(methodName, PromoRuleAppliedDTO.class, PromoTxnDetailsDTO.class, Float.class);
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            try {
	            	Object value = method.invoke(instance,promoRuleApplliedDTO,promoTxnDetails, txnAmt);
	            	txnAmt = (Float)value;
	            	
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	}
		    
		    return txnAmt;
	}
	
	public PromoRuleApplMasterDTO newPromoRuleApplMaster(PromoRuleApplMasterDTO lMaster) 
	{		
		PromoRuleApplMaster PromoRuleApplMaster = promoRuleApplMasterRepo.save(this.setPromoRuleApplMaster(lMaster));
		lMaster = getPromoRuleApplMasterDTO(PromoRuleApplMaster);
		return lMaster;
	}

	public ArrayList<PromoRuleApplMasterDTO> getAllPromoRuleApplMasters() {
		ArrayList<PromoRuleApplMaster> resourceList = (ArrayList<PromoRuleApplMaster>) promoRuleApplMasterRepo.findAll();
		ArrayList<PromoRuleApplMasterDTO> lMasterss = new ArrayList<PromoRuleApplMasterDTO>();
		lMasterss = resourceList != null ? this.getPromoRuleApplMasterDTOs(resourceList) : null;
		return lMasterss;
	}

	public PromoRuleApplMasterDTO getPromoRuleApplMasterById(Long ruleSeqNo) {
		Optional<PromoRuleApplMaster> PromoRuleApplMaster = promoRuleApplMasterRepo.findById(ruleSeqNo);
		PromoRuleApplMasterDTO lMasters = null;
		if (PromoRuleApplMaster.isPresent()) {
			lMasters = PromoRuleApplMaster != null ? this.getPromoRuleApplMasterDTO(PromoRuleApplMaster.get()) : null;
		}
		return lMasters;
	}

	public void updPromoRuleApplMaster(PromoRuleApplMasterDTO lMaster) 
	{
		PromoRuleApplMaster promoRuleApplMaster = this.setPromoRuleApplMaster(lMaster);
		if (promoRuleApplMasterRepo.existsById(lMaster.getRule_app_seq_no())) 
				{		
			promoRuleApplMaster.setRuleAppSeqNo(lMaster.getRule_app_seq_no());			
			promoRuleApplMasterRepo.save(promoRuleApplMaster);			
		}
		return;
	}

	public void delPromoRuleApplMaster(Long resourceSeqNo) {
		if (promoRuleApplMasterRepo.existsById(resourceSeqNo)) {
			promoRuleApplMasterRepo.deleteById(resourceSeqNo);
		}
		return;
	}

	public void delAllPromoRuleApplMasters() {
		promoRuleApplMasterRepo.deleteAll();
	}

	public void delSelectPromoRules(ArrayList<Long> ids)
	{
		if (ids != null) {
			promoRuleApplMasterRepo.delSelectPromoRules(ids);
		}
	}

	
	private ArrayList<PromoRuleApplMasterDTO> getPromoRuleApplMasterDTOs(ArrayList<PromoRuleApplMaster> lMasters) 
	{
		PromoRuleApplMasterDTO lDTO = null;
		ArrayList<PromoRuleApplMasterDTO> lMasterDTOs = new ArrayList<PromoRuleApplMasterDTO>();		
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getPromoRuleApplMasterDTO(lMasters.get(i));			
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private PromoRuleApplMasterDTO getPromoRuleApplMasterDTO(PromoRuleApplMaster lMaster) 
	{		
		PromoRuleApplMasterDTO lDTO = new PromoRuleApplMasterDTO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		lDTO.setFr_dttm(formatter.format(lMaster.getFR_DTTM().toLocalDateTime()));
		lDTO.setTo_dttm(formatter.format(lMaster.getTO_DTTM().toLocalDateTime()));
		lDTO.setClass_name(lMaster.getCLASS_NAME());
		lDTO.setCompany_seq_no(lMaster.getCOMPANY_SEQ_NO());
		lDTO.setRule_app_seq_no(lMaster.getRuleAppSeqNo());								
		return lDTO;
	}

	private PromoRuleApplMaster setPromoRuleApplMaster(PromoRuleApplMasterDTO lDTO) 
	{
		PromoRuleApplMaster lMaster = new PromoRuleApplMaster();		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime fr_DateTime = LocalDateTime.parse(lDTO.getFr_dttm(), formatter);
		LocalDateTime to_DateTime = LocalDateTime.parse(lDTO.getTo_dttm(), formatter);
		lMaster.setFR_DTTM(Timestamp.valueOf(fr_DateTime));
		lMaster.setTO_DTTM(Timestamp.valueOf(to_DateTime));
		lMaster.setCLASS_NAME(lDTO.getClass_name());
		lMaster.setCOMPANY_SEQ_NO(lDTO.getCompany_seq_no());		
		return lMaster;
	}
}