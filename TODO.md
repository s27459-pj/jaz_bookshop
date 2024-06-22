# TODO

1. [x] Moduł `api-gen`
   - [x] Generowanie API ze specyfikacji openapi
   - [x] Specyfikacja API
     - [x] Endpointy
     - [x] Modele
     - [x] Modele do obsługi błędów
2. [ ] Moduł `bookshop`
   - [x] Model książki
     - Autor (fk)
     - Tytuł
     - Gatunek
     - Cena
     - Ilość stron
     - Licznik odwiedzin
     - Ilość dostępnych sztuk
   - [ ] Operacje na książkach
     - [x] Dodawanie (admin)
     - [x] Usuwanie (admin)
     - [x] Edytowanie (admin)
     - [x] Wyświetlanie
     - [ ] Filtrowanie
     - [ ] Kupowanie (zmniejsza dostępność o 1)
   - [ ] Dodawanie/usuwanie/edytowanie tylko dla adminów
   - [ ] Wyświetlenie książki (jako lista lub filtrując) powinno zwiększyć jej ilość odwiedzin
   - [ ] Endpoint `order-report` (admin) do wysyłania książek na `/orders` w module `book-order`
3. [ ] Moduł `book-order`
   - [ ] Endpoint POST `/orders`
     - [ ] Przyjmuje `{id, name, visits}[]`
     - [ ] Dla każdych 10 odwiedzin zapisuje zamówienie do DB: `{id, amount}`
   - [ ] Endpoint GET `/print` do generowania zamówienia w formacie pdf
4. [x] Walidacja danych
5. [x] Obsługa błędów
6. [ ] Testy jednostkowe

