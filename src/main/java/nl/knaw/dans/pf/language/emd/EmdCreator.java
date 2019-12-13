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
 * Container for resource properties of category creator.
 * 
 * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-creator">dcmi-terms/#terms-creator</a>
 * @author ecco
 */
public class EmdCreator extends AbstractEmdContainer {

    /**
     * Terms contained.
     */
    static final Term[] TERMS = {new Term(Term.Name.CREATOR, Term.Namespace.DC, BasicString.class),
            new Term(Term.Name.CREATOR, Term.Namespace.EAS, Author.class)};

    /**
     *
     */
    private static final long serialVersionUID = 709621311103768603L;

    private List<BasicString> dcCreator = new ArrayList<BasicString>();
    private List<Author> easCreator = new ArrayList<Author>();

    /**
     * {@inheritDoc}
     */
    public List<Term> getTerms() {
        return Arrays.asList(TERMS);
    }

    /**
     * Get a list of resource properties known as 'creator' in the "http://purl.org/dc/elements/1.1/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-creator">dcmi-terms/#terms-creator</a>
     * @return a list of resource properties
     */
    public List<BasicString> getDcCreator() {
        return dcCreator;
    }

    /**
     * Set a list of resource properties known as 'creator' in the "http://purl.org/dc/elements/1.1/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-creator">dcmi-terms/#terms-creator</a>
     * @param dcCreator
     *        a list of resource properties
     */
    public void setDcCreator(final List<BasicString> dcCreator) {
        this.dcCreator = dcCreator;
    }

    /**
     * Get a list of resource properties known as 'creator' in the "http://purl.org/dc/elements/1.1/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-creator">dcmi-terms/#terms-creator</a>
     * @return a list of resource properties
     */
    public List<Author> getEasCreator() {
        return easCreator;
    }

    /**
     * Set a list of resource properties known as 'creator' in the "http://purl.org/dc/elements/1.1/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-creator">dcmi-terms/#terms-creator</a>
     * @param easCreator
     *        a list of resource properties
     */
    public void setEasCreator(final List<Author> easCreator) {
        this.easCreator = easCreator;
    }

    public List<String> getDigitalAuthorIds() {
        List<String> dais = new ArrayList<String>();
        for (Author author : easCreator) {
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
        for (Author author : easCreator) {
            if (author.hasDigitalAuthorId()) {
                daiAuthors.add(author);
            }
        }
        return daiAuthors;
    }

}
