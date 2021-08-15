package gov.hhs.acf.cb.nytds.persistence.entity;

/**
 * Filename: SystemGeneratedMessage.java
 * 
 *  Copyright 2009, ICF International
 *  Created: Oct 7, 2009
 *  Author: 16939
 *
 *  COPYRIGHT STATUS: This work, authored by ICF International employees, was funded in whole or in part 
 *  under U.S. Government contract, and is, therefore, subject to the following license: The Government is 
 *  granted for itself and others acting on its behalf a paid-up, nonexclusive, irrevocable worldwide 
 *  license in this work to reproduce, prepare derivative works, distribute copies to the public, and perform 
 *  publicly and display publicly, by or on behalf of the Government. All other rights are reserved by the 
 *  copyright owner.
 */

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * @author 16939
 *
 */
@Entity
public class SystemGeneratedMessage extends BaseEntity {
	@Getter	@Setter
	private String systemMessageBody;
	@Getter @Setter
	private String subject;
	@Getter @Setter
	private Long duration;

}
