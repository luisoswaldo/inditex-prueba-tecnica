package com.inditex.prueba.domain.exeption;

public class DomainException extends GenericStructure {

  public DomainException(final Integer code, final String message) {
    super(code, message);
  }
}
