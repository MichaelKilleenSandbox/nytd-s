/**
 * Filename: NYTDSystem.java
 * <p>
 * Copyright 2009, ICF International
 * Created: Sep 16, 2009
 * Author: 15178
 * <p>
 * COPYRIGHT STATUS: This work, authored by ICF International employees, was funded in whole or in part
 * under U.S. Government contract, and is, therefore, subject to the following license: The Government is
 * granted for itself and others acting on its behalf a paid-up, nonexclusive, irrevocable worldwide
 * license in this work to reproduce, prepare derivative works, distribute copies to the public, and perform
 * publicly and display publicly, by or on behalf of the Government. All other rights are reserved by the
 * copyright owner.
 */
package gov.hhs.acf.cb.nytds.persistence.entity;

import lombok.Getter;
import lombok.Setter;


/**
 * @author 15178
 */

public class NYTDSystem implements Sender {
    @Getter
    @Setter
    private String name = "NYTD Federal System";
    @Getter
    @Setter
    private String signature = "NYTD Federal System Admin";
    @Getter
    @Setter
    private String beforSignatureWord = "Regards";
    @Getter
    @Setter
    private String messageAddressedTo = "Dear NYTD User,";


}
