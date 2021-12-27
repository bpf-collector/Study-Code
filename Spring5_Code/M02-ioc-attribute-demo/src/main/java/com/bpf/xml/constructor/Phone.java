package com.bpf.xml.constructor;

public class Phone {

    private String owner;
    private String provider;
    private SIMCard card;

    public Phone(String owner, String provider, SIMCard card) {
        this.owner = owner;
        this.provider = provider;
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
