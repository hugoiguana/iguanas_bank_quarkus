package br.com.iguana.services;

import br.com.iguana.entities.BankAccountType;
import br.com.iguana.exceptions.BussinesNotFoundEntityException;
import br.com.iguana.repositories.IBankAccountTypeRepository;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class BankAccountTypeService implements IBankAccountTypeService {

    private static final Logger LOGGER = Logger.getLogger(BankAccountTypeService.class);

    @Inject
    private IBankAccountTypeRepository repository;


    @Override
    public BankAccountType insert(@Valid BankAccountType bankAccountType) {
        LOGGER.info("Persisting a Bank Account Type");

        repository.persist(bankAccountType);
        return bankAccountType;
    }

    @Override
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<BankAccountType> findAll() {
        LOGGER.info("Listing all Bank Accounts Type");
        return repository.listAll();
    }

    @Override
    @Transactional(Transactional.TxType.SUPPORTS)
    public Optional<BankAccountType> findById(Long id) {
        LOGGER.info("Listing Bank Accounts Type with id : " + id);
        return repository.findById(id);
    }

    @Override
    public BankAccountType update(@Valid BankAccountType bm) {
        LOGGER.info("Updating Bank Accounts Type with id : " + bm.toString());

        BankAccountType bmNew = (BankAccountType) BankAccountType.findByIdOptional(bm.id)
                .orElseThrow(() -> new BussinesNotFoundEntityException("Bank Account Type", bm.id));

        bmNew.loadToUpdate(bm);
        return bmNew;
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("Deleting Bank Accounts Type with id : " + id);
        repository.deleteById(id);
    }

}
