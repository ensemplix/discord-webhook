package ru.ensemplix.discord.api;

import java.awt.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DiscordEmbedBuilder {

    private String title;
    private String type = "rich";
    private String description;
    private String url;
    private String timestamp;
    private int color;
    private DiscordEmbed.Footer footer;
    private DiscordEmbed.Media image;
    private DiscordEmbed.Media thumbnail;
    private DiscordEmbed.Media video;
    private DiscordEmbed.Provider provider;
    private DiscordEmbed.Author author;
    private List<DiscordEmbed.Field> fields = new ArrayList<>();

    private DiscordEmbedBuilder() {}

    public DiscordEmbedBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public DiscordEmbedBuilder setType(String title) {
        this.title = title;
        return this;
    }

    public DiscordEmbedBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public DiscordEmbedBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public DiscordEmbedBuilder setColor(Color color) {
        this.color = 65536 * color.getRed() + 256 * color.getGreen() + color.getBlue();
        return this;
    }

    public DiscordEmbedBuilder setTimestamp(long millis) {
        LocalDateTime ldt = LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneId.of("Z"));
        this.timestamp = ldt.atZone(ZoneId.of("Z")).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return this;
    }

    public DiscordEmbedBuilder setFooter(String text) {
        return setFooter(text, null, null);
    }

    public DiscordEmbedBuilder setFooter(String text, String iconUrl) {
        return setFooter(text, iconUrl, null);
    }

    public DiscordEmbedBuilder setFooter(String text, String iconUrl, String proxyIconUrl) {
        this.footer = new DiscordEmbed.Footer(text, iconUrl, proxyIconUrl);
        return this;
    }

    public DiscordEmbedBuilder setImage(String url, int height, int width) {
        this.image = new DiscordEmbed.Media(url, height, width);
        return this;
    }

    public DiscordEmbedBuilder setThumbnail(String url, int height, int width) {
        this.thumbnail = new DiscordEmbed.Media(url, height, width);
        return this;
    }

    public DiscordEmbedBuilder setVideo(String url, int height, int width) {
        this.video = new DiscordEmbed.Media(url, height, width);
        return this;
    }

    public DiscordEmbedBuilder setProvider(String name, String url) {
        this.provider = new DiscordEmbed.Provider(name, url);
        return this;
    }

    public DiscordEmbedBuilder setAuthor(String name) {
        return setAuthor(name, null, null, null);
    }

    public DiscordEmbedBuilder setAuthor(String name, String url) {
        return setAuthor(name, url, null, null);
    }

    public DiscordEmbedBuilder setAuthor(String name, String url, String iconUrl) {
        return setAuthor(name, url, iconUrl, null);
    }

    public DiscordEmbedBuilder setAuthor(String name, String url, String iconUrl, String proxyIconUrl) {
        this.author = new DiscordEmbed.Author(name, url, iconUrl, proxyIconUrl);
        return this;
    }

    public DiscordEmbedBuilder field(String name, String value) {
        return field(name, value, false);
    }

    public DiscordEmbedBuilder field(String name, String value, boolean inline) {
        this.fields.add(new DiscordEmbed.Field(name, value, inline));
        return this;
    }

    public DiscordEmbed build() {
        return new DiscordEmbed(title, type, description, url, color, timestamp, footer, image, thumbnail, video, provider, author, fields);
    }

    public static DiscordEmbedBuilder newBuilder() {
        return new DiscordEmbedBuilder();
    }

}
