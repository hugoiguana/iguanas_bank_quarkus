package br.com.iguana.repository.quarkus;

import br.com.iguana.entities.InternalTransactionValidator;
import br.com.iguana.repository.ITransactionValidatorRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class TransactionValidatorRepository implements ITransactionValidatorRepository {

    @Override
    public InternalTransactionValidator persist(InternalTransactionValidator internalTransactionValidator) {
        InternalTransactionValidator.persist(internalTransactionValidator);
        return internalTransactionValidator;
    }

    @Override
    public List<InternalTransactionValidator> listAll() {
        return InternalTransactionValidator.listAll();
    }

    @Override
    public Optional<InternalTransactionValidator> findById(Long id) {
        return InternalTransactionValidator.findByIdOptional(id);
    }
}
