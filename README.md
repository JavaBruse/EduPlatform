# EduPlatform - Система управления онлайн-обучением
### Архитектурные слои:
- **Controllers** - REST API endpoints
- **Services** - Бизнес-логика приложения
- **Repositories** - Доступ к данным (Spring Data JPA)
- **Entities** - Модели данных (JPA сущности)
- **Resources** - Конфигурация и миграции БД
## Maven профили и команды для сборки

### 1. Разработка:

```bash
mvn clean install
```

### 2. Тестирование с H2:

```bash
mvn clean install -P test
```

### 3. Продакшен сборка:

```bash
mvn clean install -P prod
```

### 4. Интеграционные тесты:

```bash
mvn verify -P integration-test
```

### 5. Запуск с определенным профилем:

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

### 6.  Развернуть ранее собранное приложение в Docker контейнере

```shell
docker-compose up -d
```

## API Endpoints

### Пользователи

- `GET /api/users` - Получить всех пользователей
- `GET /api/users/{id}` - Получить пользователя по ID
- `GET /api/users/email/{email}` - Получить пользователя по email
- `POST /api/users` - Создать пользователя
- `PUT /api/users/{id}` - Обновить пользователя
- `DELETE /api/users/{id}` - Удалить пользователя

### Категории

- `GET /api/categories` - Получить все категории
- `GET /api/categories/{id}` - Получить категорию по ID
- `GET /api/categories/name/{name}` - Получить категорию по имени
- `POST /api/categories` - Создать категорию
- `PUT /api/categories/{id}` - Обновить категорию
- `DELETE /api/categories/{id}` - Удалить категорию

### Курсы

- `GET /api/courses` - Получить все курсы
- `GET /api/courses/{id}` - Получить курс по ID
- `GET /api/courses/teacher/{teacherId}` - Получить курсы преподавателя
- `GET /api/courses/category/{categoryId}` - Получить курсы по категории
- `GET /api/courses/category/name/{categoryName}` - Получить курсы по названию категории
- `POST /api/courses` - Создать курс
- `PUT /api/courses/{id}` - Обновить курс
- `DELETE /api/courses/{id}` - Удалить курс

### Записи на курсы

- `GET /api/enrollments` - Получить все записи
- `GET /api/enrollments/{id}` - Получить запись по ID
- `GET /api/enrollments/student/{studentId}` - Получить записи студента
- `GET /api/enrollments/course/{courseId}` - Получить записи на курс
- `GET /api/enrollments/student/{studentId}/course/{courseId}` - Получить запись студента на курс
- `POST /api/enrollments` - Создать запись на курс
- `PUT /api/enrollments/{id}` - Обновить запись
- `DELETE /api/enrollments/{id}` - Удалить запись

### Модули курсов

- `GET /api/modules` - Получить все модули
- `GET /api/modules/{id}` - Получить модуль по ID
- `GET /api/modules/course/{courseId}` - Получить модули курса
- `POST /api/modules` - Создать модуль
- `PUT /api/modules/{id}` - Обновить модуль
- `DELETE /api/modules/{id}` - Удалить модуль

### Уроки

- `GET /api/lessons` - Получить все уроки
- `GET /api/lessons/{id}` - Получить урок по ID
- `GET /api/lessons/module/{moduleId}` - Получить уроки модуля
- `POST /api/lessons` - Создать урок
- `PUT /api/lessons/{id}` - Обновить урок
- `DELETE /api/lessons/{id}` - Удалить урок

### Задания

- `GET /api/assignments` - Получить все задания
- `GET /api/assignments/{id}` - Получить задание по ID
- `POST /api/assignments` - Создать задание
- `PUT /api/assignments/{id}` - Обновить задание
- `DELETE /api/assignments/{id}` - Удалить задание

### Отправки работ

- `GET /api/submissions` - Получить все отправки работ
- `GET /api/submissions/{id}` - Получить отправку по ID
- `GET /api/submissions/assignment/{assignmentId}` - Получить отправки по заданию
- `GET /api/submissions/student/{studentId}` - Получить отправки студента
- `GET /api/submissions/assignment/{assignmentId}/student/{studentId}` - Получить отправку студента по заданию
- `POST /api/submissions` - Создать отправку работы
- `PUT /api/submissions/{id}` - Обновить отправку
- `DELETE /api/submissions/{id}` - Удалить отправку

### Тесты

- `GET /api/quizzes` - Получить все тесты
- `GET /api/quizzes/{id}` - Получить тест по ID
- `GET /api/quizzes/module/{moduleId}` - Получить тест модуля
- `POST /api/quizzes` - Создать тест
- `PUT /api/quizzes/{id}` - Обновить тест
- `DELETE /api/quizzes/{id}` - Удалить тест

### Вопросы тестов

- `GET /api/questions` - Получить все вопросы
- `GET /api/questions/{id}` - Получить вопрос по ID
- `GET /api/questions/quiz/{quizId}` - Получить вопросы теста
- `POST /api/questions` - Создать вопрос
- `PUT /api/questions/{id}` - Обновить вопрос
- `DELETE /api/questions/{id}` - Удалить вопрос

### Варианты ответов

- `GET /api/answer-options` - Получить все варианты ответов
- `GET /api/answer-options/{id}` - Получить вариант ответа по ID
- `GET /api/answer-options/question/{questionId}` - Получить варианты ответов вопроса
- `POST /api/answer-options` - Создать вариант ответа
- `PUT /api/answer-options/{id}` - Обновить вариант ответа
- `DELETE /api/answer-options/{id}` - Удалить вариант ответа

### Отправки тестов

- `GET /api/quiz-submissions` - Получить все отправки тестов
- `GET /api/quiz-submissions/{id}` - Получить отправку теста по ID
- `GET /api/quiz-submissions/student/{studentId}` - Получить отправки тестов студента
- `GET /api/quiz-submissions/quiz/{quizId}` - Получить отправки по тесту
- `GET /api/quiz-submissions/quiz/{quizId}/student/{studentId}` - Получить отправку студента по тесту
- `POST /api/quiz-submissions` - Создать отправку теста
- `PUT /api/quiz-submissions/{id}` - Обновить отправку теста
- `DELETE /api/quiz-submissions/{id}` - Удалить отправку теста

### Отзывы о курсах

- `GET /api/reviews` - Получить все отзывы
- `GET /api/reviews/{id}` - Получить отзыв по ID
- `GET /api/reviews/course/{courseId}` - Получить отзывы по курсу
- `GET /api/reviews/student/{studentId}` - Получить отзывы студента
- `POST /api/reviews` - Создать отзыв
- `PUT /api/reviews/{id}` - Обновить отзыв
- `DELETE /api/reviews/{id}` - Удалить отзыв

## Структура проекта
```markdown
EduPlatform/
├── src/
│ ├── main/
│ │ ├── java/ru/javabruse/
│ │ │ ├── controllers/ # REST контроллеры
│ │ │ ├── entity/ # Сущности БД
│ │ │ │ ├── EntityAbstract.java # Базовый класс сущностей
│ │ │ │ ├── User.java # Пользователи
│ │ │ │ ├── Course.java # Курсы
│ │ │ │ ├── Category.java # Категории
│ │ │ │ ├── CourseModule.java # Модули курсов
│ │ │ │ ├── Lesson.java # Уроки
│ │ │ │ ├── Assignment.java # Задания
│ │ │ │ ├── Submission.java # Отправки работ
│ │ │ │ ├── Quiz.java # Тесты
│ │ │ │ ├── Question.java # Вопросы
│ │ │ │ ├── AnswerOption.java # Варианты ответов
│ │ │ │ ├── QuizSubmission.java # Отправки тестов
│ │ │ │ ├── Enrollment.java # Записи на курсы
│ │ │ │ ├── CourseReview.java # Отзывы
│ │ │ │ ├── Profile.java # Профили пользователей
│ │ │ │ ├── Material.java # Учебные материалы
│ │ │ │ ├── Notification.java # Уведомления
│ │ │ │ ├── CourseSchedule.java # Расписания
│ │ │ │ ├── Tag.java # Теги
│ │ │ │ └── UserRole.java # Роли пользователей
│ │ │ ├── repositories/ # Репозитории Spring Data JPA
│ │ │ └── services/ # Бизнес-логика
│ │ └── resources/
│ │ ├── application.yml # Основная конфигурация
│ │ ├── application-dev.yml # Конфиг для разработки
│ │ ├── application-prod.yml # Конфиг для продакшена
│ │ ├── application-test.yml # Конфиг для тестирования
│ │ ├── .env.example # Шаблон переменных окружения
│ │ └── db/migration/ # Миграции базы данных
│ │ ├── V1__addSchema.sql
│ │ └── V2__insert.sql
│ └── test/
│   └── java/ru/javabruse/ # Тесты
├── target/ # Собранные артефакты
├── docker-compose.yml # Docker Compose для запуска
├── Dockerfile # Конфигурация Docker образа
├── pom.xml # Maven конфигурация
└── README.md # Документация проекта
```
