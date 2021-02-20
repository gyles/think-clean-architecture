/*
 * Copyright Stuff Limited
 */

package com.think.clean.web.rest.exception;

import java.text.MessageFormat;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class clazz) {
        super(MessageFormat.format("{0} not found.", clazz.getSimpleName()));
    }

}
