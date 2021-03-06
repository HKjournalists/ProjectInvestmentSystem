package com.icbc.pis.web.model;

import java.util.Map;

import com.icbc.pis.util.DoubleUtil;
import com.icbc.pis.util.StringUtil;

public class ProductElement {

	//项目编号
	private String productId;
	
	//项目内部编号
	private String productInnerId;
	
	//产品类型(合同类型)
	private String productType;
	
	//是否需要信用评级
	private String needCreditRating;
	
	//是否需要外部律师意见
	private String needLawVerify;
	
	//项目名称
	private String productName;
	
	//项目简称
	private String productBriefName;
	
	//发行人代码（项目方代码）
	private String issuerCode;


	//受托人
	private String trustManager;
	
	//偿债主体所处行业
	private String dTradeType;
	
	//期限（年）
	private int maturityYear;
	
	//发行规模（亿元）
	private double issueScale;
	
	//是否含权
	private String isIncludeRight;
	
	//含权类型
	private String rightType;
	
	//含权具体说明
	private String rightDesc;
	
	//投资收益率类型
	private String portRatingType;
	
	//收益率
	private double portRating;
	
	//基准利率
	private String benchYieldType;
	
	//基准利率变动系数
	private double benchYieldRatio;
	
	//基准利率调整频率
	private String benchYieldAdjust;
	
	//基准利率利差（%）
	private double interestMargin;
	
	//投资收益率上限（%）
	private double portRatingUpLimit;
	
	//投资收益率下限（%）
	private double portRatingLowLimit;
	
	//托管费（%）
	private double depositFee;
	
	//独立监督费（%）
	private double superviseFee;
	
	//财务顾问费（%）
	private double consultantFee;
	
	//其他费用（%）
	private double otherFee;
	
	//合计费用（%）
	private double totalFee;
	
	//净投资收益率（%）
	private double netPortRating;
	
	//净收益率计算方式
	private String netPortRatingAlgo;
	
	//利息支付频率
	private String interestFrequency;
	
	//起息日
	private String listDate;
	
	//增信措施具体说明
	private String raiseCreditDesc;
	
	//担保人
	private String guarantee;
	
	//担保人所处行业
	private String gTradeType;
	
	//抵质押物比例
	private double mortgageRatio;
	
	//托管人
	private String custodian;
	
	//独立监督人
	private String superintendent;
	
	//财务顾问
	private String fincConsultent;
	
	//其他涉及的主体
	private String otherCorp;
	
	//偿债主体外部信用评级
	private String outerCompanyRate;
	
	//偿债主体外部信用评级机构
	private String outerCompanyRateSrc;
	
	//偿债主体公司内部信用评级
	private String innerCompanyRate;
	
	//偿债主体工行内部信用评级
	private String icbcCompanyRate;
	
	//增信方工行内部信用评级
	private String icbcRaiseCreditRate;
	
	//债项外部信用评级
	private String outerBondRate;
	
	//债项外部信用评级机构
	private String outerBondRateSrc;
	
	//债项公司内部信用评级
	private String innerBondRate;
	
	//其他备注
	private String remark;
	
	//状态
	private String status;
	
	//项目经理ID
	private String productManagerId;

	private String trustManagerName;

	private String dTradeName;
	
	private String guaranteeName;
	
	private String issuerName;
	
	private String gTradeName;
	
	private String custodianName;
	
	private String superintendentName;
	
	private String fincConsultentName;
	
	private String otherCorpName;
	
	private String fundUsage;

	private String maturityDate;
	
	private double putValue;
	
	private String putDate;
	
	private double redemptionValue;
	
	private String redemptionDate;
	
	private String intPayType;
	
	private String intDesc;
	
	private String publishDate;
	
	private String trustSubType;
	
	private String investIntention;
	
	public String getInvestIntention() {
		return investIntention;
	}

	public void setInvestIntention(String investIntention) {
		this.investIntention = investIntention;
	}

	public String getProductManagerId() {
		return this.productManagerId;
	}

	public void setProductManagerId(String productManagerId) {
		this.productManagerId = productManagerId;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductInnerId() {
		return this.productInnerId;
	}

	public void setProductInnerId(String productInnerId) {
		this.productInnerId = productInnerId;
	}

	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getNeedCreditRating() {
		return this.needCreditRating;
	}

	public void setNeedCreditRating(String needCreditRating) {
		this.needCreditRating = needCreditRating;
	}

	public String getNeedLawVerify() {
		return this.needLawVerify;
	}

	public void setNeedLawVerify(String needLawVerify) {
		this.needLawVerify = needLawVerify;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductBriefName() {
		return this.productBriefName;
	}

	public void setProductBriefName(String productBriefName) {
		this.productBriefName = productBriefName;
	}

 
	
	public String getTrustManager() {
		return trustManager;
	}

	public void setTrustManager(String trustManager) {
		this.trustManager = trustManager;
	}

	public String getTrustManagerName() {
		return trustManagerName;
	}

	public void setTrustManagerName(String trustManagerName) {
		this.trustManagerName = trustManagerName;
	}

	public String getdTradeType() {
		return this.dTradeType;
	}

	public void setdTradeType(String dTradeType) {
		this.dTradeType = dTradeType;
	}

	public int getMaturityYear() {
		return this.maturityYear;
	}

	public void setMaturityYear(int maturityYear) {
		this.maturityYear = maturityYear;
	}

	public double getIssueScale() {
		return this.issueScale;
	}

	public void setIssueScale(double issueScale) {
		this.issueScale = issueScale;
	}

	public String getIsIncludeRight() {
		return this.isIncludeRight;
	}

	public void setIsIncludeRight(String isIncludeRight) {
		this.isIncludeRight = isIncludeRight;
	}

	public String getRightType() {
		return this.rightType;
	}

	public void setRightType(String rightType) {
		this.rightType = rightType;
	}

	public String getRightDesc() {
		return this.rightDesc;
	}

	public void setRightDesc(String rightDesc) {
		this.rightDesc = rightDesc;
	}

	public String getPortRatingType() {
		return this.portRatingType;
	}

	public void setPortRatingType(String portRatingType) {
		this.portRatingType = portRatingType;
	}

	public double getPortRating() {
		return this.portRating;
	}

	public void setPortRating(double portRating) {
		this.portRating = portRating;
	}

	public String getBenchYieldType() {
		return this.benchYieldType;
	}

	public void setBenchYieldType(String benchYieldType) {
		this.benchYieldType = benchYieldType;
	}

	public double getBenchYieldRatio() {
		return this.benchYieldRatio;
	}

	public void setBenchYieldRatio(double benchYieldRatio) {
		this.benchYieldRatio = benchYieldRatio;
	}

	public String getbenchYieldAdjust() {
		return this.benchYieldAdjust;
	}

	public void setbenchYieldAdjust(String benchYieldAdjust) {
		this.benchYieldAdjust = benchYieldAdjust;
	}

	public double getInterestMargin() {
		return this.interestMargin;
	}

	public void setInterestMargin(double interestMargin) {
		this.interestMargin = interestMargin;
	}

	public double getPortRatingUpLimit() {
		return this.portRatingUpLimit;
	}

	public void setPortRatingUpLimit(double portRatingUpLimit) {
		this.portRatingUpLimit = portRatingUpLimit;
	}

	public double getPortRatingLowLimit() {
		return this.portRatingLowLimit;
	}

	public void setPortRatingLowLimit(double portRatingLowLimit) {
		this.portRatingLowLimit = portRatingLowLimit;
	}

	public double getDepositFee() {
		return this.depositFee;
	}

	public void setDepositFee(double depositFee) {
		this.depositFee = depositFee;
	}

	public double getSuperviseFee() {
		return this.superviseFee;
	}

	public void setSuperviseFee(double superviseFee) {
		this.superviseFee = superviseFee;
	}

	public double getConsultantFee() {
		return this.consultantFee;
	}

	public void setConsultantFee(double consultantFee) {
		this.consultantFee = consultantFee;
	}

	public double getOtherFee() {
		return this.otherFee;
	}

	public void setOtherFee(double otherFee) {
		this.otherFee = otherFee;
	}

	public double getTotalFee() {
		return this.totalFee;
	}

	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}

	public double getNetPortRating() {
		return this.netPortRating;
	}

	public void setNetPortRating(double netPortRating) {
		this.netPortRating = netPortRating;
	}

	public String getnetPortRatingAlgo() {
		return this.netPortRatingAlgo;
	}

	public void setnetPortRatingAlgo(String netPortRatingAlgo) {
		this.netPortRatingAlgo = netPortRatingAlgo;
	}

	public String getInterestFrequency() {
		return this.interestFrequency;
	}

	public void setInterestFrequency(String interestFrequency) {
		this.interestFrequency = interestFrequency;
	}

	public String getListDate() {
		return this.listDate;
	}

	public void setListDate(String listDate) {
		this.listDate = listDate;
	}

	public String getRaiseCreditDesc() {
		return this.raiseCreditDesc;
	}

	public void setRaiseCreditDesc(String raiseCreditDesc) {
		this.raiseCreditDesc = raiseCreditDesc;
	}

	public String getGuarantee() {
		return this.guarantee;
	}

	public void setGuarantee(String guarantee) {
		this.guarantee = guarantee;
	}

	public String getgTradeType() {
		return this.gTradeType;
	}

	public void setgTradeType(String gTradeType) {
		this.gTradeType = gTradeType;
	}

	public double getMortgageRatio() {
		return this.mortgageRatio;
	}

	public void setMortgageRatio(double mortgageRatio) {
		this.mortgageRatio = mortgageRatio;
	}

	public String getCustodian() {
		return this.custodian;
	}

	public void setCustodian(String custodian) {
		this.custodian = custodian;
	}

	public String getSuperintendent() {
		return this.superintendent;
	}

	public void setSuperintendent(String superintendent) {
		this.superintendent = superintendent;
	}

	public String getFincConsultent() {
		return this.fincConsultent;
	}

	public void setFincConsultent(String fincConsultent) {
		this.fincConsultent = fincConsultent;
	}

	public String getOtherCorp() {
		return this.otherCorp;
	}

	public void setOtherCorp(String otherCorp) {
		this.otherCorp = otherCorp;
	}

	public String getOuterCompanyRate() {
		return this.outerCompanyRate;
	}

	public void setOuterCompanyRate(String outerCompanyRate) {
		this.outerCompanyRate = outerCompanyRate;
	}

	public String getOuterCompanyRateSrc() {
		return this.outerCompanyRateSrc;
	}

	public void setOuterCompanyRateSrc(String outerCompanyRateSrc) {
		this.outerCompanyRateSrc = outerCompanyRateSrc;
	}

	public String getInnerCompanyRate() {
		return this.innerCompanyRate;
	}

	public void setInnerCompanyRate(String innerCompanyRate) {
		this.innerCompanyRate = innerCompanyRate;
	}

	public String getIcbcCompanyRate() {
		return this.icbcCompanyRate;
	}

	public void setIcbcCompanyRate(String icbcCompanyRate) {
		this.icbcCompanyRate = icbcCompanyRate;
	}

	public String getIcbcRaiseCreditRate() {
		return this.icbcRaiseCreditRate;
	}

	public void setIcbcRaiseCreditRate(String icbcRaiseCreditRate) {
		this.icbcRaiseCreditRate = icbcRaiseCreditRate;
	}

	public String getOuterBondRate() {
		return this.outerBondRate;
	}

	public void setOuterBondRate(String outerBondRate) {
		this.outerBondRate = outerBondRate;
	}

	public String getOuterBondRateSrc() {
		return this.outerBondRateSrc;
	}

	public void setOuterBondRateSrc(String outerBondRateSrc) {
		this.outerBondRateSrc = outerBondRateSrc;
	}

	public String getInnerBondRate() {
		return this.innerBondRate;
	}

	public void setInnerBondRate(String innerBondRate) {
		this.innerBondRate = innerBondRate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getdTradeName() {
		return this.dTradeName;
	}

	public void setdTradeName(String dTradeName) {
		this.dTradeName = dTradeName;
	}

	public String getGuaranteeName() {
		return this.guaranteeName;
	}

	public void setGuaranteeName(String guaranteeName) {
		this.guaranteeName = guaranteeName;
	}

	public String getIssuerName() {
		return this.issuerName;
	}

	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}

	public String getgTradeName() {
		return this.gTradeName;
	}

	public void setgTradeName(String gTradeName) {
		this.gTradeName = gTradeName;
	}

	public String getCustodianName() {
		return this.custodianName;
	}

	public void setCustodianName(String custodianName) {
		this.custodianName = custodianName;
	}

	public String getSuperintendentName() {
		return this.superintendentName;
	}
	
	public String getIssuerCode() {
		return issuerCode;
	}

	public void setIssuerCode(String issuerCode) {
		this.issuerCode = issuerCode;
	}
	
	public void setSuperintendentName(String superintendentName) {
		this.superintendentName = superintendentName;
	}

	public String getFincConsultentName() {
		return this.fincConsultentName;
	}

	public void setFincConsultentName(String fincConsultentName) {
		this.fincConsultentName = fincConsultentName;
	}

	public String getOtherCorpName() {
		return this.otherCorpName;
	}

	public void setOtherCorpName(String otherCorpName) {
		this.otherCorpName = otherCorpName;
	}
	
	
	public String getFundUsage() {
		return fundUsage;
	}
	
	public void setFundUsage(String fundUsage) {
		this.fundUsage = fundUsage;
	}

	public String getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}

	public double getPutValue() {
		return putValue;
	}

	public void setPutValue(double putValue) {
		this.putValue = putValue;
	}

	public String getPutDate() {
		return putDate;
	}

	public void setPutDate(String putDate) {
		this.putDate = putDate;
	}

	public double getRedemptionValue() {
		return redemptionValue;
	}

	public void setRedemptionValue(double redemptionValue) {
		this.redemptionValue = redemptionValue;
	}

	public String getRedemptionDate() {
		return redemptionDate;
	}

	public void setRedemptionDate(String redemptionDate) {
		this.redemptionDate = redemptionDate;
	}

	public String getIntPayType() {
		return intPayType;
	}

	public void setIntPayType(String intPayType) {
		this.intPayType = intPayType;
	}

	public String getIntDesc() {
		return intDesc;
	}

	public void setIntDesc(String intDesc) {
		this.intDesc = intDesc;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getTrustSubType() {
		return trustSubType;
	}

	public void setTrustSubType(String trustSubType) {
		this.trustSubType = trustSubType;
	}
	
	private ProductElement()
	{}
	
	public ProductElement(  String productId,
							String productName,
							String productType,
							String issuerName,
							int maturityYear,
							double issueScale,
							String isIncludeRight, 
							String rightType)
	{
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.issuerName = issuerName;
		this.maturityYear = maturityYear;
		this.issueScale = issueScale;
		this.isIncludeRight = isIncludeRight;
		this.rightType = rightType;
	}
	
//	public ProductElement(String productId,
//						  String productType,
//						  String needCreditRating,
//						  String needLawVerify,
//						  String issureCode,
//						  String trustManager,
//						  int maturityYear,
//						  double issueScale,
//						  String isIncludeRight,
//						  String rightType,
//						  String portRatingType,
//						  String benchYieldType,
//						  double benchYieldRatio,
//						  String benchYieldAdjust,
//						  double interestMargin,
//						  double portRatingULimit,
//						  double portRatingLLimit,
//						  double totalFee,
//						  double netPortRating,
//						  String netPortRatingAlgo,
//						  String interestFrequency,
//						  String outerCompanyRate,
//						  String outerCompanyRateSrc,
//						  String outerBondRate,
//						  String outerBondRateSrc,
//						  String status,
//						  String productManagerId
//						  )
//	{
//		this.productId = productId;
//		
//		this.productType = productType;
//		
//		this.needCreditRating = needCreditRating;
//		
//		this.needLawVerify = needLawVerify;
//		
//		this.issureCode = issureCode;
//		
//		this.issueScale = issueScale;
//		
//		this.trustManager = trustManager;
//		
//		this.maturityYear = maturityYear;
//		
//		this.isIncludeRight = isIncludeRight;
//		
//		this.rightType = rightType;
//		
//		this.portRatingType = portRatingType;
//		
//		this.benchYieldType = benchYieldType;
//		
//		this.benchYieldRatio = benchYieldRatio;
//		
//		this.benchYieldAdjust = benchYieldAdjust;
//		
//		this.interestMargin = interestMargin;
//		
//		this.portRatingUpLimit = portRatingULimit;
//		
//		this.portRatingLowLimit = portRatingLLimit;
//		
//		this.totalFee = totalFee;
//		
//		this.netPortRating = netPortRating;
//		
//		this.netPortRatingAlgo = netPortRatingAlgo;
//		
//		this.interestFrequency = interestFrequency;
//		
//		this.outerCompanyRate = outerCompanyRate;
//		
//		this.outerCompanyRateSrc = outerCompanyRateSrc;
//		
//		this.outerBondRate = outerBondRate;
//		
//		this.outerBondRateSrc = outerBondRateSrc;
//		
//		this.status = status;
//		
//		this.productManagerId = productManagerId;
//	}
	
	public ProductElement(Map<String,String> eleMap)	
	{
		
		 this.productId  = eleMap.get("productId");
		 
		 this.productInnerId  = eleMap.get("productInnerId");
		 
		 this.productType  = eleMap.get("productType");
		 
		 this.needCreditRating  = eleMap.get("needCreditRating");
		 
		 if(StringUtil.isNullOrEmpty(this.needCreditRating))
		 {
			 this.needCreditRating = "1";
		 }
		 this.needLawVerify  = eleMap.get("needLawVerify");
		 
		 if(StringUtil.isNullOrEmpty(this.needLawVerify))
		 {
			 this.needLawVerify = "1";
		 }
		 this.productName  = eleMap.get("productName");
		 
		 this.productBriefName  = eleMap.get("productBriefName");
		 
		 this.issuerCode  = eleMap.get("issuerCode");
		 
		 this.dTradeType  = eleMap.get("dTradeType");
		 
		 if(StringUtil.isNullOrEmpty(eleMap.get("maturityYear")))
		 {
			 this.maturityYear = 0;
		 }
		 else
		 {
			 this.maturityYear  = Integer.parseInt(eleMap.get("maturityYear"));
		 }
		 
		 this.issueScale  = DoubleUtil.parseDouble(eleMap.get("issueScale"));;
		 this.isIncludeRight  = eleMap.get("isIncludeRight");
		 this.rightType  = eleMap.get("rightType");
		 this.rightDesc  = eleMap.get("rightDesc");
		 this.portRatingType  = eleMap.get("portRatingType");
		 this.portRating  = DoubleUtil.parseDouble(eleMap.get("portRating"));
		 this.benchYieldType  = eleMap.get("benchYieldType");
		 this.benchYieldRatio  = DoubleUtil.parseDouble(eleMap.get("benchYieldRatio"));
		 this.benchYieldAdjust  = eleMap.get("benchYieldAdjust");
		 this.interestMargin = DoubleUtil.parseDouble(eleMap.get("interestMargin"));
		 this.portRatingUpLimit = DoubleUtil.parseDouble(eleMap.get("portRatingUpLimit"));
		 this.portRatingLowLimit = DoubleUtil.parseDouble(eleMap.get("portRatingLowLimit"));
		 this.depositFee  = DoubleUtil.parseDouble(eleMap.get("depositFee"));
		 this.superviseFee  = DoubleUtil.parseDouble(eleMap.get("superviseFee"));
		 this.consultantFee  = DoubleUtil.parseDouble(eleMap.get("consultantFee"));
		 this.otherFee  = DoubleUtil.parseDouble(eleMap.get("otherFee"));
		 this.totalFee  = DoubleUtil.parseDouble(eleMap.get("totalFee"));
		 this.netPortRating  = DoubleUtil.parseDouble(eleMap.get("netPortRating"));
		 this.netPortRatingAlgo  = eleMap.get("netPortRatingAlgo");
		 this.interestFrequency = eleMap.get("interestFrequency");
		 this.listDate  = eleMap.get("listDate");
		 this.raiseCreditDesc  = eleMap.get("raiseCreditDesc");
		 this.guarantee  = eleMap.get("guarantee");
		 this.gTradeType  = eleMap.get("gTradeType");
		 this.mortgageRatio  = DoubleUtil.parseDouble(eleMap.get("mortgageRatio"));
		 this.custodian  = eleMap.get("custodian");
		 this.superintendent  = eleMap.get("superintendent");
		 this.fincConsultent  = eleMap.get("fincConsultent");
		 this.otherCorp  = eleMap.get("otherCorp");
		 this.outerCompanyRate  = eleMap.get("outerCompanyRate");
		 this.outerCompanyRateSrc  = eleMap.get("outerCompanyRateSrc");
		 this.innerCompanyRate  = eleMap.get("innerCompanyRate");
		 this.icbcCompanyRate  = eleMap.get("icbcCompanyRate");
		 this.icbcRaiseCreditRate  = eleMap.get("icbcRaiseCreditRate");
		 this.outerBondRate  = eleMap.get("outerBondRate");
		 this.outerBondRateSrc  = eleMap.get("outerBondRateSrc");
		 this.innerBondRate  = eleMap.get("innerBondRate");
		 this.remark  = eleMap.get("remark");
		 this.status  = eleMap.get("status");
		 this.productManagerId  = eleMap.get("productManagerId");
		 this.issuerName = eleMap.get("issuerName");
		 this.dTradeName = eleMap.get("dTradeName");
		 this.guaranteeName = eleMap.get("guaranteeName");
		 this.gTradeName = eleMap.get("gTradeName");
		 this.custodianName = eleMap.get("custodianName");
		 this.superintendentName = eleMap.get("superintendentName");
		 this.fincConsultentName = eleMap.get("fincConsultentName");
		 this.otherCorpName = eleMap.get("otherCorpName");
		 this.fundUsage = eleMap.get("fundUsage");
		 this.maturityDate = eleMap.get("maturityDate");
		 this.putValue = DoubleUtil.parseDouble(eleMap.get("putValue"));
		 this.putDate = eleMap.get("putDate");
		 this.redemptionValue = DoubleUtil.parseDouble(eleMap.get("redemptionValue"));
		 this.redemptionDate = eleMap.get("redemptionDate");
		 this.intPayType = eleMap.get("intPayType");
		 this.intDesc = eleMap.get("intDesc");
		 this.publishDate = eleMap.get("publishDate");
		 this.trustSubType = eleMap.get("trustSubType");
		 this.investIntention = eleMap.get("investIntention");
		 this.trustManager = eleMap.get("trustManager");
		 this.trustManagerName = eleMap.get("trustManagerName");
	}
	
}
