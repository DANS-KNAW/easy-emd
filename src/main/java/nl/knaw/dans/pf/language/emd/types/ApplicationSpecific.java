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

import java.io.Serializable;

public class ApplicationSpecific implements Serializable {

    public enum MetadataFormat {
        UNSPECIFIED, SOCIOLOGY, HISTORY, ARCHAEOLOGY, LIFESCIENCE, LANGUAGE_LITERATURE, ANY_DISCIPLINE;
        public static final MetadataFormat DEFAULT = ANY_DISCIPLINE;
    }

    public enum PakbonStatus {
        NOT_IMPORTED, IMPORTED;
    }

    private static final long serialVersionUID = -7645674090791579101L;

    private MetadataFormat metadataFormat = MetadataFormat.DEFAULT;
    private PakbonStatus pakbonStatus = PakbonStatus.NOT_IMPORTED;
    private EmdArchive archive;

    public MetadataFormat getMetadataFormat() {
        return metadataFormat;
    }

    public void setMetadataFormat(MetadataFormat metadataFormat) {
        this.metadataFormat = metadataFormat;
    }

    public void setPakbonStatus(PakbonStatus status) {
        pakbonStatus = status;
    }

    public PakbonStatus getPakbonStatus() {
        return pakbonStatus;
    }

    public static MetadataFormat formatForName(String name) {
        return MetadataFormat.valueOf(name.toUpperCase());
    }

    public EmdArchive getArchive() {
        return archive;
    }

    public void setArchive(EmdArchive archive) {
        this.archive = archive;
    }
}
