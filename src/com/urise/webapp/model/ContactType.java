package com.urise.webapp.model;

/**
 * Created by Admin on 22.09.16.
 */
public enum ContactType {

    PHONE("Телю."),
    MOBILE("Мобильный"),
    HOME_PHONE("Домашний тел"),
    SKYPE("Skype"),
    MAIL("Почта"),
    LINKEDIN("Профиль Linkedin"),
    GITHUB("Профиль Github"),
    STACKOVERFLOW("Профиль Stackoverflow"),
    HOME_PAGE("Домашняя страница");


    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
