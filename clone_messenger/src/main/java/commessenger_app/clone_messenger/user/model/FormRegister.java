package commessenger_app.clone_messenger.user.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormRegister {
    private String firstName;
    private String lastName;
    private String emailOrPhone;
    private String emailAgain;
    private Date birthday;
    private String sex;
    private String password;

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

    public String getEmailOrPhone() {
        return emailOrPhone;
    }

    public void setEmailOrPhone(String emailOrPhone) {
        this.emailOrPhone = emailOrPhone;
    }

    public String getEmailAgain() {
        return emailAgain;
    }

    public void setEmailAgain(String emailAgain) {
        this.emailAgain = emailAgain;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
