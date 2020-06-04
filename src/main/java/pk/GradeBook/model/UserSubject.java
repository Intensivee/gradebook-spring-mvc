package pk.GradeBook.model;

import javax.persistence.*;

@Entity
@Table(name = "user_subject", catalog = "gradebook")
public class UserSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_subject_id")
    private Long userSubjectId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "subject_id")
    private Long subjectId;

    public UserSubject() {
    }

    public Long getUserSubjectId() {
        return userSubjectId;
    }

    public void setUserSubjectId(Long userSubjectId) {
        this.userSubjectId = userSubjectId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }
}
