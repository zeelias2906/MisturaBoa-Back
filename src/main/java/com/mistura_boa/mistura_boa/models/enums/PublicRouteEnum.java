package com.mistura_boa.mistura_boa.models.enums;

import java.util.Arrays;

import lombok.Getter;

@Getter
public enum PublicRouteEnum {
    LOGIN("auth/login", "POST"),
    RESET_SENHA("auth/reset", "POST"),
    NOVO_USUARIO("auth/new-user", "POST"),
    GET_ALL_PRODUTO("produto/", "GET"),
    GET_ALL_CATEGORIA("categoria/", "GET"),
    SEARCH_PRODUTO("produto/search", "POST"),
    SEARCH_CATEGORIA("categoria/search", "POST");

    private final String rota;
    private final String metodo;

    PublicRouteEnum(String rota, String metodo){
        this.rota = rota;
        this.metodo = metodo;
    }

    public static boolean isPublicRoute(String uri, String metodoHttp) {
        String basePath = "/mistura-boa/api/";
        return Arrays.stream(values())
            .anyMatch(route -> 
                (basePath + route.rota).equalsIgnoreCase(uri)
                && route.metodo.equalsIgnoreCase(metodoHttp)
            );
    }

    public static String[] getRoutesArray() {
        return Arrays.stream(values()).map(PublicRouteEnum::getRota).toArray(String[]::new);
    }

}
