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
package nl.knaw.dans.pf.language.emd.types;

import java.net.URI;

/**
 * Relation to a resource. The Dublin Core relation qualifiers are a half-hearted attempt to bring triples to a two-dimensional universe of key-value pairs.
 * This leads to a proliferation of properties expressed as elements that in essence are predicates.
 * 
 * @author ecco
 */
public class Relation implements MetadataItem {

    private static final long serialVersionUID = 2727329285153906751L;

    private boolean emphasis;

    private BasicString subjectTitle;

    private BasicIdentifier subjectIdentifier;

    private URI subjectLink;

    /**
     * Constructor.
     */
    public Relation() {
        super();
    }

    /**
     * Expresses relation to another resource with the given title.
     * 
     * @param subjectTitle
     *        title of the resource that is the subject of this relation
     */
    public Relation(final BasicString subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    /**
     * Expresses relation to another resource with the given title.
     * 
     * @param title
     *        title of the resource that is the subject of this relation
     */
    public Relation(final String title) {
        this(new BasicString(title));
    }

    /**
     * Expresses relation to another resource with the given title and link.
     * 
     * @param title
     *        title of the resource that is the subject of this relation
     * @param subjectLink
     *        URI of the resource that is the subject of this relation
     */
    public Relation(final String title, final URI subjectLink) {
        this(title);
        this.subjectLink = subjectLink;
    }

    /**
     * Should this relation receive emphasis amongst other relations?
     * 
     * @return <code>true</code> if it has emphasis, <code>false</code> otherwise
     */
    public boolean hasEmphasis() {
        return emphasis;
    }

    /**
     * This relation should receive emphasis amongst other relations.
     * 
     * @param emphasis
     *        <code>true</code> if it should receive emphasis, <code>false</code> otherwise
     */
    public void setEmphasis(final boolean emphasis) {
        this.emphasis = emphasis;
    }

    /**
     * Get the title of the resource that is the subject of this relation.
     * 
     * @return the title of the resource that is the subject of this relation
     */
    public BasicString getSubjectTitle() {
        return subjectTitle;
    }

    /**
     * Set the title of the resource that is the subject of this relation.
     * 
     * @param subjectTitle
     *        the title of the resource
     */
    public void setSubjectTitle(final BasicString subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    /**
     * Get the title of the resource that is the subject of this relation.
     * 
     * @param title
     *        the title of the resource that is the subject of this relation
     */
    public void setSubjectTitle(final String title) {
        this.subjectTitle = new BasicString(title);
    }

    /**
     * Get information about the formal identification system that can identify the resource that is the subject of this relation.
     * 
     * @return a BasicIdentifier
     */
    public BasicIdentifier getSubjectIdentifier() {
        return subjectIdentifier;
    }

    /**
     * Set information about the formal identification system that can identify the resource that is the subject of this relation.
     * 
     * @param subjectIdentifier
     *        a BasicIdentifier
     */
    public void setSubjectIdentifier(final BasicIdentifier subjectIdentifier) {
        this.subjectIdentifier = subjectIdentifier;
    }

    /**
     * Get the URI of the resource that is the subject of this relation.
     * 
     * @return the URI of the resource that is the subject of this relation
     */
    public URI getSubjectLink() {
        return subjectLink;
    }

    /**
     * Set the URI of the resource that is the subject of this relation.
     * 
     * @param subjectLink
     *        the URI of the resource that is the subject of this relation
     */
    public void setSubjectLink(final URI subjectLink) {
        this.subjectLink = subjectLink;
    }

    /**
     * Get a string-representation of this Relation.
     * 
     * @return string-representation
     */
    @Override
    public String toString() {
        return (subjectTitle == null ? "" : "title=" + subjectTitle) + (subjectTitle != null && subjectLink != null ? " " : "")
                + (subjectLink == null ? "" : "URI=" + subjectLink);
    }

    public boolean isComplete() {
        return true;
    }

    @Override
    public String getSchemeId() {
        // we have no schemeId
        return null;
    }

}
