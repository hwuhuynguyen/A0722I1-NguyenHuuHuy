package codegym.vn.springboot.form;

import codegym.vn.springboot.entity.ClassName;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

public class StudentForm {
    private String id;
    private String name;
    private ClassName className;
    private String email;
    private boolean sex;
    private String phoneNumber;
    private Date birthdate;
    private String classId;

    public StudentForm() {
    }

    public StudentForm(String id, String name, ClassName className, String email, boolean sex, String phoneNumber, Date birthdate, String classId) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.email = email;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.birthdate = birthdate;
        this.classId = classId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClassName getClassName() {
        return className;
    }

    public void setClassName(ClassName className) {
        this.className = className;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }
}
