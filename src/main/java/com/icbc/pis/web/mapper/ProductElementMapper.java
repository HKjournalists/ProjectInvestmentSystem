package com.icbc.pis.web.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.icbc.pis.web.model.ProductElement;

 

public class ProductElementMapper implements RowMapper<ProductElement>{

	@Override
	public ProductElement mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		// TODO Auto-generated method stub
		ProductElement u = new ProductElement(
				rs.getString("PRODUCT_ID"),
				rs.getString("PRODUCT_INNER_ID"),
				rs.getString("PRODUCT_TYPE"),
				rs.getString("NEED_CREDIT_RATING"),
				rs.getString("NEED_LAW_VERIFY"),
				rs.getString("PRODUCT_NAME"),
				rs.getString("PRODUCT_BRIEF_NAME"),
				rs.getString("ISSUER_CODE"),
				rs.getString("TRUST_MANAGER"),
				rs.getString("D_TRADE_TYPE"),
				rs.getInt("MATURITY_YEAR"),
				rs.getDouble("ISSUE_SCALE"),
				rs.getString("IS_INCLUDE_RIGHT"),
				rs.getString("RIGHT_TYPE"),
				rs.getString("RIGHT_DESC"),
				rs.getString("PORT_RATING_TYPE"),
				rs.getDouble("PORT_RATING"),
				rs.getString("BENCH_YIELD_TYPE"),
				rs.getDouble("BENCH_YIELD_RATIO"),
				rs.getString("BENCH_YIELD_ADJUST"),
				rs.getDouble("INTEREST_MARGIN"),
				rs.getDouble("PROT_RATING_U_LIMIT"),
				rs.getDouble("PROT_RATING_L_LIMIT"),
				rs.getDouble("DEPOSIT_FEE"),
				rs.getDouble("SUPERVISE_FEE"),
				rs.getDouble("CONSULTANT_FEE"),
				rs.getDouble("OTHER_FEE"),
				rs.getDouble("TOTAL_FEE"),
				rs.getDouble("NET_PROT_RATING"),
				rs.getString("NET_PORT_RATING_ALGO"),
				rs.getString("INTEREST_FREQUENCY"),
				rs.getString("LIST_DATE"),
				rs.getString("RAISE_CREDIT_DESC"),
				rs.getString("GUARANTEE"),
				rs.getString("G_TRADE_TYPE"),
				rs.getDouble("MORTGAGE_RATIO"),
				rs.getString("CUSTODIAN"),
				rs.getString("SUPERINTENDENT"),
				rs.getString("FINC_CONSULTENT"),
				rs.getString("OTHER_CORP"),
				rs.getString("OUTER_COMPANY_RATE"),
				rs.getString("OUTER_COMPANY_RATE_SRC"),
				rs.getString("INNER_COMPANY_RATE"),
				rs.getString("ICBC_COMPANY_RATE"),
				rs.getString("ICBC_RAISE_CREDIT_RATE"),
				rs.getString("OUTER_BOND_RATE"),
				rs.getString("OUTER_BOND_RATE_SRC"),
				rs.getString("INNER_BOND_RATE"),
				rs.getString("REMART"),
				rs.getString("STATUS"),
				rs.getString("PRODUCT_MANAGER_ID"),
				rs.getString("TRUST_MANAGER_NAME"),
				rs.getString("D_TRADE_NAME"),
				rs.getString("GUARANTEE_NAME"),
				rs.getString("ISSUER_NAME"),
				rs.getString("G_TRADE_NAME"),
				rs.getString("CUSTODIAN_NAME"),
				rs.getString("SUPERINTENDENT_NAME"),
				rs.getString("FINC_CONSULTENT_NAME"),
				rs.getString("OTHER_CORP_NAME"),
				rs.getString("FUND_USAGE"),
				rs.getString("MATURITY_DATE"),
				rs.getDouble("PUT_VALUE"),
				rs.getString("PUT_DATE"),
				rs.getDouble("REDEMPTION_VALUE"),
				rs.getString("REDEMPTION_DATE"),
				rs.getString("INT_PAY_TYPE"),
				rs.getString("INT_DESC"),
				rs.getString("PUBLISH_DATE"),
				rs.getString("TRUST_SUB_TYPE"),
				rs.getString("INVEST_INTENTION")
				);
		return u;
	}

}
