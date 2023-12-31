## Крок 1. Запуск контейнера для компіляції Java-коду

```bash
docker run --name horchynskyi-java -w //kotlin -v /${PWD}://kotlin --rm openjdk javac Main.java
```
Ця команда запустить контейнер з образом OpenJDK і виконає такі дії\:
* Задасть ім'я контейнеру як "horchynskyi-java".
* Встановить робочу директорію всередині контейнера як "//kotlin".
* Мапуватиме поточну директорію на директорію "//kotlin" всередині контейнера.
* Автоматично видалить контейнер після завершення його роботи.
* Скомпілує Java-код з файлу "Main.java".

## Крок 2. Запуск контейнера для виконання Java\-коду

```bash
docker run --name horchynskyi-java -w //kotlin -v /${PWD}://kotlin --rm openjdk java -cp "postgresql-42.7.0.jar:." Main
```

Ця команда запустить контейнер з образом OpenJDK і виконає такі дії:

* Задасть ім'я контейнеру як "horchynskyi-java".
* Встановить робочу директорію всередині контейнера як "//kotlin".
* Мапуватиме поточну директорію на директорію "//kotlin" всередині контейнера.
* Автоматично видалить контейнер після завершення його роботи.
* Виконає Java-код, вказуючи клас "Main" та шлях до бібліотеки PostgreSQL "postgresql-42.7.0.jar".
