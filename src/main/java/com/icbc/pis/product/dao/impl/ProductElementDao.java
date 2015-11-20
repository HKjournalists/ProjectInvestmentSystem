package com.icbc.pis.product.dao.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.icbc.pis.common.dao.ICommonOperDao;
import com.icbc.pis.datastruct.ProductVerifyFlag;
import com.icbc.pis.product.dao.IProductElementDao;
import com.icbc.pis.user.service.impl.UserService;
import com.icbc.pis.util.StringUtil;
import com.icbc.pis.web.mapper.ProductElementMapper;
import com.icbc.pis.web.mapper.ProductElementPartMapper;
import com.icbc.pis.web.model.ProductElement;
import com.icbc.pis.web.model.User;

@Repository("ProductElementDao")
public class ProductElementDao implements IProductElementDao,ICommonOperDao {

	private static final Logger logger = LoggerFactory.getLogger(ProductElementDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean add(Object obj) {
		// TODO Auto-generated method stub
		ProductElement productElement = (ProductElement) obj;
		
		String sql = "insert into PIS_PRODUCT_ELEMENT("
				+ " PRODUCT_ID,"
				+ " PRODUCT_INNER_ID,"
				+ " PRODUCT_TYPE,"
				+ " NEED_CREDIT_RATING,"
				+ " NEED_LAW_VERIFY,"
				+ " PRODUCT_NAME,"
				+ " PRODUCT_BRIEF_NAME,"
				+ " ISSUER_CODE,"
				+ " D_TRADE_TYPE,"
				+ " MATURITY_YEAR,"
				+ " ISSUE_SCALE,"
				+ " IS_INCLUDE_RIGHT,"
				+ " RIGHT_TYPE,"
				+ " RIGHT_DESC,"
				+ " PORT_RATING_TYPE,"
				+ " PORT_RATING,"
				+ " BENCH_YIELD_TYPE,"
				+ " BENCH_YIELD_RATIO,"
				+ " BENCH_YIELD_ADJUST,"
				+ " INTEREST_MARGIN,"
				+ " PORT_RATING_U_LIMIT,"
				+ " PORT_RATING_L_LIMIT,"
				+ " DEPOSIT_FEE,"
				+ " SUPERVISE_FEE,"
				+ " CONSULTANT_FEE,"
				+ " OTHER_FEE,"
				+ " TOTAL_FEE,"
				+ " NET_PORT_RATING,"
				+ " NET_PORT_RATING_ALGO,"
				+ " INTEREST_FREQUENCY,"
				+ " LIST_DATE,"
				+ " RAISE_CREDIT_DESC,"
				+ " GUARANTEE,"
				+ " G_TRADE_TYPE,"
				+ " MORTGAGE_RATIO,"
				+ " CUSTODIAN,"
				+ " SUPERINTENDENT,"
				+ " FINC_CONSULTENT,"
				+ " OTHER_CORP,"
				+ " OUTER_COMPANY_RATE,"
				+ " OUTER_COMPANY_RATE_SRC,"
				+ " INNER_COMPANY_RATE,"
				+ " ICBC_COMPANY_RATE,"
				+ " ICBC_RAISE_CREDIT_RATE,"
				+ " OUTER_BOND_RATE,"
				+ " OUTER_BOND_RATE_SRC,"
				+ " INNER_BOND_RATE,"
				+ " REMART,"
				+ " STATUS,"
				+ " PRODUCT_MANAGER_ID,"
				+ " ISSUER_NAME,"
				+ " D_TRADE_NAME,"
				+ " GUARANTEE_NAME,"
				+ " G_TRADE_NAME,"
				+ " CUSTODIAN_NAME,"
				+ " SUPERINTENDENT_NAME,"
				+ " FINC_CONSULTENT_NAME,"
				+ " OTHER_CORP_NAME,"
				+ " FUND_USAGE,"
				+ " MATURITY_DATE,"
				+ " PUT_VALUE,"
				+ " PUT_DATE,"
				+ " REDEMPTION_VALUE,"
				+ " REDEMPTION_DATE,"
				+ " INT_PAY_TYPE,"
				+ " INT_DESC,"
				+ " PUBLISH_DATE,"
				+ " TRUST_SUB_TYPE,"
				+ " INVEST_INTENTION,"
				+ " TRUST_MANAGER,"
				+ " TRUST_MANAGER_NAME"
				+ ")" 
				+ " values ("
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?"
				+ ")";
			
		int affectedRows = this.jdbcTemplate.update(sql,
													productElement.getProductId(),
													productElement.getProductInnerId(),
													productElement.getProductType(),
													productElement.getNeedCreditRating(),
													productElement.getNeedLawVerify(),
													productElement.getProductName(),
													productElement.getProductBriefName(),
													productElement.getIssuerCode(),
													productElement.getdTradeType(),
													productElement.getMaturityYear(),
													productElement.getIssueScale(),
													productElement.getIsIncludeRight(),
													productElement.getRightType(),
													productElement.getRightDesc(),
													productElement.getPortRatingType(),
													productElement.getPortRating(),
													productElement.getBenchYieldType(),
													productElement.getBenchYieldRatio(),
													productElement.getbenchYieldAdjust(),
													productElement.getInterestMargin(),
													productElement.getPortRatingUpLimit(),
													productElement.getPortRatingLowLimit(),
													productElement.getDepositFee(),
													productElement.getSuperviseFee(),
													productElement.getConsultantFee(),
													productElement.getOtherFee(),
													productElement.getTotalFee(),
													productElement.getNetPortRating(),
													productElement.getnetPortRatingAlgo(),
													productElement.getInterestFrequency(),
													productElement.getListDate(),
													productElement.getRaiseCreditDesc(),
													productElement.getGuarantee(),
													productElement.getgTradeType(),
													productElement.getMortgageRatio(),
													productElement.getCustodian(),
													productElement.getSuperintendent(),
													productElement.getFincConsultent(),
													productElement.getOtherCorp(),
													productElement.getOuterCompanyRate(),
													productElement.getOuterCompanyRateSrc(),
													productElement.getInnerCompanyRate(),
													productElement.getIcbcCompanyRate(),
													productElement.getIcbcRaiseCreditRate(),
													productElement.getOuterBondRate(),
													productElement.getOuterBondRateSrc(),
													productElement.getInnerBondRate(),
													productElement.getRemark(),
													productElement.getStatus(),
													productElement.getProductManagerId(),
													productElement.getIssuerName(),
													productElement.getdTradeName(),
													productElement.getGuaranteeName(),
													productElement.getgTradeName(),
													productElement.getCustodianName(),
													productElement.getSuperintendentName(),
													productElement.getFincConsultentName(),
													productElement.getOtherCorpName(),
													productElement.getFundUsage(),
													productElement.getMaturityDate(),
													productElement.getPutValue(),
													productElement.getPutDate(),
													productElement.getRedemptionValue(),
													productElement.getRedemptionDate(),
													productElement.getIntPayType(),
													productElement.getIntDesc(),
													productElement.getPublishDate(),
													productElement.getTrustSubType(),
													productElement.getInvestIntention(),
													productElement.getTrustManager(),
													productElement.getTrustManagerName()
													);
			
			
		return affectedRows != 0;
	}

	@Override
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ProductElement productElement = (ProductElement) obj;
		
		String sql = "update PIS_PRODUCT_ELEMENT set "
				+ " PRODUCT_INNER_ID  = ?,"
				+ " PRODUCT_TYPE = ?,"
				+ " NEED_CREDIT_RATING = ?,"
				+ " NEED_LAW_VERIFY = ?,"
				+ " PRODUCT_NAME = ?,"
				+ " PRODUCT_BRIEF_NAME = ?,"
				+ " ISSUER_CODE = ?,"
				+ " D_TRADE_TYPE = ?,"
				+ " MATURITY_YEAR = ?,"
				+ " ISSUE_SCALE = ?,"
				+ " IS_INCLUDE_RIGHT = ?,"
				+ " RIGHT_TYPE = ?,"
				+ " RIGHT_DESC = ?,"
				+ " PORT_RATING_TYPE = ?,"
				+ " PORT_RATING = ?,"
				+ " BENCH_YIELD_TYPE = ?,"
				+ " BENCH_YIELD_RATIO = ?,"
				+ " BENCH_YIELD_ADJUST = ?,"
				+ " INTEREST_MARGIN = ?,"
				+ " PORT_RATING_U_LIMIT = ?,"
				+ " PORT_RATING_L_LIMIT = ?,"
				+ " DEPOSIT_FEE = ?,"
				+ " SUPERVISE_FEE = ?,"
				+ " CONSULTANT_FEE = ?,"
				+ " OTHER_FEE = ?,"
				+ " TOTAL_FEE = ?,"
				+ " NET_PORT_RATING = ?,"
				+ " NET_PORT_RATING_ALGO = ?,"
				+ " INTEREST_FREQUENCY = ?,"
				+ " LIST_DATE = ?,"
				+ " RAISE_CREDIT_DESC = ?,"
				+ " GUARANTEE = ?,"
				+ " G_TRADE_TYPE = ?,"
				+ " MORTGAGE_RATIO = ?,"
				+ " CUSTODIAN = ?,"
				+ " SUPERINTENDENT = ?,"
				+ " FINC_CONSULTENT = ?,"
				+ " OTHER_CORP = ?,"
				+ " OUTER_COMPANY_RATE = ?,"
				+ " OUTER_COMPANY_RATE_SRC = ?,"
				+ " INNER_COMPANY_RATE = ?,"
				+ " ICBC_COMPANY_RATE = ?,"
				+ " ICBC_RAISE_CREDIT_RATE = ?,"
				+ " OUTER_BOND_RATE = ?,"
				+ " OUTER_BOND_RATE_SRC = ?,"
				+ " INNER_BOND_RATE = ?,"
				+ " REMART = ?,"
				+ " STATUS = ?,"
				+ " PRODUCT_MANAGER_ID = ?,"
				+ " ISSUER_NAME = ?,"
				+ " D_TRADE_NAME = ?,"
				+ " GUARANTEE_NAME = ?,"
				+ " G_TRADE_NAME = ?,"
				+ " CUSTODIAN_NAME = ?,"
				+ " SUPERINTENDENT_NAME = ?,"
				+ " FINC_CONSULTENT_NAME = ?,"
				+ " OTHER_CORP_NAME = ?,"
				+ " FUND_USAGE = ?,"
				+ " MATURITY_DATE = ?,"
				+ " PUT_VALUE = ?,"
				+ " PUT_DATE = ?,"
				+ " REDEMPTION_VALUE = ?,"
				+ " REDEMPTION_DATE = ?,"
				+ " INT_PAY_TYPE = ?,"
				+ " INT_DESC = ?,"
				+ " PUBLISH_DATE = ?,"
				+ " TRUST_SUB_TYPE = ?,"
				+ " INVEST_INTENTION = ?,"
				+ " TRUST_MANAGER = ?,"
				+ " TRUST_MANAGER_NAME = ?"
				+ " where PRODUCT_ID = ?";;
			
		int affectedRows = this.jdbcTemplate.update(sql,
													productElement.getProductInnerId(),
													productElement.getProductType(),
													productElement.getNeedCreditRating(),
													productElement.getNeedLawVerify(),
													productElement.getProductName(),
													productElement.getProductBriefName(),
													productElement.getIssuerCode(),
													productElement.getdTradeType(),
													productElement.getMaturityYear(),
													productElement.getIssueScale(),
													productElement.getIsIncludeRight(),
													productElement.getRightType(),
													productElement.getRightDesc(),
													productElement.getPortRatingType(),
													productElement.getPortRating(),
													productElement.getBenchYieldType(),
													productElement.getBenchYieldRatio(),
													productElement.getbenchYieldAdjust(),
													productElement.getInterestMargin(),
													productElement.getPortRatingUpLimit(),
													productElement.getPortRatingLowLimit(),
													productElement.getDepositFee(),
													productElement.getSuperviseFee(),
													productElement.getConsultantFee(),
													productElement.getOtherFee(),
													productElement.getTotalFee(),
													productElement.getNetPortRating(),
													productElement.getnetPortRatingAlgo(),
													productElement.getInterestFrequency(),
													productElement.getListDate(),
													productElement.getRaiseCreditDesc(),
													productElement.getGuarantee(),
													productElement.getgTradeType(),
													productElement.getMortgageRatio(),
													productElement.getCustodian(),
													productElement.getSuperintendent(),
													productElement.getFincConsultent(),
													productElement.getOtherCorp(),
													productElement.getOuterCompanyRate(),
													productElement.getOuterCompanyRateSrc(),
													productElement.getInnerCompanyRate(),
													productElement.getIcbcCompanyRate(),
													productElement.getIcbcRaiseCreditRate(),
													productElement.getOuterBondRate(),
													productElement.getOuterBondRateSrc(),
													productElement.getInnerBondRate(),
													productElement.getRemark(),
													productElement.getStatus(),
													productElement.getProductManagerId(),
													productElement.getIssuerName(),
													productElement.getdTradeName(),
													productElement.getGuaranteeName(),
													productElement.getgTradeName(),
													productElement.getCustodianName(),
													productElement.getSuperintendentName(),
													productElement.getFincConsultentName(),
													productElement.getOtherCorpName(),
													productElement.getFundUsage(),
													productElement.getMaturityDate(),
													productElement.getPutValue(),
													productElement.getPutDate(),
													productElement.getRedemptionValue(),
													productElement.getRedemptionDate(),
													productElement.getIntPayType(),
													productElement.getIntDesc(),
													productElement.getPublishDate(),
													productElement.getTrustSubType(),
													productElement.getInvestIntention(),
													productElement.getTrustManager(),
													productElement.getTrustManagerName(),
													productElement.getProductId()
													);
			
			
		return affectedRows != 0;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExists(String id) {
		// TODO Auto-generated method stub
		
		int cnt = this.jdbcTemplate.queryForObject("select count(*) from PIS_PRODUCT_ELEMENT where PRODUCT_ID = ?",new Object[] {id}, Integer.class);
		
		return cnt > 0 ? true : false;
		
	}

	@Override
	public List<ProductElement> getProductListByCond(Map<String, String[]> filterMap) {
		// TODO Auto-generated method stub
		
		Integer iStart = 1;
		
		String number = "10";
		
		if(!StringUtil.isNullOrEmpty(StringUtil.getFirst(filterMap.get("start"))))
		{
			iStart = Integer.parseInt(StringUtil.getFirst(filterMap.get("start"))) + 1;
		}

		if(!StringUtil.isNullOrEmpty(StringUtil.getFirst(filterMap.get("number"))))
		{
			number = StringUtil.getFirst(filterMap.get("number"));
		}
		
		Integer iEnd = iStart + Integer.parseInt(number) - 1;
		
		String end = iEnd.toString();
		
		String start = iStart.toString();
		
		String productId = StringUtil.getFirst(filterMap.get("productId")) ;
		
		String productType = StringUtil.getFirst(filterMap.get("productType"));
		
		String productName = StringUtil.getFirst(filterMap.get("productName"));
		
		String productManagerId = StringUtil.getFirst(filterMap.get("productManagerId"));
		
		if(StringUtil.isNullOrEmpty(productId))
		{
			productId = null;
		}
		
		if(StringUtil.isNullOrEmpty(productType))
		{
			productType = null;
		}
		
		if(StringUtil.isNullOrEmpty(productName))
		{
			productName = null;
		}
		
		if(StringUtil.isNullOrEmpty(productManagerId))
		{
			productManagerId = null;
		}
		
		String sql = " select p.PRODUCT_ID,p.PRODUCT_NAME,p.PRODUCT_TYPE,p.ISSUER_NAME,p.MATURITY_YEAR,p.ISSUE_SCALE,p.IS_INCLUDE_RIGHT,p.RIGHT_TYPE" +
				 " from (select ROW_NUMBER() OVER(ORDER BY t.PRODUCT_ID) ROW_NUM,"
				 		+ "t.PRODUCT_ID,"
				 		+ "t.PRODUCT_NAME,"
				 		+ "t.PRODUCT_TYPE,"
				 		+ "t.ISSUER_NAME,"
				 		+ "t.MATURITY_YEAR,"
				 		+ "t.ISSUE_SCALE,"
				 		+ "t.IS_INCLUDE_RIGHT,"
				 		+ "t.RIGHT_TYPE " +
						" from PIS_PRODUCT_ELEMENT t " +
						" where t.STATUS = 1 " +
						" and ( ? is null or t.PRODUCT_NAME like ?) " +
						" and ( ? is null or t.PRODUCT_ID = ?) " +
						" and ( ? is null or t.PRODUCT_TYPE = ?) " +
						" and ( ? is null or t.PRODUCT_MANAGER_ID = ?) " +
				 ") p WHERE P.ROW_NUM between ? AND ? ";
		
		List<ProductElement> productList = this.jdbcTemplate.query(sql ,new Object[] {productName,StringUtil.likeWrap(productName),productId,productId,productType,productType,productManagerId,productManagerId,start,end}, new ProductElementPartMapper() );
		
		return productList;
	}

	@Override
	public ProductElement getProductById(String productId) {
		// TODO Auto-generated method stub
		
		String sql = " select * from PIS_PRODUCT_ELEMENT WHERE PRODUCT_ID = ? ";
		
		ProductElement roductElement = this.jdbcTemplate.queryForObject(sql ,new Object[] { productId }, new ProductElementPartMapper() );
		
		return roductElement;
	}

	@Override
	public int count(Map<String, String[]> filterMap) {
		// TODO Auto-generated method stub
		
		String productId = StringUtil.getFirst(filterMap.get("productId")) ;
		
		String productType = StringUtil.getFirst(filterMap.get("productType"));
		
		String productName = StringUtil.getFirst(filterMap.get("productName"));
		
		String productManagerId = StringUtil.getFirst(filterMap.get("productManagerId"));
		
		String sql = "select count(1) " +
					" from PIS_PRODUCT_ELEMENT t " +
					" where STATUS = 1 " +
					" and ( ? is null or t.PRODUCT_NAME like ?) " +
					" and ( ? is null or t.PRODUCT_ID = ?) " +
					" and ( ? is null or t.PRODUCT_TYPE = ?) " +
					" and ( ? is null or t.PRODUCT_MANAGER_ID = ?) ";
		
		int cnt = this.jdbcTemplate.queryForObject(sql,
				 								   new Object[] {productName,StringUtil.likeWrap(productName),productId,productId,productType,productType,productManagerId,productManagerId},
				 								   Integer.class);
		
		return cnt;
	}

	@Override
	public boolean updateVerifyFlag(ProductVerifyFlag productVerifyFlag) {
		// TODO Auto-generated method stub
		String sql = "update PIS_PRODUCT_ELEMENT set "
				+ " NEED_CREDIT_RATING = ?,"
				+ " NEED_LAW_VERIFY = ? "
				+ " where PRODUCT_ID = ?";
		
		int affectedRows = this.jdbcTemplate.update(sql,productVerifyFlag.getIsNeedCreditVerify(),
														productVerifyFlag.getIsNeedLawVerify(),
														productVerifyFlag.getProductId());
		
		return affectedRows > 0 ? true : false;
	}

}
