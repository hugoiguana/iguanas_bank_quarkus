package br.com.iguana.repositories;

import br.com.iguana.entities.BankAccount;
import br.com.iguana.entities.UserSystem;

import java.util.List;
import java.util.Optional;

public interface IBankAccountRepository {

    BankAccount persist(BankAccount bankAccount);

    List<BankAccount> listAll();

    Optional<BankAccount> findById(Long id);

    BankAccount update(BankAccount bankAccount);

    void deleteById(Long id);
}
