package ge.ibsu.demo.dto;

public class DepartmentInfoDTO {
    private String departmentName;
    private String managerFullName;
    private String countryName;
    private String city;
    private String streetAddress;

    public DepartmentInfoDTO(String departmentName, String firstName, String lastName,
                             String countryName, String city, String streetAddress) {
        this.departmentName = departmentName;
        this.managerFullName = (firstName != null && lastName != null) ? firstName + " " + lastName : "No Manager";
        this.countryName = countryName;
        this.city = city;
        this.streetAddress = streetAddress;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getManagerFullName() {
        return managerFullName;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCity() {
        return city;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setManagerFullName(String managerFullName) {
        this.managerFullName = managerFullName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
}