
package se.sogeti.app.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ShippingOption implements Serializable {

    @SerializedName("displayText")
    @Expose
    private String displayText;
    @SerializedName("toCountryCodeIso2")
    @Expose
    private String toCountryCodeIso2;
    @SerializedName("cost")
    @Expose
    private Integer cost;
    @SerializedName("isTakeaway")
    @Expose
    private Boolean isTakeaway;
    @SerializedName("extraInfoUrl")
    @Expose
    private String extraInfoUrl;
    @SerializedName("extraInfoText")
    @Expose
    private String extraInfoText;
    private static final long serialVersionUID = -2747485721644556371L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ShippingOption() {
    }

    /**
     * 
     * @param displayText
     * @param cost
     * @param extraInfoText
     * @param toCountryCodeIso2
     * @param extraInfoUrl
     * @param isTakeaway
     */
    public ShippingOption(String displayText, String toCountryCodeIso2, Integer cost, Boolean isTakeaway,
            String extraInfoUrl, String extraInfoText) {
        super();
        this.displayText = displayText;
        this.toCountryCodeIso2 = toCountryCodeIso2;
        this.cost = cost;
        this.isTakeaway = isTakeaway;
        this.extraInfoUrl = extraInfoUrl;
        this.extraInfoText = extraInfoText;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public String getToCountryCodeIso2() {
        return toCountryCodeIso2;
    }

    public void setToCountryCodeIso2(String toCountryCodeIso2) {
        this.toCountryCodeIso2 = toCountryCodeIso2;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Boolean getIsTakeaway() {
        return isTakeaway;
    }

    public void setIsTakeaway(Boolean isTakeaway) {
        this.isTakeaway = isTakeaway;
    }

    public String getExtraInfoUrl() {
        return extraInfoUrl;
    }

    public void setExtraInfoUrl(String extraInfoUrl) {
        this.extraInfoUrl = extraInfoUrl;
    }

    public String getExtraInfoText() {
        return extraInfoText;
    }

    public void setExtraInfoText(String extraInfoText) {
        this.extraInfoText = extraInfoText;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("displayText", displayText)
                .append("toCountryCodeIso2", toCountryCodeIso2).append("cost", cost).append("isTakeaway", isTakeaway)
                .append("extraInfoUrl", extraInfoUrl).append("extraInfoText", extraInfoText).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(displayText).append(cost).append(extraInfoText).append(toCountryCodeIso2)
                .append(extraInfoUrl).append(isTakeaway).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ShippingOption)) {
            return false;
        }
        ShippingOption rhs = ((ShippingOption) other);
        return new EqualsBuilder().append(displayText, rhs.displayText).append(cost, rhs.cost)
                .append(extraInfoText, rhs.extraInfoText).append(toCountryCodeIso2, rhs.toCountryCodeIso2)
                .append(extraInfoUrl, rhs.extraInfoUrl).append(isTakeaway, rhs.isTakeaway).isEquals();
    }

}
