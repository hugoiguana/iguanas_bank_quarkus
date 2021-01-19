package br.com.iguana.repositories.quarkus;

import br.com.iguana.entities.BankManager;
import br.com.iguana.repositories.IBankManagerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class BankManagerRepository implements IBankManagerRepository {

    @Inject
    private EntityManager em;

    @Override
    public BankManager persist(BankManager bankManager) {
        BankManager.persist(bankManager);
        return bankManager;
    }

    @Override
    public List<BankManager> listAll() {
        return BankManager.listAll();
    }

    @Override
    public Optional<BankManager> findById(Long id) {
        return BankManager.findByIdOptional(id);
    }

    @Override
    public BankManager update(BankManager book) {
        BankManager entity = em.merge(book);
        return entity;
    }

    @Override
    public void deleteById(Long id) {
        BankManager.deleteById(id);
    }
}
