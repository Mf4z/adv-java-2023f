package epita.fr.exams.datamodel;

import java.util.Date;
import java.util.List;

public class Competitor {
    private String familyName;
    private String givenName;
    private String gender;
    private String country;
    private Date birthDate;
    private int height;
    private String belt;
    private List<String> categories;

    public Competitor(String familyName, String givenName, String gender, String country, Date birthDate, int height, String belt, List<String> categories) {
        this.familyName = familyName;
        this.givenName = givenName;
        this.gender = gender;
        this.country = country;
        this.birthDate = birthDate;
        this.height = height;
        this.belt = belt;
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Competitor{" +
                "familyName='" + familyName + '\'' +
                ", givenName='" + givenName + '\'' +
                ", gender='" + gender + '\'' +
                ", country='" + country + '\'' +
                ", birthDate=" + birthDate +
                ", height=" + height +
                ", belt='" + belt + '\'' +
                ", categories=" + categories +
                '}';
    }
}