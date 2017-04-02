package ru.ensemplix.discord.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DiscordMessage {

    private final String username;
    private final String content;
    @SerializedName("avatar_url")
    private final String avatarUrl;
    @SerializedName("tts")
    private final boolean textToSpeech;
    private final List<DiscordEmbed> embeds;

    DiscordMessage(String username, String content, String avatarUrl, boolean textToSpeech, List<DiscordEmbed> embeds) {
        this.username = username;
        this.content = content;
        this.avatarUrl = avatarUrl;
        this.textToSpeech = textToSpeech;
        this.embeds = embeds;
    }

    public String getUsername() {
        return username;
    }

    public String getContent() {
        return content;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public boolean isTextToSpeech() {
        return textToSpeech;
    }

    public List<DiscordEmbed> getEmbeds() {
        return embeds;
    }

}
