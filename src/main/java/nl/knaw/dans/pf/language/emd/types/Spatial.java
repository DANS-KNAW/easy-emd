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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Expresses a spatial coverage.
 * 
 * @author ecco
 */
public class Spatial implements MetadataItem {

    /**
     *
     */
    private static final long serialVersionUID = -4528874991943187028L;

    private BasicString place;

    private Point point;

    private Box box;

    private List<Polygon> polygons;

    /**
     * Constructor.
     */
    public Spatial() {
        super();
    }

    /**
     * Constructor with a spatial point.
     * 
     * @param place
     *        name of a place
     * @param point
     *        the spatial point
     */
    public Spatial(final String place, final Point point) {
        super();
        this.place = new BasicString(place);
        this.point = point;
    }

    /**
     * Constructor with a spatial box.
     * 
     * @param place
     *        name of a place
     * @param box
     *        the spatial box
     */
    public Spatial(final String place, final Box box) {
        super();
        this.place = new BasicString(place);
        this.box = box;
    }

    public Spatial(String place, Polygon polygon) {
        super();
        this.place = new BasicString(place);
        this.setPolygon(polygon);
    }

    public Spatial(String place, List<Polygon> polygons) {
        super();
        this.place = new BasicString(place);
        this.setPolygons(polygons);
    }

    /**
     * Get the geographical name.
     * 
     * @return the geographical name
     */
    public BasicString getPlace() {
        return place;
    }

    /**
     * Set the geographical name.
     * 
     * @param place
     *        the geographical name
     */
    public void setPlace(final BasicString place) {
        this.place = place;
    }

    /**
     * Get the geographical coordinates, if set.
     * 
     * @return geographical coordinates
     */
    public Point getPoint() {
        return point;
    }

    /**
     * Set the spatial point. A spatial expresses either a point or a box.
     * 
     * @param point
     *        the spatial point
     * @throws IllegalStateException
     *         if this spatial expresses a box
     */
    public void setPoint(final Point point) throws IllegalStateException {
        if (box != null || polygons != null) {
            throw new IllegalStateException(String.format("Only one of %s or %s or %s is acceptable.", Point.class.getName(), Box.class.getName(),
                    Polygon.class.getName()));
        } else {
            this.point = point;
        }
    }

    /**
     * Get the spatial box, if set.
     * 
     * @return the spatial box
     */
    public Box getBox() {
        return box;
    }

    /**
     * Set the spatial box. A spatial expresses either a point or a box.
     * 
     * @param box
     *        the spatial box
     * @throws IllegalStateException
     *         if this spatial expresses a point
     */
    public void setBox(final Box box) throws IllegalStateException {
        if (point != null || polygons != null) {
            throw new IllegalStateException(String.format("Only one of %s or %s or %s is acceptable.", Point.class.getName(), Box.class.getName(),
                    Polygon.class.getName()));
        } else {
            this.box = box;
        }
    }

    public List<Polygon> getPolygons() {
        return this.polygons;
    }

    public void setPolygon(Polygon polygon) {
        if (point != null || box != null) {
            throw new IllegalStateException(String.format("Only one of %s or %s or %s is acceptable.", Point.class.getName(), Box.class.getName(),
                    Polygon.class.getName()));
        } else {
            this.polygons = new ArrayList<Polygon>();
            this.polygons.add(polygon);
        }
    }

    public void setPolygons(List<Polygon> polygons) {
        if (point != null || box != null) {
            throw new IllegalStateException(String.format("Only one of %s or %s or %s is acceptable.", Point.class.getName(), Box.class.getName(),
                    Polygon.class.getName()));
        } else {
            Set<String> schemes = new HashSet<String>();
            for (Polygon polygon : polygons) {
                String scheme = polygon.getScheme();
                if (scheme != null)
                    schemes.add(scheme);
            }

            if (schemes.size() > 1)
                throw new IllegalArgumentException("Only one scheme is allowed in the polygons.");
            else
                this.polygons = polygons;
        }
    }

    @Override
    public String getSchemeId() {
        // locator has schemeId in scheme instead of schemeId!
        if (point != null) {
            return point.getScheme();
        } else if (box != null) {
            return box.getScheme();
        } else if (polygons != null && !polygons.isEmpty()) {
            return polygons.get(0).getScheme();
        } else {
            return null;
        }
    }

    /**
     * Get a string-representation of this Spatial.
     * 
     * @return a string-representation
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        if (place != null) {
            builder.append("name=").append(place.toString()).append(" ");
        }
        if (point != null) {
            builder.append(point.toString());
        }
        if (box != null) {
            builder.append(box.toString());
        }
        if (polygons != null && !polygons.isEmpty()) {
            for (Polygon polygon : polygons) {
                builder.append(polygon.toString()).append(" ");
            }
        }
        return builder.toString();
    }

    public boolean isComplete() {
        boolean complete = true;
        if (point != null) {
            complete = point.isComplete();
        } else if (box != null) {
            complete = box.isComplete();
        } else if (polygons != null) {
            if (polygons.isEmpty())
                complete = false;
            else
                for (Polygon polygon : polygons) {
                    boolean polygonComplete = polygon.isComplete();
                    if (complete)
                        complete = polygonComplete;
                }
        }
        return complete;
    }

    /**
     * Super class for Polygon, Box and Point, all having a scheme attribute.
     * 
     * @author ecco
     */
    public static class Locator implements Serializable {

        private static final long serialVersionUID = 1359989050701264576L;

        // ecco: CHECKSTYLE: OFF
        protected String scheme;

        protected String schemeId;

        // ecco: CHECKSTYLE: ON

        /**
         * Constructor.
         */
        Locator() {
            super();
        }

        /**
         * Constructor.
         * 
         * @param scheme
         *        scheme for coordinates
         */
        public Locator(final String scheme) {
            super();
            this.scheme = scheme;
        }

        /**
         * Get the scheme.
         * 
         * @return scheme for coordinates
         */
        public String getScheme() {
            return scheme;
        }

        /**
         * Set the scheme.
         * 
         * @param scheme
         *        scheme for coordinates
         */
        public void setScheme(final String scheme) {
            this.scheme = scheme;
        }

        public String getSchemeId() {
            return schemeId;
        }

        public void setSchemeId(String schemeId) {
            this.schemeId = schemeId;
        }

        /**
         * Get a string-representation.
         * 
         * @return a string-representation
         */
        public String toString() {
            return "scheme=" + scheme;
        }

    }

    /**
     * A geographical point described in coordinates of a certain scheme.
     * 
     * @author ecco
     */
    public static class Point extends Locator {

        private static final long serialVersionUID = -3188779181045736655L;

        private String x;

        private String y;

        /**
         * Constructor.
         */
        Point() {
            super();
        }

        /**
         * Constructor.
         * 
         * @param scheme
         *        scheme for coordinates
         * @param x
         *        x coordinate
         * @param y
         *        y coordinate
         */
        public Point(final String scheme, final String x, final String y) {
            super(scheme);
            this.x = x;
            this.y = y;
        }

        /**
         * Get x coordinate.
         * 
         * @return x coordinate
         */
        public String getX() {
            return x;
        }

        /**
         * Set x coordinate.
         * 
         * @param x
         *        x coordinate
         */
        public void setX(final String x) {
            this.x = x;
        }

        /**
         * Get y coordinate.
         * 
         * @return y coordinate
         */
        public String getY() {
            return y;
        }

        /**
         * Set y coordinate.
         * 
         * @param y
         *        y coordinate
         */
        public void setY(final String y) {
            this.y = y;
        }

        /**
         * Get a string-representation.
         * 
         * @return a string-representation
         */
        public String toString() {
            return super.toString() + " x=" + x + " y=" + y;
        }

        public boolean isComplete() {
            return getScheme() != null && getX() != null && getY() != null;
        }

    }

    /**
     * A geographical space described with north, east, south and west limits of a certain scheme.
     * 
     * @author ecco
     */
    public static class Box extends Locator {

        private static final long serialVersionUID = -9058631387866597183L;

        private String north;

        private String east;

        private String south;

        private String west;

        /**
         * Constructor.
         */
        Box() {
            super();
        }

        /**
         * Constructor.
         * 
         * @param scheme
         *        scheme for limits.
         * @param north
         *        limit
         * @param east
         *        limit
         * @param south
         *        limit
         * @param west
         *        limit
         */
        public Box(final String scheme, final String north, final String east, final String south, final String west) {
            super(scheme);
            this.north = north;
            this.east = east;
            this.south = south;
            this.west = west;
        }

        /**
         * Get north limit.
         * 
         * @return north limit
         */
        public String getNorth() {
            return north;
        }

        /**
         * Set north limit.
         * 
         * @param north
         *        north limit
         */
        public void setNorth(final String north) {
            this.north = north;
        }

        /**
         * Get east limit.
         * 
         * @return east limit
         */
        public String getEast() {
            return east;
        }

        /**
         * Set east limit.
         * 
         * @param east
         *        east limit
         */
        public void setEast(final String east) {
            this.east = east;
        }

        /**
         * Get south limit.
         * 
         * @return south limit
         */
        public String getSouth() {
            return south;
        }

        /**
         * Set south limit.
         * 
         * @param south
         *        south limit
         */
        public void setSouth(final String south) {
            this.south = south;
        }

        /**
         * Get west limit.
         * 
         * @return west limit
         */
        public String getWest() {
            return west;
        }

        /**
         * Set west limit.
         * 
         * @param west
         *        west limit
         */
        public void setWest(final String west) {
            this.west = west;
        }

        /**
         * Get a string-representation.
         * 
         * @return a string-representation
         */
        public String toString() {
            return super.toString() + " north=" + north + " east=" + east + " south=" + south + " west=" + west;
        }

        public boolean isComplete() {
            return getScheme() != null && getNorth() != null && getEast() != null && getSouth() != null && getWest() != null;
        }

    }
}
