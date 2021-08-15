package gov.hhs.acf.cb.nytds.persistence.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@MappedSuperclass
public abstract class BaseEntity {
    // regular expression pattern for named parameters in messages
    // parameter format in messages is ${parameterName}
    private static final Pattern paramPattern = Pattern.compile("(\\$\\{(\\w+)\\})");

    @Id
    @Getter
    @Setter
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    @Version
    @Column(name = "version")
    @Getter
    @Setter
    protected Integer version;
    @Getter
    @Setter
    protected Calendar createdDate;
    @Getter
    @Setter
    protected String createdBy;
    @Getter
    @Setter
    protected Calendar updateDate;
    @Getter
    @Setter
    protected String updateBy;
    @Getter
    @Setter
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
