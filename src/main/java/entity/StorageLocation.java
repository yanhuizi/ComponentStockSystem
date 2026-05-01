package entity;

public class StorageLocation {
    private Integer id;
    private String code;
    private String name;
    private String remark;

    public StorageLocation() {
    }

    public StorageLocation(Integer id, String code, String name, String remark) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
