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

import java.util.List;

public class Polygon extends Spatial.Locator {

    private static final long serialVersionUID = 7316626274747251053L;

    private String place;
    private PolygonPart exterior;
    private List<PolygonPart> interior;

    public Polygon() {
        super();
    }

    public Polygon(String scheme, PolygonPart exterior, List<PolygonPart> interior) {
        super(scheme);
        this.exterior = exterior;
        this.interior = interior;
    }

    public Polygon(String scheme, String place, PolygonPart exterior, List<PolygonPart> interior) {
        super(scheme);
        this.place = place;
        this.exterior = exterior;
        this.interior = interior;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public PolygonPart getExterior() {
        return this.exterior;
    }

    public void setExterior(PolygonPart exterior) {
        this.exterior = exterior;
    }

    public List<PolygonPart> getInterior() {
        return this.interior;
    }

    public void setInterior(List<PolygonPart> interior) {
        this.interior = interior;
    }

    @Override
    public String toString() {
        return String.format("(exterior=%s, interior=%s)", this.exterior, this.interior);
    }

    public boolean isComplete() {
        return this.exterior != null && this.interior != null && this.exterior.isComplete() && isComplete(this.interior);
    }

    private boolean isComplete(List<PolygonPart> pps) {
        for (PolygonPart pp : pps) {
            if (!pp.isComplete())
                return false;
        }
        return true;
    }
}
