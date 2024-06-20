package com.darkfoxv.cursomc.resources.exceptions;

import java.util.Collections;
import java.util.List;

public class ApiErrors{

    private List<String> errors;

    public ApiErrors(List<String> errors) {
        this.errors = errors;
    }

    public ApiErrors(String error){
        this.errors = Collections.singletonList(error);
    }

}
