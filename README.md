## PPKWU - Programowanie pod kątem wielokrotnego użycia

## Laboratorium 3

API generuje kalendarz w formacie ICS/iCal dla kalendarza ze strony http://www.weeia.p.lodz.pl. 

**ICS** jest to uniwersalny format kalendarza używany przez kilka programów poczty elektronicznej i kalendarza, w tym Microsoft Outlook, Kalendarz Google i Apple iCal. Umożliwia on użytkownikom publikować i udostępniać informacje kalendarza w internecie oraz e-mail i jest używany do wysyłania zaproszeń na spotkania z innymi użytkownikami, którzy mogą importować wydarzenia z ich własnych kalendarzy. W **iCalendar** pliki są zapisywane w zwykłym formacie tekstowym. Zawierają one informacje, takie jak: tytuł, streszczenia, czas rozpoczęcia i czas zakończenia dla zdarzenia. iCalendar pozwala użytkownikom wymieniać między sobą dane kalendarzowe, czyli informacje o terminach (np. datach spotkań – w celu ustalenia pasującego czasu i miejsca) i zadaniach do wykonania – np. przesyłając je za pośrednictwem poczty elektronicznej. Odbiorca wiadomości z danymi iCalendar (za pomocą odpowiedniego programu) może natychmiast łatwo odpowiedzieć – zaakceptować termin lub zaproponować inny.

## Opis zadań
| Metoda | Ścieżka                     | Parametr         | Opis                                                             |
|--------|-----------------------------|------------------|------------------------------------------------------------------|
| GET    | /weeiaCalendar/             | {year}/{month}   | Zwraca kalendarz w formacie ics z wydarzeniami z danego miesiąca |

## Przykład użycia
```
http://http://localhost:8080/weeiaCalendar/2019/11
```
W odpowiedzi dostaniemy plik w formacie ".ics" dla listopada z wydarzeniami w ciągu tego miesiąca.
