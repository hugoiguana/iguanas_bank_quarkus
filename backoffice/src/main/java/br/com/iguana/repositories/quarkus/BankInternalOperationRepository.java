package br.com.iguana.repositories.quarkus;

import br.com.iguana.entities.BankInternalOperation;
import br.com.iguana.repositories.IBankInternalOperationRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class BankInternalOperationRepository implements IBankInternalOperationRepository {

    @Inject
    private EntityManager em;

    @Override
    public BankInternalOperation persist(BankInternalOperation BankInternalOperation) {
        BankInternalOperation.persist(BankInternalOperation);
        return BankInternalOperation;
    }

    @Override
    public List<BankInternalOperation> listAll() {
        return BankInternalOperation.listAll();
    }

    @Override
    public Optional<BankInternalOperation> findById(Long id) {
        return BankInternalOperation.findByIdOptional(id);
    }

    @Override
    public void deleteById(Long id) {
        BankInternalOperation.deleteById(id);
    }
}
