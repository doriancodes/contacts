package dorian.codes.contacts.api

import dorian.codes.contacts.read.model.service.ContactService
import dorian.codes.contacts.write.model.repository.ContactLog
import dorian.codes.contacts.write.model.service.ContactLogService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ContactController(
    val contactService: ContactService,
    val contactLogService: ContactLogService
) {

    @GetMapping("/")
    fun hello() = ResponseEntity("hello", HttpStatus.OK)

    @GetMapping("/contacts")
    fun findAll() = ResponseEntity(contactService.findAll(), HttpStatus.OK)

    @GetMapping("/contacts/{lastName}")
    fun findByLastName(@PathVariable lastName: String) =
        ResponseEntity(contactService.findByLastName(lastName), HttpStatus.OK)

    @PostMapping("/contacts")
    fun create(@RequestBody contact: ApiContact): ResponseEntity<ContactLog> {
        return ResponseEntity(contactLogService.createCommand(contact), HttpStatus.CREATED)
    }

    @PutMapping("/contacts/{contactId}")
    fun update(@PathVariable contactId: Long, @RequestBody contact: ApiContact): ResponseEntity<ContactLog> {
        return ResponseEntity(contactLogService.updateCommand(contactId, contact), HttpStatus.OK)
    }

    @DeleteMapping("/contacts/{contactId}")
    fun delete(@PathVariable contactId: Long) =
        ResponseEntity(contactLogService.deleteCommand(contactId), HttpStatus.OK)
}