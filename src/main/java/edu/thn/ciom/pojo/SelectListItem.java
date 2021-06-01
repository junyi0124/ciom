package edu.thn.ciom.pojo;

public class SelectListItem {
    private String id;
    private String value;

    public SelectListItem() {
    }

    public SelectListItem(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public SelectListItem(Integer id, String value) {
        this.id = id.toString();
        this.value = value;
    }

    public SelectListItem(Long id, String value) {
        this.id = id.toString();
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
