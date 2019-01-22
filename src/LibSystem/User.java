package LibSystem;

import java.util.Objects;

public class User {
    private String name;
    private String psw;
    private String id;
    private String rank;
    private int credits;

    public User() {
    }

    public User(String name, String psw) {
        this.name = name;
        this.psw = psw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", psw='" + psw + '\'' +
                ", id='" + id + '\'' +
                ", rank='" + rank + '\'' +
                ", credits=" + credits +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return credits == user.credits &&
                Objects.equals(name, user.name) &&
                Objects.equals(psw, user.psw) &&
                Objects.equals(id, user.id) &&
                Objects.equals(rank, user.rank);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, psw, id, rank, credits);
    }
}
