package fr.epita.exams.datamodel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;

public class Competitor {
    @JsonProperty("family_name")
    private String familyName;
    @JsonProperty("given_name")
    private String givenName;
    private String gender;
    private String country;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthDate;
    private int height;
    private String belt;
    private List<String> categories;

    @JsonCreator
    public Competitor(
            @JsonProperty("family_name") String familyName,
            @JsonProperty("given_name") String givenName,
            @JsonProperty("gender") String gender,
            @JsonProperty("country") String country,
            @JsonProperty("birthDate") Date birthDate,
            @JsonProperty("height") int height,
            @JsonProperty("belt") String belt,
            @JsonProperty("categories") List<String> categories) {
        this.familyName = familyName;
        this.givenName = givenName;
        this.gender = gender;
        this.country = country;
        this.birthDate = birthDate;
        this.height = height;
        this.belt = belt;
        this.categories = categories;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getBelt() {
        return belt;
    }

    public void setBelt(String belt) {
        this.belt = belt;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
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
