package pk.GradeBook.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mark", catalog = "gradebook")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mark_id")
    private Long markId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "subject_id")
    private Long subjectId;
    @Column(name = "attendance")
    private int attendance;
    @Column(name = "late")
    private int late;
    @Column(name = "mark_date")
    private Date markDate;
    @Column(name = "grade")
    private float grade;

    //TODO: add connections

    public Mark() {
    }

    public Long getMarkId() {
        return markId;
    }

    public void setMarkId(Long markID) {
        this.markId = markID;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectID) {
        this.subjectId = subjectID;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userID) {
        this.userId = userID;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public Date getMarkDate() {
        return markDate;
    }

    public void setMarkDate(Date markDate) {
        this.markDate = markDate;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getLate() {
        return late;
    }

    public void setLate(int late) {
        this.late = late;
    }
}
