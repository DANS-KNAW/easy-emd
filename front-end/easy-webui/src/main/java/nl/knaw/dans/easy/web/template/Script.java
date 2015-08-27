package nl.knaw.dans.easy.web.template;

import static org.apache.wicket.markup.html.JavascriptPackageResource.getHeaderContribution;

import org.apache.wicket.behavior.HeaderContributor;

public class Script {
    // @formatter:off
    public static final HeaderContributor

            JQUERY_CONTRIBUTION = getHeaderContribution(Script.class, "js/jquery-1.11.1.min.js"),
            BOOTSTRAP_CONTRIBUTION = getHeaderContribution(Script.class, "js/bootstrap.min.js"),
            JQUERY_UI_CONTRIBUTION = getHeaderContribution(Script.class, "js/jquery-ui.min.js"),
            FILEEXPLORER_RESIZE_CONTRIBUTION = getHeaderContribution(Script.class, "js/fileexplorer-resize.js");
    // @formatter:on
}