package com.icbc.pis.common.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.icbc.pis.common.dao.ISequenceDao;
import com.icbc.pis.sequence.SequenceGenerator;

@Repository("SequenceDao")
public class SequenceDao implements ISequenceDao {

	private static final Logger logger = LoggerFactory.getLogger(DictDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int GetNextIntValue(String seqName) {
		// TODO Auto-generated method stub
		return SequenceGenerator.GetInstance(this.jdbcTemplate.getDataSource()).GetNextIntValue(seqName);
	}

}
