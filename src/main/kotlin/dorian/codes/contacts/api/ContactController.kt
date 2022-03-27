package dorian.codes.contacts.api

import dorian.codes.contacts.repository.read.model.ContactRepository
import dorian.codes.contacts.repository.write.model.ContactLog
import dorian.codes.contacts.service.ContactLogService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ContactController(val contactRepository: ContactRepository, val contactLogService: ContactLogService) {

    @GetMapping("/")
    fun hello() = ResponseEntity("hello", HttpStatus.OK)

    @GetMapping("/contacts")
    fun findAll() = ResponseEntity(contactRepository.findAll(), HttpStatus.OK)

    @GetMapping("/contacts/{lastName}")
    fun findByLastName(@PathVariable lastName: String) =
        ResponseEntity(contactRepository.findByLastName(lastName), HttpStatus.OK)

    @PostMapping("/contacts")
    fun create(@RequestBody contact: ApiContact): ResponseEntity<ContactLog> {
        println(contact)

        return ResponseEntity(contactLogService.createCommand(contact), HttpStatus.CREATED)
    }
}