# Інструкція по установці PostgreSQL у Docker

## Крок 1. Завантаження образу PostgreSQL

```bash
docker pull postgres
```

Ця команда завантажить останню версію образу PostgreSQL з Docker Hub.

## Крок 2. Запуск контейнера PostgreSQL

```bash
docker run --name horchynskyi-postgres -p 5455:5432 -e POSTGRES_PASSWORD=2004 -w /scripts -v /${PWD}:/scripts -d --rm postgres
```

Ця команда запустить контейнер PostgreSQL з такими параметрами\:
  * --name horchynskyi-postgres: задає ім'я контейнера як "horchynskyi-postgres".
  * -p 5455:5432: прокидує порт 5455 з хоста на порт 5432 у контейнері.
  * -e POSTGRES_PASSWORD=2004: встановлює пароль для користувача "postgres".
  * -w /scripts: встановлює робочу директорію всередині контейнера як "/scripts".
  * -v /${PWD}:/scripts: мапить поточну директорію хоста у директорію "/scripts" всередині контейнера.

## Крок 3. Запуск оболонки Bash в контейнері

```bash
winpty docker exec -it horchynskyi-postgres bash
```

Ця команда запустить інтерактивну оболонку Bash у контейнері "horchynskyi-postgres". Winpty може знадобитися для коректного відображення вводу та виводу в середовищі Windows.

## Крок 4. Створення бази даних та виконання SQL-скрипта

```bash
createdb horchynskyi-db -U postgres
psql -U postgres -d horchynskyi-db < /scripts/db_script.sql
```

Ці команди створять базу даних "horchynskyi-db" і виконають SQL-скрипт, розташований за шляхом "/scripts/db_script.sql" всередині контейнера.

## Крок 5. Зупинка контейнера

```bash
docker stop horchynskyi-postgres
```

Ця команда зупинить контейнер "horchynskyi-postgres".
