package br.com.iguana.services;

import br.com.iguana.entities.BankAccount;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface IBankAccountService {
    BankAccount insert(@Valid BankAccount bankAccount);

    @Transactional(Transactional.TxType.SUPPORTS)
    List<BankAccount> findAll();

    @Transactional(Transactional.TxType.SUPPORTS)
    Optional<BankAccount> findById(Long id);

    BankAccount update(@Valid BankAccount bm);

    void delete(Long id);
}
