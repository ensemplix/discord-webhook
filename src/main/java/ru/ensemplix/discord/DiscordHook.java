package ru.ensemplix.discord;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;

import java.io.File;

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

    public DiscordResponse sendMessage(DiscordMessage message, File file) {
        HttpRequest request = HttpRequest.post(url)
                .userAgent("Discord Hook")
                .part("payload_json", gson.toJson(message))
                .part("file", file.getName(), file);

        return gson.fromJson(request.reader(), DiscordResponse.class);
    }

}
