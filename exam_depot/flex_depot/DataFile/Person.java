package flex_depot.DataFile;

public class Person {
    private String firstNameOfPerson;
    private String positionOfPerson;
    private String companyOfPerson;

    public Person(String firstNameOfPerson, String positionOfPerson, String companyOfPerson) {
        this.firstNameOfPerson = firstNameOfPerson;
        this.positionOfPerson = positionOfPerson;
        this.companyOfPerson = companyOfPerson;
    }

    public String getFirstNameOfPerson() {
        return firstNameOfPerson;
    }

    public void setFirstNameOfPerson(String firstNameOfPerson) {
        this.firstNameOfPerson = firstNameOfPerson;
    }

    public String getPositionOfPerson() {
        return positionOfPerson;
    }

    public void setPositionOfPerson(String positionOfPerson) {
        this.positionOfPerson = positionOfPerson;
    }

    public String getCompanyOfPerson() {
        return companyOfPerson;
    }

    public void setCompanyOfPerson(String companyOfPerson) {
        this.companyOfPerson = companyOfPerson;
    }
}
