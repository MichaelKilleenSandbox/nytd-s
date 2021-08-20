package gov.hhs.acf.cb.nytds.persistence.component;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Calendar;

@Getter
public abstract class BaseComponent {
    protected long id;
    protected Integer version;
    protected Calendar createdDate;
    protected String createdBy;
    protected Calendar updateDate;
    protected String updateBy;
    protected String description;

    public BaseComponent(long id, Integer version, Calendar createdDate, Calendar updateDate, String description) {
        this.id = id;
        this.version = version;
        this.createdDate = createdDate;
        this.updateDate = updateDate;
        this.description = description;
    }
}
