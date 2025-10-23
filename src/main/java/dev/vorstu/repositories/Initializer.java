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

    @Autowired
    private GroupRepository groupRepository;

    public void initial() {

        Group bvm231 = new Group(
                null,
                "BVM-231"
        );
        groupRepository.save(bvm231);

        Group bvm232 = new Group(
                null,
                "BVM-232"
        );
        groupRepository.save(bvm232);

        Group bvm233 = new Group(
                null,
                "BVM-233"
        );
        groupRepository.save(bvm233);



        List<User> users = Arrays.asList(
                new User(null, "student1", Role.STUDENT, "Ivanov Alex", "1488", new Password("student1"), bvm231, true),
                new User(null, "student2", Role.STUDENT, "Petrov Mike", "1489", new Password("student2"), bvm231, true),
                new User(null, "student3", Role.STUDENT, "Sidorov John", "1490", new Password("student3"), bvm231, true),
                new User(null, "student4", Role.STUDENT, "Kuznetsov Anna", "1491", new Password("student4"), bvm231, true),
                new User(null, "student5", Role.STUDENT, "Popov Maria", "1492", new Password("student5"), bvm231, true),
                new User(null, "student6", Role.STUDENT, "Lebedev Olga", "1493", new Password("student6"), bvm231, true),
                new User(null, "student7", Role.STUDENT, "Kozlov Steve", "1494", new Password("student7"), bvm231, true),
                new User(null, "student8", Role.STUDENT, "Novikov Irina", "1495", new Password("student8"), bvm231, true),
                new User(null, "student9", Role.STUDENT, "Morozov Tom", "1496", new Password("student9"), bvm231, true),
                new User(null, "student10", Role.STUDENT, "Volkov Natalia", "1497", new Password("student10"), bvm231, true),

                // Студенты группы BVM-232 (5 человек)
                new User(null, "student11", Role.STUDENT, "Fedorov Alexey", "1498", new Password("student11"), bvm232, true),
                new User(null, "student12", Role.STUDENT, "Orlov Dmitry", "1499", new Password("student12"), bvm232, true),
                new User(null, "student13", Role.STUDENT, "Belyaev Sergey", "1500", new Password("student13"), bvm232, true),
                new User(null, "student14", Role.STUDENT, "Gusev Andrey", "1501", new Password("student14"), bvm232, true),
                new User(null, "student15", Role.STUDENT, "Titov Pavel", "1502", new Password("student15"), bvm232, true),

                // Студенты группы BVM-233 (15 человек)
                new User(null, "student16", Role.STUDENT, "Komarov Elena", "1503", new Password("student16"), bvm233, true),
                new User(null, "student17", Role.STUDENT, "Shcherbakov Kate", "1504", new Password("student17"), bvm233, true),
                new User(null, "student18", Role.STUDENT, "Mikhailov Julia", "1505", new Password("student18"), bvm233, true),
                new User(null, "student19", Role.STUDENT, "Romanov Victoria", "1506", new Password("student19"), bvm233, true),
                new User(null, "student20", Role.STUDENT, "Vasiliev Sophia", "1507", new Password("student20"), bvm233, true),
                new User(null, "student21", Role.STUDENT, "Zaitsev Artem", "1508", new Password("student21"), bvm233, true),
                new User(null, "student22", Role.STUDENT, "Pavlov Maxim", "1509", new Password("student22"), bvm233, true),
                new User(null, "student23", Role.STUDENT, "Semyonov Ivan", "1510", new Password("student23"), bvm233, true),
                new User(null, "student24", Role.STUDENT, "Golubev Roman", "1511", new Password("student24"), bvm233, true),
                new User(null, "student25", Role.STUDENT, "Vinogradov Denis", "1512", new Password("student25"), bvm233, true),
                new User(null, "student26", Role.STUDENT, "Bogdanov Kristina", "1513", new Password("student26"), bvm233, true),
                new User(null, "student27", Role.STUDENT, "Vorobiev Alina", "1514", new Password("student27"), bvm233, true),
                new User(null, "student28", Role.STUDENT, "Filippov Daria", "1515", new Password("student28"), bvm233, true),
                new User(null, "student29", Role.STUDENT, "Konstantinov Polina", "1516", new Password("student29"), bvm233, true),
                new User(null, "student30", Role.STUDENT, "Grigoriev Angelina", "1517", new Password("student30"), bvm233, true)
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
                bvm231,
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
                bvm231,
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
                bvm231,
                true
        );
        userRepository.save(teacher);

    }

    public void getAllStudents(){
        studentRepository.findAll();
    }
}
