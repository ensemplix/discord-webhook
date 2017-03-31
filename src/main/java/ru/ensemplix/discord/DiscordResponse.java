package ru.ensemplix.discord;

import com.google.gson.annotations.SerializedName;

public class DiscordResponse {
    private final boolean global;
    private final  String message;
    @SerializedName("retry_after")
    private final  int retryAfter;

    public DiscordResponse(boolean global, String message, int retryAfter) {
        this.global = global;
        this.message = message;
        this.retryAfter = retryAfter;
    }

    public boolean isGlobal() {
        return global;
    }

    public String getMessage() {
        return message;
    }

    public int getRetryAfter() {
        return retryAfter;
    }

}
