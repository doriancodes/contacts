package dorian.codes.contacts.repository.read.model

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ContactRepository: CrudRepository<Contact, Long> {
    @Query("select * from contacts where last_name = :lastName")
    fun findByLastName(@Param("lastName") lastName: String): List<Contact>
}