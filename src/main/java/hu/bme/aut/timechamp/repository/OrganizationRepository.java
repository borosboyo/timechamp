package hu.bme.aut.timechamp.repository;

import hu.bme.aut.timechamp.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Organization save(Organization org);

    List<Organization> findByName(String name);

    void delete(Organization org);
}