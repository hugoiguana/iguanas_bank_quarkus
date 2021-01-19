package br.com.iguana.services;

import br.com.iguana.entities.BankManager;
import br.com.iguana.repositories.IBankManagerRepository;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class BankManagerService {

    private static final Logger LOGGER = Logger.getLogger(BankManagerService.class);

    private IBankManagerRepository repository;

    public BankManagerService (IBankManagerRepository repository) {
        this.repository = repository;
    }

    public BankManager insert(@Valid BankManager bankManager) {
        LOGGER.info("Persisting a bank manager");
        repository.persist(bankManager);
        return bankManager;
    }

    @Transactional(Transactional.TxType.SUPPORTS)
    public List<BankManager> findAll() {
        LOGGER.info("Listing all bank managers");
        return repository.listAll();
    }

    @Transactional(Transactional.TxType.SUPPORTS)
    public Optional<BankManager> findById(Long id) {
        LOGGER.info("Listing Bank managers with id : " + id);
        return repository.findById(id);
    }

    public BankManager update(@Valid BankManager book) {
        LOGGER.info("Updating Bank managers with id : " + book.toString());
        BankManager entity = repository.update(book);
        return entity;
    }

    public void delete(Long id) {
        LOGGER.info("Deleting Bank managers with id : " + id);
        repository.deleteById(id);
    }

}
