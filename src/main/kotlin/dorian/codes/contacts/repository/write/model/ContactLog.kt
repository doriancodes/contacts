package dorian.codes.contacts.repository.write.model

import dorian.codes.contacts.api.ApiContact
import dorian.codes.contacts.service.Event
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Embedded
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("contact_logs")
data class ContactLog(
    @Id var id: Long? = null,
    val event: Event,
    val createdAt: LocalDateTime,
    @Embedded.Empty
    val contact: ApiContact
)
