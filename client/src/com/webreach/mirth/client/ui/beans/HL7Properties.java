/*
 * X12Properties.java
 *
 * Created on February 16, 2007, 4:21 PM
 */

package com.webreach.mirth.client.ui.beans;

import java.beans.*;
import java.io.Serializable;

/**
 * @author brendanh
 */
public class HL7Properties implements Serializable
{
    
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    
    private PropertyChangeSupport propertySupport;
    
    public HL7Properties()
    {
        propertySupport = new PropertyChangeSupport(this);
    }

    /**
     * Holds value of property validateMessage.
     */
    private boolean validateMessage = true;

    /**
     * Getter for property validateMessage.
     * @return Value of property validateMessage.
     */
    public boolean isValidateMessage()
    {
        return this.validateMessage;
    }

    /**
     * Setter for property validateMessage.
     * @param validateMessage New value of property validateMessage.
     */
    public void setValidateMessage(boolean validateMessage)
    {
        this.validateMessage = validateMessage;
    }

    /**
     * Holds value of property receiveXML.
     */
    private boolean receiveXML = false;

    /**
     * Getter for property receiveXML.
     * @return Value of property receiveXML.
     */
    public boolean isReceiveXML()
    {
        return this.receiveXML;
    }

    /**
     * Setter for property receiveXML.
     * @param receiveXML New value of property receiveXML.
     */
    public void setReceiveXML(boolean receiveXML)
    {
        this.receiveXML = receiveXML;
    }   
}
