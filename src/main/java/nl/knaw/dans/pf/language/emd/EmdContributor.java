/**
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

import nl.knaw.dans.pf.language.emd.types.Author;
import nl.knaw.dans.pf.language.emd.types.BasicString;

/**
 * Container for resource properties of category contributor.
 * 
 * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-contributor">dcmi-terms/#terms-contributor</a>
 * @author ecco
 */
public class EmdContributor extends AbstractEmdContainer {

    /**
     * Terms contained.
     */
    static final Term[] TERMS = {new Term(Term.Name.CONTRIBUTOR, Term.Namespace.DC, BasicString.class),
            new Term(Term.Name.CONTRIBUTOR, Term.Namespace.EAS, Author.class)};

    /**
     *
     */
    private static final long serialVersionUID = 7285039294774059387L;

    private List<BasicString> dcContributor = new ArrayList<BasicString>();
    private List<Author> easContributor = new ArrayList<Author>();

    /**
     * {@inheritDoc}
     */
    public List<Term> getTerms() {
        return Arrays.asList(TERMS);
    }

    /**
     * Get a list of resource properties known as 'contributor' in the "http://purl.org/dc/elements/1.1/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-contributor">dcmi-terms/#terms-contributor</a>
     * @return a list of resource properties
     */
    public List<BasicString> getDcContributor() {
        return dcContributor;
    }

    /**
     * Set a list of resource properties known as 'contributor' in the "http://purl.org/dc/elements/1.1/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-contributor">dcmi-terms/#terms-contributor</a>
     * @param dcContributor
     *        a list of resource properties
     */
    public void setDcContributor(final List<BasicString> dcContributor) {
        this.dcContributor = dcContributor;
    }

    /**
     * Get a list of resource properties known as 'contributor' in the "http://purl.org/dc/elements/1.1/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-contributor">dcmi-terms/#terms-contributor</a>
     * @return a list of resource properties
     */
    public List<Author> getEasContributor() {
        return easContributor;
    }

    /**
     * Set a list of resource properties known as 'contributor' in the "http://purl.org/dc/elements/1.1/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-contributor">dcmi-terms/#terms-contributor</a>
     * @param easContributor
     *        a list of resource properties
     */
    public void setEasContributor(final List<Author> easContributor) {
        this.easContributor = easContributor;
    }

    public List<String> getDigitalAuthorIds() {
        List<String> dais = new ArrayList<String>();
        for (Author author : easContributor) {
            if (author.hasDigitalAuthorId()) {
                String entityId = author.getEntityId();
                if (entityId != null)
                    dais.add(entityId);
            }
        }
        return dais;
    }

    public List<Author> getDAIAuthors() {
        List<Author> daiAuthors = new ArrayList<Author>();
        for (Author author : easContributor) {
            if (author.hasDigitalAuthorId()) {
                daiAuthors.add(author);
            }
        }
        return daiAuthors;
    }

}
