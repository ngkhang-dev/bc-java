package demoOverloading;

// Khi dùng final cho class, chặn việc kế thừa
// public final class NguoiDung {}
public class NguoiDung {
    // final property: chặn việc gán lại ở các class con kế thừa
    protected final String role = "System";

    protected String username;
    protected String password;

    public NguoiDung() {
    }

    public NguoiDung(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void login(){
        System.out.println( "[USER] - Login success");
    }

    // final với method: chặn override khi class con kế thừa
    public final void getRole(){
        System.out.println("Role: User");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
