package org.fasttrackit.youtubevideoplayer.transfer;

public class GetLinkRequest {

    private String partialLink;
    private String partialTitle;
    private String partialTime;

    public String getPartialLink() {
        return partialLink;
    }

    public void setPartialLink(String partialLink) {
        this.partialLink = partialLink;
    }

    public String getPartialTitle() {
        return partialTitle;
    }

    public void setPartialTitle(String partialTitle) {
        this.partialTitle = partialTitle;
    }

    public String getPartialTime() {
        return partialTime;
    }

    public void setPartialTime(String partialTime) {
        this.partialTime = partialTime;
    }

    @Override
    public String toString() {
        return "GetLinkRequest{" +
                "partialLink='" + partialLink + '\'' +
                ", partialTitle='" + partialTitle + '\'' +
                ", partialTime='" + partialTime + '\'' +
                '}';
    }
}
