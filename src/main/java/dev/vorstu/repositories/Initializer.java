package dev.vorstu.repositories;

import dev.vorstu.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Initializer {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    public void initial() {

        List<User> users = Arrays.asList(
                // Студенты (30 штук)
                new User(null, "student1", Role.STUDENT, "Ivanov Alex", "1488", new Password("student1"), new Group("BMW-1488"), true),
                new User(null, "student2", Role.STUDENT, "Petrov Mike", "1489", new Password("student2"), new Group("BMW-1488"), true),
                new User(null, "student3", Role.STUDENT, "Sidorov John", "1490", new Password("student3"), new Group("BMW-1488"), true),
                new User(null, "student4", Role.STUDENT, "Kuznetsov Anna", "1491", new Password("student4"), new Group("BMW-1488"), true),
                new User(null, "student5", Role.STUDENT, "Popov Maria", "1492", new Password("student5"), new Group("BMW-1488"), true),
                new User(null, "student6", Role.STUDENT, "Lebedev Olga", "1493", new Password("student6"), new Group("BMW-1488"), true),
                new User(null, "student7", Role.STUDENT, "Kozlov Steve", "1494", new Password("student7"), new Group("BMW-1488"), true),
                new User(null, "student8", Role.STUDENT, "Novikov Irina", "1495", new Password("student8"), new Group("BMW-1488"), true),
                new User(null, "student9", Role.STUDENT, "Morozov Tom", "1496", new Password("student9"), new Group("BMW-1488"), true),
                new User(null, "student10", Role.STUDENT, "Volkov Natalia", "1497", new Password("student10"), new Group("BMW-1488"), true),
                new User(null, "student11", Role.STUDENT, "Fedorov Alexey", "1498", new Password("student11"), new Group("BMW-1489"), true),
                new User(null, "student12", Role.STUDENT, "Orlov Dmitry", "1499", new Password("student12"), new Group("BMW-1489"), true),
                new User(null, "student13", Role.STUDENT, "Belyaev Sergey", "1500", new Password("student13"), new Group("BMW-1489"), true),
                new User(null, "student14", Role.STUDENT, "Gusev Andrey", "1501", new Password("student14"), new Group("BMW-1489"), true),
                new User(null, "student15", Role.STUDENT, "Titov Pavel", "1502", new Password("student15"), new Group("BMW-1489"), true),
                new User(null, "student16", Role.STUDENT, "Komarov Elena", "1503", new Password("student16"), new Group("BMW-1489"), true),
                new User(null, "student17", Role.STUDENT, "Shcherbakov Kate", "1504", new Password("student17"), new Group("BMW-1489"), true),
                new User(null, "student18", Role.STUDENT, "Mikhailov Julia", "1505", new Password("student18"), new Group("BMW-1489"), true),
                new User(null, "student19", Role.STUDENT, "Romanov Victoria", "1506", new Password("student19"), new Group("BMW-1489"), true),
                new User(null, "student20", Role.STUDENT, "Vasiliev Sophia", "1507", new Password("student20"), new Group("BMW-1489"), true),
                new User(null, "student21", Role.STUDENT, "Zaitsev Artem", "1508", new Password("student21"), new Group("BMW-1490"), true),
                new User(null, "student22", Role.STUDENT, "Pavlov Maxim", "1509", new Password("student22"), new Group("BMW-1490"), true),
                new User(null, "student23", Role.STUDENT, "Semyonov Ivan", "1510", new Password("student23"), new Group("BMW-1490"), true),
                new User(null, "student24", Role.STUDENT, "Golubev Roman", "1511", new Password("student24"), new Group("BMW-1490"), true),
                new User(null, "student25", Role.STUDENT, "Vinogradov Denis", "1512", new Password("student25"), new Group("BMW-1490"), true),
                new User(null, "student26", Role.STUDENT, "Bogdanov Kristina", "1513", new Password("student26"), new Group("BMW-1490"), true),
                new User(null, "student27", Role.STUDENT, "Vorobiev Alina", "1514", new Password("student27"), new Group("BMW-1490"), true),
                new User(null, "student28", Role.STUDENT, "Filippov Daria", "1515", new Password("student28"), new Group("BMW-1490"), true),
                new User(null, "student29", Role.STUDENT, "Konstantinov Polina", "1516", new Password("student29"), new Group("BMW-1490"), true),
                new User(null, "student30", Role.STUDENT, "Grigoriev Angelina", "1517", new Password("student30"), new Group("BMW-1490"), true),

                // Преподаватели (3 штуки)
                new User(null, "teacher1", Role.TEACHER, "Prof. Ivanov", "2501", new Password("teacher1"), new Group("BMW-FAC1"), true),
                new User(null, "teacher2", Role.TEACHER, "Dr. Petrov", "2502", new Password("teacher2"), new Group("BMW-FAC2"), true),
                new User(null, "teacher3", Role.TEACHER, "PhD Sidorov", "2503", new Password("teacher3"), new Group("BMW-FAC3"), true),

                // Администраторы (2 штуки)
                new User(null, "admin1", Role.ADMIN, "Chief Admin", "3501", new Password("admin1"), new Group("BMW-ADM1"), true),
                new User(null, "admin2", Role.ADMIN, "System Admin", "3502", new Password("admin2"), new Group("BMW-ADM2"), true)
        );

// Сохраняем всех пользователей через обычный for
        for (User user : users) {
            userRepository.save(user);
        }

        User student = new User(
                null,
                "student",
                Role.STUDENT,
                "Igor Gofman Student",
                "1488",
                new Password("student"),
                new Group("BMW-1488"),
                true
        );
        userRepository.save(student);

        User admin = new User(
                null,
                "admin",
                Role.ADMIN,
                "Igor Gofman admin",
                "1489",
                new Password("admin"),
                new Group("BMW-1489"),
                true
        );
        userRepository.save(admin);

        User teacher = new User(
                null,
                "teacher",
                Role.TEACHER,
                "Igor Gofman teacher",
                "1490",
                new Password("student"),
                new Group("BMW-1490"),
                true
        );
        userRepository.save(teacher);

    }

    public void getAllStudents(){
        studentRepository.findAll();
    }
}
