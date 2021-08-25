package gov.hhs.acf.cb.nytds.persistence.component.entity;

// Generated May 20, 2009 10:16:43 AM by Hibernate Tools 3.2.4.GA

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.logging.Logger;

/*
 * SiteUser originally generated by hbm2java
 *
 * @author 18816
 */
@Entity
@AttributeOverride(name = "id", column = @Column(name = "SiteUserId"))
@SequenceGenerator(name = "default_gen", sequenceName = "SEQ_SITEUSER", allocationSize = BaseEntity.DEFAULT_SEQUENCE_ALLOCATION_SIZE)
public class SiteUser extends BaseEntity implements Sender, Recipient {

    public static final String SESSION_KEY = "siteUser";
    protected final transient Logger log = Logger.getLogger(String.valueOf(getClass()));

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "STATEID")
    private State state;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "regionId")
    private Region region;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "primaryUserRoleId")
    private PrimaryUserRole primaryUserRole;
    @Getter
    @Setter
    private String userName;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private String firstName;
    @Getter
    @Setter
    private String lastName;
    @Getter
    @Setter
    private String emailAddress;
    @Getter
    @Setter
    private String phoneNumber;
    @Getter
    @Setter
    private boolean locked = false;
    @Getter
    @Setter
    private Timestamp timeLocked;
    @Getter
    @Setter
    private String pwChangeKey;
    @Getter
    @Setter
    @Column(name = "EMAILNOTIFICATION")
    private boolean receiveEmailNotifications;
    @Getter
    @Setter
    private boolean isDeleted;
    @Getter
    @Setter
    private Calendar pwChangedDate;
    @Getter
    @Setter
    private boolean pwTemporary;
    @Getter
    @Setter
    @ManyToMany(mappedBy = "recipients")
    private Set<Message> messages;
    // TODO mjk Do we  use this, not seeing it mapped in the hbm.xml file.
//	@Getter @Setter
//    private HashSet<String> privileges;
    @Getter
    @Setter
    @OneToMany(mappedBy = "siteUser")
    private Set<SiteUserSecondaryUserRole> siteUserSecondaryUserRoles;
    @Getter
    @Setter
    @OneToMany(mappedBy = "siteUser")
    private Set<SiteUserStateRegionMapping> siteUserStateRegionMappings;
//    @Getter
//    @Setter
//    private boolean privilegesSet = false;


    public SiteUser() {
    }

    public SiteUser(Long siteUserid) {
        this.id = siteUserid;
    }


    /**
     * Remove time lock.
     */
    public void removeTimeLock() {
        this.timeLocked = null;
    }

    /**
     * Clear any permanent or time locks.
     */
    public void unlock() {
        this.setLocked(false);
        this.removeTimeLock();
    }

    /**
     * Determine whether the SiteUser is time locked.
     * <p/>
     * The SiteUser is time locked if the value of timeLocked is a time within the past 30 minutes.
     *
     * @return true if SiteUser is time locked, false otherwise
     */
    public boolean isTemporarilyLocked() {
        boolean isTimeLocked = false;
        Timestamp currentTime = new Timestamp((new Date()).getTime());
        int window = 1800000; // 30 minutes

        if (this.getTimeLocked() == null) {
            return false;
        }

        if (currentTime.getTime() - this.getTimeLocked().getTime() <= window) {
            isTimeLocked = true;
        }

        return isTimeLocked;
    }

//	/**
//	 * @return true if this user's primary role is SysOp
//	 */
//	public boolean isSystemAdminstratorUser()
//	{
//		return isPrimaryRole(Constants.SYSTEMADMIN);
//	}
//
//	/**
//	 * @return true if this user's primary role is CB
//	 */
//	public boolean isCBUser()
//	{
//		return isPrimaryRole(Constants.CBUSER);
//	}
//
//	/**
//	 * @return true if this user's primary role is Regional
//	 */
//	public boolean isRegionalUser()
//	{
//		return isPrimaryRole(Constants.REGIONALUSER);
//	}
//
//	/**
//	 * @return true if this user's primary role is State
//	 */
//	public boolean isStateUser()
//	{
//		return isPrimaryRole(Constants.STATEUSER);
//	}

//	/**
//	 * @param otherUser
//	 *           to check
//	 * @return true if this instance of a site user can see the data for the user
//	 *         represented by otherUser
//	 */
//	public boolean canView(SiteUser otherUser)
//	{
//		boolean result = false;
//		if (hasPrivilege(Constants.PRIV_CAN_ADMIN_ALL_USERS))
//		{
//			result = true;
//		}
//		else if (isCBUser())
//		{
//			result = otherUser.isCBUser();
//		}
//		else if (isRegionalUser())
//		{
//			result = otherUser.isRegionalUser() && isSameRegion(region, otherUser.getRegion());
//		}
//		else if (isStateUser())
//		{
//			result = otherUser.isStateUser() && isSameState(state, otherUser.getState());
//		}
//		log.debug("SiteUser[" + this + "].canView(" + otherUser + ") = " + result);
//		return result;
//	}
//
//	/**
//	 * @param otherUser
//	 *           to check
//	 * @return true if this instance of a site user can edit the data for the
//	 *         user represented by otherUser
//	 */
//	public boolean canEdit(SiteUser otherUser)
//	{
//		boolean result = canView(otherUser) && hasAdministratorRights();
//		log.debug("SiteUser[" + this + "].canEdit(" + otherUser + ") = " + result);
//		return result;
//	}
//
//	private boolean isSameRegion(Region r1, Region r2)
//	{
//		if (r1 == r2)
//		{
//			return true;
//		}
//		else if ((r1 == null) || (r2 == null))
//		{
//			return false;
//		}
//		else
//		{
//			return r1.getRegion().equals(r2.getRegion());
//		}
//	}
//
//	private boolean isSameState(State s1, State s2)
//	{
//		if (s1 == s2)
//		{
//			return true;
//		}
//		else if ((s1 == null) || (s2 == null))
//		{
//			return false;
//		}
//		else
//		{
//			return s1.getStateName().equals(s2.getStateName());
//		}
//	}
//
//	public ValidationResult validate()
//	{
//		ValidationResult result = new ValidationResult();
//		String category = "SiteUser";
//		result.checkForRequiredField(category, "userName", "User Id is required", userName);
//		result.checkForRequiredField(category, "firstName", "First name is required", firstName);
//		result.checkForRequiredField(category, "lastName", "Last name is required", lastName);
//		if (isReceiveEmailNotifications()) {
//			String regexEmailPattern = "^([0-9a-zA-Z]+[-._+&amp;])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$";
//			result.checkForRegexMatch(category, "emailAddress", "A valid Email address is required when 'Receive Email Notifications' is set", emailAddress, regexEmailPattern);
//		}
//		result.checkForRequiredField(category, "primaryUserRole", "Primary user role is required",
//				primaryUserRole);
//		if (isRegionalUser())
//		{
//			result.checkForRequiredField(category, "region", "Region is required for regional users", region);
//		}
//		if (isStateUser())
//		{
//			result.checkForRequiredField(category, "state", "State is required for state users", state);
//		}
//
//		return result;
//	}

    public String toString() {
        return "SiteUser: " + userName;
    }

}
