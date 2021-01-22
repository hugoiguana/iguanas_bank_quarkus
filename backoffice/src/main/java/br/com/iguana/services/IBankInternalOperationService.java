package br.com.iguana.services;

import br.com.iguana.entities.BankInternalOperation;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface IBankInternalOperationService {

    BankInternalOperation insert(@Valid BankInternalOperation operation);

    @Transactional(Transactional.TxType.SUPPORTS)
    List<BankInternalOperation> findAll();

    @Transactional(Transactional.TxType.SUPPORTS)
    Optional<BankInternalOperation> findById(Long id);

    void delete(Long id);
}
