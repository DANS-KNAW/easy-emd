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

import java.io.Serializable;
import java.util.List;

public class PolygonPart implements Serializable {

    private String place;
    private List<PolygonPoint> points;

    public PolygonPart() {}

    public PolygonPart(String place, List<PolygonPoint> points) {
        this.place = place;
        this.points = points;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public List<PolygonPoint> getPoints() {
        return this.points;
    }

    public void setPoints(List<PolygonPoint> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return String.format("(place=%s, points=%s)", this.place, this.points);
    }

    public boolean isComplete() {
        return this.place != null && this.points != null && isComplete(this.points);
    }

    private boolean isComplete(List<PolygonPoint> pps) {
        for (PolygonPoint pp : pps) {
            if (!pp.isComplete())
                return false;
        }
        return true;
    }
}
