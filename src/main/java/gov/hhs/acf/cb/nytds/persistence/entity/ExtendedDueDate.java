package gov.hhs.acf.cb.nytds.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

/*
 * ExtendedDueDate model
 */
@Entity
@AttributeOverride(name = "id", column = @Column(name = "EXTENDEDDUEDATEID"))
@SequenceGenerator(name = "default_gen", sequenceName = "SEQ_EXTENDEDDUEDATE", allocationSize = BaseEntity.DEFAULT_SEQUENCE_ALLOCATION_SIZE)
public class ExtendedDueDate extends BaseEntity {

//    @Getter
//    @Setter
//    @ManyToOne
//    Long dueDateId;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "stateId")
    State state;
    @Getter
    @Setter
    @Column(name = "EXTENDEDDUEDATE")
    private Calendar extendedDueDateCal;
//    @Getter
//    @Setter
//    private Long stateId;
    @Getter
    @Setter
    private String reason;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "dueDateId")
    private DueDate dueDate;
    @Getter
    @Setter
    private String strExtendedDueDate;
    @Getter
    @Setter
    private Character deleteFlag;

    /*
     * No argument constructor
     */
    public ExtendedDueDate() {
    }

    /*
     * Constructor taking extended due date id
     */
    public ExtendedDueDate(Long extendedDueDateId) {
        this.id = extendedDueDateId;
    }

}
