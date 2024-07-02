public class ValidatMe {
    private String content;

    public ValidatMe(String value) {
        content = value;
    }
    public ValidatMe() {
        content = "";
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public boolean isEmail(String value){
        setContent(value);
        return isEmail();
    }
    public boolean isEmail() {
        String[] arrStr = content.split("@"); // ex "zakria.zekri@gamil.com"
        if (arrStr.length != 2) {
            return false;
        }
        if (!arrStr[1].contains(".")) {
            return false;
        }
        return true;
    }
    public boolean isName(String value){
        setContent(value);
        return isName();
    }
    public boolean isName() {
        for (char ch : content.toCharArray()) {
            if (Character.isDigit(ch)) {
                System.out.println(ch);
                return false;
            }
        }
        return true;
    }
    
    public boolean isPhone(String value){
        setContent(value);
        return isPhone();
    }
    public boolean isPhone() {
        for (char c : content.toCharArray()) {
            if (!Character.isDigit(c) && c != '-' && c != '+' && c != ' ' && c != '(' && c != ')') {
                return false;
            }
        }
        return true;
    }
}
