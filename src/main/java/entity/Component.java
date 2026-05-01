package entity;

public class Component {
    private Integer id;
    private String name;
    private String model;
    private Integer categoryId;
    private Integer locationId;
    private Integer stock;
    private Integer warningQuantity;
    private String remark;

    public Component() {
    }

    public Component(Integer id, String name, String model, Integer categoryId, Integer locationId,
                     Integer stock, Integer warningQuantity, String remark) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.categoryId = categoryId;
        this.locationId = locationId;
        this.stock = stock;
        this.warningQuantity = warningQuantity;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getWarningQuantity() {
        return warningQuantity;
    }

    public void setWarningQuantity(Integer warningQuantity) {
        this.warningQuantity = warningQuantity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
