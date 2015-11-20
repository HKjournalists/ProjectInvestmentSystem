package com.icbc.pis.web.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import com.icbc.pis.web.model.ProductElement;

 

public class ProductElementMapper implements RowMapper<ProductElement>{

	@Override
	public ProductElement mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Map<String,String> retMap = new HashMap<String,String>();
		
		retMap.put("productId", rs.getString("PRODUCT_ID"));
		retMap.put("productInnerId", rs.getString("PRODUCT_INNER_ID"));
		retMap.put("productType", rs.getString("PRODUCT_TYPE"));
		retMap.put("needCreditRating", rs.getString("NEED_CREDIT_RATING"));
		retMap.put("needLawVerify", rs.getString("NEED_LAW_VERIFY"));
		retMap.put("productName", rs.getString("PRODUCT_NAME"));
		retMap.put("productBriefName", rs.getString("PRODUCT_BRIEF_NAME"));
		retMap.put("issureCode", rs.getString("ISSUER_CODE"));
		retMap.put("dTradeType", rs.getString("D_TRADE_TYPE"));
		retMap.put("maturityYear", rs.getString("MATURITY_YEAR"));
		retMap.put("issueScale", rs.getString("ISSUE_SCALE"));
		retMap.put("isIncludeRight", rs.getString("IS_INCLUDE_RIGHT"));
		retMap.put("rightType", rs.getString("RIGHT_TYPE"));
		retMap.put("rightDesc", rs.getString("RIGHT_DESC"));
		retMap.put("portRatingType", rs.getString("PORT_RATING_TYPE"));
		retMap.put("portRating", rs.getString("PORT_RATING"));
		retMap.put("benchYieldType", rs.getString("BENCH_YIELD_TYPE"));
		retMap.put("benchYieldRatio", rs.getString("BENCH_YIELD_RATIO"));
		retMap.put("benchYieldAdjust", rs.getString("BENCH_YIELD_ADJUST"));
		retMap.put("interestMargin", rs.getString("INTEREST_MARGIN"));
		retMap.put("portRatingUpLimit", rs.getString("PROT_RATING_U_LIMIT"));
		retMap.put("portRatingLowLimit", rs.getString("PROT_RATING_L_LIMIT"));
		retMap.put("depositFee", rs.getString("DEPOSIT_FEE"));
		retMap.put("superviseFee", rs.getString("SUPERVISE_FEE"));
		retMap.put("consultantFee", rs.getString("CONSULTANT_FEE"));
		retMap.put("otherFee", rs.getString("OTHER_FEE"));
		retMap.put("totalFee", rs.getString("TOTAL_FEE"));
		retMap.put("netPortRating", rs.getString("NET_PROT_RATING"));
		retMap.put("netPortRatingAlgo", rs.getString("NET_PORT_RATING_ALGO"));
		retMap.put("interestFrequency", rs.getString("INTEREST_FREQUENCY"));
		retMap.put("listDate", rs.getString("LIST_DATE"));
		retMap.put("raiseCreditDesc", rs.getString("RAISE_CREDIT_DESC"));
		retMap.put("guarantee", rs.getString("GUARANTEE"));
		retMap.put("gTradeType", rs.getString("G_TRADE_TYPE"));
		retMap.put("mortgageRatio", rs.getString("MORTGAGE_RATIO"));
		retMap.put("custodian", rs.getString("CUSTODIAN"));
		retMap.put("superintendent", rs.getString("SUPERINTENDENT"));
		retMap.put("fincConsultent", rs.getString("FINC_CONSULTENT"));
		retMap.put("otherCorp", rs.getString("OTHER_CORP"));
		retMap.put("outerCompanyRate", rs.getString("OUTER_COMPANY_RATE"));
		retMap.put("outerCompanyRateSrc", rs.getString("OUTER_COMPANY_RATE_SRC"));
		retMap.put("innerCompanyRate", rs.getString("INNER_COMPANY_RATE"));
		retMap.put("icbcCompanyRate", rs.getString("ICBC_COMPANY_RATE"));
		retMap.put("icbcRaiseCreditRate", rs.getString("ICBC_RAISE_CREDIT_RATE"));
		retMap.put("outerBondRate", rs.getString("OUTER_BOND_RATE"));
		retMap.put("outerBondRateSrc", rs.getString("OUTER_BOND_RATE_SRC"));
		retMap.put("innerBondRate", rs.getString("INNER_BOND_RATE"));
		retMap.put("remark", rs.getString("REMART"));
		retMap.put("status", rs.getString("STATUS"));
		retMap.put("productManagerId", rs.getString("PRODUCT_MANAGER_ID"));
		retMap.put("issuerName", rs.getString("ISSUER_NAME"));
		retMap.put("dTradeName", rs.getString("D_TRADE_NAME"));
		retMap.put("guaranteeName", rs.getString("GUARANTEE_NAME"));
		retMap.put("gTradeName", rs.getString("G_TRADE_NAME"));
		retMap.put("custodianName", rs.getString("CUSTODIAN_NAME"));
		retMap.put("superintendentName", rs.getString("SUPERINTENDENT_NAME"));
		retMap.put("fincConsultentName", rs.getString("FINC_CONSULTENT_NAME"));
		retMap.put("otherCorpName", rs.getString("OTHER_CORP_NAME"));
		retMap.put("fundUsage", rs.getString("FUND_USAGE"));
		retMap.put("maturityDate", rs.getString("MATURITY_DATE"));
		retMap.put("putValue", rs.getString("PUT_VALUE"));
		retMap.put("putDate", rs.getString("PUT_DATE"));
		retMap.put("redemptionValue", rs.getString("REDEMPTION_VALUE"));
		retMap.put("redemptionDate", rs.getString("REDEMPTION_DATE"));
		retMap.put("intPayType", rs.getString("INT_PAY_TYPE"));
		retMap.put("intDesc", rs.getString("INT_DESC"));
		retMap.put("publishDate", rs.getString("PUBLISH_DATE"));
		retMap.put("trustSubType", rs.getString("TRUST_SUB_TYPE"));
		retMap.put("investIntention", rs.getString("INVEST_INTENTION"));
		retMap.put("trustManager", rs.getString("TRUST_MANAGER"));
		retMap.put("trustManagerName", rs.getString("TRUST_MANAGER_NAME"));

		
		ProductElement u = new ProductElement(retMap);

		return u;
	}

}
