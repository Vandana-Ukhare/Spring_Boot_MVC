package com.vandu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vandu.entity.Crickter;
import com.vandu.repository.ICrickterRepo;

@Service("service")
public class CrickterMgmtImpl implements ICrickterMgmtService {
	@Autowired
	private ICrickterRepo repo;

	@Override
	public String registerCrickter(Crickter ckt) {
		System.out.println("CrickterMgmtImpl.regiSterCrickter()");
		return "registered with id:: "+repo.save(ckt).getCname();
	}

	
}
