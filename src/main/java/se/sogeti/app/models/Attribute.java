
package se.sogeti.app.models;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Attribute implements Serializable {

    @SerializedName("backingField")
    @Expose
    private String backingField;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("values")
    @Expose
    private List<Value> values = null;
    private static final long serialVersionUID = -6257225371513571668L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Attribute() {
    }

    /**
     * 
     * @param displayName
     * @param values
     * @param backingField
     */
    public Attribute(String backingField, String displayName, List<Value> values) {
        super();
        this.backingField = backingField;
        this.displayName = displayName;
        this.values = values;
    }

    public String getBackingField() {
        return backingField;
    }

    public void setBackingField(String backingField) {
        this.backingField = backingField;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("backingField", backingField).append("displayName", displayName)
                .append("values", values).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(backingField).append(displayName).append(values).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Attribute)) {
            return false;
        }
        Attribute rhs = ((Attribute) other);
        return new EqualsBuilder().append(backingField, rhs.backingField).append(displayName, rhs.displayName)
                .append(values, rhs.values).isEquals();
    }

}
