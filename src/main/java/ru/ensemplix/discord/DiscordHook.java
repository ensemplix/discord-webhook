package ru.ensemplix.discord;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;

public class DiscordHook {

    private static final Gson gson = new Gson();
    private final String url;

    public DiscordHook(String url) {
        this.url = url;
    }

    public DiscordResponse sendMessage(DiscordMessage message) {
        HttpRequest request = HttpRequest.post(url)
                .userAgent("Discord Hook")
                .send(gson.toJson(message));

        return gson.fromJson(request.reader(), DiscordResponse.class);
    }

}
