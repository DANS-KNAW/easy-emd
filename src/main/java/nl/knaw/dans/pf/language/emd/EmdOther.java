/*
 * Copyright (C) 2014 DANS - Data Archiving and Networked Services (info@dans.knaw.nl)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.knaw.dans.pf.language.emd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nl.knaw.dans.pf.language.emd.types.ApplicationSpecific;
import nl.knaw.dans.pf.language.emd.types.BasicRemark;

/**
 * Container for anything that can't be expressed in the Dublin Core Metadata Element Set, nor in the additional elements from the DCMI Metadata Terms. This
 * container is also suitable for global information about a resource.
 * 
 * @author ecco
 */
public class EmdOther extends AbstractEmdContainer {

    /**
     * Terms contained.
     */
    static final Term[] TERMS = {new Term(Term.Name.REMARKS, Term.Namespace.EAS, BasicRemark.class)// ,
    // new Term(Term.Name.APPLICATION_SPECIFIC, Term.Namespace.EAS, ApplicationSpecific.class)
    };

    /**
     *
     */
    private static final long serialVersionUID = 4267417466375324407L;

    private List<BasicRemark> easRemarks = new ArrayList<BasicRemark>();

    private ApplicationSpecific easApplicationSpecific = new ApplicationSpecific();

    private List<PropertyList> propertyListCollection = new ArrayList<PropertyList>();

    /**
     * {@inheritDoc}
     */
    public List<Term> getTerms() {
        return Arrays.asList(TERMS);
    }

    /**
     * Get a list of remarks.
     * 
     * @return a list of remarks
     */
    public List<BasicRemark> getEasRemarks() {
        return easRemarks;
    }

    /**
     * Set a list of remarks.
     * 
     * @param remarks
     *        a list of remarks
     */
    public void setEasRemarks(final List<BasicRemark> remarks) {
        this.easRemarks = remarks;
    }

    public ApplicationSpecific getEasApplicationSpecific() {
        return easApplicationSpecific;
    }

    public void setEasApplicationSpecific(ApplicationSpecific easApplicationSpecific) {
        this.easApplicationSpecific = easApplicationSpecific;
    }

    public List<PropertyList> getPropertyListCollection() {
        if (null == propertyListCollection) {
            propertyListCollection = new ArrayList<PropertyList>();
        }
        return propertyListCollection;
    }

    public void setPropertyListCollection(List<PropertyList> propertyListCollection) {
        this.propertyListCollection = propertyListCollection;
    }

    public void add(PropertyList propertyList) {
        getPropertyListCollection().add(propertyList);
    }

}
