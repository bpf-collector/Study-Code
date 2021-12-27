package com.bpf.xml.autowired;

public class Phone {

    private String owner;
    private String provider;
    private SIMCard card;

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setCard(SIMCard card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "owner='" + owner + '\'' +
                ", provider='" + provider + '\'' +
                ", card=" + card +
                '}';
    }
}
