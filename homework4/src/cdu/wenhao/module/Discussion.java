package cdu.wenhao.module;

import java.util.Date;

public class Discussion {
    private int discussionId;
    private int newsId;
    private int userId;
    private String nickname;
    private String beDisedUserNicename;
    private String content;
    private String discussionTime;

    public int getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(int discussionId) {
        this.discussionId = discussionId;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDiscussionTime() {
        return discussionTime;
    }

    public void setDiscussionTime(String discussionTime) {
        this.discussionTime = discussionTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getBeDisedUserNicename() {
        return beDisedUserNicename;
    }

    public void setBeDisedUserNicename(String beDisedUserNicename) {
        this.beDisedUserNicename = beDisedUserNicename;
    }
}
