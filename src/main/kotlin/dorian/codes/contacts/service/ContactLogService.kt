package dorian.codes.contacts.service

import dorian.codes.contacts.api.ApiContact
import dorian.codes.contacts.repository.read.model.Contact
import dorian.codes.contacts.repository.read.model.ContactRepository
import dorian.codes.contacts.repository.write.model.ContactLog
import dorian.codes.contacts.repository.write.model.ContactLogRepository
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class ContactLogService(val contactLogRepository: ContactLogRepository, val contactRepository: ContactRepository) {

    fun createCommand(contact: ApiContact): ContactLog {
        val contactLog = contactLogRepository.save(
            ContactLog(event = Event.CREATE, createdAt = LocalDateTime.now(), contact = contact)
        )
        contactRepository.save(contactLog.toContact())
        return contactLog
    }


    fun updateCommand(contact: ApiContact) =
        contactLogRepository.save(
            ContactLog(event = Event.UPDATE, createdAt = LocalDateTime.now(), contact = contact)
        )
}

private fun ContactLog.toContact(): Contact =
    Contact(
        eventId = id!!,
        firstName = contact.firstName,
        lastName = contact.lastName,
        prefix = contact.prefix,
        phoneNumber = contact.phoneNumber,
        email = contact.email
    )



enum class Event {
    CREATE, UPDATE, DELETE
}