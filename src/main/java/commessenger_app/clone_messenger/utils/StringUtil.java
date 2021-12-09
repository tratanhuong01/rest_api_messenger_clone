package commessenger_app.clone_messenger.utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
  public static String gereralID(String table, String id) {
    String idNew = "";
    switch (table) {
      case "users":
        if (id == null) {
          idNew = "1000000000";
        } else {
          int idNewInt = Integer.parseInt(id);
          idNewInt++;
          idNew = String.valueOf(idNewInt);
        }
        return idNew;
      case "messages":
        if (id == null) {
          idNew = "300000000";
        } else {
          int idNewInt = Integer.parseInt(id);
          idNewInt++;
          idNew = String.valueOf(idNewInt);
        }
        return idNew;
      case "groupMessage":
        if (id == null) {
          idNew = "2000000000";
        } else {
          int idNewInt = Integer.parseInt(id);
          idNewInt++;
          idNew = String.valueOf(idNewInt);
        }
        return idNew;
    }
    return idNew;
  }

  public static Boolean regexEmail(String email) {
    String regex = "^(.+)@(.+)$";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(email);

    if (matcher.matches())
      return true;
    return false;
  }

  public static Boolean regexPhone(String phone) {
    Pattern p = Pattern.compile("^[0-9]{10}$");
    Pattern p1 = Pattern.compile("^[0-9]{3}-[0-9]{3}-[0-9]{4}$");
    Pattern p2 = Pattern.compile("^[0-9]{3}.[0-9]{3}.[0-9]{4}$");
    Pattern p3 = Pattern.compile("^[0-9]{3} [0-9]{3} [0-9]{4}$");
    Pattern p4 = Pattern.compile("^[0-9]{3}-[0-9]{3}-[0-9]{4} (x|ext)[0-9]{4}$");
    Pattern p5 = Pattern.compile("^\\([0-9]{3}\\)-[0-9]{3}-[0-9]{4}$");
    if (p.matcher(phone).find() || p1.matcher(phone).find() || p2.matcher(phone).find()
        || p3.matcher(phone).find() || p4.matcher(phone).find() || p5.matcher(phone).find()) {
      return true;
    }
    return false;
  }

  public static int ramdomNumber(int from, int to) {
    Random random = new Random();
    return Math.abs(random.nextInt(to - from + 1) - from);
  }
}
