package br.com.iguana.services;

import br.com.iguana.entities.BankAccount;
import br.com.iguana.entities.BankAccountType;
import br.com.iguana.entities.UserSystem;
import br.com.iguana.exceptions.BussinesNotFoundEntityException;
import br.com.iguana.repositories.IBankAccountRepository;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class BankAccountService implements IBankAccountService {

    private static final Logger LOGGER = Logger.getLogger(BankAccountService.class);

    @Inject
    private IBankAccountRepository repository;

    @Inject
    private IUserSystemService userSystemService;

    @Inject
    private IBankAccountTypeService bankAccountTypeService;


    @Override
    public BankAccount insert(@Valid BankAccount bankAccount) {
        LOGGER.info("Persisting a Bank Account");

        UserSystem customer = userSystemService.findById(bankAccount.customer.id)
                .orElseThrow(() -> new BussinesNotFoundEntityException("Customer", bankAccount.customer.id));

        UserSystem manager = userSystemService.findById(bankAccount.manager.id)
                .orElseThrow(() -> new BussinesNotFoundEntityException("Manager", bankAccount.manager.id));

        BankAccountType accountType = bankAccountTypeService.findById(bankAccount.type.id)
                .orElseThrow(() -> new BussinesNotFoundEntityException("Bank Account Type", bankAccount.type.id));

        bankAccount.customer = customer;
        bankAccount.manager = manager;
        bankAccount.type = accountType;
        bankAccount.active = true;
        bankAccount.accountCode = "123456";
        bankAccount.accountCodeDv = "9";
        bankAccount.agencyCode = "1234";
        bankAccount.agencyCodeDv = "99";

        repository.persist(bankAccount);

        return bankAccount;
    }

    @Override
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<BankAccount> findAll() {
        LOGGER.info("Listing all Bank Accounts");
        return repository.listAll();
    }

    @Override
    @Transactional(Transactional.TxType.SUPPORTS)
    public Optional<BankAccount> findById(Long id) {
        LOGGER.info("Listing Bank Accounts with id : " + id);
        return repository.findById(id);
    }

    @Override
    public BankAccount update(@Valid BankAccount bm) {
        LOGGER.info("Updating Bank Accounts with id : " + bm.toString());

        BankAccount bmNew = (BankAccount) BankAccount.findByIdOptional(bm.id)
                .orElseThrow(() -> new BussinesNotFoundEntityException("Bank Account", bm.id));

        bmNew.loadToUpdate(bm);
        return bmNew;
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("Deleting Bank Accounts with id : " + id);
        repository.deleteById(id);
    }

}
