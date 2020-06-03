package pk.GradeBook.model;

import javax.persistence.*;

@Entity
@Table(name = "user", catalog = "gradebook")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subject_id")
    private Long subjectId;
    @Column(name = "class_name")
    private String nameClass;
    @Column(name = "subject_name")
    private String nameSubject;

    //TODO: add connections

    public Subject() {
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }
}
