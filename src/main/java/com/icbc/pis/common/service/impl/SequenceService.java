package com.icbc.pis.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icbc.pis.common.dao.impl.SequenceDao;
import com.icbc.pis.common.service.ISequenceService;

@Service("SequenceService")
public class SequenceService implements ISequenceService {

	@Autowired
	private SequenceDao sequenceDao;
	
	@Override
	public int GetNextIntValue(String seqName) {
		// TODO Auto-generated method stub
		return this.sequenceDao.GetNextIntValue(seqName);
	}

}
