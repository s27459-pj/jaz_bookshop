# TODO

1. [ ] Moduł `api-gen`
   - [x] Generowanie API ze specyfikacji openapi
   - [ ] Specyfikacja API
     - [ ] Endpointy
     - [ ] Modele
     - [ ] Modele do obsługi błędów
2. [ ] Moduł `bookshop`
   - [ ] Model książki
     - Autor (fk)
     - Gatunek
     - Cena
     - Ilość stron
     - Licznik odwiedzin
     - Ilość dostępnych sztuk
   - [ ] Operacje na książkach
     - [ ] Dodawanie (admin)
     - [ ] Usuwanie (admin)
     - [ ] Edytowanie (admin)
     - [ ] Wyświetlanie
     - [ ] Filtrowanie
     - [ ] Kupowanie
   - [ ] Dodawanie/usuwanie/edytowanie tylko dla adminów
   - [ ] Wyświetlenie książki (jako lista lub filtrując) powinno zwiększyć jej ilość odwiedzin
   - [ ] Endpoint `order-report` (admin) do wysyłania książek na `/orders` w module `book-order`
3. [ ] Moduł `book-order`
   - [ ] Endpoint POST `/orders`
     - [ ] Przyjmuje `{id, name, visits}[]`
     - [ ] Dla każdych 10 odwiedzin zapisuje zamówienie do DB: `{id, amount}`
   - [ ] Endpoint GET `/print` do generowania zamówienia w formacie pdf
4. [ ] Walidacja danych
5. [ ] Obsługa błędów
6. [ ] Testy jednostkowe

