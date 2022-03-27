package dorian.codes.contacts.write.model.service

import dorian.codes.contacts.api.ApiContact
import dorian.codes.contacts.read.model.repository.Contact
import dorian.codes.contacts.read.model.repository.ContactRepository
import dorian.codes.contacts.write.model.repository.ContactLog
import dorian.codes.contacts.write.model.repository.ContactLogRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class ContactLogService(val contactLogRepository: ContactLogRepository, val contactRepository: ContactRepository) {

    fun createCommand(apiContact: ApiContact): ContactLog {
        val contact = contactRepository.save(apiContact.toContact())

        val contactLog = contactLogRepository.save(
            ContactLog(
                contactId = contact.id!!,
                event = Event.CREATE,
                createdAt = LocalDateTime.now(),
                contact = apiContact
            )
        )
        return contactLog
    }


    fun updateCommand(id: Long, apiContact: ApiContact): ContactLog? {
        return contactRepository.findByIdOrNull(id).let {
            contactRepository.save(
                Contact(
                    id = id,
                    firstName = apiContact.firstName,
                    lastName = apiContact.lastName,
                    prefix = apiContact.prefix,
                    phoneNumber = apiContact.phoneNumber,
                    email = apiContact.email
                )
            )
            contactLogRepository.save(
                ContactLog(
                    contactId = id,
                    event = Event.UPDATE,
                    createdAt = LocalDateTime.now(),
                    contact = apiContact
                )
            )
        }
    }

    fun deleteCommand(id: Long) {
        val foundContact = contactRepository.findByIdOrNull(id)

        foundContact?.let { contact ->
            contactRepository.deleteById(id).also {
                contactLogRepository.save(
                    ContactLog(
                        contactId = contact.id!!,
                        event = Event.DELETE,
                        createdAt = LocalDateTime.now(),
                        contact = ApiContact(
                            firstName = contact.firstName,
                            lastName = contact.lastName,
                            prefix = contact.prefix,
                            phoneNumber = contact.phoneNumber,
                            email = contact.email
                        )
                    )
                )
            }
        }
    }
}

private fun ApiContact.toContact(): Contact = Contact(
    firstName = firstName,
    lastName = lastName,
    prefix = prefix,
    phoneNumber = phoneNumber,
    email = email
)

private fun ContactLog.toContact(): Contact =
    Contact(
        firstName = contact.firstName,
        lastName = contact.lastName,
        prefix = contact.prefix,
        phoneNumber = contact.phoneNumber,
        email = contact.email
    )


enum class Event {
    CREATE, UPDATE, DELETE
}