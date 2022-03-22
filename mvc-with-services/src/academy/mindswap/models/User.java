package academy.mindswap.models;

public class User {

    private String username;
    private int id;
    private String email;
    private String password;

    public User(String username, int id, String email, String password) {
        this.username = username;
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
