package gov.hhs.acf.cb.nytds.persistence.component.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement.DEFAULT;
import java.util.Calendar;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@MappedSuperclass
public abstract class BaseEntityIdentity {
    // regular expression pattern for named parameters in messages
    // parameter format in messages is ${parameterName}
    private static final Pattern paramPattern = Pattern.compile("(\\$\\{(\\w+)\\})");
    public static final long DEFAULT_SEQUENCE_ALLOCATION_SIZE = 1;

    @Id
    @Getter
    @Setter(AccessLevel.PROTECTED)
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    @Version
    @Column(name = "version")
    @Getter
    @Setter(AccessLevel.PROTECTED)
    protected Integer version;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    @CreatedDate
    protected Calendar createdDate;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    @CreatedBy
    protected String createdBy;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    @LastModifiedDate
    protected Calendar updateDate;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    @LastModifiedBy
    protected String updateBy;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    @Column(length = 1000)
    protected String description;

    public String formatText(String text, Map params) {
        Matcher paramMatcher = paramPattern.matcher(text);
        StringBuilder sb = new StringBuilder();
        while (paramMatcher.find()) {
            String namedParameter = paramMatcher.group(2);

            if (params.containsKey(namedParameter)) {
                paramMatcher.appendReplacement(
                        sb, params.get(namedParameter).toString());
            } else {
                throw new RuntimeException(
                        "parameter map missing named parmater " + namedParameter);
            }
        }
        paramMatcher.appendTail(sb);
        return sb.toString();
    }

}
