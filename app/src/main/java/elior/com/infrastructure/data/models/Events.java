package elior.com.infrastructure.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Events implements Serializable {

    @SerializedName("activity")
    private String activity;
    @SerializedName("type")
    private String type;
    @SerializedName("participants")
    private Integer participants;
    @SerializedName("price")
    private Double price;
    @SerializedName("link")
    private String link;
    @SerializedName("key")
    private String key;
    @SerializedName("accessibility")
    private Double accessibility;

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getParticipants() {
        return participants;
    }

    public void setParticipants(Integer participants) {
        this.participants = participants;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Double getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(Double accessibility) {
        this.accessibility = accessibility;
    }

}
