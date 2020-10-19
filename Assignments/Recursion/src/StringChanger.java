public class StringChanger {
  public static String removeCharacter(String str, char character) {
    if(str.length() == 0)
      return str;
    else if(str.charAt(0) == character)
      return removeCharacter(str.substring(1), character);
    else
      return str.charAt(0) + removeCharacter(str.substring(1), character);
  }
}