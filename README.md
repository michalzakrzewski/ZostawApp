# Zostaw tu!
## Spis treści
* [O aplikacji](#o-aplikacji)
* [Technologie](#technologie)
* [Działanie](#działanie)

## O aplikacji
Aplikacja - API REST - bazujaca na CRUD, która umozliwia dodawanie użytkowników oraz ogłoszeń w zależności od roli.
	
## Technologie
Wykorzystane technologie
* IntelliJ IDEA
* Spring-Boot
* Sourcetree(git)

## Działanie
Aplikacja posiada dwóch domyślnych użytkowników:
* Admin (admin/test)
* User (user/test)

Admin posiada dostęp do:
* localhost:8080/api/get/all-users - wyświetlenie pełnych informacji na temat użytkowników
* localhost:8080/api/get/user/{id} - wyświetlenie konkretnego użytkownika, gdzie id to identyfikator uzytkownika (1, 2, 3,...., n)
* localhost:8080/api/add-user - możliwość dodania użytkownika
* localhost:8080/api/edit-user/{id} - edycja użytkownika, gdzie id to identyfikator uzytkownika (1, 2, 3,...., n)
* localhost:8080/api/delete-user/{id} - usuwanie użytkownika, gdzie id to identyfikator uzytkownika (1, 2, 3,...., n)
* localhost:8080/api/edit-advertisement/{id} - edycja ogłoszenia, gdzie id to identyfikator uzytkownika (1, 2, 3,...., n)
* localhost:8080/api/delete-advertisement/{id} - usunięcie ogłoszenia, gdzie id to identyfikator uzytkownika (1, 2, 3,...., n)

User posiada dostęp do:
* localhost:8080/api/get/users - wyświetlenie ograniczone informacje na temat użytkowników
* localhost:8080/api/add-advertisement - dodanie ogłoszenia

Każdy posiada dostęp do:
* localhost:8080/api/get/users - wyświetlenie ograniczonych informacji o użytkowniku
* localhost:8080/api/get/advertisement-user/{signature} - wyświetlenie ogłoszenia konkretnego uzytkownika, gdzie signature to podpis użytkownika
* localhost:8080/api/get/all-advertisement - wyświetlenie informacji o wszystkich 
* localhost:8080/api/get/advertisement/{id} - wyświetlenie informacji o konkretnym ogłoszeniu po Id
 
  


  
