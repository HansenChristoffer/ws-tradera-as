
package se.sogeti.app.models;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import se.sogeti.app.models.dto.SellerDTO;

public class Seller implements Serializable {

    @SerializedName("alias")
    @Expose
    private String alias;
    @SerializedName("cleanedAlias")
    @Expose
    private String cleanedAlias;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("detailedSellerRatingAverage")
    @Expose
    private Double detailedSellerRatingAverage;
    @SerializedName("existsInFavouriteSellers")
    @Expose
    private Boolean existsInFavouriteSellers;
    @SerializedName("hasDsr")
    @Expose
    private Boolean hasDsr;
    @SerializedName("hasShop")
    @Expose
    private Boolean hasShop;
    @SerializedName("heroImage")
    @Expose
    private HeroImage heroImage;
    @SerializedName("isCompany")
    @Expose
    private Boolean isCompany;
    @SerializedName("memberId")
    @Expose
    private Integer memberId;
    @SerializedName("totalRating")
    @Expose
    private Integer totalRating;
    private static final long serialVersionUID = -6457009222201294115L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Seller() {
    }

    /**
     * 
     * @param city
     * @param detailedSellerRatingAverage
     * @param alias
     * @param totalRating
     * @param hasShop
     * @param heroImage
     * @param existsInFavouriteSellers
     * @param isCompany
     * @param hasDsr
     * @param cleanedAlias
     * @param memberId
     */
    public Seller(String alias, String cleanedAlias, String city, Double detailedSellerRatingAverage,
            Boolean existsInFavouriteSellers, Boolean hasDsr, Boolean hasShop, HeroImage heroImage, Boolean isCompany,
            Integer memberId, Integer totalRating) {
        super();
        this.alias = alias;
        this.cleanedAlias = cleanedAlias;
        this.city = city;
        this.detailedSellerRatingAverage = detailedSellerRatingAverage;
        this.existsInFavouriteSellers = existsInFavouriteSellers;
        this.hasDsr = hasDsr;
        this.hasShop = hasShop;
        this.heroImage = heroImage;
        this.isCompany = isCompany;
        this.memberId = memberId;
        this.totalRating = totalRating;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCleanedAlias() {
        return cleanedAlias;
    }

    public void setCleanedAlias(String cleanedAlias) {
        this.cleanedAlias = cleanedAlias;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getDetailedSellerRatingAverage() {
        return detailedSellerRatingAverage;
    }

    public void setDetailedSellerRatingAverage(Double detailedSellerRatingAverage) {
        this.detailedSellerRatingAverage = detailedSellerRatingAverage;
    }

    public Boolean getExistsInFavouriteSellers() {
        return existsInFavouriteSellers;
    }

    public void setExistsInFavouriteSellers(Boolean existsInFavouriteSellers) {
        this.existsInFavouriteSellers = existsInFavouriteSellers;
    }

    public Boolean getHasDsr() {
        return hasDsr;
    }

    public void setHasDsr(Boolean hasDsr) {
        this.hasDsr = hasDsr;
    }

    public Boolean getHasShop() {
        return hasShop;
    }

    public void setHasShop(Boolean hasShop) {
        this.hasShop = hasShop;
    }

    public HeroImage getHeroImage() {
        return heroImage;
    }

    public void setHeroImage(HeroImage heroImage) {
        this.heroImage = heroImage;
    }

    public Boolean getIsCompany() {
        return isCompany;
    }

    public void setIsCompany(Boolean isCompany) {
        this.isCompany = isCompany;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(Integer totalRating) {
        this.totalRating = totalRating;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("alias", alias).append("cleanedAlias", cleanedAlias)
                .append("city", city).append("detailedSellerRatingAverage", detailedSellerRatingAverage)
                .append("existsInFavouriteSellers", existsInFavouriteSellers).append("hasDsr", hasDsr)
                .append("hasShop", hasShop).append("heroImage", heroImage).append("isCompany", isCompany)
                .append("memberId", memberId).append("totalRating", totalRating).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(city).append(detailedSellerRatingAverage).append(alias).append(totalRating)
                .append(hasShop).append(heroImage).append(existsInFavouriteSellers).append(isCompany).append(hasDsr)
                .append(cleanedAlias).append(memberId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Seller)) {
            return false;
        }
        Seller rhs = ((Seller) other);
        return new EqualsBuilder().append(city, rhs.city)
                .append(detailedSellerRatingAverage, rhs.detailedSellerRatingAverage).append(alias, rhs.alias)
                .append(totalRating, rhs.totalRating).append(hasShop, rhs.hasShop).append(heroImage, rhs.heroImage)
                .append(existsInFavouriteSellers, rhs.existsInFavouriteSellers).append(isCompany, rhs.isCompany)
                .append(hasDsr, rhs.hasDsr).append(cleanedAlias, rhs.cleanedAlias).append(memberId, rhs.memberId)
                .isEquals();
    }

    public SellerDTO build() {
        return new SellerDTO(getMemberId(), getAlias(), getCity(),
                String.format("/profile/items/%d/%s", getMemberId(), getCleanedAlias()),
                getDetailedSellerRatingAverage(), getTotalRating(), getIsCompany());
    }

}
