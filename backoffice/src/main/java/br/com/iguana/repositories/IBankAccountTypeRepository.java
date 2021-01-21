package br.com.iguana.repositories;

import br.com.iguana.entities.BankAccountType;

import java.util.List;
import java.util.Optional;

public interface IBankAccountTypeRepository {

    BankAccountType persist(BankAccountType BankAccountType);

    List<BankAccountType> listAll();

    Optional<BankAccountType> findById(Long id);

    BankAccountType update(BankAccountType BankAccountType);

    void deleteById(Long id);
}
