package gov.hhs.acf.cb.nytds.persistence.component.entity;

// Generated May 20, 2009 10:16:43 AM by Hibernate Tools 3.2.4.GA

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

/*
 * State generated by hbm2java
 */
@Entity
@Table(name = "STATE")
@AttributeOverride(name = "id", column = @Column(name = "stateId"))
@SequenceGenerator(name = "default_gen", sequenceName = "SEQ_STATE", allocationSize = BaseEntity.DEFAULT_SEQUENCE_ALLOCATION_SIZE)
@Getter
@Setter(AccessLevel.PROTECTED)
public class State extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "REGIONID")
    private Region region;
    private String stateName;
    private String abbreviation;
    private String fipsCode;
    // TODO mjk Check if used, not mapped in hbm.xml
//	@Getter @Setter
//	private Set<PrimaryUserRole> primaryUserRoles = new HashSet<>(0);
    @OneToMany(mappedBy = "state")
    private Set<Transmission> transmissions;

    public State() {
    }

    public State(Long stateId) {
        this.id = stateId;
    }

    public State(Region region, String stateName, String abbreviation, String fipsCode,
                 Calendar createdDate, String createdBy, Calendar updateDate, String updateBy, String description,
                 Set<PrimaryUserRole> primaryUserRoles, Set<Transmission> transmissions) {
        this.region = region;
        this.stateName = stateName;
        this.abbreviation = abbreviation;
        this.fipsCode = fipsCode;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.updateDate = updateDate;
        this.updateBy = updateBy;
        this.description = description;
//		this.primaryUserRoles = primaryUserRoles;
//		this.transmissions = transmissions;
    }


    @Override
    public String toString() {
        return "{\"State\":"
                + super.toString()
                + ", \"id\":\"" + id + "\""
                + ", \"version\":\"" + version + "\""
                + ", \"createdDate\":" + createdDate
                + ", \"createdBy\":\"" + createdBy + "\""
                + ", \"updateDate\":" + updateDate
                + ", \"updateBy\":\"" + updateBy + "\""
                + ", \"description\":\"" + description + "\""
                + ", \"region\":" + region
                + ", \"stateName\":\"" + stateName + "\""
                + ", \"abbreviation\":\"" + abbreviation + "\""
                + ", \"fipsCode\":\"" + fipsCode + "\""
                + "}";
    }
}
