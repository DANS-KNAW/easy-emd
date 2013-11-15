/**
 *
 */
package nl.knaw.dans.easy.web.template.emd.atomic;

import java.util.List;
import java.util.Map;

import nl.knaw.dans.common.lang.service.exceptions.ServiceException;
import nl.knaw.dans.easy.domain.deposit.discipline.ChoiceList;
import nl.knaw.dans.easy.domain.model.Dataset;
import nl.knaw.dans.easy.servicelayer.services.Services;
import nl.knaw.dans.easy.web.deposit.RelationViewPanel;
import nl.knaw.dans.pf.language.emd.types.Relation;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author akmi
 */
public class RelationInfoPanel extends Panel
{
    private static final long serialVersionUID = -5703756567092947861L;
    private static final Logger logger = LoggerFactory.getLogger(RelationInfoPanel.class);

    /**
     * @param id
     * @param model
     */
    public RelationInfoPanel(String id, Dataset dataset)
    {
        super(id);
        Map<String, List<Relation>> map = dataset.getEasyMetadata().getEmdRelation().getRelationMap();
        ChoiceList qualifierLabels = getQualifierLabels();

        RepeatingView qualifierView = new RepeatingView("repeatingQualifier");
        for (String key : map.keySet())
        {
            RepeatingView relationsView = new RepeatingView("repeatingRelation");
            for (Relation relation : map.get(key))
            {
                if (relation.hasEmphasis())
                {
                    ExternalLink link = createLink(relation);

                    WebMarkupContainer item = new WebMarkupContainer(relationsView.newChildId());
                    relationsView.add(item);
                    item.add(link);
                }
            }
            if (relationsView.size() != 0)
            {
                WebMarkupContainer item = new WebMarkupContainer(qualifierView.newChildId());
                qualifierView.add(item);
                item.add(relationsView);
                item.add(new Label("qualifier", qualifierLabels == null ? key : qualifierLabels.getValue(key)));
            }
        }
        this.add(qualifierView);
        this.setVisible(qualifierView.size() != 0);
    }

    private ExternalLink createLink(Relation relation)
    {
        String relTitle = relation.getSubjectTitle().getValue();
        String relUrl = relation.getSubjectLink().toString();

        ExternalLink link = new ExternalLink("relationLink", relUrl);
        link.setVisible(relUrl != null);
        link.add(new Label("relationTitle", relTitle).setVisible(relTitle != null));
        return link;
    }

    private ChoiceList getQualifierLabels()
    {
        ChoiceList choiceList = null;
        try
        {
            // TODO code smell: wrong dependency for constant
            choiceList = Services.getDepositService().getChoices(RelationViewPanel.CHOICE_LIST_ID, getLocale());
        }
        catch (ServiceException e)
        {
            logger.warn("could not get user friendly versions for qualifiers", e);
        }
        return choiceList;
    }
}
