package org.fasttrackit.youtubevideoplayer.transfer;

import javax.validation.constraints.NotNull;

public class SaveLinkRequest {

    @NotNull
    private String link;

    @NotNull
    private String title;

    private String imageUrl;
    private String time;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "SaveLinkRequest{" +
                "link='" + link + '\'' +
                ", title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
