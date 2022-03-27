# Contacts

A simple contact service to add, modify and delete contacts.

Instead of designing this service according CRUD principles, like this:

- Create a contact
- Read contacts by surname
- Update a contact
- Delete a contact

I designed the service to follow the Command Query Responsibility Segregation model (CQRS), imagining a scenario in 
which I start refactoring from a CRUD service. 

This first project doesn't use Event Sourcing and makes use of a single DB (postgres) as single source of truth.



