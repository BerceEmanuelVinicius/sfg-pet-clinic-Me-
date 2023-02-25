package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRespository;
import guru.springframework.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

    private final VisitRespository visitRespository;

    public VisitSDJpaService(VisitRespository visitRespository) {
        this.visitRespository = visitRespository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visitSet = new HashSet<>();
        visitRespository.findAll().forEach(visitSet::add);
        return visitSet;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRespository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRespository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRespository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRespository.deleteById(aLong);
    }
}
