package com.navarro.padroesprojetospring.PPS.exceptions;

import org.springframework.http.HttpStatus;

public record ErrorMessage(HttpStatus status, String message) {
}
