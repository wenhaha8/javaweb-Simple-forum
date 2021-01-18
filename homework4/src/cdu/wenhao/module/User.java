package cdu.wenhao.module;

import java.io.Serializable;

public class User implements Serializable {
    protected int userId;
    protected String userName;
    protected String nickname;
    protected String pwd;
    private String gender;
    private String hobby;
    private String headSculpture;
    private String reg_time;
    private int totalPrisedNum;
    private int totalNewsNum;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getReg_time() {
        return reg_time;
    }

    public void setReg_time(String reg_time) {
        this.reg_time = reg_time;
    }

    public String getHeadSculpture() {
        return headSculpture;
    }

    public void setHeadSculpture(String headSculpture) {
        this.headSculpture = headSculpture;
    }

    public int getTotalPrisedNum() {
        return totalPrisedNum;
    }

    public void setTotalPrisedNum(int totalPrisedNum) {
        this.totalPrisedNum = totalPrisedNum;
    }

    public int getTotalNewsNum() {
        return totalNewsNum;
    }

    public void setTotalNewsNum(int totalNewsNum) {
        this.totalNewsNum = totalNewsNum;
    }

    @Override
    public String toString() {
        //这里如果要输出id话要注意，当你添加新用户时，id是自动生成，所以生成的user最开始id显示为0，
        // 当你再cong数据库中取出来才会发现他的id不是零而是自增的
        return "User:"+userId+" "+userName+" "+pwd+" "+gender+" "+hobby+" "+reg_time;
    }
}
