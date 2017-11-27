# Renovation-Man-API
API de gestion d'utilisateurs et de documents pour l'entreprise Renovation Man

## URL
- [POST /users] - Create a new user, company or person
- [POST /users/{:user_id}] - Modify a user, company or person. Should return the previous version of the person
- [GET /users] - List all users, be they persons or companies
- [GET /users/companies] - List all users that are companies
- [GET /users/persons] - List all users that are persons
- [GET /users/{user_id}] - Get the details of that particular user, whether a person or company
- [POST /docs] - Create a new document at version number 1
- [POST /docs/{doc_id}] - Create a new version of the document of that particular id
- [GET /docs] - List all docs (including the text of the latest version)
- [GET /docs/created_by/{user_id}] - List all docs (including the text of the latest version) created by this user. Do not include documents that have been modified by this author.
- [GET /docs/created_or_modified_by/{user_id}] - List all docs modified by that particular user id
- [GET /docs/{doc_id}] - Get the details of the latest version of a document
- [GET /docs/{doc_id}/versions] - List all the versions of the document, in reverse order