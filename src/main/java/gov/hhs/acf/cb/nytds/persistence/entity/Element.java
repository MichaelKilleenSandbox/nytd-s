package gov.hhs.acf.cb.nytds.persistence.entity;

// Generated May 20, 2009 10:16:43 AM by Hibernate Tools 3.2.4.GA

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;


/*
 * Element originally generated by hbm2java
 */
@Entity
@AttributeOverride(name = "id", column = @Column(name = "elementId"))
public class Element extends BaseEntity {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String nodeName;
    @Getter @Setter
    private String variableName;
    @Getter
    @Setter
    private Integer sort;
    @Getter
    @Setter
    @OneToOne
    private ComplianceStandard complianceStandard;
    @Getter
    @Setter
    @OneToMany(mappedBy = "element")
    private Set<AllowedValue> allowedValues = new HashSet<>(0);
    @Getter
    @Setter
    @OneToMany(mappedBy = "element")
    private Set<Datum> datums = new HashSet<>(0);
    @Getter
    @Setter
    @OneToMany(mappedBy = "element")
    private Set<ElementPopulation> elementPopulations = new HashSet<>(0);
    @Getter
    @Setter
    @OneToMany(mappedBy = "element")
    private Set<ElementNote> elementNotes = new HashSet<>(0);

    public Element() {
    }

    public Element(Long id) {
        this.id = id;
    }

    public Element(Long elementid, String name, Calendar createdDate, String createdBy, Calendar updateDate,
                   String updateBy, String description, String nodeName, Integer sort,
                   ComplianceStandard complianceStandard, Set<AllowedValue> allowedValues, Set<Datum> datums,
                   Set<ElementPopulation> elementPopulations) {
        this.id = elementid;
        this.name = name;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.updateDate = updateDate;
        this.updateBy = updateBy;
        this.description = description;
        this.nodeName = nodeName;
        this.sort = sort;
        this.complianceStandard = complianceStandard;
        this.allowedValues = allowedValues;
        this.datums = datums;
        this.elementPopulations = elementPopulations;
    }

}
