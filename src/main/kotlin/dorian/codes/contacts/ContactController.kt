package dorian.codes.contacts

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ContactController(val contactRepository: ContactRepository) {

    @GetMapping("/")
    fun hello() = ResponseEntity("hello", HttpStatus.OK)

    @GetMapping("/contacts")
    fun findAll() = ResponseEntity(contactRepository.findAll(), HttpStatus.OK)

}