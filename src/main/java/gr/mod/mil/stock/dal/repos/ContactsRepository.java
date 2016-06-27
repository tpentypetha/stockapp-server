package gr.mod.mil.stock.dal.repos;


import gr.mod.mil.stock.dal.model.stock.Contacts;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;




    @Repository
    public interface ContactsRepository extends CrudRepository<Contacts, String> {

        @Query( "SELECT C " +
                "FROM Contacts C " +
                "WHERE C.phone = :id")
        Contacts findbyId(@Param("id") String id);
}
