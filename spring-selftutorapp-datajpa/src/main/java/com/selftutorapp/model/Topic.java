package com.selftutorapp.model;

public enum Topic {
    HTML("Html 5"),
    ANGULAR("Angular"),
    PYTHON("Python"),
    DIGITALMARKETING("Digital Marketing"),
    NODEjs("Nodejs"),
    CSS("Css"),
    REACT("React"),
    DJANGO("DJango"),
    JAVA("Java"),
    SPRING("Spring"),
    SEO("Seo Marketing"),
    BRANDING("Product Branding"),
    MARKETING("Digital Marketing"),
    COOKING("Cooking"),
    COFFEE("Coffee"),
    BAKING("Cake Baking"),
    CHESS("Chess"),
    ESPORTS("E-sports"),
    POKER("Poker"),
    TRAVEL("Travel Tips"),
    ADVENTURE("Adventure Trip");

    public String topic;
    Topic(String topic) {
        this.topic = topic;
    }
}
