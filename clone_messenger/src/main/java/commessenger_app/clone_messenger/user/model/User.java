package commessenger_app.clone_messenger.user.model;

import commessenger_app.clone_messenger.message.model.Message;
import commessenger_app.clone_messenger.relationshipuser.model.RelationshipUser;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")

public class User {
    @Id
    private String id;

    @OneToMany(mappedBy="userRelationshipUser")
    private Set<RelationshipUser> relationshipUser;

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column
    private Date birthday;

    @Column(length = 5)
    private String sex;

    @Column(length = 50)
    private String email;

    @Column(length = 10)
    private String phone;

    @Column(length = 100)
    private String password;

    @Column
    private String avatar;

    @Column
    private int darkMode;

    @Column
    private int typeAccoount;

    @Column
    private Timestamp dateCreated;


    public int getDarkMode() {
        return darkMode;
    }

    public void setDarkMode(int darkMode) {
        this.darkMode = darkMode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = format.parse(birthday);
        this.birthday = parsed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getTypeAccoount() {
        return typeAccoount;
    }

    public void setTypeAccoount(int typeAccoount) {
        this.typeAccoount = typeAccoount;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }
}
