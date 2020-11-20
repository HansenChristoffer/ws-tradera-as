
package se.sogeti.app.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Campaign implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    private static final long serialVersionUID = -3576338535845303637L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Campaign() {
    }

    /**
     * 
     * @param id
     */
    public Campaign(Integer id) {
        super();
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Campaign)) {
            return false;
        }
        Campaign rhs = ((Campaign) other);
        return new EqualsBuilder().append(id, rhs.id).isEquals();
    }

}
