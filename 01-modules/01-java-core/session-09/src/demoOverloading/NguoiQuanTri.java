package demoOverloading;

public class NguoiQuanTri extends NguoiDung {
    private String key;

    public NguoiQuanTri() {
    }

    public NguoiQuanTri(String username, String password, String key) {
        super(username, password);
        this.key = key;
    }

    @Override
    public void login() {
        System.out.println("[ADMIN] - Login success");
    }

    public void blockUser(String username){
        System.out.println("Block user: " + username);
    }

    public void blockUser(int userId){
        System.out.println("Block user: " + userId);
    }
}
