
package se.sogeti.app.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Image implements Serializable {

    @SerializedName("fullSize")
    @Expose
    private String fullSize;
    @SerializedName("normal")
    @Expose
    private String normal;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("small")
    @Expose
    private String small;
    @SerializedName("altText")
    @Expose
    private String altText;
    private static final long serialVersionUID = -4556085977412003457L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Image() {
    }

    /**
     * 
     * @param small
     * @param normal
     * @param thumbnail
     * @param altText
     * @param fullSize
     */
    public Image(String fullSize, String normal, String thumbnail, String small, String altText) {
        super();
        this.fullSize = fullSize;
        this.normal = normal;
        this.thumbnail = thumbnail;
        this.small = small;
        this.altText = altText;
    }

    public String getFullSize() {
        return fullSize;
    }

    public void setFullSize(String fullSize) {
        this.fullSize = fullSize;
    }

    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("fullSize", fullSize).append("normal", normal)
                .append("thumbnail", thumbnail).append("small", small).append("altText", altText).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(small).append(normal).append(thumbnail).append(altText).append(fullSize)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Image)) {
            return false;
        }
        Image rhs = ((Image) other);
        return new EqualsBuilder().append(small, rhs.small).append(normal, rhs.normal).append(thumbnail, rhs.thumbnail)
                .append(altText, rhs.altText).append(fullSize, rhs.fullSize).isEquals();
    }

}
