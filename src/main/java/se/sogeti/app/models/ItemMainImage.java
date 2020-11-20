
package se.sogeti.app.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ItemMainImage implements Serializable {

    @SerializedName("max")
    @Expose
    private String max;
    @SerializedName("med")
    @Expose
    private String med;
    @SerializedName("min")
    @Expose
    private String min;
    private static final long serialVersionUID = 6181292832048054631L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ItemMainImage() {
    }

    /**
     * 
     * @param min
     * @param max
     * @param med
     */
    public ItemMainImage(String max, String med, String min) {
        super();
        this.max = max;
        this.med = med;
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMed() {
        return med;
    }

    public void setMed(String med) {
        this.med = med;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("max", max).append("med", med).append("min", min).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(min).append(max).append(med).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ItemMainImage)) {
            return false;
        }
        ItemMainImage rhs = ((ItemMainImage) other);
        return new EqualsBuilder().append(min, rhs.min).append(max, rhs.max).append(med, rhs.med).isEquals();
    }

}
