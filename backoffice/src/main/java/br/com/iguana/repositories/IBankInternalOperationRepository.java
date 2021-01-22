package br.com.iguana.repositories;

import br.com.iguana.entities.BankInternalOperation;
import br.com.iguana.entities.BankInternalOperation;

import java.util.List;
import java.util.Optional;

public interface IBankInternalOperationRepository {

    BankInternalOperation persist(BankInternalOperation bankInternalOperation);

    List<BankInternalOperation> listAll();

    Optional<BankInternalOperation> findById(Long id);

    void deleteById(Long id);
}
