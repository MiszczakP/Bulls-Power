# Bulls-Power

## Lista dostępnych komend:

- start
- stop
- report
- continue
- list
- last
- current
- -h
- -f

1. start
	start nazwa_projektu nazwa_zadania
rozpoczyna naliczanie czasu pracy nad wskazanym zadaniem w projekcie.
Po słowie start należy podać nazwę projektu oraz nazwę zadania.
Uruchomienie nowego zadania automatycznie kończy aktywność bieżącego zadania.
Po uruchomieniu komendy konsola wyświetla godzinę oraz datę rozpoczęcia zadania.

2. stop
kończy naliczanie czasu dla bieżącego zadania.
Po uruchomieniu komendy konsola wyświetla godzinę oraz datę zakońćzenia zadania.

3. report
	report -p nazwa_projektu
wyświetla liczbę godzin przepracowanych nad danym projektem.
	report -p nazwa_projektu okres_czasu
wyświetla liczbę godzin przepracowanych w danym czasie
	report -d okres_czasu
wyświetla liczbę godzin przepracowanych nad danym projektem w danym czasie.

4. continue
	continue
wywołuje komendę start na zadaniu, nad którym ostatnio pracowaliśmy
	continue identyfikator_zadania
wywołuje komendę start na zadaniu wskazanym poprzez identyfikator

5. list
	list
wypisuje wszystkie aktywności
	list okres_czasu
wypisuje wszystkie aktywności dla wskazanego okresu czasu

6. last
wypisuje tabelę wyświetlającą 9 ostatnich zadań. Możliwość kontynuowania pracy nad którymś z zadań za pomocą continue

7. current
wskazuje aktualnie wykonywane zadanie

8. -h
	-h
wypisuje listę dostępnych komend
	nazwa_komendy -h
wyświetla informacje o danej komendzie, m.in. przyjmowane argumenty

9. -f
	-f ścieżka_pliku
możliwość wskazania pliku, do którego mają się zapisywać dane.
