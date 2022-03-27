package dorian.codes.contacts.write.model.repository

import dorian.codes.contacts.api.ApiContact
import dorian.codes.contacts.write.model.service.Event
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Embedded
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("contact_logs")
data class ContactLog(
    @Id var id: Long? = null,
    val contactId: Long,
    val event: Event,
    val createdAt: LocalDateTime,
    @Embedded.Empty
    val contact: ApiContact
)
