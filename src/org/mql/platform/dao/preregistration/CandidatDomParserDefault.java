package org.mql.platform.dao.preregistration;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;
import org.mql.platform.models.preregistration.*;
import org.mql.platform.tools.preregistration.XMLNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;

/*
 *  DOM parser with :
 *  add method for adding a new candidate to the xml file
 *  update method for updating and saving candidate to the xml file
 */
public class CandidatDomParserDefault implements CandidatDomParser {

	private List<Candidat> candidates;
	@Autowired
	private ConfigurableEnvironment conf; /*to configure*/
	private String path;

	public CandidatDomParserDefault() {
		loadData();
	}

	public void addCandidat(Candidat candidat) {
		boolean exists = false;
		for (Candidat cand : candidates) {
			exists = (candidat.getCin().equals(cand.getCin()) ? true : false);
		}
		if (!exists) {
			candidates.add(candidat);
			saveCandidats();
		}

	}

	public boolean updateCandidat(Candidat can) {
		for (Candidat candidat : candidates) {
			if (candidat.getCin().equals(can.getCin())) {
				candidates.remove(candidat);
				candidates.add(can);
				saveCandidats();
				return true;
			}
		}
		return false;
	}
	
	
	
	private List<Candidat> loadData() {
		candidates = new Vector<>();
		XMLNode root = new XMLNode(path);
		Vector<XMLNode> list = root.getChildren();
		for (XMLNode a : list) {
			Candidat candidat = new Candidat();
			candidates.add(candidat);
			candidat.setCin(a.getChild("cin").getValue());
			candidat.setCne(a.getChild("cne").getIntValue());
			candidat.setLastName(a.getChild("lastName").getValue());
			candidat.setFirstName(a.getChild("firstName").getValue());
			candidat.setAge(a.getChild("age").getIntValue());
			candidat.setSituation(a.getChild("situation").getValue());
			candidat.setCity(a.getChild("city").getValue());
			candidat.setGender(a.getChild("gender").getValue());
			candidat.setHandicap(a.getChild("gender").getBooleanValue());
			/*****************/
			XMLNode dips = a.getChild("diplomas");
			Vector<XMLNode> listDip = dips.getChildren();

			Vector<Diploma> diplomas = new Vector<>();
			for (XMLNode b : listDip) {
				Diploma diploma = new Diploma();
				diplomas.add(diploma);

				diploma.setTitle(b.getChild("title").getValue());
				diploma.setUnivercity(b.getChild("univercity").getValue());
				diploma.setCollege(b.getChild("college").getValue());
				diploma.setSpeciality(b.getChild("speciality").getValue());
				diploma.setDistrict(b.getChild("district").getValue());
				diploma.setYear(b.getIntAttribute("year"));
				diploma.setCoef(b.getIntAttribute("coef"));
				diploma.setMention(b.getChild("mention").getValue());
				diploma.setGrade(b.getChild("grade").getDoubleValue());
				diploma.setCity(b.getChild("city").getValue());
				/*******************/
				XMLNode markks = b.getChild("marks");
				Vector<XMLNode> listMark = markks.getChildren();

				Vector<Mark> marks = new Vector<>();
				for (XMLNode c : listMark) {
					Mark mark = new Mark();
					marks.add(mark);

					mark.setSemester(c.getChild("semester").getValue());
					mark.setValue(c.getChild("value").getDoubleValue());
				}
				diploma.setMarks(marks);
			}
			candidat.setDiplomas(diplomas);
		}
		return candidates;
	}

	private void saveCandidats() {
		StringBuffer xml = new StringBuffer("<candidats>");
		for (Candidat candidat : candidates) {
			xml.append(candidat.toXml());
		}
		xml.append("</candidats>");
		File file = new File(path);
		try {
			if (!file.exists())
				file.createNewFile();
			PrintWriter writer = new PrintWriter(file);
			writer.print(xml.toString());
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
