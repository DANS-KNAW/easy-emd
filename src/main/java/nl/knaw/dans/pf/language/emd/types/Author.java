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
package nl.knaw.dans.pf.language.emd.types;

import nl.knaw.dans.common.lang.id.DAI;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static nl.knaw.dans.pf.language.emd.types.EmdConstants.DAI_RESOLVER;
import static nl.knaw.dans.pf.language.emd.types.EmdConstants.ISNI_RESOLVER;
import static nl.knaw.dans.pf.language.emd.types.EmdConstants.ORCID_RESOLVER;
import static nl.knaw.dans.pf.language.emd.types.EmdConstants.SCHEME_DAI;
import static nl.knaw.dans.pf.language.emd.types.EmdConstants.SCHEME_ISNI;
import static nl.knaw.dans.pf.language.emd.types.EmdConstants.SCHEME_ORCID;

/**
 * Author of a resource.
 * <p/>
 * An optional entityId can relate an author to a common entity through an identification system. The default identification system is the Digital Author
 * Identification (DAI).
 * 
 * @see <a href="http://www.rug.nl/bibliotheek/informatie/digitaleBibliotheek/daikort">digitaleBibliotheek/daikort</a>
 * @author ecco
 */
public class Author implements MetadataItem {

    public static class Role implements Serializable {
        private String role;
        private String scheme;

        public Role() {}

        public Role(String role) {
            this(role, "DATACITE");
        }

        public Role(String role, String scheme) {
            this.role = role;
            this.setScheme(scheme);
        }

        public String getRole() {
            return this.role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getScheme() {
            return this.scheme;
        }

        public void setScheme(String scheme) {
            if ("DATACITE".equals(scheme) || "EASY".equals(scheme))
                this.scheme = scheme;
            else
                throw new IllegalArgumentException("The Author's role scheme can only be \"DATACITE\" or \"EASY\"");
        }
    }

    /**
     * The default identification system. {@value}
     */
    public static final String DEFAULT_SCHEME = SCHEME_DAI;
    public static final String DEFAULT_IDENTIFICATION_SYSTEM = DAI_RESOLVER;

    /**
     *
     */
    private static final long serialVersionUID = -8429016201723749485L;

    private String title;
    private String initials;
    private String prefix;
    private String surname;
    private String organization;
    private EntityId organizationIdHolder;
    private List<EntityId> entityIdHolder = new ArrayList<EntityId>();
    private Role role;

    /**
     * Constructs an Author.
     */
    public Author() {
        super();
    }

    /**
     * Constructs an Author.
     * 
     * @param title
     *        title(s) of the author, may be <code>null</code>
     * @param initials
     *        initials, may be <code>null</code>
     * @param prefix
     *        prefix(es), may be <code>null</code>
     * @param surname
     *        surname, may be <code>null</code>
     */
    public Author(final String title, final String initials, final String prefix, final String surname) {
        setTitle(title);
        setInitials(initials);
        setPrefix(prefix);
        this.surname = surname;
    }

    /**
     * A string-representation of this author.
     * 
     * @return string-representation of this author
     */
    public String toString() {
        return (surname == null || "".equals(surname) ? "" : surname + ", ") + (title == null || "".equals(title) ? "" : title + " ")
                + (initials == null || "".equals(initials) ? "" : initials) + (prefix == null || "".equals(prefix) ? "" : " " + prefix)
                + (organization == null ? "" : hasPersonalEntries() ? " (" + organization + ")" : organization)
                + (role == null || role.role == null || "".equals(role.role) ? "" : ", " + role.role);
    }

    /**
     * Get this author's titles, may be <code>null</code>.
     * 
     * @return the authors titles
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set this author's title(s).
     * 
     * @param title
     *        title(s) of the author, may be <code>null</code>
     */
    public final void setTitle(final String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * Get this author's initials.
     * 
     * @return this author's initials, may be <code>null</code>
     */
    public String getInitials() {
        return initials;
    }

    /**
     * Set this author's initials.
     * 
     * @param initials
     *        this author's initials, may be <code>null</code>
     */
    public final void setInitials(final String initials) {
        this.initials = initials == null ? null : initials.trim().toUpperCase();
    }

    /**
     * Get this author's prefix.
     * 
     * @return this author's prefix, may be <code>null</code>
     */
    public String getPrefix() {
        return prefix == null ? null : prefix.trim();
    }

    /**
     * Set this author's prefix.
     * 
     * @param prefix
     *        this author's prefix, may be <code>null</code>
     */
    public final void setPrefix(final String prefix) {
        this.prefix = prefix;
    }

    /**
     * Get this author's surname.
     * 
     * @return this author's surname, may be <code>null</code>
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Set this author's surname.
     * 
     * @param surname
     *        this author's surname, may be <code>null</code>
     */
    public final void setSurname(final String surname) {
        this.surname = surname == null ? null : surname.trim();
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /**
     * Get the entity id object of this author. This object includes the entity id, its identification system and scheme.
     * 
     * @return the entity id object of this author, may be <code>null</code>
     */
    public EntityId getOrganizationIdHolder() {
        return this.organizationIdHolder;
    }
    public List<EntityId> getEntityIdHolder() {
        return this.entityIdHolder;
    }

    /**
     * Set the entity id object of this author. If the scheme was not yet set, it is set to "DAI".
     * 
     * @param entityIdHolder
     *        the entity id object of this author
     */
    public void setEntityIdHolder(List<EntityId> entityIdHolder) {
        this.entityIdHolder = entityIdHolder;
        for (EntityId entityId : this.entityIdHolder) {
            if (entityId.getScheme() == null) {
                entityId.setScheme(DEFAULT_SCHEME);
                entityId.setIdentificationSystem(toURI(DEFAULT_IDENTIFICATION_SYSTEM));
            }
        }
    }

    private URI toURI(String string) {
        try {
            return new URI(string);
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Set the entity id object of this author organization.
     *
     * @param organizationIdHolder
     *
     *        the entity id object of this author organization
     */
    public void setOrganizationIdHolder(EntityId organizationIdHolder) {
        this.organizationIdHolder = organizationIdHolder;
        if (this.organizationIdHolder.getScheme() == null)
            this.organizationIdHolder.setScheme(DEFAULT_SCHEME);
    }

    /**
     * Get the scheme by which this author is identified.
     * 
     * @return the scheme by which this author is identified
     */
    // backwards compatible
    public String getScheme() {
        if (this.entityIdHolder != null && !this.entityIdHolder.isEmpty())
            // return first DAI scheme
            for (EntityId entityId : this.entityIdHolder) {
                String scheme = entityId.getScheme();
                if (scheme != null && scheme.equals(DEFAULT_SCHEME))
                    return entityId.getScheme();
            }

        return null;
    }

    /**
     * Set the scheme by which this author is identified.
     * 
     * @param scheme
     *        the scheme by which this author is identified
     */
    // keep this for backwards compatibility
    public void setScheme(final String scheme) {
        if (this.entityIdHolder == null)
            this.entityIdHolder = new ArrayList<EntityId>();

        if (this.entityIdHolder.isEmpty())
            this.entityIdHolder.add(new EntityId(null, scheme, null));
        else
            this.entityIdHolder.get(0).setScheme(scheme);
    }

    /**
     * Get this author's identification system.
     * 
     * @return this author's identification system, may be <code>null</code>
     */
    // keep this for backwards compatibility
    public URI getIdentificationSystem() {
        if (this.entityIdHolder != null && !this.entityIdHolder.isEmpty())
            // return first DAI identificationSystem
            for (EntityId entityId : this.entityIdHolder) {
                String scheme = entityId.getScheme();
                if (scheme != null && scheme.equals(DEFAULT_SCHEME))
                    return entityId.getIdentificationSystem();
            }

        return null;
    }

    /**
     * Set this author's identification system.
     * 
     * @param identificationSystem
     *        this author's identification system, may be <code>null</code>
     */
    // keep this for backwards compatibility
    public void setIdentificationSystem(final URI identificationSystem) {
        if (this.entityIdHolder == null)
            this.entityIdHolder = new ArrayList<EntityId>();

        if (this.entityIdHolder.isEmpty())
            this.entityIdHolder.add(new EntityId(null, null, identificationSystem));
        else
            for (EntityId entityId : this.entityIdHolder) {
                if (DEFAULT_SCHEME.equals(entityId.getScheme()))
                    entityId.setIdentificationSystem(identificationSystem);
            }
    }

    /**
     * Get the entity id of this author.
     * 
     * @return the entity id of this author, may be <code>null</code>
     */
    // keep this for backwards compatibility
    public String getEntityId() {
        if (this.entityIdHolder != null && !this.entityIdHolder.isEmpty())
            // return first DAI entityId
            for (EntityId entityId : this.entityIdHolder) {
                String scheme = entityId.getScheme();
                if (scheme != null && scheme.equals(DEFAULT_SCHEME))
                    return entityId.getEntityId();
            }
        
        return null;
    }

    public List<EntityId> getEntityIds(String scheme) {
        List<EntityId> entityIds = new ArrayList<EntityId>();
        if (this.entityIdHolder != null && !this.entityIdHolder.isEmpty()) {
            for (EntityId entityId : this.entityIdHolder) {
                if (scheme.equals(entityId.getScheme()))
                    entityIds.add(entityId);
            }
        }
        return entityIds;
    }

    /**
     * Set the entity id of this author. The scheme is set to "DAI".
     * 
     * @param entityId
     *        the entity id of this author
     */
    // keep this for backwards compatibility
    public void setEntityId(final String entityId) {
        if (this.entityIdHolder == null)
            this.entityIdHolder = new ArrayList<EntityId>();

        this.entityIdHolder.add(new EntityId(entityId, DEFAULT_SCHEME, toURI(DEFAULT_IDENTIFICATION_SYSTEM)));
    }

    public void setOrganizationId(final String organizationId) {
        this.organizationIdHolder = new EntityId(organizationId);
    }

    /**
     * Set entity id and identification system of this author.
     * 
     * @param entityId
     *        the entity id of this author
     * @param scheme
     *        formal name of the identification system
     */
    // keep this for backwards compatibility
    public EntityId setEntityIdWithScheme(final String entityId, final String scheme) {
        if (this.entityIdHolder == null)
            this.entityIdHolder = new ArrayList<EntityId>();

        URI identificationSystem = null;
        if (scheme == null || scheme.equals(DEFAULT_SCHEME))
            identificationSystem = toURI(DEFAULT_IDENTIFICATION_SYSTEM);
        else if (scheme.equals(SCHEME_ISNI))
            identificationSystem = toURI(ISNI_RESOLVER);
        else if (scheme.equals(SCHEME_ORCID))
            identificationSystem = toURI(ORCID_RESOLVER);

        EntityId entity = new EntityId(entityId, scheme, identificationSystem);
        this.entityIdHolder.add(entity);

        return entity;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isComplete() {
        return (hasPersonalEntries() && StringUtils.isNotBlank(surname) && StringUtils.isNotBlank(initials)) || StringUtils.isNotBlank(organization);
    }

    @Override
    public String getSchemeId() {
        // we have no schemeId
        return null;
    }

    private boolean hasPersonalEntries() {
        if (this.entityIdHolder != null && !this.entityIdHolder.isEmpty()) {
            for (EntityId entityId: this.entityIdHolder) {
                if (StringUtils.isNotBlank(entityId.getEntityId()))
                    return true;
            }
        }

        return StringUtils.isNotBlank(initials)
            || StringUtils.isNotBlank(prefix)
            || StringUtils.isNotBlank(surname)
            || StringUtils.isNotBlank(title);
    }

    public boolean hasDigitalAuthorId() {
        if (this.entityIdHolder != null && !this.entityIdHolder.isEmpty()) {
            for (EntityId entityId : this.entityIdHolder) {
                if (SCHEME_DAI.equals(entityId.getScheme()) && DAI.isValid(entityId.getEntityId()))
                    return true;
            }
        }
        return false;
    }

    public DAI getDigitalAuthorId() {
        List<EntityId> dais = getEntityIds(SCHEME_DAI);
        for (EntityId dai : dais) {
            if (DAI.isValid(dai.getEntityId()))
                return new DAI(dai.getEntityId());
        }
        return null;
    }

    public boolean hasOrcid() {
        return !getEntityIds(SCHEME_ORCID).isEmpty();
    }

    public EntityId getOrcid() {
        List<EntityId> ids = getEntityIds(SCHEME_ORCID);
        if (!ids.isEmpty())
            return ids.get(0);
        return null;
    }

    public void setOrcid(final String entityId) {
        if (this.entityIdHolder == null)
            this.entityIdHolder = new ArrayList<EntityId>();

        this.entityIdHolder.add(new EntityId(entityId, SCHEME_ORCID, toURI(ORCID_RESOLVER)));
    }

    public boolean hasIsni() {
        return !getEntityIds(SCHEME_ISNI).isEmpty();
    }

    public EntityId getIsni() {
        List<EntityId> ids = getEntityIds(SCHEME_ISNI);
        if (!ids.isEmpty())
            return ids.get(0);
        return null;
    }

    public void setIsni(final String entityId) {
        if (this.entityIdHolder == null)
            this.entityIdHolder = new ArrayList<EntityId>();

        this.entityIdHolder.add(new EntityId(entityId, SCHEME_ISNI, toURI(ISNI_RESOLVER)));
    }
}
