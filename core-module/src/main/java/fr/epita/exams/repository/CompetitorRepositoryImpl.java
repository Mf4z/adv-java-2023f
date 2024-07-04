package fr.epita.exams.repository;

import fr.epita.exams.datamodel.Competitor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class CompetitorRepositoryImpl implements CompetitorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createCompetitor(Competitor competitor) {
        entityManager.persist(competitor);
    }
}
