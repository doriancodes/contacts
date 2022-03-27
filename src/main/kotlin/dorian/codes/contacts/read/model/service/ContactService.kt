package dorian.codes.contacts.read.model.service

import dorian.codes.contacts.api.ApiContact
import dorian.codes.contacts.read.model.repository.Contact
import dorian.codes.contacts.read.model.repository.ContactRepository
import org.springframework.stereotype.Component

@Component
class ContactService(val contactRepository: ContactRepository) {

    fun findByLastName(lastName: String): List<ApiContact> {
        return contactRepository.findByLastName(lastName).map { contact -> contact.toApiContact() }
    }

    fun findAll() = contactRepository.findAll().map { contact -> contact.toApiContact() }
}

private fun Contact.toApiContact() = ApiContact(firstName, lastName, prefix, phoneNumber, email)
