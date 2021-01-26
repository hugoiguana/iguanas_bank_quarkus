package br.com.iguana.service;

import br.com.iguana.entities.InternalTransactionValidator;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface IInternalTransactionValidatorService {

    InternalTransactionValidator insert(@Valid InternalTransactionValidator transactionValidator);

    @Transactional(Transactional.TxType.SUPPORTS)
    List<InternalTransactionValidator> findAll();

    @Transactional(Transactional.TxType.SUPPORTS)
    Optional<InternalTransactionValidator> findById(Long id);
}
