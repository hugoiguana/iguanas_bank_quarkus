package br.com.iguana.repository;

import br.com.iguana.entities.InternalTransactionValidator;

import java.util.List;
import java.util.Optional;

public interface ITransactionValidatorRepository {

    InternalTransactionValidator persist(InternalTransactionValidator internalTransactionValidator);

    List<InternalTransactionValidator> listAll();

    Optional<InternalTransactionValidator> findById(Long id);
}
