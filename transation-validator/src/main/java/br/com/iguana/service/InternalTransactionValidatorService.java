package br.com.iguana.service;

import br.com.iguana.entities.InternalTransactionValidator;
import br.com.iguana.repository.ITransactionValidatorRepository;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class InternalTransactionValidatorService implements IInternalTransactionValidatorService {

    private static final Logger LOGGER = Logger.getLogger(IInternalTransactionValidatorService.class);

    @Inject
    private ITransactionValidatorRepository repository;

    @Override
    public InternalTransactionValidator insert(@Valid InternalTransactionValidator transactionValidator) {
        LOGGER.info("Persisting a Transaction Validator");

        transactionValidator.isValid = Boolean.TRUE;
        transactionValidator.key = "çlsjdpghfdghpfdjgpofk46546546FDFDF"; //todo: Generate a key

        return repository.persist(transactionValidator);
    }

    @Override
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<InternalTransactionValidator> findAll() {
        LOGGER.info("Listing all Transactions Validator");
        return repository.listAll();
    }

    @Override
    @Transactional(Transactional.TxType.SUPPORTS)
    public Optional<InternalTransactionValidator> findById(Long id) {
        LOGGER.info("Listing Transaction Validator with id : " + id);
        return repository.findById(id);
    }
}
