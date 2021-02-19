/*
 * Copyright Stuff Limited
 */

package com.think.clean.domain.usecase.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DomainException extends RuntimeException {

    public DomainException(String message) {
        super(message);
    }

}
