package gov.hhs.acf.cb.nytds.persistence.compliance;

import gov.hhs.acf.cb.nytds.persistence.PaginatedSearch;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* penalty search model extending PaginatedSerach.
*/
public class PenaltySearch extends PaginatedSearch {
    @Getter @Setter private List<String> availableReportingPeriods;
    @Getter @Setter private List<String> selectedReportingPeriods;
    @Getter @Setter private List<String> noJSList;
    @Getter @Setter private String stateName;
    @Getter @Setter private String complianceStatus;
    @Getter @Setter private String timelyData;
    @Getter @Setter private String correctFormatData;
    @Getter @Setter private String errorFreeData;
    @Getter @Setter private String elementName;
    @Getter @Setter private boolean viewSubmissionsOnly;
    @Getter @Setter private boolean javaScriptEnabled;
    @Getter @Setter private List<String> availableElementNumbers;
    @Getter @Setter private List<String> selectedElementNumbers;
    @Getter @Setter private List<Long> selectedElementNums;
    @Getter @Setter private boolean viewActiveSubmissionsOnly;
    @Getter @Setter private Map<String,String> availableStates = new HashMap<>();
    @Getter @Setter private Map<String,String> selectedStates = new HashMap<>();
    
    /*
    * Constructor with no argument
    */
    public PenaltySearch() {
        super();
        loadDefaults();
    }
    
    /*
    * Reset the search
    */
    @Override
    public void reset() {
        super.reset();
        loadDefaults();
    }


    /*
    * Loading default search on extend due date page
    */
    private void loadDefaults() {
        setStateName("All");
        setAvailableReportingPeriods(new ArrayList<>());
        setNoJSList(new ArrayList<>());
        setSelectedReportingPeriods(new ArrayList<>());        
        setComplianceStatus("All");
        setTimelyData("All");
        setCorrectFormatData("All");
        setErrorFreeData("All");
        setAvailableElementNumbers(new ArrayList<>());
        setSelectedElementNumbers(new ArrayList<>());  
        setElementName("");
        setViewSubmissionsOnly(false);
        setJavaScriptEnabled(false);
    	setViewActiveSubmissionsOnly(false);
    	setAvailableStates(new HashMap<>());
    	setSelectedStates(new HashMap<>());
    }

}
