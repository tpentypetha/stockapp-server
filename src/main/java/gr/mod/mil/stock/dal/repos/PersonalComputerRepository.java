package gr.mod.mil.stock.dal.repos;


import gr.mod.mil.stock.dal.model.devices.DeviceStatus;
import gr.mod.mil.stock.dal.model.devices.PersonalComputer;
import gr.mod.mil.stock.dal.model.devices.PersonalComputerDomain;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalComputerRepository extends DeviceRepository<PersonalComputer, Long> {

    PersonalComputer findByPublicid(String publicid);

    @Query( "SELECT P.domain, P.status, count(P.id) as total " +
            "FROM PersonalComputer P " +
            "GROUP BY P.domain, P.status")
    List<Object[]> getDomainStausMatrix();

    @Query( "SELECT P " +
            "FROM PersonalComputer P " +
            "WHERE P.domain = :domain " +
            "AND P.status = :status")
    List<PersonalComputer> getComputerByDomainAndStatus(@Param("domain") PersonalComputerDomain domain, @Param("status") DeviceStatus status);


}
