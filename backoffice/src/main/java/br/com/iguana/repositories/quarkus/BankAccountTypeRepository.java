package br.com.iguana.repositories.quarkus;

import br.com.iguana.entities.BankAccountType;
import br.com.iguana.repositories.IBankAccountTypeRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class BankAccountTypeRepository implements IBankAccountTypeRepository {

    @Inject
    private EntityManager em;

    @Override
    public BankAccountType persist(BankAccountType bankAccountType) {
        bankAccountType.persist(bankAccountType);
        return bankAccountType;
    }

    @Override
    public List<BankAccountType> listAll() {
        return BankAccountType.listAll();
    }

    @Override
    public Optional<BankAccountType> findById(Long id) {
        return BankAccountType.findByIdOptional(id);
    }

    @Override
    public BankAccountType update(BankAccountType bankAccountType) {
        return em.merge(bankAccountType);
    }

    @Override
    public void deleteById(Long id) {
        BankAccountType.deleteById(id);
    }
}
