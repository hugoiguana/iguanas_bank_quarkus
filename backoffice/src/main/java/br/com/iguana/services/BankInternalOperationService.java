package br.com.iguana.services;

import br.com.iguana.entities.BankInternalOperation;
import br.com.iguana.repositories.IBankInternalOperationRepository;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class BankInternalOperationService implements IBankInternalOperationService {

    private static final Logger LOGGER = Logger.getLogger(BankInternalOperationService.class);

    @Inject
    private IBankInternalOperationRepository repository;


    @Override
    public BankInternalOperation insert(@Valid BankInternalOperation operation) {
        LOGGER.info("Persisting a Bank Internal Operation");

        repository.persist(operation);
        return operation;
    }

    @Override
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<BankInternalOperation> findAll() {
        LOGGER.info("Listing all Bank Internal Operations");
        return repository.listAll();
    }

    @Override
    @Transactional(Transactional.TxType.SUPPORTS)
    public Optional<BankInternalOperation> findById(Long id) {
        LOGGER.info("Listing Bank Internal Operations with id : " + id);
        return repository.findById(id);
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("Deleting Bank Internal Operation with id : " + id);
        repository.deleteById(id);
    }

}
