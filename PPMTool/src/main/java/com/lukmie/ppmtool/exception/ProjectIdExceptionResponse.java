package com.lukmie.ppmtool.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectIdExceptionResponse {
    private String projectIdentifier;
}
