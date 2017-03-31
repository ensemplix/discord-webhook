package ru.ensemplix.discord;

import java.util.ArrayList;
import java.util.List;

public class DiscordMessageBuilder {

    private String username;
    private String content;
    private String avatarUrl;
    private boolean textToSpeech;
    private List<DiscordEmbed> embeds = new ArrayList<>();

    private DiscordMessageBuilder() {}

    public DiscordMessageBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public DiscordMessageBuilder setContent(String content) {
        this.content = content;
        return this;
    }

    public DiscordMessageBuilder setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

    public DiscordMessageBuilder setTextToSpeech(boolean textToSpeech) {
        this.textToSpeech = textToSpeech;
        return this;
    }

    public DiscordMessageBuilder embed(DiscordEmbed embed) {
        this.embeds.add(embed);
        return this;
    }

    public DiscordMessage build() {
        return new DiscordMessage(username, content, avatarUrl, textToSpeech, embeds);
    }

    public static DiscordMessageBuilder newBuilder() {
        return new DiscordMessageBuilder();
    }

}
