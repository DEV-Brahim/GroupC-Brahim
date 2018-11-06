package org.mql.platform.models.preregistration;

/* Candidates diplomas marks*/
public class Mark {

	private String semester;
	private double value;

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Mark(String semester, double value) {
		super();
		this.semester = semester;
		this.value = value;
	}

	public String toString() {
		return "Degree [semester=" + semester + ", value=" + value + "]";
	}

	public Mark() {
		// TODO Auto-generated constructor stub
	}

	public String toXml() {
		return "<mark>" + 
					"<semester>" + getSemester() + "</semester>" + 
					"<value>" + getValue() + "</value>" + 
				"</mark>";
	}

}
