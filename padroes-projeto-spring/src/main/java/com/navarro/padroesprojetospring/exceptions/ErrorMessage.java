package com.navarro.padroesprojetospring.exceptions;

import org.springframework.http.HttpStatus;

public record ErrorMessage(HttpStatus status, String message) {
}
