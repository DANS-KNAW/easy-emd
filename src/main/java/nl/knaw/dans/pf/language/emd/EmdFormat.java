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

import nl.knaw.dans.pf.language.emd.types.BasicString;

/**
 * Container for resource properties of category format.
 * 
 * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-format">dcmi-terms/#terms-format</a>
 * @author ecco
 */
public class EmdFormat extends AbstractEmdContainer {

    /**
     * Terms contained.
     */
    static final Term[] TERMS = {new Term(Term.Name.FORMAT, Term.Namespace.DC, BasicString.class),
            new Term(Term.Name.EXTENT, Term.Namespace.DCTERMS, BasicString.class), new Term(Term.Name.MEDIUM, Term.Namespace.DCTERMS, BasicString.class)};

    /**
     *
     */
    private static final long serialVersionUID = 2241428118907275164L;

    private List<BasicString> dcFormat = new ArrayList<BasicString>();

    private List<BasicString> termsExtent = new ArrayList<BasicString>();

    private List<BasicString> termsMedium = new ArrayList<BasicString>();

    /**
     * {@inheritDoc}
     */
    public List<Term> getTerms() {
        return Arrays.asList(TERMS);
    }

    /**
     * Get a list of resource properties known as 'format' in the "http://purl.org/dc/elements/1.1/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-format">dcmi-terms/#terms-format</a>
     * @return a list of resource properties
     */
    public List<BasicString> getDcFormat() {
        return dcFormat;
    }

    /**
     * Set a list of resource properties known as 'format' in the "http://purl.org/dc/elements/1.1/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-format">dcmi-terms/#terms-format</a>
     * @param dcFormat
     *        a list of resource properties
     */
    public void setDcFormat(final List<BasicString> dcFormat) {
        this.dcFormat = dcFormat;
    }

    /**
     * Get a list of resource properties known as 'extent' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-extent">dcmi-terms/#terms-extent</a>
     * @return a list of resource properties
     */
    public List<BasicString> getTermsExtent() {
        return termsExtent;
    }

    /**
     * Set a list of resource properties known as 'extent' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-extent">dcmi-terms/#terms-extent</a>
     * @param termsExtent
     *        a list of resource properties
     */
    public void setTermsExtent(final List<BasicString> termsExtent) {
        this.termsExtent = termsExtent;
    }

    /**
     * Get a list of resource properties known as 'medium' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-medium">dcmi-terms/#terms-medium</a>
     * @return a list of resource properties
     */
    public List<BasicString> getTermsMedium() {
        return termsMedium;
    }

    /**
     * Set a list of resource properties known as 'medium' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-medium">dcmi-terms/#terms-medium</a>
     * @param termsMedium
     *        a list of resource properties
     */
    public void setTermsMedium(final List<BasicString> termsMedium) {
        this.termsMedium = termsMedium;
    }
}
