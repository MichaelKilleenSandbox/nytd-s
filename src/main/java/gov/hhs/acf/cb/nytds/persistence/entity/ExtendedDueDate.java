package gov.hhs.acf.cb.nytds.persistence.entity;

import java.util.Calendar;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/*
 * ExtendedDueDate model
 */
@Entity
public class ExtendedDueDate  extends BaseEntity {

    @Getter @Setter  private Calendar extendedDueDateCal;
    @Getter @Setter private Long stateId;
    @Getter @Setter private Long dueDateId;	
    @Getter @Setter private String reason;
    @Getter @Setter private DueDate dueDate;
    @Getter @Setter private State state;
    @Getter @Setter private String strExtendedDueDate;
    @Getter @Setter private Character deleteFlag;

    /*
    * No argument constructor
    */
    public ExtendedDueDate(){}

    /*
    * Constructor taking extended due date id
    */
    public ExtendedDueDate(Long extendedDueDateId) {
        this.id = extendedDueDateId;
    }

  }
