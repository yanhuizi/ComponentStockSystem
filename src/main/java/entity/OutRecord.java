package entity;

import java.time.LocalDateTime;

public class OutRecord {
    private Integer id;
    private Integer componentId;
    private Integer quantity;
    private String operator;
    private LocalDateTime outTime;
    private String remark;

    public OutRecord() {
    }

    public OutRecord(Integer id, Integer componentId, Integer quantity, String operator,
                     LocalDateTime outTime, String remark) {
        this.id = id;
        this.componentId = componentId;
        this.quantity = quantity;
        this.operator = operator;
        this.outTime = outTime;
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

    public LocalDateTime getOutTime() {
        return outTime;
    }

    public void setOutTime(LocalDateTime outTime) {
        this.outTime = outTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
