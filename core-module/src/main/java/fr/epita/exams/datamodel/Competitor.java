package fr.epita.exams.datamodel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "competitors")
public class Competitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "family_name")
    @JsonProperty("family_name")
    private String familyName;

    @Column(name = "given_name")
    @JsonProperty("given_name")
    private String givenName;

    @Transient // This indicates that the field should not be stored in the database.
    @JsonIgnore
    private String middleName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "country")
    private String country;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthDate;

    @Column(name = "height")
    private int height;

    @Column(name = "belt")
    private String belt;

    // Assume Categories are a set of category names, stored as a comma-separated string in the database
    @Column(name = "categories")
    private String categories;

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
        this.setCategories(categories); // Use setter to handle list to string conversion if necessary
    }

    // Default constructor for JPA
    public Competitor() {}



    public void setCategories(List<String> categories) {
        this.categories = String.join(",", categories); // Convert List to comma-separated String for storage
    }

    public List<String> getCategories() {
        return List.of(categories.split(",")); // Convert back from String to List
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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

    @Override
    public String toString() {
        return "Competitor{" +
                "id=" + id +
                ", familyName='" + familyName + '\'' +
                ", givenName='" + givenName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", gender='" + gender + '\'' +
                ", country='" + country + '\'' +
                ", birthDate=" + birthDate +
                ", height=" + height +
                ", belt='" + belt + '\'' +
                ", categories='" + categories + '\'' +
                '}';
    }
}
