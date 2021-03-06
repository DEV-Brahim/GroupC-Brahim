package org.mql.platform.business.impl;

import org.mql.platform.business.LaureateService;
import org.mql.platform.dao.CurriculumRepository;
import org.mql.platform.models.Curriculum;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultLaureateService implements LaureateService {
	@Autowired
	private CurriculumRepository curriculumRepository;
	
	public Curriculum getCurriculum(Integer id) {
		return curriculumRepository.getOne(id);
	}

}
