INSERT INTO categories (created_at, updated_at, name) VALUES
(NOW(), NOW(), 'Программирование'),
(NOW(), NOW(), 'Математика'),
(NOW(), NOW(), 'Физика'),
(NOW(), NOW(), 'Иностранные языки'),
(NOW(), NOW(), 'Дизайн');

INSERT INTO tags (created_at, updated_at, name) VALUES
(NOW(), NOW(), 'Java'),
(NOW(), NOW(), 'Spring'),
(NOW(), NOW(), 'Базы данных'),
(NOW(), NOW(), 'Алгоритмы'),
(NOW(), NOW(), 'Веб-разработка'),
(NOW(), NOW(), 'Математический анализ'),
(NOW(), NOW(), 'Английский язык');

INSERT INTO users (created_at, updated_at, name, email, role) VALUES
(NOW(), NOW(), 'Иван Петров', 'ivan.petrov@mail.ru', 'TEACHER'),
(NOW(), NOW(), 'Мария Сидорова', 'maria.sidorova@mail.ru', 'TEACHER'),
(NOW(), NOW(), 'Алексей Козлов', 'alexey.kozlov@mail.ru', 'TEACHER'),
(NOW(), NOW(), 'Анна Смирнова', 'anna.smirnova@mail.ru', 'STUDENT'),
(NOW(), NOW(), 'Дмитрий Иванов', 'dmitry.ivanov@mail.ru', 'STUDENT'),
(NOW(), NOW(), 'Елена Попова', 'elena.popova@mail.ru', 'STUDENT'),
(NOW(), NOW(), 'Сергей Васильев', 'sergey.vasilyev@mail.ru', 'STUDENT'),
(NOW(), NOW(), 'Ольга Новикова', 'olga.novikova@mail.ru', 'STUDENT'),
(NOW(), NOW(), 'Администратор', 'admin@eduplatform.ru', 'ADMIN');

INSERT INTO profiles (created_at, updated_at, user_id, bio, avatar_url) VALUES
(NOW(), NOW(), 1, 'Преподаватель Java с 10-летним опытом', '/avatars/ivan.jpg'),
(NOW(), NOW(), 2, 'Специалист по базам данных и алгоритмам', '/avatars/maria.jpg'),
(NOW(), NOW(), 3, 'Преподаватель математики и физики', '/avatars/alexey.jpg'),
(NOW(), NOW(), 4, 'Студент 2 курса, изучаю программирование', '/avatars/anna.jpg'),
(NOW(), NOW(), 9, 'Администратор образовательной платформы', '/avatars/admin.jpg');

INSERT INTO courses (created_at, updated_at, title, description, category_id, teacher_id) VALUES
(NOW(), NOW(), 'Java для начинающих', 'Полный курс по основам Java программирования', 1, 1),
(NOW(), NOW(), 'Spring Framework', 'Современная разработка на Spring Boot', 1, 1),
(NOW(), NOW(), 'Базы данных SQL', 'Изучение реляционных баз данных и SQL', 1, 2),
(NOW(), NOW(), 'Математический анализ', 'Основы математического анализа для программистов', 2, 3),
(NOW(), NOW(), 'Английский для IT', 'Технический английский для разработчиков', 4, 2);

INSERT INTO course_tags (course_id, tag_id) VALUES
(1, 1), (1, 4),
(2, 1), (2, 2), (2, 5),
(3, 3), (3, 4),
(4, 6),
(5, 7);

INSERT INTO modules (created_at, updated_at, course_id, title, order_index) VALUES
(NOW(), NOW(), 1, 'Введение в Java', 1),
(NOW(), NOW(), 1, 'Объектно-ориентированное программирование', 2),
(NOW(), NOW(), 1, 'Коллекции и исключения', 3),
(NOW(), NOW(), 2, 'Введение в Spring', 1),
(NOW(), NOW(), 2, 'Spring Boot', 2),
(NOW(), NOW(), 3, 'Основы SQL', 1),
(NOW(), NOW(), 3, 'Нормализация баз данных', 2);

INSERT INTO lessons (created_at, updated_at, module_id, title, content, video_url) VALUES
(NOW(), NOW(), 1, 'Первая программа на Java', 'Основы синтаксиса Java, написание первой программы', '/videos/java-intro.mp4'),
(NOW(), NOW(), 1, 'Переменные и типы данных', 'Изучение примитивных типов и объявления переменных', '/videos/java-variables.mp4'),
(NOW(), NOW(), 2, 'Классы и объекты', 'Создание классов, конструкторы, методы', '/videos/java-classes.mp4'),
(NOW(), NOW(), 4, 'Введение в Spring Framework', 'Архитектура Spring, IoC контейнер', '/videos/spring-intro.mp4'),
(NOW(), NOW(), 6, 'SELECT запросы', 'Изучение базовых операторов SELECT', '/videos/sql-select.mp4');

INSERT INTO materials (created_at, updated_at, lesson_id, type, title, url, description) VALUES
(NOW(), NOW(), 1, 'PDF', 'Презентация к уроку', '/materials/java-intro.pdf', 'Основные слайды урока'),
(NOW(), NOW(), 1, 'ARTICLE', 'Дополнительные материалы', 'https://docs.oracle.com/javase/tutorial/', 'Официальная документация Java'),
(NOW(), NOW(), 3, 'PDF', 'Задачи по ООП', '/materials/oop-tasks.pdf', 'Практические задания'),
(NOW(), NOW(), 4, 'VIDEO', 'Дополнительное видео', '/videos/spring-ioc.mp4', 'Подробнее про IoC'),
(NOW(), NOW(), 5, 'PDF', 'Шпаргалка по SQL', '/materials/sql-cheatsheet.pdf', 'Основные команды SQL');

INSERT INTO assignments (created_at, updated_at, lesson_id, title, description, due_date, max_score) VALUES
(NOW(), NOW(), 1, 'Первая программа', 'Напишите программу Hello World с использованием Scanner', '2024-02-20 23:59:59', 100),
(NOW(), NOW(), 3, 'Класс Student', 'Создайте класс Student с полями и методами', '2024-02-25 23:59:59', 100),
(NOW(), NOW(), 5, 'SQL запросы', 'Напишите SELECT запросы для выборки данных', '2024-02-28 23:59:59', 100);

INSERT INTO quizzes (created_at, updated_at, module_id, title) VALUES
(NOW(), NOW(), 1, 'Тест по основам Java'),
(NOW(), NOW(), 2, 'Тест по ООП'),
(NOW(), NOW(), 6, 'Тест по SQL');

INSERT INTO questions (created_at, updated_at, quiz_id, text, type) VALUES
(NOW(), NOW(), 1, 'Какой оператор используется для вывода в консоль?', 'SINGLE_CHOICE'),
(NOW(), NOW(), 1, 'Какие из следующих типов являются примитивными?', 'MULTIPLE_CHOICE'),
(NOW(), NOW(), 2, 'Что такое инкапсуляция?', 'SINGLE_CHOICE'),
(NOW(), NOW(), 3, 'Какой оператор используется для фильтрации в SQL?', 'SINGLE_CHOICE');

INSERT INTO answer_options (created_at, updated_at, question_id, text, is_correct) VALUES
(NOW(), NOW(), 1, 'System.out.println()', TRUE),
(NOW(), NOW(), 1, 'console.log()', FALSE),
(NOW(), NOW(), 1, 'print()', FALSE),
(NOW(), NOW(), 2, 'int', TRUE),
(NOW(), NOW(), 2, 'String', FALSE),
(NOW(), NOW(), 2, 'boolean', TRUE),
(NOW(), NOW(), 2, 'Integer', FALSE),
(NOW(), NOW(), 3, 'Сокрытие реализации', TRUE),
(NOW(), NOW(), 3, 'Наследование классов', FALSE),
(NOW(), NOW(), 3, 'Создание объектов', FALSE),
(NOW(), NOW(), 4, 'WHERE', TRUE),
(NOW(), NOW(), 4, 'FILTER', FALSE),
(NOW(), NOW(), 4, 'HAVING', FALSE);

INSERT INTO enrollments (created_at, updated_at, student_id, course_id, enrol_date, status) VALUES
(NOW(), NOW(), 4, 1, NOW(), 'ACTIVE'),
(NOW(), NOW(), 5, 1, NOW(), 'ACTIVE'),
(NOW(), NOW(), 6, 1, NOW(), 'ACTIVE'),
(NOW(), NOW(), 4, 2, NOW(), 'ACTIVE'),
(NOW(), NOW(), 7, 3, NOW(), 'ACTIVE'),
(NOW(), NOW(), 8, 5, NOW(), 'ACTIVE');

INSERT INTO submissions (created_at, updated_at, assignment_id, student_id, submitted_at, content, score, feedback) VALUES
(NOW(), NOW(), 1, 4, NOW(), 'public class HelloWorld { public static void main(String[] args) { System.out.println("Hello World"); } }', 95, 'Отличная работа!'),
(NOW(), NOW(), 1, 5, NOW(), 'public class Main { public static void main(String[] args) { Scanner sc = new Scanner(System.in); System.out.println("Hello"); } }', 85, 'Хорошо, но нужно закрывать Scanner');

INSERT INTO quiz_submissions (created_at, updated_at, quiz_id, student_id, score, taken_at) VALUES
(NOW(), NOW(), 1, 4, 90, NOW()),
(NOW(), NOW(), 1, 5, 75, NOW()),
(NOW(), NOW(), 3, 7, 95, NOW());

INSERT INTO course_reviews (created_at, updated_at, course_id, student_id, rating, comment, created_at_review) VALUES
(NOW(), NOW(), 1, 4, 5, 'Отличный курс, все понятно объясняют!', NOW()),
(NOW(), NOW(), 1, 5, 4, 'Хороший курс, но нужно больше практики', NOW()),
(NOW(), NOW(), 3, 7, 5, 'Прекрасный преподаватель, много полезного материала', NOW());

INSERT INTO course_schedules (created_at, updated_at, course_id, start_date, end_date, weekday) VALUES
(NOW(), NOW(), 1, '2024-02-01', '2024-05-01', 'MONDAY'),
(NOW(), NOW(), 1, '2024-02-01', '2024-05-01', 'WEDNESDAY'),
(NOW(), NOW(), 2, '2024-02-15', '2024-04-15', 'TUESDAY'),
(NOW(), NOW(), 3, '2024-03-01', '2024-06-01', 'THURSDAY');

INSERT INTO notifications (created_at, updated_at, user_id, message, read, created_at_note) VALUES
(NOW(), NOW(), 4, 'Новое задание доступно: "Первая программа"', FALSE, NOW()),
(NOW(), NOW(), 5, 'Вы получили оценку за задание: 85/100', TRUE, NOW()),
(NOW(), NOW(), 4, 'Ваша работа проверена: 95/100', TRUE, NOW()),
(NOW(), NOW(), 7, 'Начинается новый модуль: "Нормализация баз данных"', FALSE, NOW());