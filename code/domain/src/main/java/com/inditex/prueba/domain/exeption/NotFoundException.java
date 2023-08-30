package com.inditex.prueba.domain.exeption;

public class NotFoundException extends GenericStructure {

  public NotFoundException(final Integer code, final String message) {
    super(code, message);
  }
}
