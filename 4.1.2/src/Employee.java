public class Employee {
    private String name;
    private String surname;
    private Integer age;
    private String sex;
    private String education;
    private String position;
    private String department;


    public Employee(String name, String surname, Integer age, String sex, String education, String position, String department) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
        this.education = education;
        this.position = position;
        this.department = department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getEducation() {
        return education;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return surname + "\t" +
                name + "\t" +
                age + "\t" +
                sex + "\t" +
                education + "\t" +
                position + "\t" +
                department;
    }
}
