package io.orangehealth.bvac.domain;

/**
 * Enumeration of Vaccines
 * 
 * @author Rafael Rodrigues
 */

public enum Vaccine {
	Pfizer_BioNTech("Pfizer–BioNTech"), Moderna("Moderna"), Oxford_AstraZeneca("Oxford–AstraZeneca"),
	Sputnik_V("Sputnik V"), Johnson_n_Johnson("Johnson & Johnson"), Convidicea("Convidicea"), BBIBP_CorV("BBIBP-CorV"),
	CoronaVac("CoronaVac"), Covaxin("Covaxin"), CoviVac("CoviVac"), EpiVacCorona("EpiVacCorona"),
	RBD_Dimer("RBD-Dimer"),;

	private String name;

	Vaccine(String name) {
		this.name = name;
	}

	public static Vaccine findByVaccineName(String vaccineName) {
		for (Vaccine vaccine : Vaccine.values()) {
			if (vaccine.name.equalsIgnoreCase(vaccineName))
				return vaccine;
		}
		return null;
	}

	public String getName() {
		return name;
	}
}
