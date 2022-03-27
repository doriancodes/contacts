package dorian.codes.contacts.repository.write.model

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ContactLogRepository : CrudRepository<ContactLog, Long> {

}