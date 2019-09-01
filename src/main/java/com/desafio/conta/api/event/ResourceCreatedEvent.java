package com.desafio.conta.api.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

@Getter
public class ResourceCreatedEvent extends ApplicationEvent {

    private HttpServletResponse response;
    private String id;

    public ResourceCreatedEvent(Object source, HttpServletResponse response, String id) {
        super(source);
        this.response = response;
        this.id = id;
    }
}
