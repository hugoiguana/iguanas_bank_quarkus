package br.com.iguana.services;

import br.com.iguana.entities.BankAccountType;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface IBankAccountTypeService {

    BankAccountType insert(@Valid BankAccountType BankAccountType);

    @Transactional(Transactional.TxType.SUPPORTS)
    List<BankAccountType> findAll();

    @Transactional(Transactional.TxType.SUPPORTS)
    Optional<BankAccountType> findById(Long id);

    BankAccountType update(@Valid BankAccountType bm);

    void delete(Long id);
}
