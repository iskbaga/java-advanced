package info.kgeorgiy.ja.bagautdinov.student;

import info.kgeorgiy.java.advanced.student.Group;
import info.kgeorgiy.java.advanced.student.GroupName;
import info.kgeorgiy.java.advanced.student.GroupQuery;
import info.kgeorgiy.java.advanced.student.Student;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StudentDB implements GroupQuery {
    private final static Comparator<Student> STUDENT_COMPARATOR = Comparator.comparing(Student::getLastName)
            .thenComparing(Student::getFirstName)
            .thenComparing(Comparator.comparing(Student::getId).reversed());

    private final static Comparator<Group> GROUP_COMPARATOR = Comparator.comparing(Group::getName);
    private final static Comparator<String> STRING_COMPARATOR = String::compareTo;

    private final static Comparator<Student> STUDENT_ID_COMPARATOR = Student::compareTo;
    private final static Comparator<GroupName> GROUP_NAME_COMPARATOR =
            Comparator.comparing(GroupName::toString, Comparator.reverseOrder());

    @Override
    public List<Group> getGroupsByName(Collection<Student> students) {
        return mapGroup(students, STUDENT_COMPARATOR);
    }

    @Override
    public List<Group> getGroupsById(Collection<Student> students) {
        return mapGroup(students, STUDENT_ID_COMPARATOR);
    }

    @Override
    public GroupName getLargestGroup(Collection<Student> students) {
        return getMaxGroup(getGroupMap(students, Collectors.counting()),
                Comparator.naturalOrder());
    }

    @Override
    public GroupName getLargestGroupFirstName(Collection<Student> students) {
        return getMaxGroup(getGroupMap(students,
                        Collectors.collectingAndThen(Collectors.toList(),
                                first -> (long) getDistinctFirstNames(first).size())),
                Comparator.reverseOrder());
    }

    @Override
    public List<String> getFirstNames(List<Student> students) {
        return getStudentList(students, Student::getFirstName);
    }

    @Override
    public List<String> getLastNames(List<Student> students) {
        return getStudentList(students, Student::getLastName);
    }

    @Override
    public List<GroupName> getGroups(List<Student> students) {
        return getStudentList(students, Student::getGroup);
    }

    @Override
    public List<String> getFullNames(List<Student> students) {
        return getStudentList(students, student -> student.getFirstName() + " " + student.getLastName());
    }

    @Override
    public Set<String> getDistinctFirstNames(List<Student> students) {
        return mapStudents(students,
                Student::getFirstName,
                STRING_COMPARATOR,
                Collectors.toSet());

    }

    @Override
    public String getMaxStudentFirstName(List<Student> students) {
        return students.stream()
                .max(STUDENT_ID_COMPARATOR)
                .map(Student::getFirstName)
                .orElse("");
    }

    @Override
    public List<Student> sortStudentsById(Collection<Student> students) {
        return filterStudents(students,
                student -> true,
                STUDENT_ID_COMPARATOR,
                Collectors.toList());
    }

    @Override
    public List<Student> sortStudentsByName(Collection<Student> students) {
        return filterStudents(students,
                student -> true,
                STUDENT_COMPARATOR,
                Collectors.toList());
    }

    @Override
    public List<Student> findStudentsByFirstName(Collection<Student> students, String name) {
        return filterStudents(students,
                student -> student.getFirstName().equals(name),
                STUDENT_COMPARATOR,
                Collectors.toList());
    }

    @Override
    public List<Student> findStudentsByLastName(Collection<Student> students, String name) {
        return filterStudents(students,
                student -> student.getLastName().equals(name),
                STUDENT_COMPARATOR,
                Collectors.toList());
    }

    @Override
    public List<Student> findStudentsByGroup(Collection<Student> students, GroupName group) {
        return filterStudents(students,
                student -> student.getGroup().equals(group),
                STUDENT_COMPARATOR,
                Collectors.toList());
    }

    @Override
    public Map<String, String> findStudentNamesByGroup(Collection<Student> students, GroupName group) {
        return filterStudents(students,
                student -> student.getGroup().equals(group),
                Comparator.comparingInt(student -> 0),
                Collectors.toMap(Student::getLastName,
                        Student::getFirstName,
                        BinaryOperator.minBy(STRING_COMPARATOR)));
    }

    private <T, V> V mapStudents(Collection<Student> students, Function<Student, T> mapper, Comparator<T> comparator, Collector<T, ?, V> collector) {
        return students.stream()
                .map(mapper)
                .sorted(comparator)
                .collect(collector);
    }


    private <T> List<T> getStudentList(List<Student> students, Function<Student, T> mapper) {
        return mapStudents(students, mapper,
                Comparator.comparingInt(student -> 0), Collectors.toList());
    }

    private <T> T filterStudents(Collection<Student> students, Predicate<Student> filter, Comparator<Student> comparator, Collector<Student, ?, T> collector) {
        return students.stream()
                .filter(filter)
                .sorted(comparator)
                .collect(collector);
    }

    private <T> Map<GroupName, T> getGroupMap(Collection<Student> students, Collector<Student, ?, T> collector) {
        return filterStudents(students,
                student -> true,
                Comparator.comparingInt(student -> 0),
                Collectors.groupingBy(Student::getGroup, collector));
    }

    private GroupName getMaxGroup(Map<GroupName, Long> groupMap, Comparator<GroupName> comparator) {
        return groupMap.values().stream()
                .reduce(Long::max)
                .flatMap(maxGroup -> groupMap.entrySet().stream()
                        .filter(entry -> entry.getValue().equals(maxGroup))
                        .map(Map.Entry::getKey)
                        .sorted(GROUP_NAME_COMPARATOR)
                        .max(comparator))
                .orElse(null);
    }

    private List<Group> mapGroup(Collection<Student> students, Comparator<Student> comparator) {
        return getGroupMap(students, Collectors.toList()).entrySet().stream()
                .map(entry -> new Group(entry.getKey(),
                        filterStudents(entry.getValue(),
                                x -> true,
                                comparator,
                                Collectors.toList())))
                .sorted(GROUP_COMPARATOR)
                .collect(Collectors.toList());
    }
}
