package org.mql.platform.dao.preregistration;


import org.mql.platform.models.preregistration.Candidat;

public interface CandidatDomParser {
	public void addCandidat(Candidat candidat);
	public boolean updateCandidat(Candidat candidat);
}
