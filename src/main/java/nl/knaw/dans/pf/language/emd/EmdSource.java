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

import nl.knaw.dans.pf.language.emd.types.BasicIdentifier;

/**
 * Container for resource properties of category source.
 * 
 * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-source">dcmi-terms/#terms-source</a>
 * @author ecco
 */
public class EmdSource extends AbstractEmdContainer {

    /**
     * Terms contained.
     */
    static final Term[] TERMS = {new Term(Term.Name.SOURCE, Term.Namespace.DC, BasicIdentifier.class)};

    /**
     *
     */
    private static final long serialVersionUID = -8406539731481024935L;

    private List<BasicIdentifier> dcSource = new ArrayList<BasicIdentifier>();

    /**
     * {@inheritDoc}
     */
    public List<Term> getTerms() {
        return Arrays.asList(TERMS);
    }

    /**
     * Get a list of resource properties known as 'source' in the "http://purl.org/dc/elements/1.1/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-source">dcmi-terms/#terms-source</a>
     * @return a list of resource properties
     */
    public List<BasicIdentifier> getDcSource() {
        return dcSource;
    }

    /**
     * Set a list of resource properties known as 'source' in the "http://purl.org/dc/elements/1.1/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-source">dcmi-terms/#terms-source</a>
     * @param dcSource
     *        a list of resource properties
     */
    public void setDcSource(final List<BasicIdentifier> dcSource) {
        this.dcSource = dcSource;
    }

}
