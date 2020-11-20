
package se.sogeti.app.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PaymentOption implements Serializable {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("displayText")
    @Expose
    private String displayText;
    private static final long serialVersionUID = -9146853516370806667L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PaymentOption() {
    }

    /**
     * 
     * @param displayText
     * @param type
     */
    public PaymentOption(String type, String displayText) {
        super();
        this.type = type;
        this.displayText = displayText;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("type", type).append("displayText", displayText).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(type).append(displayText).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof PaymentOption)) {
            return false;
        }
        PaymentOption rhs = ((PaymentOption) other);
        return new EqualsBuilder().append(type, rhs.type).append(displayText, rhs.displayText).isEquals();
    }

}
