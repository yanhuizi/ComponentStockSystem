package entity;

import java.time.LocalDateTime;

public class InRecord {
    private Integer id;
    private Integer componentId;
    private Integer quantity;
    private String operator;
    private LocalDateTime inTime;
    private String remark;

    public InRecord() {
    }

    public InRecord(Integer id, Integer componentId, Integer quantity, String operator,
                    LocalDateTime inTime, String remark) {
        this.id = id;
        this.componentId = componentId;
        this.quantity = quantity;
        this.operator = operator;
        this.inTime = inTime;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public LocalDateTime getInTime() {
        return inTime;
    }

    public void setInTime(LocalDateTime inTime) {
        this.inTime = inTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
