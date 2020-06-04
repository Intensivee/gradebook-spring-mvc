package pk.GradeBook.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subject", catalog = "gradebook")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Long subjectId;
    @Column(name = "subject_name")
    private String subjectName;
    @Column(name = "class_name")
    private String className;

    @OneToMany
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    private List<Mark> marks;

    @OneToMany
    @JoinColumn(name="subject_id", referencedColumnName = "subject_id")
    private List<Event> events;

    @ManyToMany(mappedBy = "subjects")
    private List<User> users;

    public Subject() {
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
