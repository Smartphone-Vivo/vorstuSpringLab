package dev.vorstu.repositories;

import dev.vorstu.dto.Password;
import dev.vorstu.dto.Role;
import dev.vorstu.dto.Student;
import dev.vorstu.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Initializer {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    public void initial() {
        studentRepository.save(new Student("Igor Gofman", "BVM-231", "+79153981488"));
        studentRepository.save(new Student("Kolesnikov Igor", "ZOV-232", "+79105110036"));
        studentRepository.save(new Student("Petrova Maria", "BVM-231", "+79105110002"));
        studentRepository.save(new Student("Gerasimova Anastasia", "BIST-233", "+79105110027"));
        studentRepository.save(new Student("Novikov Pavel", "BVM-232", "+79105110009"));
        studentRepository.save(new Student("Rodionova Marina", "ZOV-231", "+79105110035"));
        studentRepository.save(new Student("Tarasov Evgeny", "BIST-233", "+79105110028"));
        studentRepository.save(new Student("Kuznetsova Anna", "BVM-231", "+79105110004"));
        studentRepository.save(new Student("Belov Stanislav", "BIST-233", "+79105110030"));
        studentRepository.save(new Student("Vinogradova Karina", "ZOV-233", "+79105110043"));
        studentRepository.save(new Student("Fedorov Igor", "BVM-232", "+79105110007"));
        studentRepository.save(new Student("Andreeva Milana", "BVM-233", "+79105110049"));
        studentRepository.save(new Student("Soloviev Roman", "BIST-231", "+79105110018"));
        studentRepository.save(new Student("Makarov Gleb", "BVM-231", "+79105110046"));
        studentRepository.save(new Student("Komarova Yulia", "BIST-232", "+79105110025"));
        studentRepository.save(new Student("Pavlova Natalia", "BVM-232", "+79105110010"));
        studentRepository.save(new Student("Zaitsev Kirill", "BIST-232", "+79105110022"));
        studentRepository.save(new Student("Timofeev Oleg", "ZOV-232", "+79105110038"));
        studentRepository.save(new Student("Kuzmin Artem", "BIST-231", "+79105110016"));
        studentRepository.save(new Student("Sidorov Dmitry", "BVM-231", "+79105110003"));
        studentRepository.save(new Student("Lapina Angelina", "ZOV-233", "+79105110045"));
        studentRepository.save(new Student("Gusev Maxim", "BVM-233", "+79105110014"));
        studentRepository.save(new Student("Morozova Olga", "BVM-232", "+79105110008"));
        studentRepository.save(new Student("Savina Elizaveta", "ZOV-232", "+79105110037"));
        studentRepository.save(new Student("Davydov Vladislav", "BIST-233", "+79105110026"));
        studentRepository.save(new Student("Ivanov Alexey", "BVM-231", "+79105110001"));
        studentRepository.save(new Student("Stepanova Arina", "ZOV-231", "+79105110031"));
        studentRepository.save(new Student("Krylova Sofia", "ZOV-232", "+79105110039"));
        studentRepository.save(new Student("Popov Sergey", "BVM-231", "+79105110005"));
        studentRepository.save(new Student("Egorova Alina", "BIST-232", "+79105110021"));
        studentRepository.save(new Student("Volkova Elena", "BVM-232", "+79105110006"));
        studentRepository.save(new Student("Polyakov Artur", "ZOV-233", "+79105110042"));
        studentRepository.save(new Student("Sorokina Diana", "BIST-232", "+79105110047"));
        studentRepository.save(new Student("Osipova Valeria", "ZOV-233", "+79105110041"));
        studentRepository.save(new Student("Borisov Alexander", "BIST-232", "+79105110024"));
        studentRepository.save(new Student("Lebedeva Irina", "BVM-233", "+79105110011"));
        studentRepository.save(new Student("Matveeva Veronika", "ZOV-231", "+79105110033"));
        studentRepository.save(new Student("Titova Ekaterina", "BVM-233", "+79105110015"));
        studentRepository.save(new Student("Zakharov Lev", "BIST-231", "+79105110050"));
        studentRepository.save(new Student("Filippov Nikita", "ZOV-231", "+79105110032"));
        studentRepository.save(new Student("Kozlov Andrey", "BVM-233", "+79105110012"));
        studentRepository.save(new Student("Vasileva Polina", "BIST-231", "+79105110019"));
        studentRepository.save(new Student("Kovalev Egor", "ZOV-231", "+79105110048"));
        studentRepository.save(new Student("Orlova Svetlana", "BVM-233", "+79105110013"));
        studentRepository.save(new Student("Medvedeva Kristina", "BIST-233", "+79105110029"));
        studentRepository.save(new Student("Semyonov Vadim", "ZOV-233", "+79105110044"));
        studentRepository.save(new Student("Mikhailov Denis", "BIST-231", "+79105110020"));
        studentRepository.save(new Student("Grigoriev Anton", "ZOV-231", "+79105110034"));
        studentRepository.save(new Student("Karpova Daria", "BIST-232", "+79105110023"));
        studentRepository.save(new Student("Nikolaeva Victoria", "BIST-231", "+79105110017"));
        studentRepository.save(new Student("Nikitin Mikhail", "ZOV-232", "+79105110040"));

        User student = new User(
                null,
                "student",
                Role.USER,
                new Password("1234"),
                true
        );
        userRepository.save(student);
    }

    public void getAllStudents(){
        studentRepository.findAll();
    }
}
