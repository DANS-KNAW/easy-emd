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
package nl.knaw.dans.pf.language.emd.util;

import java.util.*;

public final class StringUtil {

    public static String firstCharToUpper(final String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    public static String commaSeparatedList(Collection<?> objects) {
        StringBuilder sb = new StringBuilder();
        Iterator<?> iter = objects.iterator();
        while (iter.hasNext()) {
            sb.append(iter.next());
            sb.append(", ");
        }
        if (sb.length() > 2) {
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String printStackTrace(StackTraceElement[] stes, String filter) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement ste : stes) {
            if (filter == null || ste.getClassName().startsWith(filter)) {
                sb.append("\n\t").append("at ").append(ste.getClassName()).append(" (").append(ste.getFileName()).append(":").append(ste.getLineNumber())
                        .append(")");
            }

        }
        return sb.toString();
    }

}
