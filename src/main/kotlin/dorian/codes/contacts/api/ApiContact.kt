package dorian.codes.contacts.api

data class ApiContact(
    val firstName: String,
    val lastName: String,
    val prefix: Long?,
    val phoneNumber: Long,
    val email: String?
)
