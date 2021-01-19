package br.com.iguana.repositories;

import br.com.iguana.entities.BankManager;

import java.util.List;
import java.util.Optional;

public interface IBankManagerRepository {
    BankManager persist(BankManager bankManager);

    List<BankManager> listAll();

    Optional<BankManager> findById(Long id);

    BankManager update(BankManager book);

    void deleteById(Long id);
}
