package se.sogeti.app.models.dto;

import java.io.Serializable;
import java.util.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SellerDTO implements Serializable {

    private static final long serialVersionUID = 8568034028794214340L;

    @SerializedName("memberId")
    @Expose
    private Integer memberId;

    @SerializedName("alias")
    @Expose
    private String alias;

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("canonicalURL")
    @Expose
    private String canonicalURL;

    @SerializedName("sellerRatingAverage")
    @Expose
    private Double sellerRatingAverage;

    @SerializedName("totalRating")
    @Expose
    private Integer totalRating;

    @SerializedName("isCompany")
    @Expose
    private Boolean isCompany;

    public SellerDTO() {
    }

    public SellerDTO(Integer memberId, String alias, String city, String canonicalURL, Double sellerRatingAverage,
            Integer totalRating, Boolean isCompany) {
        this.memberId = memberId;
        this.alias = alias;
        this.city = city;
        this.canonicalURL = canonicalURL;
        this.sellerRatingAverage = sellerRatingAverage;
        this.totalRating = totalRating;
        this.isCompany = isCompany;
    }

    public Integer getMemberId() {
        return this.memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCanonicalURL() {
        return this.canonicalURL;
    }

    public void setCanonicalURL(String canonicalURL) {
        this.canonicalURL = canonicalURL;
    }

    public Double getSellerRatingAverage() {
        return this.sellerRatingAverage;
    }

    public void setSellerRatingAverage(Double sellerRatingAverage) {
        this.sellerRatingAverage = sellerRatingAverage;
    }

    public Integer getTotalRating() {
        return this.totalRating;
    }

    public void setTotalRating(Integer totalRating) {
        this.totalRating = totalRating;
    }

    public Boolean isIsCompany() {
        return this.isCompany;
    }

    public Boolean getIsCompany() {
        return this.isCompany;
    }

    public void setIsCompany(Boolean isCompany) {
        this.isCompany = isCompany;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SellerDTO)) {
            return false;
        }
        SellerDTO seller = (SellerDTO) o;
        return Objects.equals(memberId, seller.memberId) && Objects.equals(alias, seller.alias)
                && Objects.equals(city, seller.city) && Objects.equals(canonicalURL, seller.canonicalURL)
                && Objects.equals(sellerRatingAverage, seller.sellerRatingAverage)
                && Objects.equals(totalRating, seller.totalRating) && Objects.equals(isCompany, seller.isCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, alias, city, canonicalURL, sellerRatingAverage, totalRating, isCompany);
    }

    @Override
    public String toString() {
        return "{" + " memberId='" + getMemberId() + "'" + ", alias='" + getAlias() + "'" + ", city='" + getCity() + "'"
                + ", canonicalURL='" + getCanonicalURL() + "'" + ", sellerRatingAverage='" + getSellerRatingAverage()
                + "'" + ", totalRating='" + getTotalRating() + "'" + ", isCompany='" + isIsCompany() + "'" + "}";
    }

}
