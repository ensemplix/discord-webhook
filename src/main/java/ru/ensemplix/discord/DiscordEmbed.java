package ru.ensemplix.discord;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DiscordEmbed {

    private final String title;
    private final String type;
    private final String description;
    private final String url;
    private final int color;
    private final Footer footer;
    private final Media image;
    private final Media thumbnail;
    private final Media video;
    private final Provider provider;
    private final Author author;
    private final List<Field> fields;

    DiscordEmbed(String title, String type, String description, String url, int color, Footer footer, Media image,
                 Media thumbnail, Media video, Provider provider, Author author, List<Field> fields) {
        this.title = title;
        this.type = type;
        this.description = description;
        this.url = url;
        this.color = color;
        this.footer = footer;
        this.image = image;
        this.thumbnail = thumbnail;
        this.video = video;
        this.provider = provider;
        this.author = author;
        this.fields = fields;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public int getColor() {
        return color;
    }

    public Footer getFooter() {
        return footer;
    }

    public Media getImage() {
        return image;
    }

    public Media getThumbnail() {
        return thumbnail;
    }

    public Media getVideo() {
        return video;
    }

    public Provider getProvider() {
        return provider;
    }

    public Author getAuthor() {
        return author;
    }

    public List<Field> getFields() {
        return fields;
    }

    public static class Footer {
        private final String text;
        @SerializedName("icon_url")
        private final String iconUrl;
        @SerializedName("proxy_icon_url")
        private final String proxyIconUrl;

        Footer(String text, String iconUrl, String proxyIconUrl) {
            this.text = text;
            this.iconUrl = iconUrl;
            this.proxyIconUrl = proxyIconUrl;
        }

        public String getText() {
            return text;
        }

        public String getIconUrl() {
            return iconUrl;
        }

        public String getProxyIconUrl() {
            return proxyIconUrl;
        }
    }

    public static class Media {
        private final String url;
        private final int height;
        private final int width;

        Media(String url, int height, int width) {
            this.url = url;
            this.height = height;
            this.width = width;
        }

        public String getUrl() {
            return url;
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }
    }

    public static class Provider {
        private final String name;
        private final String url;

        Provider(String name, String url) {
            this.name = name;
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }
    }

    public static class Author {
        private final String name;
        private final String url;
        @SerializedName("icon_url")
        private final String iconUrl;
        @SerializedName("proxy_icon_url")
        private final String proxyIconUrl;

        Author(String name, String url, String iconUrl, String proxyIconUrl) {
            this.name = name;
            this.url = url;
            this.iconUrl = iconUrl;
            this.proxyIconUrl = proxyIconUrl;
        }

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }

        public String getIconUrl() {
            return iconUrl;
        }

        public String getProxyIconUrl() {
            return proxyIconUrl;
        }
    }

    public static class Field {
        private final String name;
        private final String value;
        private final boolean inline;

        Field(String name, String value, boolean inline) {
            this.name = name;
            this.value = value;
            this.inline = inline;
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }

        public boolean isInline() {
            return inline;
        }
    }

}
