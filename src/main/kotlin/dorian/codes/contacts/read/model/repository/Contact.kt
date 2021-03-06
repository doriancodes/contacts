package dorian.codes.contacts.read.model.repository

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("contacts")
data class Contact(
    @Id var id: Long? = null,
    val firstName: String,
    val lastName: String,
    val prefix: Long?,
    val phoneNumber: Long,
    val email: String?
)
