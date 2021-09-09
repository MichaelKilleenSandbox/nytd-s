package gov.hhs.acf.cb.nytds.persistence.extendedduedate;

import gov.hhs.acf.cb.nytds.persistence.PaginatedSearch;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;

import java.util.Calendar;

public class ExtendedDueDateSearch extends PaginatedSearch {
    protected Logger log = Logger.getLogger(getClass());
    @Getter
    @Setter
    private String state;
    @Getter
    @Setter
    private String stateName;
    @Getter
    @Setter
    private String reportingPeriod;
    @Getter
    @Setter
    private String reportingPeriodName;
    @Getter
    @Setter
    private Calendar extendedDueDate;

    /*
     * Constructor with no argument
     */
    public ExtendedDueDateSearch() {
        super();
        loadDefaults();
    }

    /*
     * Constructor with SQL date, checks for current extended due dates
     * */
    public ExtendedDueDateSearch(Calendar date) {
        super();
        loadDefaults();
        setExtendedDueDate(date);
    }

    public static ExtendedDueDateSearch from(Calendar date) {
        return new ExtendedDueDateSearch(date);
    }

    /*
     * Reset the search
     */
    @Override
    public void reset() {
        super.reset();
        loadDefaults();
    }

    public static ExtendedDueDateSearch create() {
        ExtendedDueDateSearch extendedDueDateSearch = new ExtendedDueDateSearch();
        extendedDueDateSearch.loadDefaults();
        return extendedDueDateSearch;
    }

    /*
     * Loading default search on extend due date page
     */
    private void loadDefaults() {
        log.info("ExtendedDueDateSearch.loadDefaults >>>>>>>>>>>>>>>>>>>>>>>>>> " + state + " , "
                + reportingPeriod + ", pageSize : " + getPageSize() + " , getSortColumn(): "
                + getSortColumn() + " , getSortDirection: " + getSortDirection());
        setState("0");
        setReportingPeriod("0");
        setSortColumn("reportingPeriodName");
        setSortDirection(PaginatedSearch.SortDirection.ASC);
        setStateName("All");
    }

}

