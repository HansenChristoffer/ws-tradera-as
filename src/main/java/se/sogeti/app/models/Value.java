package se.sogeti.app.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Value implements Serializable {

    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("value")
    @Expose
    private String value;
    private static final long serialVersionUID = -5973828904842059451L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Value() {
    }

    /**
     * 
     * @param displayName
     * @param value
     * @param url
     */
    public Value(String displayName, String url, String value) {
        super();
        this.displayName = displayName;
        this.url = url;
        this.value = value;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("displayName", displayName).append("url", url).append("value", value)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(value).append(displayName).append(url).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Value)) {
            return false;
        }
        Value rhs = ((Value) other);
        return new EqualsBuilder().append(value, rhs.value).append(displayName, rhs.displayName).append(url, rhs.url)
                .isEquals();
    }

}
