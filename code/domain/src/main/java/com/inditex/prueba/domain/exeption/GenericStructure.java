package com.inditex.prueba.domain.exeption;

import lombok.Getter;

@Getter
public class GenericStructure extends RuntimeException {

  private final Integer code;

  private final String message;

  public GenericStructure(final Integer code, final String message) {
    this.code = code;
    this.message = message;
  }
}
