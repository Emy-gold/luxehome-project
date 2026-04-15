package org.backendluxehome.template;

import lombok.Getter;

@Getter
public enum EmailTemplateName {

    ACTIVATE_ACCOUNT("activate_account");
    public final String name;

    EmailTemplateName(String name){
        this.name = name;
    }
}
