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

import nl.knaw.dans.pf.language.emd.types.BasicString;
import nl.knaw.dans.pf.language.emd.types.Relation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Container for resource properties of category relation.
 * 
 * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-relation">dcmi-terms/#terms-relation</a>
 * @author ecco
 */
public class EmdRelation extends AbstractEmdContainer {

    private static List<String> QUALIFIER_LIST;

    /**
     *
     */
    private static final long serialVersionUID = 2575109351833151169L;

    private List<BasicString> dcRelation;
    private List<BasicString> termsConformsTo;
    private List<BasicString> termsIsVersionOf;
    private List<BasicString> termsHasVersion;
    private List<BasicString> termsIsReplacedBy;
    private List<BasicString> termsReplaces;
    private List<BasicString> termsIsRequiredBy;
    private List<BasicString> termsRequires;
    private List<BasicString> termsIsPartOf;
    private List<BasicString> termsHasPart;
    private List<BasicString> termsIsReferencedBy;
    private List<BasicString> termsReferences;
    private List<BasicString> termsIsFormatOf;
    private List<BasicString> termsHasFormat;
    private List<Relation> easRelation;
    private List<Relation> easConformsTo;
    private List<Relation> easIsVersionOf;
    private List<Relation> easHasVersion;
    private List<Relation> easIsReplacedBy;
    private List<Relation> easReplaces;
    private List<Relation> easIsRequiredBy;
    private List<Relation> easRequires;
    private List<Relation> easIsPartOf;
    private List<Relation> easHasPart;
    private List<Relation> easIsReferencedBy;
    private List<Relation> easReferences;
    private List<Relation> easIsFormatOf;
    private List<Relation> easHasFormat;

    /**
     * Terms contained.
     */
    static final Term[] TERMS = {new Term(Term.Name.RELATION, Term.Namespace.DC, BasicString.class),
            new Term(Term.Name.CONFORMS_TO, Term.Namespace.DCTERMS, BasicString.class),
            new Term(Term.Name.IS_VERSION_OF, Term.Namespace.DCTERMS, BasicString.class),
            new Term(Term.Name.HAS_VERSION, Term.Namespace.DCTERMS, BasicString.class),
            new Term(Term.Name.IS_REPLACED_BY, Term.Namespace.DCTERMS, BasicString.class),
            new Term(Term.Name.REPLACES, Term.Namespace.DCTERMS, BasicString.class),
            new Term(Term.Name.IS_REQUIRED_BY, Term.Namespace.DCTERMS, BasicString.class),
            new Term(Term.Name.REQUIRES, Term.Namespace.DCTERMS, BasicString.class), new Term(Term.Name.IS_PART_OF, Term.Namespace.DCTERMS, BasicString.class),
            new Term(Term.Name.HAS_PART, Term.Namespace.DCTERMS, BasicString.class),
            new Term(Term.Name.IS_REFERENCED_BY, Term.Namespace.DCTERMS, BasicString.class),
            new Term(Term.Name.REFERENCES, Term.Namespace.DCTERMS, BasicString.class),
            new Term(Term.Name.IS_FORMAT_OF, Term.Namespace.DCTERMS, BasicString.class),
            new Term(Term.Name.HAS_FORMAT, Term.Namespace.DCTERMS, BasicString.class),

            new Term(Term.Name.RELATION, Term.Namespace.EAS, Relation.class), new Term(Term.Name.CONFORMS_TO, Term.Namespace.EAS, Relation.class),
            new Term(Term.Name.IS_VERSION_OF, Term.Namespace.EAS, Relation.class), new Term(Term.Name.HAS_VERSION, Term.Namespace.EAS, Relation.class),
            new Term(Term.Name.IS_REPLACED_BY, Term.Namespace.EAS, Relation.class), new Term(Term.Name.REPLACES, Term.Namespace.EAS, Relation.class),
            new Term(Term.Name.IS_REQUIRED_BY, Term.Namespace.EAS, Relation.class), new Term(Term.Name.REQUIRES, Term.Namespace.EAS, Relation.class),
            new Term(Term.Name.IS_PART_OF, Term.Namespace.EAS, Relation.class), new Term(Term.Name.HAS_PART, Term.Namespace.EAS, Relation.class),
            new Term(Term.Name.IS_REFERENCED_BY, Term.Namespace.EAS, Relation.class), new Term(Term.Name.REFERENCES, Term.Namespace.EAS, Relation.class),
            new Term(Term.Name.IS_FORMAT_OF, Term.Namespace.EAS, Relation.class), new Term(Term.Name.HAS_FORMAT, Term.Namespace.EAS, Relation.class)};

    public static final String RELATION = "";
    public static final String CONFORMS_TO = "conformsTo";
    public static final String HAS_FORMAT = "hasFormat";
    public static final String HAS_PART = "hasPart";
    public static final String REFERENCES = "references";
    public static final String REPLACES = "replaces";
    public static final String REQUIRES = "requires";
    public static final String HAS_VERSION = "hasVersion";
    public static final String IS_FORMAT_OF = "isFormatOf";
    public static final String IS_PART_OF = "isPartOf";
    public static final String IS_REFERENCED_BY = "isReferencedBy";
    public static final String IS_REPLACED_BY = "isReplacedBy";
    public static final String IS_REQUIRED_BY = "isRequiredBy";
    public static final String IS_VERSION_OF = "isVersionOf";

    public static List<String> getQualifierList() {
        if (QUALIFIER_LIST == null) {
            QUALIFIER_LIST = new ArrayList<String>();
            QUALIFIER_LIST.add(RELATION);
            QUALIFIER_LIST.add(CONFORMS_TO);
            QUALIFIER_LIST.add(HAS_FORMAT);
            QUALIFIER_LIST.add(HAS_PART);
            QUALIFIER_LIST.add(REFERENCES);
            QUALIFIER_LIST.add(REPLACES);
            QUALIFIER_LIST.add(REQUIRES);
            QUALIFIER_LIST.add(HAS_VERSION);
            QUALIFIER_LIST.add(IS_FORMAT_OF);
            QUALIFIER_LIST.add(IS_PART_OF);
            QUALIFIER_LIST.add(IS_REFERENCED_BY);
            QUALIFIER_LIST.add(IS_REPLACED_BY);
            QUALIFIER_LIST.add(IS_REQUIRED_BY);
            QUALIFIER_LIST.add(IS_VERSION_OF);
        }
        return Collections.unmodifiableList(QUALIFIER_LIST);
    }

    public Map<String, List<Relation>> getRelationMap() {
        Map<String, List<Relation>> map = new HashMap<String, List<Relation>>();
        map.put(RELATION, this.getEasRelation());
        map.put(CONFORMS_TO, this.getEasConformsTo());
        map.put(HAS_FORMAT, this.getEasHasFormat());
        map.put(HAS_PART, this.getEasHasPart());
        map.put(REFERENCES, this.getEasReferences());
        map.put(REPLACES, this.getEasReplaces());
        map.put(REQUIRES, this.getEasRequires());
        map.put(HAS_VERSION, this.getEasHasVersion());
        map.put(IS_FORMAT_OF, this.getEasIsFormatOf());
        map.put(IS_PART_OF, this.getEasIsPartOf());
        map.put(IS_REFERENCED_BY, this.getEasIsReferencedBy());
        map.put(IS_REPLACED_BY, this.getEasIsReplacedBy());
        map.put(IS_REQUIRED_BY, this.getEasIsRequiredBy());
        map.put(IS_VERSION_OF, this.getEasIsVersionOf());

        return map;
    }

    public Map<String, List<BasicString>> getDCRelationMap() {
        Map<String, List<BasicString>> map = new HashMap<String, List<BasicString>>();
        map.put(RELATION, this.getDcRelation());
        map.put(CONFORMS_TO, this.getTermsConformsTo());
        map.put(HAS_FORMAT, this.getTermsHasFormat());
        map.put(HAS_PART, this.getTermsHasPart());
        map.put(REFERENCES, this.getTermsReferences());
        map.put(REPLACES, this.getTermsReplaces());
        map.put(REQUIRES, this.getTermsRequires());
        map.put(HAS_VERSION, this.getTermsHasVersion());
        map.put(IS_FORMAT_OF, this.getTermsIsFormatOf());
        map.put(IS_PART_OF, this.getTermsIsPartOf());
        map.put(IS_REFERENCED_BY, this.getTermsIsReferencedBy());
        map.put(IS_REPLACED_BY, this.getTermsIsReplacedBy());
        map.put(IS_REQUIRED_BY, this.getTermsIsRequiredBy());
        map.put(IS_VERSION_OF, this.getTermsIsVersionOf());

        return map;
    }

    public static final String[] LIST_KEYS = {RELATION, CONFORMS_TO, HAS_FORMAT, HAS_PART, REFERENCES, REPLACES, REQUIRES, HAS_VERSION, IS_FORMAT_OF,
            IS_PART_OF, IS_REFERENCED_BY, IS_REPLACED_BY, IS_REQUIRED_BY, IS_VERSION_OF};

    /**
     * {@inheritDoc}
     */
    public List<Term> getTerms() {
        return Arrays.asList(TERMS);
    }

    /**
     * Get a list of resource properties known as 'relation' in the "http://purl.org/dc/elements/1.1/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-relation">dcmi-terms/#terms-relation</a>
     * @return a list of resource properties
     */
    public List<BasicString> getDcRelation() {
        if (dcRelation == null) {
            dcRelation = new ArrayList<BasicString>();
        }
        return dcRelation;
    }

    /**
     * Set a list of resource properties known as 'relation' in the "http://purl.org/dc/elements/1.1/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-relation">dcmi-terms/#terms-relation</a>
     * @param list
     *        a list of resource properties
     */
    public void setDcRelation(final List<BasicString> list) {
        this.dcRelation = list;
    }

    /**
     * Get a list of resource properties known as 'conformsTo' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-conformsTo">dcmi-terms/#terms-conformsTo</a>
     * @return a list of resource properties
     */
    public List<BasicString> getTermsConformsTo() {
        if (termsConformsTo == null) {
            termsConformsTo = new ArrayList<BasicString>();
        }
        return termsConformsTo;
    }

    /**
     * Set a list of resource properties known as 'conformsTo' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-conformsTo">dcmi-terms/#terms-conformsTo</a>
     * @param list
     *        a list of resource properties
     */
    public void setTermsConformsTo(final List<BasicString> list) {
        this.termsConformsTo = list;
    }

    /**
     * Get a list of resource properties known as 'isVersionOf' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-isVersionOf">dcmi-terms/#terms-isVersionOf</a>
     * @return a list of resource properties
     */
    public List<BasicString> getTermsIsVersionOf() {
        if (termsIsVersionOf == null) {
            termsIsVersionOf = new ArrayList<BasicString>();
        }
        return termsIsVersionOf;
    }

    /**
     * Set a list of resource properties known as 'isVersionOf' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-isVersionOf">dcmi-terms/#terms-isVersionOf</a>
     * @param list
     *        a list of resource properties
     */
    public void setTermsIsVersionOf(final List<BasicString> list) {
        this.termsIsVersionOf = list;
    }

    /**
     * Get a list of resource properties known as 'hasVersion' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-hasVersion">dcmi-terms/#terms-hasVersion</a>
     * @return a list of resource properties
     */
    public List<BasicString> getTermsHasVersion() {
        if (termsHasVersion == null) {
            termsHasVersion = new ArrayList<BasicString>();
        }
        return termsHasVersion;
    }

    /**
     * Set a list of resource properties known as 'hasVersion' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-hasVersion">dcmi-terms/#terms-hasVersion</a>
     * @param list
     *        a list of resource properties
     */
    public void setTermsHasVersion(final List<BasicString> list) {
        this.termsHasVersion = list;
    }

    /**
     * Get a list of resource properties known as 'isReplacedBy' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-isReplacedBy">dcmi-terms/#terms-isReplacedBy</a>
     * @return a list of resource properties
     */
    public List<BasicString> getTermsIsReplacedBy() {
        if (termsIsReplacedBy == null) {
            termsIsReplacedBy = new ArrayList<BasicString>();
        }
        return termsIsReplacedBy;
    }

    /**
     * Set a list of resource properties known as 'isReplacedBy' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-isReplacedBy">dcmi-terms/#terms-isReplacedBy</a>
     * @param list
     *        a list of resource properties
     */
    public void setTermsIsReplacedBy(final List<BasicString> list) {
        this.termsIsReplacedBy = list;
    }

    /**
     * Get a list of resource properties known as 'replaces' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-replaces">dcmi-terms/#terms-replaces</a>
     * @return a list of resource properties
     */
    public List<BasicString> getTermsReplaces() {
        if (termsReplaces == null) {
            termsReplaces = new ArrayList<BasicString>();
        }
        return termsReplaces;
    }

    /**
     * Set a list of resource properties known as 'replaces' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-replaces">dcmi-terms/#terms-replaces</a>
     * @param list
     *        a list of resource properties
     */
    public void setTermsReplaces(final List<BasicString> list) {
        this.termsReplaces = list;
    }

    /**
     * Get a list of resource properties known as 'isRequiredBy' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-isRequiredBy">dcmi-terms/#terms-isRequiredBy</a>
     * @return a list of resource properties
     */
    public List<BasicString> getTermsIsRequiredBy() {
        if (termsIsRequiredBy == null) {
            termsIsRequiredBy = new ArrayList<BasicString>();
        }
        return termsIsRequiredBy;
    }

    /**
     * Set a list of resource properties known as 'isRequiredBy' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-isRequiredBy">dcmi-terms/#terms-isRequiredBy</a>
     * @param list
     *        a list of resource properties
     */
    public void setTermsIsRequiredBy(final List<BasicString> list) {
        this.termsIsRequiredBy = list;
    }

    /**
     * Get a list of resource properties known as 'requires' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-requires">dcmi-terms/#terms-requires</a>
     * @return a list of resource properties
     */
    public List<BasicString> getTermsRequires() {
        if (termsRequires == null) {
            termsRequires = new ArrayList<BasicString>();
        }
        return termsRequires;
    }

    /**
     * Set a list of resource properties known as 'requires' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-requires">dcmi-terms/#terms-requires</a>
     * @param list
     *        a list of resource properties
     */
    public void setTermsRequires(final List<BasicString> list) {
        this.termsRequires = list;
    }

    /**
     * Get a list of resource properties known as 'isPartOf' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-isPartOf">dcmi-terms/#terms-isPartOf</a>
     * @return a list of resource properties
     */
    public List<BasicString> getTermsIsPartOf() {
        if (termsIsPartOf == null) {
            termsIsPartOf = new ArrayList<BasicString>();
        }
        return termsIsPartOf;
    }

    /**
     * Set a list of resource properties known as 'isPartOf' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-isPartOf">dcmi-terms/#terms-isPartOf</a>
     * @param list
     *        a list of resource properties
     */
    public void setTermsIsPartOf(final List<BasicString> list) {
        this.termsIsPartOf = list;
    }

    /**
     * Get a list of resource properties known as 'hasPart' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-hasPart">dcmi-terms/#terms-hasPart</a>
     * @return a list of resource properties
     */
    public List<BasicString> getTermsHasPart() {
        if (termsHasPart == null) {
            termsHasPart = new ArrayList<BasicString>();
        }
        return termsHasPart;
    }

    /**
     * Set a list of resource properties known as 'hasPart' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-hasPart">dcmi-terms/#terms-hasPart</a>
     * @param list
     *        a list of resource properties
     */
    public void setTermsHasPart(final List<BasicString> list) {
        this.termsHasPart = list;
    }

    /**
     * Get a list of resource properties known as 'isReferencedBy' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-isReferencedBy">dcmi-terms/#terms-isReferencedBy</a>
     * @return a list of resource properties
     */
    public List<BasicString> getTermsIsReferencedBy() {
        if (termsIsReferencedBy == null) {
            termsIsReferencedBy = new ArrayList<BasicString>();
        }
        return termsIsReferencedBy;
    }

    /**
     * Set a list of resource properties known as 'isReferencedBy' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-isReferencedBy">dcmi-terms/#terms-isReferencedBy</a>
     * @param list
     *        a list of resource properties
     */
    public void setTermsIsReferencedBy(final List<BasicString> list) {
        this.termsIsReferencedBy = list;
    }

    /**
     * Get a list of resource properties known as 'references' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-references">dcmi-terms/#terms-references</a>
     * @return a list of resource properties
     */
    public List<BasicString> getTermsReferences() {
        if (termsReferences == null) {
            termsReferences = new ArrayList<BasicString>();
        }
        return termsReferences;
    }

    /**
     * Set a list of resource properties known as 'references' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-references">dcmi-terms/#terms-references</a>
     * @param list
     *        a list of resource properties
     */
    public void setTermsReferences(final List<BasicString> list) {
        this.termsReferences = list;
    }

    /**
     * Get a list of resource properties known as 'isFormatOf' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-isFormatOf">dcmi-terms/#terms-isFormatOf</a>
     * @return a list of resource properties
     */
    public List<BasicString> getTermsIsFormatOf() {
        if (termsIsFormatOf == null) {
            termsIsFormatOf = new ArrayList<BasicString>();
        }
        return termsIsFormatOf;
    }

    /**
     * Set a list of resource properties known as 'isFormatOf' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-isFormatOf">dcmi-terms/#terms-isFormatOf</a>
     * @param list
     *        a list of resource properties
     */
    public void setTermsIsFormatOf(final List<BasicString> list) {
        this.termsIsFormatOf = list;
    }

    /**
     * Get a list of resource properties known as 'hasFormat' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-hasFormat">dcmi-terms/#terms-hasFormat</a>
     * @return a list of resource properties
     */
    public List<BasicString> getTermsHasFormat() {
        if (termsHasFormat == null) {
            termsHasFormat = new ArrayList<BasicString>();
        }
        return termsHasFormat;
    }

    /**
     * Set a list of resource properties known as 'hasFormat' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-hasFormat">dcmi-terms/#terms-hasFormat</a>
     * @param list
     *        a list of resource properties
     */
    public void setTermsHasFormat(final List<BasicString> list) {
        this.termsHasFormat = list;
    }

    // ////////////////

    /**
     * Get a list of resource properties known as 'relation' in the "http://purl.org/dc/elements/1.1/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-relation">dcmi-terms/#terms-relation</a>
     * @return a list of resource properties
     */
    public List<Relation> getEasRelation() {
        if (easRelation == null) {
            easRelation = new ArrayList<Relation>();
        }
        return easRelation;
    }

    /**
     * Set a list of resource properties known as 'relation' in the "http://purl.org/dc/elements/1.1/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-relation">dcmi-terms/#terms-relation</a>
     * @param list
     *        a list of resource properties
     */
    public void setEasRelation(final List<Relation> list) {
        this.easRelation = list;
    }

    /**
     * Get a list of resource properties known as 'conformsTo' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-conformsTo">dcmi-terms/#terms-conformsTo</a>
     * @return a list of resource properties
     */
    public List<Relation> getEasConformsTo() {
        if (easConformsTo == null) {
            easConformsTo = new ArrayList<Relation>();
        }
        return easConformsTo;
    }

    /**
     * Set a list of resource properties known as 'conformsTo' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-conformsTo">dcmi-terms/#terms-conformsTo</a>
     * @param list
     *        a list of resource properties
     */
    public void setEasConformsTo(final List<Relation> list) {
        this.easConformsTo = list;
    }

    /**
     * Get a list of resource properties known as 'isVersionOf' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-isVersionOf">dcmi-terms/#terms-isVersionOf</a>
     * @return a list of resource properties
     */
    public List<Relation> getEasIsVersionOf() {
        if (easIsVersionOf == null) {
            easIsVersionOf = new ArrayList<Relation>();
        }
        return easIsVersionOf;
    }

    /**
     * Set a list of resource properties known as 'isVersionOf' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-isVersionOf">dcmi-terms/#terms-isVersionOf</a>
     * @param list
     *        a list of resource properties
     */
    public void setEasIsVersionOf(final List<Relation> list) {
        this.easIsVersionOf = list;
    }

    /**
     * Get a list of resource properties known as 'hasVersion' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-hasVersion">dcmi-terms/#terms-hasVersion</a>
     * @return a list of resource properties
     */
    public List<Relation> getEasHasVersion() {
        if (easHasVersion == null) {
            easHasVersion = new ArrayList<Relation>();
        }
        return easHasVersion;
    }

    /**
     * Set a list of resource properties known as 'hasVersion' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-hasVersion">dcmi-terms/#terms-hasVersion</a>
     * @param list
     *        a list of resource properties
     */
    public void setEasHasVersion(final List<Relation> list) {
        this.easHasVersion = list;
    }

    /**
     * Get a list of resource properties known as 'isReplacedBy' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-isReplacedBy">dcmi-terms/#terms-isReplacedBy</a>
     * @return a list of resource properties
     */
    public List<Relation> getEasIsReplacedBy() {
        if (easIsReplacedBy == null) {
            easIsReplacedBy = new ArrayList<Relation>();
        }
        return easIsReplacedBy;
    }

    /**
     * Set a list of resource properties known as 'isReplacedBy' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-isReplacedBy">dcmi-terms/#terms-isReplacedBy</a>
     * @param list
     *        a list of resource properties
     */
    public void setEasIsReplacedBy(final List<Relation> list) {
        this.easIsReplacedBy = list;
    }

    /**
     * Get a list of resource properties known as 'replaces' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-replaces">dcmi-terms/#terms-replaces</a>
     * @return a list of resource properties
     */
    public List<Relation> getEasReplaces() {
        if (easReplaces == null) {
            easReplaces = new ArrayList<Relation>();
        }
        return easReplaces;
    }

    /**
     * Set a list of resource properties known as 'replaces' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-replaces">dcmi-terms/#terms-replaces</a>
     * @param list
     *        a list of resource properties
     */
    public void setEasReplaces(final List<Relation> list) {
        this.easReplaces = list;
    }

    /**
     * Get a list of resource properties known as 'isRequiredBy' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-isRequiredBy">dcmi-terms/#terms-isRequiredBy</a>
     * @return a list of resource properties
     */
    public List<Relation> getEasIsRequiredBy() {
        if (easIsRequiredBy == null) {
            easIsRequiredBy = new ArrayList<Relation>();
        }
        return easIsRequiredBy;
    }

    /**
     * Set a list of resource properties known as 'isRequiredBy' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-isRequiredBy">dcmi-terms/#terms-isRequiredBy</a>
     * @param list
     *        a list of resource properties
     */
    public void setEasIsRequiredBy(final List<Relation> list) {
        this.easIsRequiredBy = list;
    }

    /**
     * Get a list of resource properties known as 'requires' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-requires">dcmi-terms/#terms-requires</a>
     * @return a list of resource properties
     */
    public List<Relation> getEasRequires() {
        if (easRequires == null) {
            easRequires = new ArrayList<Relation>();
        }
        return easRequires;
    }

    /**
     * Set a list of resource properties known as 'requires' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-requires">dcmi-terms/#terms-requires</a>
     * @param list
     *        a list of resource properties
     */
    public void setEasRequires(final List<Relation> list) {
        this.easRequires = list;
    }

    /**
     * Get a list of resource properties known as 'isPartOf' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-isPartOf">dcmi-terms/#terms-isPartOf</a>
     * @return a list of resource properties
     */
    public List<Relation> getEasIsPartOf() {
        if (easIsPartOf == null) {
            easIsPartOf = new ArrayList<Relation>();
        }
        return easIsPartOf;
    }

    /**
     * Set a list of resource properties known as 'isPartOf' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-isPartOf">dcmi-terms/#terms-isPartOf</a>
     * @param list
     *        a list of resource properties
     */
    public void setEasIsPartOf(final List<Relation> list) {
        this.easIsPartOf = list;
    }

    /**
     * Get a list of resource properties known as 'hasPart' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-hasPart">dcmi-terms/#terms-hasPart</a>
     * @return a list of resource properties
     */
    public List<Relation> getEasHasPart() {
        if (easHasPart == null) {
            easHasPart = new ArrayList<Relation>();
        }
        return easHasPart;
    }

    /**
     * Set a list of resource properties known as 'hasPart' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-hasPart">dcmi-terms/#terms-hasPart</a>
     * @param list
     *        a list of resource properties
     */
    public void setEasHasPart(final List<Relation> list) {
        this.easHasPart = list;
    }

    /**
     * Get a list of resource properties known as 'isReferencedBy' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-isReferencedBy">dcmi-terms/#terms-isReferencedBy</a>
     * @return a list of resource properties
     */
    public List<Relation> getEasIsReferencedBy() {
        if (easIsReferencedBy == null) {
            easIsReferencedBy = new ArrayList<Relation>();
        }
        return easIsReferencedBy;
    }

    /**
     * Set a list of resource properties known as 'isReferencedBy' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-isReferencedBy">dcmi-terms/#terms-isReferencedBy</a>
     * @param list
     *        a list of resource properties
     */
    public void setEasIsReferencedBy(final List<Relation> list) {
        this.easIsReferencedBy = list;
    }

    /**
     * Get a list of resource properties known as 'references' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-references">dcmi-terms/#terms-references</a>
     * @return a list of resource properties
     */
    public List<Relation> getEasReferences() {
        if (easReferences == null) {
            easReferences = new ArrayList<Relation>();
        }
        return easReferences;
    }

    /**
     * Set a list of resource properties known as 'references' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-references">dcmi-terms/#terms-references</a>
     * @param list
     *        a list of resource properties
     */
    public void setEasReferences(final List<Relation> list) {
        this.easReferences = list;
    }

    /**
     * Get a list of resource properties known as 'isFormatOf' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-isFormatOf">dcmi-terms/#terms-isFormatOf</a>
     * @return a list of resource properties
     */
    public List<Relation> getEasIsFormatOf() {
        if (easIsFormatOf == null) {
            easIsFormatOf = new ArrayList<Relation>();
        }
        return easIsFormatOf;
    }

    /**
     * Set a list of resource properties known as 'isFormatOf' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-isFormatOf">dcmi-terms/#terms-isFormatOf</a>
     * @param list
     *        a list of resource properties
     */
    public void setEasIsFormatOf(final List<Relation> list) {
        this.easIsFormatOf = list;
    }

    /**
     * Get a list of resource properties known as 'hasFormat' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-hasFormat">dcmi-terms/#terms-hasFormat</a>
     * @return a list of resource properties
     */
    public List<Relation> getEasHasFormat() {
        if (easHasFormat == null) {
            easHasFormat = new ArrayList<Relation>();
        }
        return easHasFormat;
    }

    /**
     * Set a list of resource properties known as 'hasFormat' in the "http://purl.org/dc/terms/" name space.
     * 
     * @see <a href="http://dublincore.org/documents/dcmi-terms/#terms-hasFormat">dcmi-terms/#terms-hasFormat</a>
     * @param list
     *        a list of resource properties
     */
    public void setEasHasFormat(final List<Relation> list) {
        this.easHasFormat = list;
    }

}
