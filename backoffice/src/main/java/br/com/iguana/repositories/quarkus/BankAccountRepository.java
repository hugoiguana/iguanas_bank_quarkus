package br.com.iguana.repositories.quarkus;

import br.com.iguana.entities.BankAccount;
import br.com.iguana.repositories.IBankAccountRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class BankAccountRepository implements IBankAccountRepository {

    @Inject
    private EntityManager em;

    @Override
    public BankAccount persist(BankAccount BankAccount) {
        BankAccount.persist(BankAccount);
        return BankAccount;
    }

    @Override
    public List<BankAccount> listAll() {
        return BankAccount.listAll();
    }

    @Override
    public Optional<BankAccount> findById(Long id) {
        return BankAccount.findByIdOptional(id);
    }

    @Override
    public BankAccount update(BankAccount bm) {
        return em.merge(bm);
    }

    @Override
    public void deleteById(Long id) {
        BankAccount.deleteById(id);
    }
}
