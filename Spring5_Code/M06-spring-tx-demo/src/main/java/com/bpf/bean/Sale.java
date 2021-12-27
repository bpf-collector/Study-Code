package com.bpf.bean;

public class Sale {

    private Integer id;
    private Integer goodId;
    private Integer nums;

    public Sale() {}

    public Sale(Integer goodId, Integer nums) {
        this.goodId = goodId;
        this.nums = nums;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", goodId=" + goodId +
                ", nums=" + nums +
                '}';
    }
}
