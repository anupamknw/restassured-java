package models;

public class ShareRequest {
    String id;
    String security;
    String buySell;
    String quantity;
    String priceInCents;
    String totalCostInCents;

    public ShareRequest(String id, String security, String buySell, String quantity, String priceInCents, String totalCostInCents) {
        this.id = id;
        this.security = security;
        this.buySell = buySell;
        this.quantity = quantity;
        this.priceInCents = priceInCents;
        this.totalCostInCents = totalCostInCents;
    }

    public String  getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getBuySell() {
        return buySell;
    }

    public void setBuySell(String buySell) {
        this.buySell = buySell;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(String priceInCents) {
        this.priceInCents = priceInCents;
    }

    public String getTotalCostInCents() {
        return totalCostInCents;
    }

    public void setTotalCostInCents(String totalCostInCents) {
        this.totalCostInCents = totalCostInCents;
    }
}
