package br.com.iguana.exceptions;

public class BussinesNotFoundEntityException extends BusinessException {

    public BussinesNotFoundEntityException(String entityName, Long entityId) {
        super(entityName + " not found with id = " + entityId);
    }
}
