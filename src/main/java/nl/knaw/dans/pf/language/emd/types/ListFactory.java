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

import java.util.ArrayList;
import java.util.List;

/**
 * Factory for lists of emd types.
 * 
 * @author ecco
 */
public final class ListFactory {

    private ListFactory() {
        // never instantiate.
    }

    // ecco: CHECKSTYLE: OFF
    // Method used by JiBX serialization.
    static synchronized List<Author> authorList() {
        return new ArrayList<Author>();
    }

    static synchronized List<EntityId> entityIdList() {
        return new ArrayList<EntityId>();
    }

    // Method used by JiBX serialization.
    static synchronized List<BasicDate> basicDateList() {
        return new ArrayList<BasicDate>();
    }

    // Method used by JiBX serialization.
    static synchronized List<BasicIdentifier> basicIdentifierList() {
        return new ArrayList<BasicIdentifier>();
    }

    // Method used by JiBX serialization.
    static synchronized List<BasicString> basicStringList() {
        return new ArrayList<BasicString>();
    }

    // Method used by JiBX serialization.
    static synchronized List<IsoDate> isoDateList() {
        return new ArrayList<IsoDate>();
    }

    // Method used by JiBX serialization.
    static synchronized List<Relation> relationList() {
        return new ArrayList<Relation>();
    }

    // Method used by JiBX serialization.
    static synchronized List<Spatial> spatialList() {
        return new ArrayList<Spatial>();
    }

    // Method used by JiBX serialization.
    static synchronized List<BasicRemark> basicRemarkList() {
        return new ArrayList<BasicRemark>();
    }

    // Method used by JiBX serialization.
    static synchronized List<Polygon> polygonList() {
        return new ArrayList<Polygon>();
    }

    // Method used by JiBX serialization.
    static synchronized List<PolygonPart> polygonPartList() {
        return new ArrayList<PolygonPart>();
    }

    // Method used by JiBX serialization.
    static synchronized List<PolygonPoint> polygonPointList() {
        return new ArrayList<PolygonPoint>();
    }
}
