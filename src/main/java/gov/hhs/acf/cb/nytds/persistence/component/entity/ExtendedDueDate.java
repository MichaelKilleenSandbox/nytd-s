package gov.hhs.acf.cb.nytds.persistence.component.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
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
State state;
    @Getter
    @Setter
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
