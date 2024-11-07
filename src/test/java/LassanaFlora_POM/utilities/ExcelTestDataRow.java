package LassanaFlora_POM.utilities;

public class ExcelTestDataRow {
    private String username;
    private String password;

    public ExcelTestDataRow(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
