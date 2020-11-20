package se.sogeti.app.models.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdvertDTO implements Serializable {

  private static final long serialVersionUID = 9019546640732574254L;

  @SerializedName("title")
  @Expose
  private String title;

  @SerializedName("description")
  @Expose
  private String description;

  @SerializedName("openingBid")
  @Expose
  private Double openingBid;

  @SerializedName("startDate")
  @Expose
  private String startDate;

  @SerializedName("endDate")
  @Expose
  private String endDate;

  @SerializedName("itemId")
  @Expose
  private Integer itemId;

  @SerializedName("canonicalURL")
  @Expose
  private String canonicalURL;

  @SerializedName("categoryId")
  @Expose
  private Integer categoryId;

  @SerializedName("memberId")
  @Expose
  private Integer memberId;

  @SerializedName("condition")
  @Expose
  private String condition;

  @SerializedName("brands")
  @Expose
  private Set<String> brands;

  @SerializedName("sizes")
  @Expose
  private Set<String> sizes;

  @SerializedName("colors")
  @Expose
  private Set<String> colors;

  @SerializedName("allowedBuyerRegion")
  @Expose
  private String allowedBuyerRegion;

  @SerializedName("shipsToBuyer")
  @Expose
  private Boolean shipsToBuyer;

  @SerializedName("isAuction")
  @Expose
  private Boolean isAuction;

  @SerializedName("images")
  @Expose
  private List<byte[]> images;

  public AdvertDTO() {
  }

  public AdvertDTO(String title, String description, Double openingBid, String startDate, String endDate,
      Integer itemId, String canonicalURL, Integer categoryId, Integer memberId, String condition, Set<String> brands,
      Set<String> sizes, Set<String> colors, String allowedBuyerRegion, Boolean shipsToBuyer, Boolean isAuction) {
    this.title = title;
    this.description = description;
    this.openingBid = openingBid;
    this.startDate = startDate;
    this.endDate = endDate;
    this.itemId = itemId;
    this.canonicalURL = canonicalURL;
    this.categoryId = categoryId;
    this.memberId = memberId;
    this.condition = condition;
    this.brands = brands;
    this.sizes = sizes;
    this.colors = colors;
    this.allowedBuyerRegion = allowedBuyerRegion;
    this.shipsToBuyer = shipsToBuyer;
    this.isAuction = isAuction;
  }

  public AdvertDTO(String title, String description, Double openingBid, String startDate, String endDate,
      Integer itemId, String canonicalURL, Integer categoryId, Integer memberId, String condition, Set<String> brands,
      Set<String> sizes, Set<String> colors, String allowedBuyerRegion, Boolean shipsToBuyer, Boolean isAuction,
      List<byte[]> images) {
    this.title = title;
    this.description = description;
    this.openingBid = openingBid;
    this.startDate = startDate;
    this.endDate = endDate;
    this.itemId = itemId;
    this.canonicalURL = canonicalURL;
    this.categoryId = categoryId;
    this.memberId = memberId;
    this.condition = condition;
    this.brands = brands;
    this.sizes = sizes;
    this.colors = colors;
    this.allowedBuyerRegion = allowedBuyerRegion;
    this.shipsToBuyer = shipsToBuyer;
    this.isAuction = isAuction;
    this.images = images;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getOpeningBid() {
    return this.openingBid;
  }

  public void setOpeningBid(Double openingBid) {
    this.openingBid = openingBid;
  }

  public String getStartDate() {
    return this.startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return this.endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public Integer getItemId() {
    return this.itemId;
  }

  public void setItemId(Integer itemId) {
    this.itemId = itemId;
  }

  public String getCanonicalURL() {
    return this.canonicalURL;
  }

  public void setCanonicalURL(String canonicalURL) {
    this.canonicalURL = canonicalURL;
  }

  public Integer getCategoryId() {
    return this.categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public Integer getMemberId() {
    return this.memberId;
  }

  public void setMemberId(Integer memberId) {
    this.memberId = memberId;
  }

  public String getCondition() {
    return this.condition;
  }

  public void setCondition(String condition) {
    this.condition = condition;
  }

  public Set<String> getBrands() {
    return this.brands;
  }

  public void setBrands(Set<String> brands) {
    this.brands = brands;
  }

  public Set<String> getSizes() {
    return this.sizes;
  }

  public void setSizes(Set<String> sizes) {
    this.sizes = sizes;
  }

  public Set<String> getColors() {
    return this.colors;
  }

  public void setColors(Set<String> colors) {
    this.colors = colors;
  }

  public String getAllowedBuyerRegion() {
    return this.allowedBuyerRegion;
  }

  public void setAllowedBuyerRegion(String allowedBuyerRegion) {
    this.allowedBuyerRegion = allowedBuyerRegion;
  }

  public boolean getShipsToBuyer() {
    return this.shipsToBuyer;
  }

  public void setShipsToBuyer(boolean shipsToBuyer) {
    this.shipsToBuyer = shipsToBuyer;
  }

  public boolean isAuction() {
    return this.isAuction;
  }

  public void setAuction(boolean isAuction) {
    this.isAuction = isAuction;
  }

  public List<byte[]> getImages() {
    return this.images;
  }

  public void setImages(List<byte[]> images) {
    this.images = images;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof AdvertDTO)) {
      return false;
    }
    AdvertDTO advertDTO = (AdvertDTO) o;
    return Objects.equals(title, advertDTO.title) && Objects.equals(description, advertDTO.description)
        && openingBid == advertDTO.openingBid && Objects.equals(startDate, advertDTO.startDate)
        && Objects.equals(endDate, advertDTO.endDate) && Objects.equals(itemId, advertDTO.itemId)
        && Objects.equals(canonicalURL, advertDTO.canonicalURL) && Objects.equals(categoryId, advertDTO.categoryId)
        && Objects.equals(memberId, advertDTO.memberId) && Objects.equals(condition, advertDTO.condition)
        && Objects.equals(brands, advertDTO.brands) && Objects.equals(sizes, advertDTO.sizes)
        && Objects.equals(colors, advertDTO.colors) && Objects.equals(allowedBuyerRegion, advertDTO.allowedBuyerRegion)
        && shipsToBuyer == advertDTO.shipsToBuyer && isAuction == advertDTO.isAuction
        && Objects.equals(images, advertDTO.images);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, description, openingBid, startDate, endDate, itemId, canonicalURL, categoryId, memberId,
        condition, brands, sizes, colors, allowedBuyerRegion, shipsToBuyer, isAuction, images);
  }

  @Override
  public String toString() {
    return "{" + " title='" + getTitle() + "'" + ", description='" + getDescription() + "'" + ", openingBid='"
        + getOpeningBid() + "'" + ", startDate='" + getStartDate() + "'" + ", endDate='" + getEndDate() + "'"
        + ", itemId='" + getItemId() + "'" + ", canonicalURL='" + getCanonicalURL() + "'" + ", categoryId='"
        + getCategoryId() + "'" + ", memberId='" + getMemberId() + "'" + ", condition='" + getCondition() + "'"
        + ", brand='" + getBrands() + "'" + ", sizes='" + getSizes() + "'" + ", colors='" + getColors() + "'"
        + ", allowedBuyerRegion='" + getAllowedBuyerRegion() + "'" + ", shipsToBuyer='" + getShipsToBuyer() + "'"
        + ", isAuction='" + isAuction() + "'" + ", images='" + getImages() + "'" + "}";
  }

}
