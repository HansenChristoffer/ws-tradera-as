package se.sogeti.app.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import se.sogeti.app.models.dto.AdvertDTO;

public class ItemDetails implements Serializable {

    @SerializedName("itemId")
    @Expose
    private Integer itemId;
    @SerializedName("itemType")
    @Expose
    private String itemType;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("openingBid")
    @Expose
    private Double openingBid;
    @SerializedName("categoryId")
    @Expose
    private Integer categoryId;
    @SerializedName("sellerMemberId")
    @Expose
    private Integer sellerMemberId;
    @SerializedName("hasEnded")
    @Expose
    private Boolean hasEnded;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("itemMainImage")
    @Expose
    private ItemMainImage itemMainImage;
    @SerializedName("forciblyClosed")
    @Expose
    private Boolean forciblyClosed;
    @SerializedName("isApprovedBuyer")
    @Expose
    private Boolean isApprovedBuyer;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("additionalDescriptions")
    @Expose
    private transient List<Object> additionalDescriptions = null;
    @SerializedName("shippingOptions")
    @Expose
    private List<ShippingOption> shippingOptions = null;
    @SerializedName("shippingTerms")
    @Expose
    private String shippingTerms;
    @SerializedName("paymentOptions")
    @Expose
    private List<PaymentOption> paymentOptions = null;
    @SerializedName("paymentTerms")
    @Expose
    private String paymentTerms;
    @SerializedName("seller")
    @Expose
    private Seller seller;
    @SerializedName("campaign")
    @Expose
    private Campaign campaign;
    @SerializedName("allowedBuyerRegion")
    @Expose
    private String allowedBuyerRegion;
    @SerializedName("canBeBought")
    @Expose
    private Boolean canBeBought;
    @SerializedName("discountRate")
    @Expose
    private Integer discountRate;
    @SerializedName("priceBeforeDiscount")
    @Expose
    private Integer priceBeforeDiscount;
    @SerializedName("attributes")
    @Expose
    private List<Attribute> attributes = null;
    @SerializedName("visits")
    @Expose
    private Integer visits;
    @SerializedName("isAuction")
    @Expose
    private Boolean isAuction;
    @SerializedName("isAuctionBin")
    @Expose
    private Boolean isAuctionBin;
    @SerializedName("isBuyItNow")
    @Expose
    private Boolean isBuyItNow;
    @SerializedName("isShopItem")
    @Expose
    private Boolean isShopItem;
    @SerializedName("itemCanBeAddedToCart")
    @Expose
    private Boolean itemCanBeAddedToCart;
    @SerializedName("conditionDisplayText")
    @Expose
    private String conditionDisplayText;
    @SerializedName("hasPaynova")
    @Expose
    private Boolean hasPaynova;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("allowedBuyerRegionText")
    @Expose
    private String allowedBuyerRegionText;
    @SerializedName("shipsToBuyerCountry")
    @Expose
    private Boolean shipsToBuyerCountry;
    private static final long serialVersionUID = -4734987404628960872L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ItemDetails() {
    }

    /**
     *
     * @param seller
     * @param discountRate
     * @param conditionDisplayText
     * @param itemType
     * @param endDate
     * @param shipsToBuyerCountry
     * @param priceBeforeDiscount
     * @param isAuction
     * @param description
     * @param allowedBuyerRegion
     * @param title
     * @param visits
     * @param paymentOptions
     * @param additionalDescriptions
     * @param isBuyItNow
     * @param hasPaynova
     * @param isApprovedBuyer
     * @param itemCanBeAddedToCart
     * @param shippingOptions
     * @param paymentTerms
     * @param images
     * @param quantity
     * @param isAuctionBin
     * @param sellerMemberId
     * @param isShopItem
     * @param allowedBuyerRegionText
     * @param itemId
     * @param itemMainImage
     * @param openingBid
     * @param hasEnded
     * @param forciblyClosed
     * @param shippingTerms
     * @param campaign
     * @param attributes
     * @param canBeBought
     * @param startDate
     * @param categoryId
     */
    public ItemDetails(Integer itemId, String itemType, String startDate, String endDate, Double openingBid,
            Integer categoryId, Integer sellerMemberId, Boolean hasEnded, String title, String description,
            ItemMainImage itemMainImage, Boolean forciblyClosed, Boolean isApprovedBuyer, List<Image> images,
            List<Object> additionalDescriptions, List<ShippingOption> shippingOptions, String shippingTerms,
            List<PaymentOption> paymentOptions, String paymentTerms, Seller seller, Campaign campaign,
            String allowedBuyerRegion, Boolean canBeBought, Integer discountRate, Integer priceBeforeDiscount,
            List<Attribute> attributes, Integer visits, Boolean isAuction, Boolean isAuctionBin, Boolean isBuyItNow,
            Boolean isShopItem, Boolean itemCanBeAddedToCart, String conditionDisplayText, Boolean hasPaynova,
            Integer quantity, String allowedBuyerRegionText, Boolean shipsToBuyerCountry) {
        super();
        this.itemId = itemId;
        this.itemType = itemType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.openingBid = openingBid;
        this.categoryId = categoryId;
        this.sellerMemberId = sellerMemberId;
        this.hasEnded = hasEnded;
        this.title = title;
        this.description = description;
        this.itemMainImage = itemMainImage;
        this.forciblyClosed = forciblyClosed;
        this.isApprovedBuyer = isApprovedBuyer;
        this.images = images;
        this.additionalDescriptions = additionalDescriptions;
        this.shippingOptions = shippingOptions;
        this.shippingTerms = shippingTerms;
        this.paymentOptions = paymentOptions;
        this.paymentTerms = paymentTerms;
        this.seller = seller;
        this.campaign = campaign;
        this.allowedBuyerRegion = allowedBuyerRegion;
        this.canBeBought = canBeBought;
        this.discountRate = discountRate;
        this.priceBeforeDiscount = priceBeforeDiscount;
        this.attributes = attributes;
        this.visits = visits;
        this.isAuction = isAuction;
        this.isAuctionBin = isAuctionBin;
        this.isBuyItNow = isBuyItNow;
        this.isShopItem = isShopItem;
        this.itemCanBeAddedToCart = itemCanBeAddedToCart;
        this.conditionDisplayText = conditionDisplayText;
        this.hasPaynova = hasPaynova;
        this.quantity = quantity;
        this.allowedBuyerRegionText = allowedBuyerRegionText;
        this.shipsToBuyerCountry = shipsToBuyerCountry;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getOpeningBid() {
        return openingBid;
    }

    public void setOpeningBid(Double openingBid) {
        this.openingBid = openingBid;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getSellerMemberId() {
        return sellerMemberId;
    }

    public void setSellerMemberId(Integer sellerMemberId) {
        this.sellerMemberId = sellerMemberId;
    }

    public Boolean hasEnded() {
        return hasEnded;
    }

    public void setEnded(Boolean hasEnded) {
        this.hasEnded = hasEnded;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemMainImage getItemMainImage() {
        return itemMainImage;
    }

    public void setItemMainImage(ItemMainImage itemMainImage) {
        this.itemMainImage = itemMainImage;
    }

    public Boolean isForciblyClosed() {
        return forciblyClosed;
    }

    public void setForciblyClosed(Boolean forciblyClosed) {
        this.forciblyClosed = forciblyClosed;
    }

    public Boolean isApprovedBuyer() {
        return isApprovedBuyer;
    }

    public void setIsApprovedBuyer(Boolean isApprovedBuyer) {
        this.isApprovedBuyer = isApprovedBuyer;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Object> getAdditionalDescriptions() {
        return additionalDescriptions;
    }

    public void setAdditionalDescriptions(List<Object> additionalDescriptions) {
        this.additionalDescriptions = additionalDescriptions;
    }

    public List<ShippingOption> getShippingOptions() {
        return shippingOptions;
    }

    public void setShippingOptions(List<ShippingOption> shippingOptions) {
        this.shippingOptions = shippingOptions;
    }

    public String getShippingTerms() {
        return shippingTerms;
    }

    public void setShippingTerms(String shippingTerms) {
        this.shippingTerms = shippingTerms;
    }

    public List<PaymentOption> getPaymentOptions() {
        return paymentOptions;
    }

    public void setPaymentOptions(List<PaymentOption> paymentOptions) {
        this.paymentOptions = paymentOptions;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public String getAllowedBuyerRegion() {
        return allowedBuyerRegion;
    }

    public void setAllowedBuyerRegion(String allowedBuyerRegion) {
        this.allowedBuyerRegion = allowedBuyerRegion;
    }

    public Boolean getCanBeBought() {
        return canBeBought;
    }

    public void setCanBeBought(Boolean canBeBought) {
        this.canBeBought = canBeBought;
    }

    public Integer getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Integer discountRate) {
        this.discountRate = discountRate;
    }

    public Integer getPriceBeforeDiscount() {
        return priceBeforeDiscount;
    }

    public void setPriceBeforeDiscount(Integer priceBeforeDiscount) {
        this.priceBeforeDiscount = priceBeforeDiscount;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    public Boolean isAuction() {
        return isAuction;
    }

    public void setAuction(Boolean isAuction) {
        this.isAuction = isAuction;
    }

    public Boolean isAuctionBin() {
        return isAuctionBin;
    }

    public void setAuctionBin(Boolean isAuctionBin) {
        this.isAuctionBin = isAuctionBin;
    }

    public Boolean isBuyItNow() {
        return isBuyItNow;
    }

    public void setIsBuyItNow(Boolean isBuyItNow) {
        this.isBuyItNow = isBuyItNow;
    }

    public Boolean isShopItem() {
        return isShopItem;
    }

    public void setShopItem(Boolean isShopItem) {
        this.isShopItem = isShopItem;
    }

    public Boolean getItemCanBeAddedToCart() {
        return itemCanBeAddedToCart;
    }

    public void setItemCanBeAddedToCart(Boolean itemCanBeAddedToCart) {
        this.itemCanBeAddedToCart = itemCanBeAddedToCart;
    }

    public String getConditionDisplayText() {
        return conditionDisplayText;
    }

    public void setConditionDisplayText(String conditionDisplayText) {
        this.conditionDisplayText = conditionDisplayText;
    }

    public Boolean hasPaynova() {
        return hasPaynova;
    }

    public void setPaynova(Boolean hasPaynova) {
        this.hasPaynova = hasPaynova;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getAllowedBuyerRegionText() {
        return allowedBuyerRegionText;
    }

    public void setAllowedBuyerRegionText(String allowedBuyerRegionText) {
        this.allowedBuyerRegionText = allowedBuyerRegionText;
    }

    public Boolean getShipsToBuyerCountry() {
        return shipsToBuyerCountry;
    }

    public void setShipsToBuyerCountry(Boolean shipsToBuyerCountry) {
        this.shipsToBuyerCountry = shipsToBuyerCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ItemDetails)) {
            return false;
        }
        ItemDetails itemDetails = (ItemDetails) o;
        return Objects.equals(itemId, itemDetails.itemId) && Objects.equals(itemType, itemDetails.itemType)
                && Objects.equals(startDate, itemDetails.startDate) && Objects.equals(endDate, itemDetails.endDate)
                && Objects.equals(openingBid, itemDetails.openingBid)
                && Objects.equals(categoryId, itemDetails.categoryId)
                && Objects.equals(sellerMemberId, itemDetails.sellerMemberId)
                && Objects.equals(hasEnded, itemDetails.hasEnded) && Objects.equals(title, itemDetails.title)
                && Objects.equals(description, itemDetails.description)
                && Objects.equals(itemMainImage, itemDetails.itemMainImage)
                && Objects.equals(forciblyClosed, itemDetails.forciblyClosed)
                && Objects.equals(isApprovedBuyer, itemDetails.isApprovedBuyer)
                && Objects.equals(images, itemDetails.images)
                && Objects.equals(additionalDescriptions, itemDetails.additionalDescriptions)
                && Objects.equals(shippingOptions, itemDetails.shippingOptions)
                && Objects.equals(shippingTerms, itemDetails.shippingTerms)
                && Objects.equals(paymentOptions, itemDetails.paymentOptions)
                && Objects.equals(paymentTerms, itemDetails.paymentTerms) && Objects.equals(seller, itemDetails.seller)
                && Objects.equals(campaign, itemDetails.campaign)
                && Objects.equals(allowedBuyerRegion, itemDetails.allowedBuyerRegion)
                && Objects.equals(canBeBought, itemDetails.canBeBought)
                && Objects.equals(discountRate, itemDetails.discountRate)
                && Objects.equals(priceBeforeDiscount, itemDetails.priceBeforeDiscount)
                && Objects.equals(attributes, itemDetails.attributes) && Objects.equals(visits, itemDetails.visits)
                && Objects.equals(isAuction, itemDetails.isAuction)
                && Objects.equals(isAuctionBin, itemDetails.isAuctionBin)
                && Objects.equals(isBuyItNow, itemDetails.isBuyItNow)
                && Objects.equals(isShopItem, itemDetails.isShopItem)
                && Objects.equals(itemCanBeAddedToCart, itemDetails.itemCanBeAddedToCart)
                && Objects.equals(conditionDisplayText, itemDetails.conditionDisplayText)
                && Objects.equals(hasPaynova, itemDetails.hasPaynova) && Objects.equals(quantity, itemDetails.quantity)
                && Objects.equals(allowedBuyerRegionText, itemDetails.allowedBuyerRegionText)
                && Objects.equals(shipsToBuyerCountry, itemDetails.shipsToBuyerCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemType, startDate, endDate, openingBid, categoryId, sellerMemberId, hasEnded,
                title, description, itemMainImage, forciblyClosed, isApprovedBuyer, images, additionalDescriptions,
                shippingOptions, shippingTerms, paymentOptions, paymentTerms, seller, campaign, allowedBuyerRegion,
                canBeBought, discountRate, priceBeforeDiscount, attributes, visits, isAuction, isAuctionBin, isBuyItNow,
                isShopItem, itemCanBeAddedToCart, conditionDisplayText, hasPaynova, quantity, allowedBuyerRegionText,
                shipsToBuyerCountry);
    }

    @Override
    public String toString() {
        return "{" + " itemId='" + getItemId() + "'" + ", itemType='" + getItemType() + "'" + ", startDate='"
                + getStartDate() + "'" + ", endDate='" + getEndDate() + "'" + ", openingBid='" + getOpeningBid() + "'"
                + ", categoryId='" + getCategoryId() + "'" + ", sellerMemberId='" + getSellerMemberId() + "'"
                + ", hasEnded='" + hasEnded() + "'" + ", title='" + getTitle() + "'" + ", description='"
                + getDescription() + "'" + ", itemMainImage='" + getItemMainImage() + "'" + ", forciblyClosed='"
                + isForciblyClosed() + "'" + ", isApprovedBuyer='" + isApprovedBuyer() + "'" + ", images='"
                + getImages() + "'" + ", additionalDescriptions='" + getAdditionalDescriptions() + "'"
                + ", shippingOptions='" + getShippingOptions() + "'" + ", shippingTerms='" + getShippingTerms() + "'"
                + ", paymentOptions='" + getPaymentOptions() + "'" + ", paymentTerms='" + getPaymentTerms() + "'"
                + ", seller='" + getSeller() + "'" + ", campaign='" + getCampaign() + "'" + ", allowedBuyerRegion='"
                + getAllowedBuyerRegion() + "'" + ", canBeBought='" + getCanBeBought() + "'" + ", discountRate='"
                + getDiscountRate() + "'" + ", priceBeforeDiscount='" + getPriceBeforeDiscount() + "'"
                + ", attributes='" + getAttributes() + "'" + ", visits='" + getVisits() + "'" + ", isAuction='"
                + isAuction() + "'" + ", isAuctionBin='" + isAuctionBin() + "'" + ", isBuyItNow='" + isBuyItNow() + "'"
                + ", isShopItem='" + isShopItem() + "'" + ", itemCanBeAddedToCart='" + getItemCanBeAddedToCart() + "'"
                + ", conditionDisplayText='" + getConditionDisplayText() + "'" + ", hasPaynova='" + hasPaynova() + "'"
                + ", quantity='" + getQuantity() + "'" + ", allowedBuyerRegionText='" + getAllowedBuyerRegionText()
                + "'" + ", shipsToBuyerCountry='" + getShipsToBuyerCountry() + "'" + "}";
    }

    public AdvertDTO build() {
        Set<String> brands = new HashSet<>();
        Set<String> sizes = new HashSet<>();
        Set<String> colors = new HashSet<>();

        getAttributes().forEach(attr -> {
            if (attr.getBackingField().equalsIgnoreCase("brand")) {
                attr.getValues().forEach(b -> brands.add(b.getValue()));
            } else if (attr.getBackingField().equalsIgnoreCase("clothes_size")) {
                attr.getValues().forEach(s -> sizes.add(s.getValue()));
            } else if (attr.getBackingField().equalsIgnoreCase("color")) {
                attr.getValues().forEach(c -> colors.add(c.getValue()));
            }
        });

        return new AdvertDTO(getTitle(), getDescription(), getOpeningBid(), getStartDate(), getEndDate(), getItemId(),
                "", getCategoryId(), getSellerMemberId(), getConditionDisplayText(), brands, sizes, colors,
                getAllowedBuyerRegion(), getShipsToBuyerCountry(), isAuction());
    }

}