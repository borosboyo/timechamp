package hu.bme.aut.timechamp.repository;

import hu.bme.aut.timechamp.model.Organization;
import java.util.List;

public interface OrganizationRepository {
    Organization save(Organization org);

    List<Organization> findByName(String name);

    void delete(Organization org);
}
