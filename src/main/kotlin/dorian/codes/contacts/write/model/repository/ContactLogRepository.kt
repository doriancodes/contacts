package dorian.codes.contacts.write.model.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ContactLogRepository : CrudRepository<ContactLog, Long> {

}