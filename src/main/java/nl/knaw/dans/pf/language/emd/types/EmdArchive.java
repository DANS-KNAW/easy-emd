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

/**
 * Contains information about the way the dataset is archiving Created by paulboon on 07/08/2017.
 */
public class EmdArchive implements Serializable {
    private static final long serialVersionUID = 1L;

    // denotes where the dataset is archived.
    public enum Location {
        EASY, // data and metadata are archived in EASY
        DATAVAULT; // data and metadata are archived in the DATAVAULT. there may be dissemination copies in EASY
        public static final Location DEFAULT = EASY;
    }

    private Location location = Location.DEFAULT;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
