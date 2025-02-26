package com.crio.xlido.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question {
    private int id;
    private String content;
    private int event_id;
    private int user_id;
    private int upvoteCount;
    private Set<Integer> upVoteUser;
    private List<String> replies;
    
    public Question(int id, String content, int event_id, int user_id) {
        this.id = id;
        this.content = content;
        this.event_id = event_id;
        this.user_id = user_id;
        this.upvoteCount = 0;
        this.upVoteUser = new HashSet<>();
        this.replies = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public int getEvent_id() {
        return event_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getUpvoteCount(){
        return upvoteCount;
    }

    public boolean hasUserUpvoted(int userId) {
        return upVoteUser.contains(userId);
    }

    public void getUpvote(int user_id) {
        upVoteUser.add(user_id);
        upvoteCount++;
    }

    public void addReply(int userId, String reply) {
        replies.add("User " + userId + ": " + reply);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Question ID: ").append(id).append("\n")
          .append("Content: ").append(content).append("\n")
          .append("Votes: ").append(upvoteCount).append("\n")
          .append("Replies:\n");
    
        if (!replies.isEmpty()) {
            for (String reply : replies) {
                sb.append("  - ").append(reply).append("\n");
            }
        }
    
        return sb.toString().trim() + "\n"; 
    }

}
